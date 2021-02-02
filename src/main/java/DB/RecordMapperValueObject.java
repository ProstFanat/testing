/*
$RCSfile: RecordMapperValueObject.java,v $

Change Summary
==============

*/

package DB;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.trackensure.AppConstants;
//import com.trackensure.integration.dao.DAOAppException;
//import com.trackensure.integration.dao.DAOSysException;
//import com.transplusconnector.valueobject.TPCDriver;
//import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import java.util.Date;


/**
 * This class provides common record value object functionality, which is
 * enforced by the IRecordValueObject interface.  The common functionality
 * includes a convenience addVOField method, which registers VO Fields.
 * Common field iterator functionality is also provided.
 * @author roman.mironenko
 * @version 1.0
 * @created 4-Oct-2006
 */
public abstract class RecordMapperValueObject {
    private Integer pluginId = null;
    protected ArrayList fields = new ArrayList();
    private transient Iterator iter = null;

    //Indicates whether one of the fields was registered as an RECORD ID field.
    //One field must be RECORD ID, otherwise the record for which this value object
    //is created cannot be processed.  One and only one RECORD ID field can be registered.
    private boolean isRecordIDFieldSet = false;
    //Refers to RECORD ID field.
//    private RecordValueObjectField recordIdField = null;
//
//    protected void addVOField(String dbFieldName, int dbFieldType, String setterName, Class setterType, String getterName) {
//        RecordValueObjectField field = new RecordValueObjectField();
//        field.databaseFieldName = dbFieldName.toLowerCase();
//        field.databaseFieldType = dbFieldType;
//        field.setterMethodName = setterName;
//        field.getterMethodName = getterName;
//        field.setterType = setterType;
//        fields.add(field);
//    }

    public void clearVOFields() {
        fields = new ArrayList<>();
        iter = null;
    }


    /**
     * Returns true if there is at least one more field to map from the result set to this vo.
     */
    public boolean hasNextField() {
        if (iter == null) {
            iter = fields.iterator();
        }
        return iter.hasNext();
    }
    /**
     * Returns RecordValueObjectField object, which contains vo to db field mapping parameters.
     */

    //DAO Util Methods
    public static Set<String> getRSColumns(ResultSet rs) throws Exception {
        Set<String> setColNames = new HashSet();
        try {
            ResultSetMetaData meta = rs.getMetaData();
            int numberOfColumns = meta.getColumnCount();
            for(int i=1;i<=numberOfColumns;i++) {
                setColNames.add(meta.getColumnName(i).toLowerCase());
            }
        } catch (SQLException e) {
            throw new Exception("Cannot retrieve result set meta data ");
        }

        return setColNames;
    }
    protected String getString(ResultSet rs, String databaseFieldName, Set<String> allColumns) throws Exception {
        return getString(rs, databaseFieldName, allColumns, null);
    }

    protected String getString(ResultSet rs, String databaseFieldName, Set<String> allColumns, String defaultValue) throws Exception {
        if (allColumns == null || !allColumns.contains(databaseFieldName.toLowerCase())) {
            return defaultValue;
        }
        try {
            String stringValue = rs.getString(databaseFieldName);
            return stringValue != null ? stringValue : defaultValue;
        } catch (Throwable e) {
            throw new Exception(e.getMessage());
        }
    }

    protected Date getDate(ResultSet rs, String databaseFieldName, Set<String> allColumns) throws Exception {
        return getDate(rs, databaseFieldName, allColumns, null);
    }

    protected Date getDate(ResultSet rs, String databaseFieldName, Set<String> allColumns, Date defaultValue) throws Exception {
        if (allColumns == null || !allColumns.contains(databaseFieldName.toLowerCase())) {
            return defaultValue;
        }
        try {
            Timestamp timestamp = rs.getTimestamp(databaseFieldName);
            if (timestamp == null) {
                return defaultValue;
            } else {
                return new Date(timestamp.getTime());
            }
        } catch (Throwable e) {
            throw new Exception(e.getMessage());
        }
    }

    protected Integer getInteger(ResultSet rs, String databaseFieldName, Set<String> allColumns) throws Exception {
        return getInteger(rs, databaseFieldName, allColumns, null);
    }

    protected Integer getInteger(ResultSet rs, String databaseFieldName, Set<String> allColumns, Integer defaultValue) throws Exception {
        if (allColumns == null || !allColumns.contains(databaseFieldName.toLowerCase())) {
            return defaultValue;
        }
        try {
            Integer integerValue = new Integer(rs.getInt(databaseFieldName));
            if (rs.wasNull()) {
                integerValue = null;
            }
            return integerValue != null ? integerValue : defaultValue;
        } catch (Throwable e) {
            throw new Exception(e.getMessage());
        }
    }

