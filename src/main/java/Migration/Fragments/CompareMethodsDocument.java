package Migration.Fragments;

import Migration.*;
import Migration.DAO.*;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;
import java.util.Timer;

import static DB.DBConstant.*;
import static Migration.Fragments.Report.catFont;

public class CompareMethodsDocument {
    public static void compareDriverByDriverId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        DriverProfileDAO daoOld = new DriverProfileDAO(DB_URL, USER_DB, PASS_DB);
        DriverProfileDAO daoNew = new DriverProfileDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        DriverProfile oldValue = daoOld.getDriverById(id);
        DriverProfile newValue = daoNew.getDriverById(getNewId.getNewDriverId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareDriverByDriverId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareDriverByDriverId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareEldEventsByDriverId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        EldEventDao daoOld = new EldEventDao(DB_URL, USER_DB, PASS_DB);
        EldEventDao daoNew = new EldEventDao(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getEldEventsForDriver(id);
        List<String> newValue = daoNew.getEldEventsForDriver(getNewId.getNewDriverId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareEldEventsByDriverId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareEldEventsByDriverId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareEldOriginalEventsById(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        EldEventOriginalDao daoOld = new EldEventOriginalDao(DB_URL, USER_DB, PASS_DB);
        EldEventOriginalDao daoNew = new EldEventOriginalDao(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> newValue = daoOld.getEldEventsOriginalForDriver(id);
        List<String> oldValue = daoNew.getEldEventsOriginalForDriver(getNewId.getNewDriverId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareEldOriginalEventsById " + id + " Done");
        } else {
            Anchor title = new Anchor("compareEldOriginalEventsById " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareAccountsByOrgId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        AccountDAO daoOld = new AccountDAO(DB_URL, USER_DB, PASS_DB);
        AccountDAO daoNew = new AccountDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        Account oldValue = daoOld.getAccountByOrgId(id);
        Account newValue = daoNew.getAccountByOrgId(getNewId.getNewOrgId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareAccountsByOrgId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareAccountsByOrgId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareOrganizationsByOrgId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException, NoSuchFieldException {
        OrganizationDAO daoOld = new OrganizationDAO(DB_URL, USER_DB, PASS_DB);
        OrganizationDAO daoNew = new OrganizationDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        Organization oldValue = daoOld.getOrganizationById(id);
        Organization newValue = daoNew.getOrganizationById(getNewId.getNewOrgId(id));

        if(newValue.toString().equals(oldValue.toString())){
            System.out.println("compareOrganizationsByOrgId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareOrganizationsByOrgId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareAddressesByOrgId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        AddressDAO daoOld = new AddressDAO(DB_URL, USER_DB, PASS_DB);
        AddressDAO daoNew = new AddressDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        Address oldValue = daoOld.getAddressByOrgId(id);
        Address newValue = daoNew.getAddressByOrgId(getNewId.getNewOrgId(id));

        if(newValue.toString().equals(oldValue.toString())){
            System.out.println("compareAddressesByOrgId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareAddressesByOrgId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareOptionsByOrgId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        OptionDAO daoOld = new OptionDAO(DB_URL, USER_DB, PASS_DB);
        OptionDAO daoNew = new OptionDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfOptionsByOrgId(id);
        List<String> newValue = daoNew.getListOfOptionsByOrgId(getNewId.getNewOrgId(id));

        if(newValue.toString().equals(oldValue.toString())){
            System.out.println("compareOptionsByOrgId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareOptionsByOrgId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareACLUserGroupsByOrgId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        ACLUserGroupDAO daoOld = new ACLUserGroupDAO(DB_URL, USER_DB, PASS_DB);
        ACLUserGroupDAO daoNew = new ACLUserGroupDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfACLUserGroupsByOrgId(id);
        List<String> newValue = daoNew.getListOfACLUserGroupsByOrgId(getNewId.getNewOrgId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLUserGroupsByOrgId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareACLUserGroupsByOrgId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareACLMatricesByOrgId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        ACLMatrixDAO daoOld = new ACLMatrixDAO(DB_URL, USER_DB, PASS_DB);
        ACLMatrixDAO daoNew = new ACLMatrixDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfACLMatrixByOrgId(id);
        List<String> newValue = daoNew.getListOfACLMatrixByOrgId(getNewId.getNewOrgId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLMatricesByOrgId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareACLMatricesByOrgId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareACLResourcesByOrgId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        ACLResourceDAO daoOld = new ACLResourceDAO(DB_URL, USER_DB, PASS_DB);
        ACLResourceDAO daoNew = new ACLResourceDAO(DB_URL2, USER_DB2, PASS_DB2);
        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfACLResourcesByOrgId(id);
        List<String> newValue = daoNew.getListOfACLResourcesByOrgId(getNewId.getNewOrgId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLResourcesByOrgId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareACLResourcesByOrgId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareDepartmentsByOrgId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        DepartmentDAO daoOld = new DepartmentDAO(DB_URL, USER_DB, PASS_DB);
        DepartmentDAO daoNew = new DepartmentDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfDepartmentsByOrgId(id);
        List<String> newValue = daoNew.getListOfDepartmentsByOrgId(getNewId.getNewOrgId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareDepartmentsByOrgId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareDepartmentsByOrgId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareConsumersByOrgId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        ConsumerDAO daoOld = new ConsumerDAO(DB_URL, USER_DB, PASS_DB);
        ConsumerDAO daoNew = new ConsumerDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfConsumersByOrgId(id);
        List<String> newValue = daoNew.getListOfConsumersByOrgId(getNewId.getNewOrgId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareConsumersByOrgId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareConsumersByOrgId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareContactsByOrgId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        ContactDAO daoOld = new ContactDAO(DB_URL, USER_DB, PASS_DB);
        ContactDAO daoNew = new ContactDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        Contact oldValue = daoOld.getContactByOrgId(id);
        Contact newValue = daoNew.getContactByOrgId(getNewId.getNewOrgId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareContactsByOrgId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareContactsByOrgId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

//    public static void compareAddressBooksByOrgId(String id, Document document) throws SQLException {
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

    public static void compareACLUsersByDriverId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        ACLUserDAO daoOld = new ACLUserDAO(DB_URL, USER_DB, PASS_DB);
        ACLUserDAO daoNew = new ACLUserDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        ACLUser oldValue = daoOld.getACLUserByDriverId(id);
        ACLUser newValue = daoNew.getACLUserByDriverId(getNewId.getNewDriverId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLUsersByDriverId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareACLUsersByDriverId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }


    public static void compareACLUsersByUserId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        ACLUserDAO daoOld = new ACLUserDAO(DB_URL, USER_DB, PASS_DB);
        ACLUserDAO daoNew = new ACLUserDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        ACLUser oldValue = daoOld.getACLUserByUserId(id);
        ACLUser newValue = daoNew.getACLUserByUserId(getNewId.getNewAclUserId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLUsersByUserId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareACLUsersByUserId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareAddressBooksByDriverId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        AddressBookRecordDAO daoOld = new AddressBookRecordDAO(DB_URL, USER_DB, PASS_DB);
        AddressBookRecordDAO daoNew = new AddressBookRecordDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfAddressBookRecordsByDriverId(id);
        List<String> newValue = daoNew.getListOfAddressBookRecordsByDriverId(getNewId.getNewDriverId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareAddressBooksByDriverId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareAddressBooksByDriverId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareAddressBooksByUserId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        AddressBookRecordDAO daoOld = new AddressBookRecordDAO(DB_URL, USER_DB, PASS_DB);
        AddressBookRecordDAO daoNew = new AddressBookRecordDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfAddressBookRecordsByUserId(id);
        List<String> newValue = daoNew.getListOfAddressBookRecordsByUserId(getNewId.getNewAclUserId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareAddressBooksByUserId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareAddressBooksByUserId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareACLUserMatricesByUserId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        ACLUserMatrixDAO daoOld = new ACLUserMatrixDAO(DB_URL, USER_DB, PASS_DB);
        ACLUserMatrixDAO daoNew = new ACLUserMatrixDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getListOfACLUserMatrixByUserId(id);
        List<String> newValue = daoNew.getListOfACLUserMatrixByUserId(getNewId.getNewAclUserId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLUserMatricesByUserId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareACLUserMatricesByUserId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareACLUserInGroupByDriverId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        AclUserInGroupDAO daoOld = new AclUserInGroupDAO(DB_URL, USER_DB, PASS_DB);
        AclUserInGroupDAO daoNew = new AclUserInGroupDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getAclUserInGroupList(id);
        List<String> newValue = daoNew.getAclUserInGroupList(getNewId.getNewDriverId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLUserInGroupByDriverId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareACLUserInGroupByDriverId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareACLUserInGroupByUserId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        AclUserInGroupDAO daoOld = new AclUserInGroupDAO(DB_URL, USER_DB, PASS_DB);
        AclUserInGroupDAO daoNew = new AclUserInGroupDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getAclUserInGroupList(id);
        List<String> newValue = daoNew.getAclUserInGroupList(getNewId.getNewAclUserId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareACLUserInGroupByUserId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareACLUserInGroupByDriverId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareInspectionReportDriverId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        InspectionReportDao daoOld = new InspectionReportDao(DB_URL, USER_DB, PASS_DB);
        InspectionReportDao daoNew = new InspectionReportDao(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getInspectionReportsByDriver(id);
        List<String> newValue = daoNew.getInspectionReportsByDriver(getNewId.getNewDriverId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareInspectionReportDriverId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareInspectionReportDriverId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareEldBorderCrossingEventsDriverId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        EldBorderCrossingEventDao daoOld = new EldBorderCrossingEventDao(DB_URL, USER_DB, PASS_DB);
        EldBorderCrossingEventDao daoNew = new EldBorderCrossingEventDao(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getEldBorderCrossingEventForDriver(id);
        List<String> newValue = daoNew.getEldBorderCrossingEventForDriver(getNewId.getNewDriverId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareEldBorderCrossingEventsDriverId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareEldBorderCrossingEventsDriverId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareEldSignalsHistoryDriverId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        EldSignalHistoryDao daoOld = new EldSignalHistoryDao(DB_URL, USER_DB, PASS_DB);
        EldSignalHistoryDao daoNew = new EldSignalHistoryDao(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getEldSignalsHistoryByDriver(id);
        List<String> newValue = daoNew.getEldSignalsHistoryByDriver(getNewId.getNewDriverId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareEldSignalsHistoryDriverId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareEldSignalsHistoryDriverId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareFmcsaEldExportDriverId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        FMCSAELDExportDAO daoOld = new FMCSAELDExportDAO(DB_URL, USER_DB, PASS_DB);
        FMCSAELDExportDAO daoNew = new FMCSAELDExportDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getFMCSAELDExportForDriver(id);
        List<String> newValue = daoNew.getFMCSAELDExportForDriver(getNewId.getNewDriverId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareFmcsaEldExportDriverId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareFmcsaEldExportDriverId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareFuelPurchaseReceiptDriverId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        FuelPurchaseReceiptDAO daoOld = new FuelPurchaseReceiptDAO(DB_URL, USER_DB, PASS_DB);
        FuelPurchaseReceiptDAO daoNew = new FuelPurchaseReceiptDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getFuelPurchaseReceiptForDriver(id);
        List<String> newValue = daoNew.getFuelPurchaseReceiptForDriver(getNewId.getNewDriverId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareFuelPurchaseReceiptDriverId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareFuelPurchaseReceiptDriverId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareTruckByTruckId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        TruckDAO daoOld = new TruckDAO(DB_URL, USER_DB, PASS_DB);
        TruckDAO daoNew = new TruckDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        Truck oldValue = daoOld.getTruckById(id);
        Truck newValue = daoNew.getTruckById(getNewId.getNewTruckId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareTruckByTruckId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareTruckByTruckId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareTruckDeviceSignalHistoryByTruckId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        TruckDeviceSignalHistoryDAO daoOld = new TruckDeviceSignalHistoryDAO(DB_URL, USER_DB, PASS_DB);
        TruckDeviceSignalHistoryDAO daoNew = new TruckDeviceSignalHistoryDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getTruckDeviceSignalsByTruckId(id);
        List<String> newValue = daoNew.getTruckDeviceSignalsByTruckId(getNewId.getNewTruckId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareTruckDeviceSignalHistoryByTruckId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareTruckDeviceSignalHistoryByTruckId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareTagsByDriverId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        tagDAO daoOld = new tagDAO(DB_URL, USER_DB, PASS_DB);
        tagDAO daoNew = new tagDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getTagsByDriverId(id);
        List<String> newValue = daoNew.getTagsByDriverId(getNewId.getNewDriverId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareTagsByOrgId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareTagsByOrgId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareTransportMovementByTruckId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        TransportMovementDAO daoOld = new TransportMovementDAO(DB_URL, USER_DB, PASS_DB);
        TransportMovementDAO daoNew = new TransportMovementDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getTransportMovementsByTruckId(id);
        List<String> newValue = daoNew.getTransportMovementsByTruckId(getNewId.getNewTruckId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareTransportMovementByTruckId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareTransportMovementByTruckId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareTransportMovementHistoryByTruckId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        TransportMovementHistoryDAO daoOld = new TransportMovementHistoryDAO(DB_URL, USER_DB, PASS_DB);
        TransportMovementHistoryDAO daoNew = new TransportMovementHistoryDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getTransportMovementsHistoryByTruckId(id);
        List<String> newValue = daoNew.getTransportMovementsHistoryByTruckId(getNewId.getNewTruckId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareTransportMovementHistoryByTruckId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareTransportMovementHistoryByTruckId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareTrailerByTrailerId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        TrailerDAO daoOld = new TrailerDAO(DB_URL, USER_DB, PASS_DB);
        TrailerDAO daoNew = new TrailerDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        Trailer oldValue = daoOld.getTrailerById(id);
        Trailer newValue = daoNew.getTrailerById(getNewId.getNewTrailerId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareTrailerByTrailerId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareTrailerByTrailerId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareTrailerDeviceSignalHistoryByTrailerId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        TrailerDeviceSignalHistoryDAO daoOld = new TrailerDeviceSignalHistoryDAO(DB_URL, USER_DB, PASS_DB);
        TrailerDeviceSignalHistoryDAO daoNew = new TrailerDeviceSignalHistoryDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getTrailerDeviceSignalsByTrailerId(id);
        List<String> newValue = daoNew.getTrailerDeviceSignalsByTrailerId(getNewId.getNewTrailerId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareTrailerDeviceSignalHistoryByTrailerId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareTrailerDeviceSignalHistoryByTrailerId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareEdiDataConsumerByOrgId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        EdiDataConsumerDAO daoOld = new EdiDataConsumerDAO(DB_URL, USER_DB, PASS_DB);
        EdiDataConsumerDAO daoNew = new EdiDataConsumerDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getEdiDataConsumerByOrgId(id);
        List<String> newValue = daoNew.getEdiDataConsumerByOrgId(getNewId.getNewOrgId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareEdiDataConsumerByOrgId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareEdiDataConsumerByOrgId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareGpsSignalConsumerByOrgId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        GPSSignalConsumerDAO daoOld = new GPSSignalConsumerDAO(DB_URL, USER_DB, PASS_DB);
        GPSSignalConsumerDAO daoNew = new GPSSignalConsumerDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getGpsSignalConsumerByOrgId(id);
        List<String> newValue = daoNew.getGpsSignalConsumerByOrgId(getNewId.getNewOrgId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareGpsSignalConsumerByOrgId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareGpsSignalConsumerByOrgId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareGeocodeProviderByOrgId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        GeocodeProviderDAO daoOld = new GeocodeProviderDAO(DB_URL, USER_DB, PASS_DB);
        GeocodeProviderDAO daoNew = new GeocodeProviderDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getGeocodeProvideByOrgId(id);
        List<String> newValue = daoNew.getGeocodeProvideByOrgId(getNewId.getNewOrgId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareGeocodeProviderByOrgId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareGeocodeProviderByOrgId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareMessagingProviderByOrgId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        MessagingProviderDAO daoOld = new MessagingProviderDAO(DB_URL, USER_DB, PASS_DB);
        MessagingProviderDAO daoNew = new MessagingProviderDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getMessagingProvideByOrgId(id);
        List<String> newValue = daoNew.getMessagingProvideByOrgId(getNewId.getNewOrgId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareMessagingProviderByOrgId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareMessagingProviderByOrgId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareHosProviderByOrgId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        HosProviderDAO daoOld = new HosProviderDAO(DB_URL, USER_DB, PASS_DB);
        HosProviderDAO daoNew = new HosProviderDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getHOSProvideByOrgId(id);
        List<String> newValue = daoNew.getHOSProvideByOrgId(getNewId.getNewOrgId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareHosProviderByOrgId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareHosProviderByOrgId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareGpsSignalProviderByOrgId(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        GPSSignalProviderDAO daoOld = new GPSSignalProviderDAO(DB_URL, USER_DB, PASS_DB);
        GPSSignalProviderDAO daoNew = new GPSSignalProviderDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getGpsSignalsProvideByOrgId(id);
        List<String> newValue = daoNew.getGpsSignalsProvideByOrgId(getNewId.getNewOrgId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareGpsSignalProviderByOrgId " + id + " Done");
        } else {
            Anchor title = new Anchor("compareGpsSignalProviderByOrgId " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareStripeCustomerByDriver(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        StripeCustomerDAO daoOld = new StripeCustomerDAO(DB_URL, USER_DB, PASS_DB);
        StripeCustomerDAO daoNew = new StripeCustomerDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getStripeCustomerByDriverId(id);
        List<String> newValue = daoNew.getStripeCustomerByDriverId(getNewId.getNewDriverId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareStripeCustomer " + id + " Done");
        } else {
            Anchor title = new Anchor("compareStripeCustomer " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareStripeSubscriptionByDriver(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        StripeSubscriptionDAO daoOld = new StripeSubscriptionDAO(DB_URL, USER_DB, PASS_DB);
        StripeSubscriptionDAO daoNew = new StripeSubscriptionDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getStripeSubscription(id);
        List<String> newValue = daoNew.getStripeSubscription(getNewId.getNewDriverId(id));


        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareStripeSubscription " + id + " Done");
        } else {
            Anchor title = new Anchor("compareStripeSubscription " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareStripeSubscriptionItemByDriver(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        StripeSubscriptionItemDAO daoOld = new StripeSubscriptionItemDAO(DB_URL, USER_DB, PASS_DB);
        StripeSubscriptionItemDAO daoNew = new StripeSubscriptionItemDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getStripeSubscriptionItem(id);
        List<String> newValue = daoNew.getStripeSubscriptionItem(getNewId.getNewDriverId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareStripeSubscriptionItem " + id + " Done");
        } else {
            Anchor title = new Anchor("compareStripeSubscriptionItem " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareEldSubscriptionsByDriver(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        EldSubscriptionDAO daoOld = new EldSubscriptionDAO(DB_URL, USER_DB, PASS_DB);
        EldSubscriptionDAO daoNew = new EldSubscriptionDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getEldSubscription(id);
        List<String> newValue = daoNew.getEldSubscription(getNewId.getNewDriverId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareEldSubscriptionsByDriver " + id + " Done");
        } else {
            Anchor title = new Anchor("compareEldSubscriptionsByDriver " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareStripeCustomerByUser(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        StripeCustomerDAO daoOld = new StripeCustomerDAO(DB_URL, USER_DB, PASS_DB);
        StripeCustomerDAO daoNew = new StripeCustomerDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getStripeCustomerByUser(id);
        List<String> newValue = daoNew.getStripeCustomerByUser(getNewId.getNewAclUserId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareStripeCustomer " + id + " Done");
        } else {
            Anchor title = new Anchor("compareStripeCustomer " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareStripeSubscriptionByUser(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        StripeSubscriptionDAO daoOld = new StripeSubscriptionDAO(DB_URL, USER_DB, PASS_DB);
        StripeSubscriptionDAO daoNew = new StripeSubscriptionDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getStripeSubscriptionByUser(id);
        List<String> newValue = daoNew.getStripeSubscriptionByUser(getNewId.getNewAclUserId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareStripeSubscription " + id + " Done");
        } else {
            Anchor title = new Anchor("compareStripeSubscription " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareStripeSubscriptionItemByUser(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        StripeSubscriptionItemDAO daoOld = new StripeSubscriptionItemDAO(DB_URL, USER_DB, PASS_DB);
        StripeSubscriptionItemDAO daoNew = new StripeSubscriptionItemDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getStripeSubscriptionItemByUser(id);
        List<String> newValue = daoNew.getStripeSubscriptionItemByUser(getNewId.getNewAclUserId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareStripeSubscriptionItem " + id + " Done");
        } else {
            Anchor title = new Anchor("compareStripeSubscriptionItem " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareEldSubscriptionsByUser(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException {
        EldSubscriptionDAO daoOld = new EldSubscriptionDAO(DB_URL, USER_DB, PASS_DB);
        EldSubscriptionDAO daoNew = new EldSubscriptionDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getEldSubscriptionByUser(id);
        List<String> newValue = daoNew.getEldSubscriptionByUser(getNewId.getNewAclUserId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareEldSubscriptions " + id + " Done");
        } else {
            Anchor title = new Anchor("compareEldSubscriptions " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compareHosDayVerify(String id, Document document) throws SQLException, IllegalAccessException, DocumentException, NoSuchFieldException{
        HosDayVerifyDAO daoOld = new HosDayVerifyDAO(DB_URL, USER_DB, PASS_DB);
        HosDayVerifyDAO daoNew = new HosDayVerifyDAO(DB_URL2, USER_DB2, PASS_DB2);

        GetNewId getNewId = new GetNewId(DB_URL2, USER_DB2, PASS_DB2);

        List<String> oldValue = daoOld.getHosVerifyByDriver(id);
        List<String> newValue = daoNew.getHosVerifyByDriver(getNewId.getNewDriverId(id));

        if(oldValue.toString().equals(newValue.toString())){
            System.out.println("compareEldSubscriptions " + id + " Done");
        } else {
            Anchor title = new Anchor("compareEldSubscriptions " + id, catFont);
            document.add(title);
            compare(oldValue, newValue, document);
        }
    }

    public static void compare(Object oldObj, Object newObj, Document document) throws DocumentException, NoSuchFieldException, IllegalAccessException {
        Field[] fields = newObj.getClass().getFields();
        for(Field field : fields){
            String fieldName = field.getName();
            if (newObj.getClass().getField(fieldName).get(newObj) != null || oldObj.getClass().getField(fieldName).get(newObj) != null) {
                if (!(newObj.getClass().getField(fieldName).get(newObj).toString().equals(oldObj.getClass().getField(fieldName).get(newObj).toString()))) {
                    Paragraph phrase1 = new Paragraph("New value: " + newObj.getClass().getField(fieldName).get(newObj).toString() + " type: " + fieldName);
                    Paragraph phrase2 = new Paragraph("Old value: " + oldObj.getClass().getField(fieldName).get(newObj).toString() + " type: " + fieldName);
                    document.add(phrase1);
                    document.add(phrase2);
                }
            }
        }
    }
}
