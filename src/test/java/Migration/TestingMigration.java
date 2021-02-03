package Migration;

import Migration.Fragments.CompareMethods;
import Migration.Fragments.EldEvents;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class TestingMigration extends CompareMethods{
    @BeforeAll
    static void setup() {
        ;
    }


    @Test
    public void testDriver() throws SQLException {
        compareDriverByDriverId("25364");
        compareEldEventsByDriverId("25364");
        compareEldOriginalEventsById("25364");
        compareInspectionReportDriverId("25364");
        compareEldBorderCrossingEventsDriverId("25364");
        compareEldSignalsHistoryDriverId("25364");
        compareFmcsaEldExportDriverId("25364");
        compareFuelPurchaseReceiptDriverId("25364");
    }

    @Test
    public void testTruck() throws SQLException {
        compareTruckByTruckId("289040");
        compareTruckDeviceSignalHistoryByTruckId("289040");
        compareTagsByOrgId("289040");
        compareTransportMovementByTruckId("289040");
        compareTransportMovementHistoryByTruckId("289040");
    }

    @Test
    public void testTrailer() throws SQLException {
        compareTrailerByTrailerId("55035");
        compareTrailerDeviceSignalHistoryByTrailerId("55035");
    }

    @Test
    public void testOrg() throws SQLException {
        compareOrganizationsByOrgId("1370");
        compareAddressesByOrgId("1370");
        //compareOptionsByOrgId("1370");
        compareACLUserGroupsByOrgId("1370");
        compareACLMatricesByOrgId("1370");
        compareDepartmentsByOrgId("1370");
        compareConsumersByOrgId("1370");
        compareAccountsByOrgId("1370");
        //compareContactsByOrgId("1370");

        //compareAddressBooksByOrgId("1370");
        //compareACLUserMatricesByOrgId("1370");
        // Узнать кто именно переходит

        //compareACLUserInGroupByOrgId("1370");
        compareGpsSignalProviderByOrgId("1370");
        compareHosProviderByOrgId("1370");
        compareMessagingProviderByOrgId("1370");
        compareGeocodeProviderByOrgId("1370");
        compareGpsSignalConsumerByOrgId("1370");
        compareEdiDataConsumerByOrgId("1370");

        compareACLUsersByDriverId("25364");
    }
}
