package Migration.Fragments;

import Migration.*;
import Migration.DAO.*;
import org.junit.jupiter.api.Assertions;

import java.sql.SQLException;
import java.util.List;

import static DB.DBConstant.*;

public class CompareMethods {

    public static void compareDriverByDriverId(String id) throws SQLException {
        DriverProfileDAO profileDAOOld = new DriverProfileDAO(DB_URL, USER_DB, PASS_DB);
        DriverProfileDAO profileDAONew = new DriverProfileDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        DriverProfile DriverProfileOld = profileDAOOld.getDriverById(id);
        DriverProfile DriverProfileNew = profileDAONew.getDriverById(getNewId.getNewDriverId(id));

        Assertions.assertEquals(DriverProfileOld.toString(), DriverProfileNew.toString());
        if(DriverProfileOld.toString().equals(DriverProfileNew.toString())){
            System.out.println("compareDriverByDriverId " + id + " Done");
        }
    }

    public static void compareEldEventsByDriverId(String id) throws SQLException {
        EldEventDao profileDAOOld = new EldEventDao(DB_URL, USER_DB, PASS_DB);
        EldEventDao profileDAONew = new EldEventDao(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);


        List<String> eldEventOld = profileDAOOld.getEldEventsForDriver(id);
        List<String> eldEventNew = profileDAONew.getEldEventsForDriver(getNewId.getNewDriverId(id));

        Assertions.assertEquals(eldEventNew.toString(), eldEventOld.toString());
        if(eldEventOld.toString().equals(eldEventNew.toString())){
            System.out.println("compareEldEventsByDriverId " + id + " Done");
        }
    }

    public static void compareEldOriginalEventsById(String id) throws SQLException {
        EldEventOriginalDao eldEventsOriginalOld = new EldEventOriginalDao(DB_URL, USER_DB, PASS_DB);
        EldEventOriginalDao eldEventsOriginalNew = new EldEventOriginalDao(DB_URL2, USER_DB2, PASS_DB2);
        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> eldEventOld = eldEventsOriginalOld.getEldEventsOriginalForDriver(id);
        List<String> eldEventNew = eldEventsOriginalNew.getEldEventsOriginalForDriver(getNewId.getNewDriverId(id));

        Assertions.assertEquals(eldEventNew.toString(), eldEventOld.toString());
        if(eldEventOld.toString().equals(eldEventNew.toString())){
            System.out.println("compareEldOriginalEventsById " + id + " Done");
        }
    }

