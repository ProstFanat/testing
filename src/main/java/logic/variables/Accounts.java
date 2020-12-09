package logic.variables;

import com.google.gson.JsonObject;
import logic.csv.ErrorLogs;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Accounts {
    public static String KOLOS_FLEET_LOGIN = "358";
    public static String KOLOS_FLEET_PASS = "test";
    public static String MGK_FLEET_LOGIN = "17492";
    public static String MGK_FLEET_PASS = "test";

    public final static String EMAIL_ADDRESS = "trackensuretest@ukr.net";
    public final static String EMAIL_PASSWORD = "8MbRjjV5V5PTXw8s";
    public final static String EMAIL_SERVER = "imap.ukr.net";

    public final static String PROD_HELLEN_LOGIN = "te-adviser-1612@trackensure.com";
    public final static String PROD_HELLEN_PASSWORD = "Te325!vI0rgCOM";
    public static final long TEST_DRIVER_ID = 59007;
    //public static final long TEST_DRIVER_ID = 61320;
    public static final String DRIVER_TO_TRANSFER_NAME = "John Transfer";
    public static HashMap getLoginValues(){
        //String testPlace = System.getProperty("TestPlace");
        String testPlace = "Local";
        String login = "";
        String password = "";
        if(testPlace.equals("Local")){
            //login="17492";
            //login="10";
            login = "14713";
            password="test";
        } else if (testPlace.equals("Prod") || testPlace.equals("CA") ){
            login="hudoliy.e@gmail.com";
            password="Eugen7881122H";
        }
        HashMap <String,String> loginValues = new HashMap<>();
        loginValues.put("login",login);
        loginValues.put("password", password);
        return loginValues;
    }
    public static String getCompanyForLogin(){
        //String testPlace = System.getProperty("LoginAsCompany");
        String testPlace = "IMOVE TRANS LLC";
        //String testPlace = "Hellen";
        //String testPlace = "HL Motor";
        return testPlace;

    }

}