    protected Character getCharacter(ResultSet rs, String databaseFieldName, Set<String> allColumns) throws Exception {
        return getCharacter(rs, databaseFieldName, allColumns, null);
    }

    protected Character getCharacter(ResultSet rs, String databaseFieldName, Set<String> allColumns, Character defaultValue) throws Exception {
        if (allColumns == null || !allColumns.contains(databaseFieldName.toLowerCase())) {
            return defaultValue;
        }
        try {
            String stringValue = rs.getString(databaseFieldName);
            Character characterValue = (stringValue != null && !stringValue.isEmpty()) ? stringValue.charAt(0) : null;
            return characterValue != null ? characterValue : defaultValue;
        } catch (Throwable e) {
            throw new Exception(e.getMessage());
        }
    }

    protected BigDecimal getBigDecimal(ResultSet rs, String databaseFieldName, Set<String> allColumns) throws Exception {
        return getBigDecimal(rs, databaseFieldName, allColumns, null);
    }

    protected BigDecimal getBigDecimal(ResultSet rs, String databaseFieldName, Set<String> allColumns, BigDecimal defaultValue) throws Exception {
        if (allColumns == null || !allColumns.contains(databaseFieldName.toLowerCase())) {
            return defaultValue;
        }
        try {
            BigDecimal bigDecimalValue = rs.getBigDecimal(databaseFieldName);
            return bigDecimalValue != null ? bigDecimalValue : defaultValue;
        } catch (Throwable e) {
            throw new Exception(e.getMessage());
        }
    }

    protected Float getFloat(ResultSet rs, String databaseFieldName, Set<String> allColumns) throws Exception {
        return getFloat(rs, databaseFieldName, allColumns, null);
    }

    protected Float getFloat(ResultSet rs, String databaseFieldName, Set<String> allColumns, Float defaultValue) throws Exception {
        if (allColumns == null || !allColumns.contains(databaseFieldName.toLowerCase())) {
            return defaultValue;
        }
        try {
            Float floatValue = rs.getFloat(databaseFieldName);
            if (rs.wasNull()) {
                floatValue = null;
            }
            return floatValue != null ? floatValue : defaultValue;
        } catch (Throwable e) {
            throw new Exception(e.getMessage());
        }
    }

    protected <T> T get(ResultSet rs, String[] databaseFieldNameArray, Set<String> allColumns, Class<T> aClass) throws Exception {
        for (String databaseFieldName : databaseFieldNameArray) {
            T value = Long.class.equals(aClass) ? (T) getLong(rs, databaseFieldName, allColumns, null)
                    : String.class.equals(aClass) ? (T) getString(rs, databaseFieldName, allColumns, null)
                    : Integer.class.equals(aClass) ? (T) getInteger(rs, databaseFieldName, allColumns, null)
                    : Date.class.equals(aClass) ? (T) getDate(rs, databaseFieldName, allColumns, null)
                    : Character.class.equals(aClass) ? (T) getCharacter(rs, databaseFieldName, allColumns, null)
                    : null;
            if (value != null) {
                return value;
            }
        }
        return null;
    }

    protected Long getLong(ResultSet rs, String databaseFieldName, Set<String> allColumns) throws Exception {
        return getLong(rs, databaseFieldName, allColumns, null);
    }

    protected Long getLong(ResultSet rs, String databaseFieldName, Set<String> allColumns, Long defaultValue) throws Exception {
        if (allColumns == null || !allColumns.contains(databaseFieldName.toLowerCase())) {
            return defaultValue;
        }
        try {
            Long longValue = rs.getLong(databaseFieldName);
            if (rs.wasNull()) {
                longValue = null;
            }
            return longValue != null ? longValue : defaultValue;
        } catch (Throwable e) {
            throw new Exception(e.getMessage());
        }
    }

    protected Double getDouble(ResultSet rs, String databaseFieldName, Set<String> allColumns) throws Exception {
        return getDouble(rs, databaseFieldName, allColumns, null);
    }

    protected Double getDouble(ResultSet rs, String databaseFieldName, Set<String> allColumns, Double defaultValue) throws Exception {
        if (allColumns == null || !allColumns.contains(databaseFieldName.toLowerCase())) {
            return defaultValue;
        }
        try {
            Double doubleValue = rs.getDouble(databaseFieldName);
            if (rs.wasNull()) {
                doubleValue = null;
            }
            return doubleValue != null ? doubleValue : defaultValue;
        } catch (Throwable e) {
            throw new Exception(e.getMessage());
        }
    }

