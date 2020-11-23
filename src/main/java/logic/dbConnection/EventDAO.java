package logic.dbConnection;

import io.qameta.allure.Step;
import logic.dbConnection.entity.BdxEntity;
import logic.dbConnection.entity.EventEntity;
import logic.report.LogToAllure;
import logic.variables.Accounts;
import logic.variables.TestConstant;
import logic.variables.events.EventTimestamp;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class EventDAO {
    private static String FIFTEEN_DAYS_DATE = new SimpleDateFormat("yyyy-MM-dd").format(EventTimestamp.getDate((TestConstant.NUM_OF_DAYS_FOR_CSV_REPORT_GENERATE * 24)).getTime());

    private static final Logger log = Logger.getLogger(EventDAO.class);
    static private final String INSERT_EVENTS = "INSERT INTO eld.eld_event (driver_id_1, truck_id,org_id, record_status, record_origin, " +
            "event_type, event_code, latitude, longitude, location_description, device_uid, event_timestamp) VALUES (";
    static private final String DELETE_EVENTS_FROM_DRIVER = "DELETE FROM eld.eld_event WHERE org_id=3464 and driver_id_1=";
    static private final String INSERT_BDX = "INSERT INTO eld.eld_border_crossing_event (org_id,crossing_date,driver_id_1,truck_id,event_origin, from_country_code, to_country_code)" +
            "VALUES(";
    static private final String DELETE_BDX_EVENTS_FROM_DRIVER = "DELETE FROM eld.eld_border_crossing_event WHERE driver_id_1=" + Accounts.TEST_DRIVER_ID + " and org_id=3464";
    private final static String GET_DRIVER_EVENTS_BY_ID = "SELECT E.eld_sequence,E.record_status," +
            "E.record_origin, E.event_type, E.event_code, E.event_timestamp," +
            "E.total_vehicle_miles, E.accumulated_vehicle_miles, E.total_engine_hours, E.elapsed_engine_hours," +
            "E.latitude, E.longitude,E.truck_number, E.truck_vin, E.trailer_number, E.shipping_number, E.distance_since_last_valid_coords," +
            "E.malfunction_indicator_status, E.data_diagnostic_event_idicator_status," +
            "E.malfunction_diagnostic_code, E.comment, E.data_check_value, DP.login_name FROM eld.eld_event E JOIN fleet.driver_profile DP on E.driver_id_1 = DP.driver_id" +
            " WHERE E.event_timestamp>'" + FIFTEEN_DAYS_DATE + " 00:00:00'and E.eld_sequence is not null and E.driver_id_1=";

    @Step("Insert List of events to DB: {0}")
    public static boolean createEvents(List<EventEntity> events) throws SQLException {
        if (events != null) {
            Statement st = null;
            try {
                st = DBConnection.getConnection().createStatement();
                for (EventEntity event :
                        events) {
                    st.executeUpdate(INSERT_EVENTS + event.getDriver_id_1() + " ," + event.getTruck_id() + " ," + event.getOrg_id() + " ," + event.getRecordStatus()
                            + " ," + event.getRecordOrigin() + " ," + event.getEventType() + " ," + event.getEventCode() + " ," + event.getLatitude() + " ," + event.getLongitude()
                            + " ," + event.getLocation_description() + " ," + event.getDevice_uid() + " ," + event.getEventTimeStamp() + ")");
                    log.info("Insert event to DB: " + event.toString());
                }
            } catch (SQLException e) {
                log.error("Insert event is not successful: " + e);
                return false;
            } finally {
                if (st != null) st.close();
            }
            return true;
        } else return false;
    }

    @Step("Insert BDX event to DB: {0}")
    public static boolean createBDX(List<BdxEntity> events) throws SQLException {
        if (events != null) {
            Statement st = null;
            try {
                st = DBConnection.getConnection().createStatement();
                for (BdxEntity event :
                        events) {
                    st.executeUpdate(INSERT_BDX + event.getOrgId() + " ," + event.getCrossingDate() + " ," + event.getDriverId() + " ," + event.getTruckId()
                            + " ," + event.getRecordOrigin() + " ," + event.getFromCountryCode() + " ," + event.getToCountryCode() + ")");
                    log.info("Insert BDX event to DB: " + event.toString());
                }
            } catch (SQLException e) {
                log.error("Insert BDX event is not successful: " + e);
                return false;
            } finally {
                if (st != null) st.close();
            }
            return true;
        } else return false;
    }

    @Step("Delete events for driver.")
    public static boolean deleteEvents(long driver_id) throws SQLException {
        Statement st = null;
        try {
            st = DBConnection.getConnection().createStatement();
            st.executeUpdate(DELETE_EVENTS_FROM_DRIVER + driver_id);
            log.info("Delete all events for driver_id = " + driver_id);
        } catch (SQLException e) {
            log.error("Delete events is not successful: " + e);
            return false;
        } finally {
            if (st != null) st.close();
        }
        return true;
    }

    @Step("Delete events for driver.")
    public static boolean deleteBDXEvents() throws SQLException {
        Statement st = null;
        try {
            st = DBConnection.getConnection().createStatement();
            st.executeUpdate(DELETE_BDX_EVENTS_FROM_DRIVER);
            log.info("Delete all BDX events for driver_id = " + Accounts.TEST_DRIVER_ID);
        } catch (SQLException e) {
            log.error("Delete events BDX is not successful: " + e);
            return false;
        } finally {
            if (st != null) st.close();
        }
        return true;
    }

    @Step("Connecting to the DB and creating a request for the driver")
    public static List<EventEntity> getEvents(String driverId) throws SQLException {
        List<EventEntity> eventsList = new ArrayList<>();
        Statement st = null;
        try {
            st = DBConnection.getConnection().createStatement();
            ResultSet resultSet = st.executeQuery(GET_DRIVER_EVENTS_BY_ID + driverId);
            while (resultSet.next()) {
                EventEntity event = new EventEntity
                        .Builder()
                        .setEventSequence(resultSet.getString("eld_sequence"))
                        .setRecordStatus(resultSet.getInt("record_status"))
                        .setRecordOrigin(resultSet.getInt("record_origin"))
                        .setEventType(resultSet.getInt("event_type"))
                        .setEventCode(resultSet.getInt("event_code"))
                        .setEventTimeStamp(resultSet.getString("event_timestamp"))
                        .setTotalVehicleMiles(resultSet.getDouble("total_vehicle_miles"))
                        .setAccumulatedVehicleMiles(resultSet.getDouble("accumulated_vehicle_miles"))
                        .setTotalEngineHours(resultSet.getDouble("total_engine_hours"))
                        .setElapsedEngineHours(resultSet.getDouble("elapsed_engine_hours"))
                        .setLatitude(resultSet.getString("latitude"))
                        .setLongitude(resultSet.getString("longitude"))
                        .setTruckNumber(resultSet.getString("truck_number"))
                        .setVinNumber(resultSet.getString("truck_vin"))
                        .setTrailerNumber(resultSet.getString("trailer_number"))
                        .setShippingNumber(resultSet.getString("shipping_number"))
                        .setDistanceLastValidCoordinates(resultSet.getDouble("distance_since_last_valid_coords"))
                        .setMalfunctionIndicatorStatus(resultSet.getInt("malfunction_indicator_status"))
                        .setDataDiagnosticEventIndicatorStatus(resultSet.getInt("data_diagnostic_event_idicator_status"))
                        .setMalfunctionOrDiagnosticCode(resultSet.getString("malfunction_diagnostic_code"))
                        .setCommentTextOrAnnotation(resultSet.getString("comment"))
                        .setEldUserName(resultSet.getString("login_name"))
                        .build();
                eventsList.add(event);
            }
        } catch (SQLException e) {
            log.error("Select is not successful " + e);
        } finally {
            if (st != null) st.close();
        }
        LogToAllure.logToAllure("Getting data from the database", eventsList.toString());
        return eventsList;
    }
}
