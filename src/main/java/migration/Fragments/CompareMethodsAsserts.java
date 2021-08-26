package migration.Fragments;

import migration.*;
import migration.DAO.*;
import com.itextpdf.text.*;
import org.junit.jupiter.api.Assertions;

import java.sql.SQLException;
import java.util.List;

import static db.DBConstant.*;

public class CompareMethodsAsserts {
    public static void compareDriverByDriverId(String id) throws SQLException, IllegalAccessException {
        DriverProfileDAO profileDAOOld = new DriverProfileDAO(DB_URL, USER_DB, PASS_DB);
        DriverProfileDAO profileDAONew = new DriverProfileDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        DriverProfile oldValue = profileDAOOld.getDriverById(id);
        DriverProfile newValue = profileDAONew.getDriverById(getNewId.getNewDriverId(id));

//        System.out.println(newValue.toString());
//        System.out.println(oldValue.toString());

        //compareObjects(DriverProfileOld, DriverProfileNew);
        Assertions.assertEquals(oldValue.toString(), newValue.toString());
        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareDriverByDriverId " + id + " Done");
        }
    }

    public static void compareEldEventsByDriverId(String id) throws SQLException, IllegalAccessException {
        EldEventDao profileDAOOld = new EldEventDao(DB_URL, USER_DB, PASS_DB);
        EldEventDao profileDAONew = new EldEventDao(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);


        List<String> oldValue = profileDAOOld.getEldEventsForDriver(id);
        List<String> newValue = profileDAONew.getEldEventsForDriver(getNewId.getNewDriverId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

      //  System.out.println(newValue.toString());
      //  System.out.println(oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareEldEventsByDriverId " + id + " Done");
        }
    }

    public static void compareEldOriginalEventsById(String id) throws SQLException, IllegalAccessException {
        EldEventOriginalDao eldEventsOriginalOld = new EldEventOriginalDao(DB_URL, USER_DB, PASS_DB);
        EldEventOriginalDao eldEventsOriginalNew = new EldEventOriginalDao(DB_URL2, USER_DB2, PASS_DB2);
        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> newValue = eldEventsOriginalOld.getEldEventsOriginalForDriver(id);
        List<String> oldValue = eldEventsOriginalNew.getEldEventsOriginalForDriver(getNewId.getNewDriverId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

//        System.out.println(newValue.toString());
//        System.out.println(oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareEldOriginalEventsById " + id + " Done");
        }
    }

    public static void compareAccountsByOrgId(String id) throws SQLException, IllegalAccessException {
        AccountDAO daoOld = new AccountDAO(DB_URL, USER_DB, PASS_DB);
        AccountDAO daoNew = new AccountDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        Account oldValue = daoOld.getAccountByOrgId(id);
        Account newValue = daoNew.getAccountByOrgId(getNewId.getNewOrgId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareAccountsByOrgId " + id + " Done");
        }
    }

    public static void compareOrganizationsByOrgId(String id) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        OrganizationDAO daoOld = new OrganizationDAO(DB_URL, USER_DB, PASS_DB);
        OrganizationDAO daoNew = new OrganizationDAO(DB_URL2, USER_DB2, PASS_DB2);
        OrganizationDAO classPath = new OrganizationDAO(DB_URL, USER_DB, PASS_DB);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        Organization oldValue = daoOld.getOrganizationById(id);
        Organization newValue = daoNew.getOrganizationById(getNewId.getNewOrgId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        if(newValue.toString().equals(oldValue.toString())){
            System.out.println("compareOrganizationsByOrgId " + id + " Done");
        }
    }

    public static void compareAddressesByOrgId(String id) throws SQLException, IllegalAccessException {
        AddressDAO daoOld = new AddressDAO(DB_URL, USER_DB, PASS_DB);
        AddressDAO daoNew = new AddressDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        Address oldValue = daoOld.getAddressByOrgId(id);
        Address newValue = daoNew.getAddressByOrgId(getNewId.getNewOrgId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //System.out.println(newValue.toString());

        if(newValue.toString().equals(oldValue.toString())){
            System.out.println("compareAddressesByOrgId " + id + " Done");
        }
    }

    public static void compareOptionsByOrgId(String id) throws SQLException, IllegalAccessException {
        OptionDAO daoOld = new OptionDAO(DB_URL, USER_DB, PASS_DB);
        OptionDAO daoNew = new OptionDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfOptionsByOrgId(id);
        List<String> newValue = daoNew.getListOfOptionsByOrgId(getNewId.getNewOrgId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(newValue.toString().equals(oldValue.toString())){
            System.out.println("compareOptionsByOrgId " + id + " Done");
        }
    }

    public static void compareACLUserGroupsByOrgId(String id) throws SQLException, IllegalAccessException {
        ACLUserGroupDAO daoOld = new ACLUserGroupDAO(DB_URL, USER_DB, PASS_DB);
        ACLUserGroupDAO daoNew = new ACLUserGroupDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfACLUserGroupsByOrgId(id);
        List<String> newValue = daoNew.getListOfACLUserGroupsByOrgId(getNewId.getNewOrgId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //System.out.println(newValue.toString());
        //System.out.println(oldValue.toString());
        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLUserGroupsByOrgId " + id + " Done");
        }
    }

    public static void compareACLMatricesByOrgId(String id) throws SQLException, IllegalAccessException {
        ACLMatrixDAO daoOld = new ACLMatrixDAO(DB_URL, USER_DB, PASS_DB);
        ACLMatrixDAO daoNew = new ACLMatrixDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfACLMatrixByOrgId(id);
        List<String> newValue = daoNew.getListOfACLMatrixByOrgId(getNewId.getNewOrgId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLMatricesByOrgId " + id + " Done");
        }
    }

    public static void compareACLResourcesByOrgId(String id) throws SQLException, IllegalAccessException {
        ACLResourceDAO daoOld = new ACLResourceDAO(DB_URL, USER_DB, PASS_DB);
        ACLResourceDAO daoNew = new ACLResourceDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfACLResourcesByOrgId(id);
        List<String> newValue = daoNew.getListOfACLResourcesByOrgId(getNewId.getNewOrgId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLResourcesByOrgId " + id + " Done");
        }
    }

    public static void compareDepartmentsByOrgId(String id) throws SQLException, IllegalAccessException {
        DepartmentDAO daoOld = new DepartmentDAO(DB_URL, USER_DB, PASS_DB);
        DepartmentDAO daoNew = new DepartmentDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfDepartmentsByOrgId(id);
        List<String> newValue = daoNew.getListOfDepartmentsByOrgId(getNewId.getNewOrgId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareDepartmentsByOrgId " + id + " Done");
        }
    }

    public static void compareConsumersByOrgId(String id) throws SQLException, IllegalAccessException {
        ConsumerDAO daoOld = new ConsumerDAO(DB_URL, USER_DB, PASS_DB);
        ConsumerDAO daoNew = new ConsumerDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfConsumersByOrgId(id);
        List<String> newValue = daoNew.getListOfConsumersByOrgId(getNewId.getNewOrgId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareConsumersByOrgId " + id + " Done");
        }
    }

    public static void compareContactsByOrgId(String id) throws SQLException, IllegalAccessException {
        ContactDAO daoOld = new ContactDAO(DB_URL, USER_DB, PASS_DB);
        ContactDAO daoNew = new ContactDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        Contact oldValue = daoOld.getContactByOrgId(id);
        Contact newValue = daoNew.getContactByOrgId(getNewId.getNewOrgId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareContactsByOrgId " + id + " Done");
        }
    }

//    public static void compareAddressBooksByOrgId(String id) throws SQLException {
//        AddressBookRecordDAO daoOld = new AddressBookRecordDAO(DB_URL, USER_DB, PASS_DB);
//        AddressBookRecordDAO daoNew = new AddressBookRecordDAO(DB_URL2, USER_DB2, PASS_DB2);
//
//        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);
//
//        List<String> oldValue = daoOld.getListOfAddressBookRecordsByOrgId(id);
//        List<String> newValue = daoNew.getListOfAddressBookRecordsByOrgId(getNewId.getNewOrgId(id));
//
//        Assertions.assertEquals(newValue.toString(), oldValue.toString());
//
//        if(oldValue.toString().equals(newValue.toString())){
//            System.out.println("compareAddressBooksByOrgId " + id + " Done");
//        }
//    }

    public static void compareACLUsersByDriverId(String id) throws SQLException, IllegalAccessException {
        ACLUserDAO daoOld = new ACLUserDAO(DB_URL, USER_DB, PASS_DB);
        ACLUserDAO daoNew = new ACLUserDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        ACLUser oldValue = daoOld.getACLUserByDriverId(id);
        ACLUser newValue = daoNew.getACLUserByDriverId(getNewId.getNewDriverId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLUsersByDriverId " + id + " Done");
        }
    }


    public static void compareACLUsersByUserId(String id) throws SQLException, IllegalAccessException {
        ACLUserDAO daoOld = new ACLUserDAO(DB_URL, USER_DB, PASS_DB);
        ACLUserDAO daoNew = new ACLUserDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        ACLUser oldValue = daoOld.getACLUserByUserId(id);
        ACLUser newValue = daoNew.getACLUserByUserId(getNewId.getNewAclUserId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLUsersByUserId " + id + " Done");
        }
    }

    public static void compareAddressBooksByDriverId(String id) throws SQLException, IllegalAccessException {
        AddressBookRecordDAO daoOld = new AddressBookRecordDAO(DB_URL, USER_DB, PASS_DB);
        AddressBookRecordDAO daoNew = new AddressBookRecordDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfAddressBookRecordsByDriverId(id);
        List<String> newValue = daoNew.getListOfAddressBookRecordsByDriverId(getNewId.getNewDriverId(id));

        //System.out.println(oldValue.toString());
        //System.out.println(newValue.toString());

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareAddressBooksByDriverId " + id + " Done");
        }
    }

    public static void compareAddressBooksByUserId(String id) throws SQLException, IllegalAccessException {
        AddressBookRecordDAO daoOld = new AddressBookRecordDAO(DB_URL, USER_DB, PASS_DB);
        AddressBookRecordDAO daoNew = new AddressBookRecordDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfAddressBookRecordsByUserId(id);
        List<String> newValue = daoNew.getListOfAddressBookRecordsByUserId(getNewId.getNewAclUserId(id));
//
//        System.out.println(oldValue.toString());
//        System.out.println(newValue.toString());

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareAddressBooksByUserId " + id + " Done");
        }
    }

    public static void compareACLUserMatricesByUserId(String id) throws SQLException, IllegalAccessException {
        ACLUserMatrixDAO daoOld = new ACLUserMatrixDAO(DB_URL, USER_DB, PASS_DB);
        ACLUserMatrixDAO daoNew = new ACLUserMatrixDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfACLUserMatrixByUserId(id);
        List<String> newValue = daoNew.getListOfACLUserMatrixByUserId(getNewId.getNewAclUserId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLUserMatricesByUserId " + id + " Done");
        }
    }

    public static void compareACLUserInGroupByDriverId(String id) throws SQLException, IllegalAccessException {
        AclUserInGroupDAO daoOld = new AclUserInGroupDAO(DB_URL, USER_DB, PASS_DB);
        AclUserInGroupDAO daoNew = new AclUserInGroupDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getAclUserInGroupList(id);
        List<String> newValue = daoNew.getAclUserInGroupList(getNewId.getNewDriverId(id));

        Assertions.assertEquals(newValue.size(), oldValue.size());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLUserInGroupByDriverId " + id + " Done");
        }
    }

    public static void compareACLUserInGroupByUserId(String id) throws SQLException, IllegalAccessException {
        AclUserInGroupDAO daoOld = new AclUserInGroupDAO(DB_URL, USER_DB, PASS_DB);
        AclUserInGroupDAO daoNew = new AclUserInGroupDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getAclUserInGroupList(id);
        List<String> newValue = daoNew.getAclUserInGroupList(getNewId.getNewAclUserId(id));

        Assertions.assertEquals(newValue.size(), oldValue.size());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLUserInGroupByUserId " + id + " Done");
        }
    }

    public static void compareInspectionReportDriverId(String id) throws SQLException, IllegalAccessException {
        InspectionReportDao daoOld = new InspectionReportDao(DB_URL, USER_DB, PASS_DB);
        InspectionReportDao daoNew = new InspectionReportDao(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getInspectionReportsByDriver(id);
        List<String> newValue = daoNew.getInspectionReportsByDriver(getNewId.getNewDriverId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareInspectionReportDriverId " + id + " Done");
        }
    }

    public static void compareEldBorderCrossingEventsDriverId(String id) throws SQLException, IllegalAccessException {
        EldBorderCrossingEventDao daoOld = new EldBorderCrossingEventDao(DB_URL, USER_DB, PASS_DB);
        EldBorderCrossingEventDao daoNew = new EldBorderCrossingEventDao(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getEldBorderCrossingEventForDriver(id);
        List<String> newValue = daoNew.getEldBorderCrossingEventForDriver(getNewId.getNewDriverId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareEldBorderCrossingEventsDriverId " + id + " Done");
        }
    }

    public static void compareEldSignalsHistoryDriverId(String id) throws SQLException, IllegalAccessException {
        EldSignalHistoryDao daoOld = new EldSignalHistoryDao(DB_URL, USER_DB, PASS_DB);
        EldSignalHistoryDao daoNew = new EldSignalHistoryDao(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getEldSignalsHistoryByDriver(id);
        List<String> newValue = daoNew.getEldSignalsHistoryByDriver(getNewId.getNewDriverId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareEldSignalsHistoryDriverId " + id + " Done");
        }
    }

    public static void compareFmcsaEldExportDriverId(String id) throws SQLException, IllegalAccessException {
        FMCSAELDExportDAO daoOld = new FMCSAELDExportDAO(DB_URL, USER_DB, PASS_DB);
        FMCSAELDExportDAO daoNew = new FMCSAELDExportDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getFMCSAELDExportForDriver(id);
        List<String> newValue = daoNew.getFMCSAELDExportForDriver(getNewId.getNewDriverId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());
//
//        System.out.println(oldValue.toString());
//        System.out.println(newValue.toString());


        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareFmcsaEldExportDriverId " + id + " Done");
        }
    }

    public static void compareFuelPurchaseReceiptDriverId(String id) throws SQLException, IllegalAccessException {
        FuelPurchaseReceiptDAO daoOld = new FuelPurchaseReceiptDAO(DB_URL, USER_DB, PASS_DB);
        FuelPurchaseReceiptDAO daoNew = new FuelPurchaseReceiptDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getFuelPurchaseReceiptForDriver(id);
        List<String> newValue = daoNew.getFuelPurchaseReceiptForDriver(getNewId.getNewDriverId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareFuelPurchaseReceiptDriverId " + id + " Done");
        }
    }

    public static void compareTruckByTruckId(String id) throws SQLException, IllegalAccessException {
        TruckDAO daoOld = new TruckDAO(DB_URL, USER_DB, PASS_DB);
        TruckDAO daoNew = new TruckDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        Truck oldValue = daoOld.getTruckById(id);
        Truck newValue = daoNew.getTruckById(getNewId.getNewTruckId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareTruckByTruckId " + id + " Done");
        }
    }

    public static void compareTruckDeviceSignalHistoryByTruckId(String id) throws SQLException, IllegalAccessException {
        TruckDeviceSignalHistoryDAO daoOld = new TruckDeviceSignalHistoryDAO(DB_URL, USER_DB, PASS_DB);
        TruckDeviceSignalHistoryDAO daoNew = new TruckDeviceSignalHistoryDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getTruckDeviceSignalsByTruckId(id);
        List<String> newValue = daoNew.getTruckDeviceSignalsByTruckId(getNewId.getNewTruckId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

//        System.out.println(newValue.toString());
//        System.out.println(oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareTruckDeviceSignalHistoryByTruckId " + id + " Done");
        }
    }

    public static void compareTagsByDriverId(String id) throws SQLException, IllegalAccessException {
        tagDAO daoOld = new tagDAO(DB_URL, USER_DB, PASS_DB);
        tagDAO daoNew = new tagDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getTagsByDriverId(id);
        List<String> newValue = daoNew.getTagsByDriverId(getNewId.getNewDriverId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        System.out.println(newValue.toString());
        System.out.println(oldValue.toString());
        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareTagsByOrgId " + id + " Done");
        }
    }

    public static void compareTransportMovementByTruckId(String id) throws SQLException, IllegalAccessException {
        TransportMovementDAO daoOld = new TransportMovementDAO(DB_URL, USER_DB, PASS_DB);
        TransportMovementDAO daoNew = new TransportMovementDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getTransportMovementsByTruckId(id);
        List<String> newValue = daoNew.getTransportMovementsByTruckId(getNewId.getNewTruckId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareTransportMovementByTruckId " + id + " Done");
        }
    }

    public static void compareTransportMovementHistoryByTruckId(String id) throws SQLException, IllegalAccessException {
        TransportMovementHistoryDAO daoOld = new TransportMovementHistoryDAO(DB_URL, USER_DB, PASS_DB);
        TransportMovementHistoryDAO daoNew = new TransportMovementHistoryDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getTransportMovementsHistoryByTruckId(id);
        List<String> newValue = daoNew.getTransportMovementsHistoryByTruckId(getNewId.getNewTruckId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareTransportMovementHistoryByTruckId " + id + " Done");
        }
    }

    public static void compareTrailerByTrailerId(String id) throws SQLException, IllegalAccessException {
        TrailerDAO daoOld = new TrailerDAO(DB_URL, USER_DB, PASS_DB);
        TrailerDAO daoNew = new TrailerDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        Trailer oldValue = daoOld.getTrailerById(id);
        Trailer newValue = daoNew.getTrailerById(getNewId.getNewTrailerId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareTrailerByTrailerId " + id + " Done");
        }
    }

    public static void compareTrailerDeviceSignalHistoryByTrailerId(String id) throws SQLException, IllegalAccessException {
        TrailerDeviceSignalHistoryDAO daoOld = new TrailerDeviceSignalHistoryDAO(DB_URL, USER_DB, PASS_DB);
        TrailerDeviceSignalHistoryDAO daoNew = new TrailerDeviceSignalHistoryDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getTrailerDeviceSignalsByTrailerId(id);
        List<String> newValue = daoNew.getTrailerDeviceSignalsByTrailerId(getNewId.getNewTrailerId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareTrailerDeviceSignalHistoryByTrailerId " + id + " Done");
        }
    }

    public static void compareEdiDataConsumerByOrgId(String id) throws SQLException, IllegalAccessException {
        EdiDataConsumerDAO daoOld = new EdiDataConsumerDAO(DB_URL, USER_DB, PASS_DB);
        EdiDataConsumerDAO daoNew = new EdiDataConsumerDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getEdiDataConsumerByOrgId(id);
        List<String> newValue = daoNew.getEdiDataConsumerByOrgId(getNewId.getNewOrgId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareEdiDataConsumerByOrgId " + id + " Done");
        }
    }

    public static void compareGpsSignalConsumerByOrgId(String id) throws SQLException, IllegalAccessException {
        GPSSignalConsumerDAO daoOld = new GPSSignalConsumerDAO(DB_URL, USER_DB, PASS_DB);
        GPSSignalConsumerDAO daoNew = new GPSSignalConsumerDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getGpsSignalConsumerByOrgId(id);
        List<String> newValue = daoNew.getGpsSignalConsumerByOrgId(getNewId.getNewOrgId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareGpsSignalConsumerByOrgId " + id + " Done");
        }
    }

    public static void compareGeocodeProviderByOrgId(String id) throws SQLException, IllegalAccessException {
        GeocodeProviderDAO daoOld = new GeocodeProviderDAO(DB_URL, USER_DB, PASS_DB);
        GeocodeProviderDAO daoNew = new GeocodeProviderDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getGeocodeProvideByOrgId(id);
        List<String> newValue = daoNew.getGeocodeProvideByOrgId(getNewId.getNewOrgId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareGeocodeProviderByOrgId " + id + " Done");
        }
    }

    public static void compareMessagingProviderByOrgId(String id) throws SQLException, IllegalAccessException {
        MessagingProviderDAO daoOld = new MessagingProviderDAO(DB_URL, USER_DB, PASS_DB);
        MessagingProviderDAO daoNew = new MessagingProviderDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getMessagingProvideByOrgId(id);
        List<String> newValue = daoNew.getMessagingProvideByOrgId(getNewId.getNewOrgId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareMessagingProviderByOrgId " + id + " Done");
        }
    }

    public static void compareHosProviderByOrgId(String id) throws SQLException, IllegalAccessException {
        HosProviderDAO daoOld = new HosProviderDAO(DB_URL, USER_DB, PASS_DB);
        HosProviderDAO daoNew = new HosProviderDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getHOSProvideByOrgId(id);
        List<String> newValue = daoNew.getHOSProvideByOrgId(getNewId.getNewOrgId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareHosProviderByOrgId " + id + " Done");
        }
    }

    public static void compareGpsSignalProviderByOrgId(String id) throws SQLException, IllegalAccessException {
        GPSSignalProviderDAO daoOld = new GPSSignalProviderDAO(DB_URL, USER_DB, PASS_DB);
        GPSSignalProviderDAO daoNew = new GPSSignalProviderDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getGpsSignalsProvideByOrgId(id);
        List<String> newValue = daoNew.getGpsSignalsProvideByOrgId(getNewId.getNewOrgId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());

        //compareObjects(oldValue, newValue);

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareGpsSignalProviderByOrgId " + id + " Done");
        }
    }

    public static void compareStripeCustomerByDriver(String id) throws SQLException, IllegalAccessException {
        StripeCustomerDAO daoOld = new StripeCustomerDAO(DB_URL, USER_DB, PASS_DB);
        StripeCustomerDAO daoNew = new StripeCustomerDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getStripeCustomerByDriverId(id);
        List<String> newValue = daoNew.getStripeCustomerByDriverId(getNewId.getNewDriverId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());
        //compareObjects(oldValue, newValue);

        System.out.println(newValue.toString());
        System.out.println(oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareStripeCustomer " + id + " Done");
        }
    }

    public static void compareStripeSubscriptionByDriver(String id) throws SQLException, IllegalAccessException {
        StripeSubscriptionDAO daoOld = new StripeSubscriptionDAO(DB_URL, USER_DB, PASS_DB);
        StripeSubscriptionDAO daoNew = new StripeSubscriptionDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getStripeSubscription(id);
        List<String> newValue = daoNew.getStripeSubscription(getNewId.getNewDriverId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());
        //compareObjects(oldValue, newValue);
        System.out.println(newValue.toString());
        System.out.println(oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareStripeSubscription " + id + " Done");
        }
    }

    public static void compareStripeSubscriptionItemByDriver(String id) throws SQLException, IllegalAccessException {
        StripeSubscriptionItemDAO daoOld = new StripeSubscriptionItemDAO(DB_URL, USER_DB, PASS_DB);
        StripeSubscriptionItemDAO daoNew = new StripeSubscriptionItemDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getStripeSubscriptionItem(id);
        List<String> newValue = daoNew.getStripeSubscriptionItem(getNewId.getNewDriverId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());
        //compareObjects(oldValue, newValue);
        System.out.println(newValue.toString());
        System.out.println(oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareStripeSubscriptionItem " + id + " Done");
        }
    }

    public static void compareEldSubscriptionsByDriver(String id) throws SQLException, IllegalAccessException {
        EldSubscriptionDAO daoOld = new EldSubscriptionDAO(DB_URL, USER_DB, PASS_DB);
        EldSubscriptionDAO daoNew = new EldSubscriptionDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getEldSubscription(id);
        List<String> newValue = daoNew.getEldSubscription(getNewId.getNewDriverId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());
        //compareObjects(oldValue, newValue);
        System.out.println(newValue.toString());
        System.out.println(oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareEldSubscriptionsByDriver " + id + " Done");
        }
    }

    public static void compareStripeCustomerByUser(String id) throws SQLException, IllegalAccessException {
        StripeCustomerDAO daoOld = new StripeCustomerDAO(DB_URL, USER_DB, PASS_DB);
        StripeCustomerDAO daoNew = new StripeCustomerDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getStripeCustomerByUser(id);
        List<String> newValue = daoNew.getStripeCustomerByUser(getNewId.getNewAclUserId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());
        //compareObjects(oldValue, newValue);
        System.out.println(newValue.toString());
        System.out.println(oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareStripeCustomer " + id + " Done");
        }
    }

    public static void compareStripeSubscriptionByUser(String id) throws SQLException, IllegalAccessException {
        StripeSubscriptionDAO daoOld = new StripeSubscriptionDAO(DB_URL, USER_DB, PASS_DB);
        StripeSubscriptionDAO daoNew = new StripeSubscriptionDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getStripeSubscriptionByUser(id);
        List<String> newValue = daoNew.getStripeSubscriptionByUser(getNewId.getNewAclUserId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());
        //compareObjects(oldValue, newValue);
        System.out.println(newValue.toString());
        System.out.println(oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareStripeSubscription " + id + " Done");
        }
    }

    public static void compareStripeSubscriptionItemByUser(String id) throws SQLException, IllegalAccessException {
        StripeSubscriptionItemDAO daoOld = new StripeSubscriptionItemDAO(DB_URL, USER_DB, PASS_DB);
        StripeSubscriptionItemDAO daoNew = new StripeSubscriptionItemDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getStripeSubscriptionItemByUser(id);
        List<String> newValue = daoNew.getStripeSubscriptionItemByUser(getNewId.getNewAclUserId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());
        //compareObjects(oldValue, newValue);
        System.out.println(newValue.toString());
        System.out.println(oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareStripeSubscriptionItem " + id + " Done");
        }
    }

    public static void compareEldSubscriptionsByUser(String id) throws SQLException, IllegalAccessException {
        EldSubscriptionDAO daoOld = new EldSubscriptionDAO(DB_URL, USER_DB, PASS_DB);
        EldSubscriptionDAO daoNew = new EldSubscriptionDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getEldSubscriptionByUser(id);
        List<String> newValue = daoNew.getEldSubscriptionByUser(getNewId.getNewAclUserId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());
        //compareObjects(oldValue, newValue);
        System.out.println(newValue.toString());
        System.out.println(oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareEldSubscriptions " + id + " Done");
        }
    }

    public static void compareHosDayVerify(String id) throws SQLException, IllegalAccessException {
        HosDayVerifyDAO daoOld = new HosDayVerifyDAO(DB_URL, USER_DB, PASS_DB);
        HosDayVerifyDAO daoNew = new HosDayVerifyDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getHosVerifyByDriver(id);
        List<String> newValue = daoNew.getHosVerifyByDriver(getNewId.getNewDriverId(id));

        Assertions.assertEquals(newValue.toString(), oldValue.toString());
        //compareObjects(oldValue, newValue);
        System.out.println(newValue.toString());
        System.out.println(oldValue.toString());

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareEldSubscriptions " + id + " Done");
        }
    }
}
