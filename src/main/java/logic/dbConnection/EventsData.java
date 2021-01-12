package logic.dbConnection;

import logic.dbConnection.entity.BdxEntity;
import logic.dbConnection.entity.EventEntity;
import logic.variables.Accounts;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EventsData {
    final int RECORD_STATUS = 1;
    final String LATTITUDE = "'M'";
    final String LONGITUDE = "'M'";
    final String LOCATION_DESCRIPTION = "'New York, New York, US'";
    final String DEVICE_UID = "'server'";
    final long TRUCK_ID = 286809;
    final long ORG_ID = 4112;

    public EventsData() {
    }

    public List<EventEntity> EVENTS_FOR_SHIFT_GROUP_DUTY_EVENTS(long driverId) {
        List<EventEntity> events = new ArrayList<>();
        // S 0
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-1) + " 07:07:00'"));
        // MC 1
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 7, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-1) + " 05:00:00'"));
        // OFF 2
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-1) + " 04:07:00'"));
        // ML 3
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 7, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 03:50:00'"));
        // ON 4
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 1, 4, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 02:45:00'"));
        // LOGOUT 5
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 5, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 01:25:00'"));
        // OFF 6
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 01:00:00'"));
        // LOGIN 7
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 5, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-3) + " 17:35:00'"));
        // S 8
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 1, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-3) + " 17:10:00'"));
        // POWER D 9
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 6, 3, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-3) + " 16:00:00'"));
        // S 10
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-3) + " 14:25:00'"));
        // POWER UP 11
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 6, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-3) + " 13:13:00'"));
        // OFF 12
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-3) + " 11:45:00'"));
        // ON 13
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 1, 4, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-3) + " 11:00:00'"));
        return events;
    }

    public List<EventEntity> EVENTS_FOR_SHIFT_GROUP_TWO(long driverId) {
        List<EventEntity> events = new ArrayList<>();
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-1) + " 02:00:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 3, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-1) + " 03:30:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 3, 0, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-1) + " 06:25:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 4, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-1) + " 06:25:05'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 7, 3, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-1) + " 09:10:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 3, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-1) + " 12:44:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 7, 4, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-1) + " 14:25:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 4, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-1) + " 15:00:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 3, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-1) + " 16:13:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 3, 0, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-1) + " 19:00:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-1) + " 19:00:05'"));
        return events;
    }

    public List<EventEntity> EVENTS_FOR_SHIFT_GROUP_WITH_BDX_AND_INTERMEDIATE(long driverId) {
        List<EventEntity> events = new ArrayList<>();
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 02:00:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 1, 4, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 04:10:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 1, 3, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 09:25:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 2, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 10:25:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 2, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 11:25:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 2, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 12:25:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 2, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 13:25:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 13:50:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 19:00:00'"));
        return events;
    }

    public List<EventEntity> EVENTS_FOR_SHIFT_GROUP_GAP_DATE(long driverId) {
        List<EventEntity> events = new ArrayList<>();
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-8) + " 07:07:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 7, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-8) + " 05:00:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-8) + " 04:07:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 7, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-9) + " 03:50:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 1, 4, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-9) + " 02:45:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 5, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-9) + " 01:25:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-9) + " 01:00:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 5, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-10) + " 17:35:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 1, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-10) + " 17:10:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 6, 3, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-10) + " 16:00:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-10) + " 14:25:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 6, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-10) + " 13:13:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-10) + " 11:45:00'"));
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 1, 4, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-10) + " 11:00:00'"));
        return events;
    }

    public List<BdxEntity> BDX_FOR_SHIFT_GROUP_WITH_BDX_AND_INTERMEDIATE(long driverId) {
        List<BdxEntity> bdxEvents = new ArrayList<>();
        bdxEvents.add(new BdxEntity(ORG_ID, driverId, TRUCK_ID, "'" + dateChange(-2) + " 05:00:00'", "'Manual'", "'US'", "'CA'"));
        return bdxEvents;
    }


    public List<EventEntity> FIRST_EVENT(long driverId) {
        List<EventEntity> events = new ArrayList<>();
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-9) + " 07:00:00'"));
        return events;
    }

    /*Набор ивентов для тестов Трансфера в которых только Duty ивенты*/
    public List<EventEntity> EVENTS_FOR_TRANSFER_DUTY_EVENTS(long driverId) {
        List<EventEntity> events = new ArrayList<>();
        //OFF DUTY 11
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-7) + " 07:00:00'"));
        //SLEEP 10
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-7) + " 10:40:00'"));
        //DRIVING AUTO 9
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 1, 3, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-7) + " 17:00:00'"));
        //ON DUTY MANUAL 8
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 4, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-6) + " 01:00:00'"));
        //DRIVING MANUAL 7
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 3, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-6) + " 05:00:00'"));
        //ON DUTY AUTO 6
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 1, 4, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-6) + " 10:05:00'"));
        //YM 5
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 3, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-6) + " 15:23:00'"));
        //CLEARED 4
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 3, 0, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-6) + " 17:22:40'"));
        //OFF 3
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-6) + " 17:23:01'"));
        //PU 2
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 3, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-6) + " 23:23:00'"));
        //CLEARED 1
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 3, 0, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-5) + " 02:22:00'"));
        //SLEEP 0
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-5) + " 02:23:00'"));
        return events;
    }
    public List<EventEntity> EVENTS_FOR_TRANSFER_DUTY_EVENTS_FOR_SECOND_DRIVER(long driverId) {
        List<EventEntity> events = new ArrayList<>();
        //OFF DUTY
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-7) + " 07:00:00'"));
        //SLEEP
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 4, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-7) + " 10:40:00'"));
        //DRIVING AUTO
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 3, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-7) + " 17:00:00'"));
        //ON DUTY MANUAL
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-6) + " 01:00:00'"));
        //DRIVING MANUAL
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-6) + " 05:00:00'"));
        //ON DUTY AUTO
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 5, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-6) + " 10:05:00'"));
        //YM
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-6) + " 15:23:00'"));
        //CLEARED
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-6) + " 17:22:40'"));
        //OFF
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-6) + " 17:23:01'"));
        //PU
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 4, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-6) + " 23:23:00'"));
        //CLEARED
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 6, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-5) + " 02:22:00'"));
        //SLEEP
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 7, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-5) + " 02:23:00'"));
        return events;
    }
    public List<EventEntity> EVENTS_FOR_TRANSFER_DRIVING_WITH_INTERM_EVENTS_AND_VERTICAL(long driverId) {
        List<EventEntity> events = new ArrayList<>();
        //OFF DUTY
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-4) + " 07:00:00'"));
        //LOGIN
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 5, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-4) + " 10:40:00'"));
        //LOGOUT
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 5, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-4) + " 11:00:00'"));
        //ON DUTY MANUAL
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 4, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-4) + " 12:00:00'"));
        //POWER UP
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 6, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-4) + " 13:00:00'"));
        //POWER DOWN
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 6, 3, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-4) + " 13:05:00'"));
        //D
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 1, 3, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-4) + " 15:23:00'"));
        //INTER
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 2, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-4) + " 16:22:40'"));
        //INTER
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 2, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-4) + " 17:22:40'"));
        //INTER
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 2, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-4) + " 18:22:40'"));
        //D
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 1, 3, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-4) + " 18:24:00'"));
        //INTER
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 2, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-4) + " 19:24:40'"));
        //S
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-4) + " 20:00:40'"));
        return events;
    }

    public List<EventEntity> EVENTS_FOR_TRANSFER_DUTY_WITH_MALFUNCTION_DATA_DIAGNOST(long driverId) {
        List<EventEntity> events = new ArrayList<>();
        //D
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 1, 3, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 07:00:00'"));
        //ML
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 7, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 10:40:00'"));
        //MC
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 7, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 11:00:00'"));
        //ON DUTY A
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 1, 4, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 12:00:00'"));
        //DATA DIAG LOG
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 7, 3, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 13:00:00'"));
        //DATA DIAG CL
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 7, 4, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 13:05:00'"));
        //D
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 1, 3, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 15:23:00'"));
        //INTER
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 2, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 16:22:40'"));
        //INTER
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 2, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 17:22:40'"));
        //INTER
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 2, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 18:22:40'"));
        //D
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 1, 3, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 18:24:00'"));
        //MALF LOG
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 7, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 19:24:40'"));
        //DATA DIAG LOG
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 7, 3, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 20:00:40'"));
        return events;
    }

    public List<BdxEntity> EVENTS_FOR_TRANSFER_BDX(long driverId) {
        List<BdxEntity> bdxEvents = new ArrayList<>();
        bdxEvents.add(new BdxEntity(ORG_ID, driverId, TRUCK_ID, "'" + dateChange(-2) + " 16:00:00'", "'Manual'", "'US'", "'CA'"));
        return bdxEvents;
    }

    public List<EventEntity> EVENTS_FOR_TRANSFER_DUTY_CERT_BDX (long driverId) {
        List<EventEntity> events = new ArrayList<>();
        //ON
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 4, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 07:00:00'"));
        //CERT
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 4, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 10:40:00'"));
        //CERT
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 4, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 11:00:00'"));
        //CERT
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 4, 3, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 12:00:00'"));
        //PU
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 3, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 13:00:00'"));
        //CERT
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 4, 4, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 13:05:00'"));
        //CLEARED
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 3, 0, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 15:23:00'"));
        //OFF
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-2) + " 16:22:40'"));

        return events;
    }
    public List<EventEntity> EVENTS_FOR_DELETE_DUTY_EVENTS(long driverId) {
        List<EventEntity> events = new ArrayList<>();
        //OFF DUTY 14
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-7) + " 07:00:00'"));
        //SLEEP 13
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-7) + " 10:40:00'"));
        //DRIVING AUTO 12
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 1, 3, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-7) + " 17:00:00'"));
        //ON DUTY MANUAL 11
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 4, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-6) + " 01:00:00'"));
        //OFF 10
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-6) + " 05:00:00'"));
        //Power Up 9
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 6, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-6) + " 10:05:00'"));
        //D 8
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 1, 3, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-6) + " 15:23:00'"));
        //S 7
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-6) + " 17:22:40'"));
        //POWER DOWN 6
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 1, 6, 3, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-6) + " 17:40:01'"));
        //ON 5
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 4, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-6) + " 23:23:00'"));
        //YM 4
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 3, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-5) + " 15:23:00'"));
        //CLEARED 3
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 3, 0, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-5) + " 17:22:40'"));
        //SLEEP 2
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 2, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-5) + " 17:59:00'"));
        //OFF 1
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 1, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-5) + " 18:23:01'"));
        //PU 0
        events.add(new EventEntity(driverId, TRUCK_ID, ORG_ID, RECORD_STATUS, 2, 3, 1, LATTITUDE, LONGITUDE,
                LOCATION_DESCRIPTION, DEVICE_UID, "'" + dateChange(-5) + " 23:23:00'"));
        return events;
    }
    private String dateChange(int changeOnDays) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, changeOnDays * 24);
        String newDate = format.format(cal.getTime());
        return newDate;
    }


}