    public static void compareAccountsByOrgId(String id) throws SQLException {
        AccountDAO daoOld = new AccountDAO(DB_URL, USER_DB, PASS_DB);
        AccountDAO daoNew = new AccountDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        Account oldValue = daoOld.getAccountByOrgId(id);
        Account newValue = daoNew.getAccountByOrgId(id);

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareAccountsByOrgId " + id + " Done");
        }
    }

    public static void compareOrganizationsByOrgId(String id) throws SQLException {
        OrganizationDAO daoOld = new OrganizationDAO(DB_URL, USER_DB, PASS_DB);
        OrganizationDAO daoNew = new OrganizationDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        Organization oldValue = daoOld.getOrganizationById(id);
        Organization newValue = daoNew.getOrganizationById(id);

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareOrganizationsByOrgId " + id + " Done");
        }
    }

    public static void compareAddressesByOrgId(String id) throws SQLException {
        AddressDAO daoOld = new AddressDAO(DB_URL, USER_DB, PASS_DB);
        AddressDAO daoNew = new AddressDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        Address oldValue = daoOld.getAddressByOrgId(id);
        Address newValue = daoNew.getAddressByOrgId(id);

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareAddressesByOrgId " + id + " Done");
        }
    }

    public static void compareOptionsByOrgId(String id) throws SQLException {
        OptionDAO daoOld = new OptionDAO(DB_URL, USER_DB, PASS_DB);
        OptionDAO daoNew = new OptionDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfOptionsByOrgId(id);
        List<String> newValue = daoNew.getListOfOptionsByOrgId(id);

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareOptionsByOrgId " + id + " Done");
        }
    }

    public static void compareACLUserGroupsByOrgId(String id) throws SQLException {
        ACLUserGroupDAO daoOld = new ACLUserGroupDAO(DB_URL, USER_DB, PASS_DB);
        ACLUserGroupDAO daoNew = new ACLUserGroupDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfACLUserGroupsByOrgId(id);
        List<String> newValue = daoNew.getListOfACLUserGroupsByOrgId(id);

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLUserGroupsByOrgId " + id + " Done");
        }
    }

    public static void compareACLMatricesByOrgId(String id) throws SQLException {
        ACLMatrixDAO daoOld = new ACLMatrixDAO(DB_URL, USER_DB, PASS_DB);
        ACLMatrixDAO daoNew = new ACLMatrixDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfACLMatrixByOrgId(id);
        List<String> newValue = daoNew.getListOfACLMatrixByOrgId(id);

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLMatricesByOrgId " + id + " Done");
        }
    }

    public static void compareACLResourcesByOrgId(String id) throws SQLException {
        ACLResourceDAO daoOld = new ACLResourceDAO(DB_URL, USER_DB, PASS_DB);
        ACLResourceDAO daoNew = new ACLResourceDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfACLResourcesByOrgId(id);
        List<String> newValue = daoNew.getListOfACLResourcesByOrgId(id);

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLResourcesByOrgId " + id + " Done");
        }
    }

    public static void compareDepartmentsByOrgId(String id) throws SQLException {
        DepartmentDAO daoOld = new DepartmentDAO(DB_URL, USER_DB, PASS_DB);
        DepartmentDAO daoNew = new DepartmentDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfDepartmentsByOrgId(id);
        List<String> newValue = daoNew.getListOfDepartmentsByOrgId(id);

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareDepartmentsByOrgId " + id + " Done");
        }
    }

    public static void compareConsumersByOrgId(String id) throws SQLException {
        ConsumerDAO daoOld = new ConsumerDAO(DB_URL, USER_DB, PASS_DB);
        ConsumerDAO daoNew = new ConsumerDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfConsumersByOrgId(id);
        List<String> newValue = daoNew.getListOfConsumersByOrgId(id);

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareConsumersByOrgId " + id + " Done");
        }
    }

    public static void compareContactsByOrgId(String id) throws SQLException {
        ContactDAO daoOld = new ContactDAO(DB_URL, USER_DB, PASS_DB);
        ContactDAO daoNew = new ContactDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        Contact oldValue = daoOld.getContactByOrgId(id);
        Contact newValue = daoNew.getContactByOrgId(id);

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareContactsByOrgId " + id + " Done");
        }
    }

    public static void compareAddressBooksByOrgId(String id) throws SQLException {
        AddressBookRecordDAO daoOld = new AddressBookRecordDAO(DB_URL, USER_DB, PASS_DB);
        AddressBookRecordDAO daoNew = new AddressBookRecordDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfAddressBookRecordsByOrgId(id);
        List<String> newValue = daoNew.getListOfAddressBookRecordsByOrgId(id);

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareAddressBooksByOrgId " + id + " Done");
        }
    }

    public static void compareACLUsersByDriverId(String id) throws SQLException {
        ACLUserDAO daoOld = new ACLUserDAO(DB_URL, USER_DB, PASS_DB);
        ACLUserDAO daoNew = new ACLUserDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        ACLUser oldValue = daoOld.getACLUserByDriverId(id);
        ACLUser newValue = daoNew.getACLUserByDriverId(getNewId.getNewDriverId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLUsersByDriverId " + id + " Done");
        }
    }


    public static void compareACLUsersByUserId(String id) throws SQLException {
        ACLUserDAO daoOld = new ACLUserDAO(DB_URL, USER_DB, PASS_DB);
        ACLUserDAO daoNew = new ACLUserDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        ACLUser oldValue = daoOld.getACLUserByUserId(id);
        ACLUser newValue = daoNew.getACLUserByUserId(getNewId.getNewAclUserId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLUsersByUserId " + id + " Done");
        }
    }

    public static void compareACLUserMatricesByUserId(String id) throws SQLException {
        ACLUserMatrixDAO daoOld = new ACLUserMatrixDAO(DB_URL, USER_DB, PASS_DB);
        ACLUserMatrixDAO daoNew = new ACLUserMatrixDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfACLUserMatrixByUserId(id);
        List<String> newValue = daoNew.getListOfACLUserMatrixByUserId(getNewId.getNewAclUserId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLUserMatricesByUserId " + id + " Done");
        }
    }

    public static void compareACLUserInGroupByDriverId(String id) throws SQLException {
        AclUserInGroupDAO daoOld = new AclUserInGroupDAO(DB_URL, USER_DB, PASS_DB);
        AclUserInGroupDAO daoNew = new AclUserInGroupDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getAclUserInGroupList(id);
        List<String> newValue = daoNew.getAclUserInGroupList(getNewId.getNewAclUserId(id));

        Assertions.assertEquals(newValue.size(), oldValue.size());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLUserInGroupByDriverId " + id + " Done");
        }
    }

    public static void compareACLUserInGroupByUserId(String id) throws SQLException {
        AclUserInGroupDAO daoOld = new AclUserInGroupDAO(DB_URL, USER_DB, PASS_DB);
        AclUserInGroupDAO daoNew = new AclUserInGroupDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getAclUserInGroupList(id);
        List<String> newValue = daoNew.getAclUserInGroupList(getNewId.getNewAclUserId(id));

        Assertions.assertEquals(newValue.size(), oldValue.size());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLUserInGroupByUserId " + id + " Done");
        }
    }

    public static void compareInspectionReportDriverId(String id) throws SQLException {
        InspectionReportDao daoOld = new InspectionReportDao(DB_URL, USER_DB, PASS_DB);
        InspectionReportDao daoNew = new InspectionReportDao(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getInspectionReportsByDriver(id);
        List<String> newValue = daoNew.getInspectionReportsByDriver(getNewId.getNewDriverId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareInspectionReportDriverId " + id + " Done");
        }
    }

    public static void compareEldBorderCrossingEventsDriverId(String id) throws SQLException {
        EldBorderCrossingEventDao daoOld = new EldBorderCrossingEventDao(DB_URL, USER_DB, PASS_DB);
        EldBorderCrossingEventDao daoNew = new EldBorderCrossingEventDao(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getEldBorderCrossingEventForDriver(id);
        List<String> newValue = daoNew.getEldBorderCrossingEventForDriver(getNewId.getNewDriverId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareEldBorderCrossingEventsDriverId " + id + " Done");
        }
    }

    public static void compareEldSignalsHistoryDriverId(String id) throws SQLException {
        EldSignalHistoryDao daoOld = new EldSignalHistoryDao(DB_URL, USER_DB, PASS_DB);
        EldSignalHistoryDao daoNew = new EldSignalHistoryDao(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getEldSignalsHistoryByDriver(id);
        List<String> newValue = daoNew.getEldSignalsHistoryByDriver(getNewId.getNewDriverId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareEldSignalsHistoryDriverId " + id + " Done");
        }
    }

    public static void compareFmcsaEldExportDriverId(String id) throws SQLException {
        FMCSAELDExportDAO daoOld = new FMCSAELDExportDAO(DB_URL, USER_DB, PASS_DB);
        FMCSAELDExportDAO daoNew = new FMCSAELDExportDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getFMCSAELDExportForDriver(id);
        List<String> newValue = daoNew.getFMCSAELDExportForDriver(getNewId.getNewDriverId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareFmcsaEldExportDriverId " + id + " Done");
        }
    }

    public static void compareFuelPurchaseReceiptDriverId(String id) throws SQLException {
        FuelPurchaseReceiptDAO daoOld = new FuelPurchaseReceiptDAO(DB_URL, USER_DB, PASS_DB);
        FuelPurchaseReceiptDAO daoNew = new FuelPurchaseReceiptDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getFuelPurchaseReceiptForDriver(id);
        List<String> newValue = daoNew.getFuelPurchaseReceiptForDriver(getNewId.getNewDriverId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareFuelPurchaseReceiptDriverId " + id + " Done");
        }
    }

    public static void compareTruckByTruckId(String id) throws SQLException {
        TruckDAO daoOld = new TruckDAO(DB_URL, USER_DB, PASS_DB);
        TruckDAO daoNew = new TruckDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        Truck oldValue = daoOld.getTruckById(id);
        Truck newValue = daoNew.getTruckById(getNewId.getNewTruckId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareTruckByTruckId " + id + " Done");
        }
    }

    public static void compareTruckDeviceSignalHistoryByTruckId(String id) throws SQLException {
        TruckDeviceSignalHistoryDAO daoOld = new TruckDeviceSignalHistoryDAO(DB_URL, USER_DB, PASS_DB);
        TruckDeviceSignalHistoryDAO daoNew = new TruckDeviceSignalHistoryDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getTruckDeviceSignalsByTruckId(id);
        List<String> newValue = daoNew.getTruckDeviceSignalsByTruckId(getNewId.getNewTruckId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareTruckDeviceSignalHistoryByTruckId " + id + " Done");
        }
    }

    public static void compareTagsByOrgId(String id) throws SQLException {
        tagDAO daoOld = new tagDAO(DB_URL, USER_DB, PASS_DB);
        tagDAO daoNew = new tagDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getTagsByOrgId(id);
        List<String> newValue = daoNew.getTagsByOrgId(id);

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareTagsByOrgId " + id + " Done");
        }
    }

    public static void compareTransportMovementByTruckId(String id) throws SQLException {
        TransportMovementDAO daoOld = new TransportMovementDAO(DB_URL, USER_DB, PASS_DB);
        TransportMovementDAO daoNew = new TransportMovementDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getTransportMovementsByTruckId(id);
        List<String> newValue = daoNew.getTransportMovementsByTruckId(getNewId.getNewTruckId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareTransportMovementByTruckId " + id + " Done");
        }
    }

    public static void compareTransportMovementHistoryByTruckId(String id) throws SQLException {
        TransportMovementHistoryDAO daoOld = new TransportMovementHistoryDAO(DB_URL, USER_DB, PASS_DB);
        TransportMovementHistoryDAO daoNew = new TransportMovementHistoryDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getTransportMovementsHistoryByTruckId(id);
        List<String> newValue = daoNew.getTransportMovementsHistoryByTruckId(getNewId.getNewTruckId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareTransportMovementHistoryByTruckId " + id + " Done");
        }
    }

    public static void compareTrailerByTrailerId(String id) throws SQLException {
        TrailerDAO daoOld = new TrailerDAO(DB_URL, USER_DB, PASS_DB);
        TrailerDAO daoNew = new TrailerDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        Trailer oldValue = daoOld.getTrailerById(id);
        Trailer newValue = daoNew.getTrailerById(getNewId.getNewTrailerId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareTrailerByTrailerId " + id + " Done");
        }
    }

    public static void compareTrailerDeviceSignalHistoryByTrailerId(String id) throws SQLException {
        TrailerDeviceSignalHistoryDAO daoOld = new TrailerDeviceSignalHistoryDAO(DB_URL, USER_DB, PASS_DB);
        TrailerDeviceSignalHistoryDAO daoNew = new TrailerDeviceSignalHistoryDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getTrailerDeviceSignalsByTrailerId(id);
        List<String> newValue = daoNew.getTrailerDeviceSignalsByTrailerId(getNewId.getNewTrailerId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareTrailerDeviceSignalHistoryByTrailerId " + id + " Done");
        }
    }

    public static void compareEdiDataConsumerByOrgId(String id) throws SQLException {
        EdiDataConsumerDAO daoOld = new EdiDataConsumerDAO(DB_URL, USER_DB, PASS_DB);
        EdiDataConsumerDAO daoNew = new EdiDataConsumerDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getEdiDataConsumerByOrgId(id);
        List<String> newValue = daoNew.getEdiDataConsumerByOrgId(id);

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareEdiDataConsumerByOrgId " + id + " Done");
        }
    }

    public static void compareGpsSignalConsumerByOrgId(String id) throws SQLException {
        GPSSignalConsumerDAO daoOld = new GPSSignalConsumerDAO(DB_URL, USER_DB, PASS_DB);
        GPSSignalConsumerDAO daoNew = new GPSSignalConsumerDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getGpsSignalConsumerByOrgId(id);
        List<String> newValue = daoNew.getGpsSignalConsumerByOrgId(id);

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareGpsSignalConsumerByOrgId " + id + " Done");
        }
    }

    public static void compareGeocodeProviderByOrgId(String id) throws SQLException {
        GeocodeProviderDAO daoOld = new GeocodeProviderDAO(DB_URL, USER_DB, PASS_DB);
        GeocodeProviderDAO daoNew = new GeocodeProviderDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getGeocodeProvideByOrgId(id);
        List<String> newValue = daoNew.getGeocodeProvideByOrgId(id);

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareGeocodeProviderByOrgId " + id + " Done");
        }
    }

    public static void compareMessagingProviderByOrgId(String id) throws SQLException {
        MessagingProviderDAO daoOld = new MessagingProviderDAO(DB_URL, USER_DB, PASS_DB);
        MessagingProviderDAO daoNew = new MessagingProviderDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getMessagingProvideByOrgId(id);
        List<String> newValue = daoNew.getMessagingProvideByOrgId(id);

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareMessagingProviderByOrgId " + id + " Done");
        }
    }

    public static void compareHosProviderByOrgId(String id) throws SQLException {
        HosProviderDAO daoOld = new HosProviderDAO(DB_URL, USER_DB, PASS_DB);
        HosProviderDAO daoNew = new HosProviderDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getHOSProvideByOrgId(id);
        List<String> newValue = daoNew.getHOSProvideByOrgId(id);

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareHosProviderByOrgId " + id + " Done");
        }
    }

    public static void compareGpsSignalProviderByOrgId(String id) throws SQLException {
        GPSSignalProviderDAO daoOld = new GPSSignalProviderDAO(DB_URL, USER_DB, PASS_DB);
        GPSSignalProviderDAO daoNew = new GPSSignalProviderDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getGpsSignalsProvideByOrgId(id);
        List<String> newValue = daoNew.getGpsSignalsProvideByOrgId(id);

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareGpsSignalProviderByOrgId " + id + " Done");
        }
    }
}
