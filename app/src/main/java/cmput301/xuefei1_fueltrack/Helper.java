package cmput301.xuefei1_fueltrack;

/**
 * Created by Fred on 2016/1/19.
 */
public final class Helper {

    /*

    Purpose: Helper class designed to provide useful static methods/constants will be used by all classes in the App

    Design rationale: Having a static helper class is always beneficial. We can put constants here as well as any static helper methods.
    Making them visible to every class.

    Issues: None

    */

    public static final String ACTIVITY_BUNDLE_TITLE = "INFO";
    public static final String ACTIVITY_BUNDLE_ACTIVITY_TYPE = "TYPE";
    public static final String ACTIVITY_BUNDLE_AMOUNT= "AMOUNT";
    public static final String ACTIVITY_BUNDLE_UNIT_PRICE= "PRICE";
    public static final String ACTIVITY_BUNDLE_ODOMETER= "ODOMETER";
    public static final String ACTIVITY_BUNDLE_STATION= "STATION";
    public static final String ACTIVITY_BUNDLE_GRADE= "GRADE";
    public static final String ACTIVITY_BUNDLE_DATE_YEAR= "DATE_YEAR";
    public static final String ACTIVITY_BUNDLE_DATE_MONTH= "DATE_MONTH";
    public static final String ACTIVITY_BUNDLE_DATE_DAY= "DATE_DAY";
    public static final String ACTIVITY_BUNDLE_INDEX= "INDEX";

    public static final int ACTIVITY_TYPE_NEW_LOG = 0x0;
    public static final int ACTIVITY_TYPE_EDIT_LOG = 0x1;

    public static String roundDecimal(int place, float num){
        String format_str = "%."+String.valueOf(place)+"f";
        return String.format(format_str, num);
    }

}