    protected byte[] getBytes(ResultSet rs, String databaseFieldName, Set<String> allColumns) throws Exception {
        if (allColumns == null || !allColumns.contains(databaseFieldName.toLowerCase())) {
            return null;
        }
        try {
            return rs.getBytes(databaseFieldName);
        } catch (Throwable e) {
            throw new Exception(e.getMessage());
        }
    }

    protected Byte getByte(ResultSet rs, String databaseFieldName, Set<String> allColumns) throws Exception {
        if (allColumns == null || !allColumns.contains(databaseFieldName.toLowerCase())) {
            return null;
        }
        try {
            return rs.getByte(databaseFieldName);
        } catch (Throwable e) {
            throw new Exception(e.getMessage());
        }
    }

    protected Boolean getBooleanFromCharacter(ResultSet rs, String databaseFieldName, Set<String> allColumns) throws Exception {
        return getBooleanFromCharacter(rs, databaseFieldName, allColumns, null);
    }

    protected Boolean getBooleanFromCharacter(ResultSet rs, String databaseFieldName, Set<String> allColumns, Boolean defaultValue) throws Exception {
        if (allColumns == null || !allColumns.contains(databaseFieldName.toLowerCase())) {
            return defaultValue;
        }
        Character characterValue = getCharacter(rs, databaseFieldName, allColumns);
        if (characterValue != null) {
            return new Character('Y').equals(characterValue) ? new Boolean(true) : new Boolean(false);
        } else {
            return defaultValue;
        }
    }

//    protected Boolean getBooleanFromBit(ResultSet rs, String databaseFieldName, Set<String> allColumns) {
//        return getBooleanFromBit(rs, databaseFieldName, allColumns, null);
//    }
//
//    protected Boolean getBooleanFromBit(ResultSet rs, String databaseFieldName, Set<String> allColumns, Boolean defaultValue) throws Exception {
//        if (allColumns == null || !allColumns.contains(databaseFieldName.toLowerCase())) {
//            return defaultValue;
//        }
//
//        Byte value = getByte(rs, databaseFieldName, allColumns);
//        if (value == 1){
//            return true;
//        }
//        return false;
//    }
    protected Time getTime(ResultSet rs, String databaseFieldName, Set<String> allColumns) throws Exception {
        return getTime(rs, databaseFieldName, allColumns, null);
    }

    protected Time getTime(ResultSet rs, String databaseFieldName, Set<String> allColumns, Time defaultValue) throws Exception {
        if (allColumns == null || !allColumns.contains(databaseFieldName.toLowerCase())) {
            return defaultValue;
        }
        try {
            Time timeValue = rs.getTime(databaseFieldName);
            if (rs.wasNull()) {
                timeValue = null;
            }
            return timeValue != null ? timeValue : defaultValue;
        } catch (Throwable e) {
            throw new Exception(e.getMessage());
        }
    }

//	public Object serialize (Object object, Boolean key) {
//		Map<String, Object> fieldsMap = new HashMap<>();
//
//			for (Field field : object.getClass().getDeclaredFields()) {
//				field.setAccessible(true);
//
//				String fieldName = field.getName();
//				Object fieldValue = null;
//				Method method = null;
//				try {
//					fieldValue = field.get(object);
//					String getterName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
//					method = object.getClass().getDeclaredMethod(getterName);
//				} catch (NoSuchMethodException | IllegalAccessException e){
//					continue;
//				}
//
//				JSONArray jsonArray = new JSONArray();
//				if (Collection.class.isAssignableFrom(field.getType())) {
//					try {
//						List<?> aList = (List<?>)method.invoke(object);
//						if (aList != null && aList.size() > 0) {
//							Iterator aListIterator = aList.iterator();
//							while(aListIterator.hasNext()) {
//								Object obj = aListIterator.next();
//								JSONObject jsonObject = (JSONObject)serialize(obj, true);
////							jsonString = jsonString.substring(1, jsonString.length() - 1);
//								System.out.println(jsonObject.toString());
//								jsonArray.put(jsonObject);
//							}
//						}
//					} catch (IllegalAccessException e) {
//						e.printStackTrace();
//					} catch (InvocationTargetException e) {
//						e.printStackTrace();
//					}
//
//					if (jsonArray.length() > 0) {
//						System.out.println(jsonArray.toString());
//						fieldValue = jsonArray;
//					}
//				}
//
//				fieldsMap.put(fieldName, fieldValue);
//			}
//		if (key != null && key) {
//			return new JSONObject(fieldsMap);
//		}
//		return new JSONObject(fieldsMap).toString();
//	}
}