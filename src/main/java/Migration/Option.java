package Migration;

import DB.RecordMapperValueObject;

import java.sql.ResultSet;
import java.util.Set;

public class Option extends RecordMapperValueObject {
    private Long optionId;
    private String optionName;
    private String optionType; // see TYPE_* constatns
    private Character editable;
    private Character visibleToClient;
    private Long valueId;
    private Long orgId;
    private String value;
    private Character visibleToClientValue;

    public Option(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }

//        this.optionId                       = getLong(rs, "option_id", rsColumns);
        this.optionName                     = getString(rs, "option_name", rsColumns);
        this.optionType                     = getString(rs, "option_type", rsColumns);
        this.editable                       = getCharacter(rs, "editable", rsColumns);
        this.visibleToClient                = getCharacter(rs, "visible_to_client", rsColumns);
//        this.valueId                        = getLong(rs, "value_id", rsColumns);
      //  this.orgId                          = getLong(rs, "org_id", rsColumns);
        this.value                          = getString(rs, "value", rsColumns);
     //   this.visibleToClientValue           = getCharacter(rs, "visible_to_client_value", rsColumns);
    }

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    public Character getEditable() {
        return editable;
    }

    public void setEditable(Character editable) {
        this.editable = editable;
    }

    public Character getVisibleToClient() {
        return visibleToClient;
    }

    public void setVisibleToClient(Character visibleToClient) {
        this.visibleToClient = visibleToClient;
    }

    public Long getValueId() {
        return valueId;
    }

    public void setValueId(Long valueId) {
        this.valueId = valueId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Character getVisibleToClientValue() {
        return visibleToClientValue;
    }

    public void setVisibleToClientValue(Character visibleToClientValue) {
        this.visibleToClientValue = visibleToClientValue;
    }

    @Override
    public String toString() {
        return "Option{" +
                "optionId=" + optionId +
                ", optionName='" + optionName + '\'' +
                ", optionType='" + optionType + '\'' +
                ", editable=" + editable +
                ", visibleToClient=" + visibleToClient +
                ", valueId=" + valueId +
                ", orgId=" + orgId +
                ", value='" + value + '\'' +
                ", visibleToClientValue=" + visibleToClientValue +
                '}';
    }
}
