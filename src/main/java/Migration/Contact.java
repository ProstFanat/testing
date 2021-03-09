package Migration;

import DB.RecordMapperValueObject;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Set;

public class Contact extends RecordMapperValueObject implements Serializable {

    public Long contactId;
    public String contactName;
    public String contactPhone;
    public String contactEmail;
    public String additionalContact;

    public Contact(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
//        this.contactId = getLong(rs, "contact_id",rsColumns);
        this.contactName = getString(rs, "contact_name", rsColumns);
        this.contactPhone = getString(rs, "contact_phone", rsColumns);
        this.contactEmail = getString(rs, "contact_email", rsColumns);
        this.additionalContact = getString(rs, "additional_contact", rsColumns);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", contactName='" + contactName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", additionalContact='" + additionalContact + '\'' +
                '}';
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getAdditionalContact() {return additionalContact;	}

    public void setAdditionalContact(String additionalContact) {this.additionalContact = additionalContact;	}
}