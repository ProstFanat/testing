package migration;

import db.RecordMapperValueObject;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class HosDayVerify extends RecordMapperValueObject {
    public Long id;
    public Long org_id;
    public Date verified_date;
    public Date create_date;
    public Long events_count;
    public Long driver_id;
    public Long user_id;
    public Character active;
    public Character verified_status;
    public String comment;

    public HosDayVerify(ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
        //this.id = getLong(rs, "id", rsColumns);
        //this.org_id;
        this.verified_date = getDate(rs, "verified_date", rsColumns);
       // this.create_date = getDate(rs, "create_date", rsColumns);
        this.events_count = getLong(rs, "events_count", rsColumns);
        //this. driver_id;
        //this.user_id;
        this.active = getCharacter(rs, "active", rsColumns);
        this.verified_status = getCharacter(rs, "verified_status", rsColumns);
        this.comment = getString(rs, "comment", rsColumns);
    }

    @Override
    public String toString() {
        return "HosDayVerify{" +
                "fields=" + fields +
                ", id=" + id +
                ", org_id=" + org_id +
                ", verified_date=" + verified_date +
                ", create_date=" + create_date +
                ", events_count=" + events_count +
                ", driver_id=" + driver_id +
                ", user_id=" + user_id +
                ", active=" + active +
                ", verified_status=" + verified_status +
                ", comment='" + comment + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Long org_id) {
        this.org_id = org_id;
    }

    public Date getVerified_date() {
        return verified_date;
    }

    public void setVerified_date(Date verified_date) {
        this.verified_date = verified_date;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Long getEvents_count() {
        return events_count;
    }

    public void setEvents_count(Long events_count) {
        this.events_count = events_count;
    }

    public Long getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Long driver_id) {
        this.driver_id = driver_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Character getVerified_status() {
        return verified_status;
    }

    public void setVerified_status(Character verified_status) {
        this.verified_status = verified_status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public List<Field> getFields() {
        return null;
    }
}
