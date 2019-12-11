package uz.com.uzgovmonsys.constants;

public class Constants {

    public static final String BASE_URL = "https://api.new.mediabox.uz";

    public static final String DATABASE_NAME = "bkm_db";
    public static final String SHARED_PREFERENCES = "UzGovMonSys_Sharedpreferense";
    public static final String PINCODE = "PINCODE_CREATD";
    public static final String EMPTY_STRING="";
    public static final String PASSWORD_MIN_LENGTH="d{8}$";

    public static final String COUNTRY_CODE = "+998";
        public static final String PHONE_NUMBER_REGEX = "(90|91|93|94|97|99|95|98|77)\\d{7}$";
    //public static final String PHONE_NUMBER_REGEX = "\\d{9}$";
    public static final String PHONE_NUMBER_REGEX_FULL = "^(\\+" + COUNTRY_CODE + ")" + PHONE_NUMBER_REGEX;
    public static final byte CONNECT_TIMEOUT = 120;
    public static final byte WRITE_TIMEOUT = 120;
    public static final byte READ_TIMEOUT = 120;
}
