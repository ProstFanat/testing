package Migration.DAO;

import DB.DBConnection;
import Migration.Organization;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;

import java.io.Console;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrganizationDAO {

    public String db;
    public String user;
    public String pass;

    public OrganizationDAO(String db, String user, String pass) {
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public Organization getOrganizationById(String orgId) throws SQLException {
        Organization organization = null;
        Connection connection = DBConnection.getConnection(db, user, pass);
        String sql = "SELECT * from public.organization WHERE organization_id=" + orgId + " ORDER BY organization_name";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                organization = new Organization(rs, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return organization;
    }

    public void compare(Organization newObj,Organization oldObj, Document document) throws DocumentException, NoSuchFieldException, IllegalAccessException {
        Field[] fields = newObj.getClass().getFields();
        for(Field field : fields){
            String fieldName = field.getName();
            if (newObj.getClass().getField(fieldName).get(newObj) != null || oldObj.getClass().getField(fieldName).get(newObj) != null) {
                System.out.println(newObj.getClass().getField(fieldName).get(newObj).toString());
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
