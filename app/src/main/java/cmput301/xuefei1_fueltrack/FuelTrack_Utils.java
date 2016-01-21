package cmput301.xuefei1_fueltrack;

/**
 * Created by Fred on 2016/1/19.
 */
public final class FuelTrack_Utils {

    public static final String ACTIVITY_BUNDLE_TITLE = "INFO";
    public static final String ACTIVITY_BUNDLE_ACTIVITY_TYPE = "TYPE";

    public static final int ACTIVITY_TYPE_NEW_LOG = 0x0;
    public static final int ACTIVITY_TYPE_EDIT_LOG = 0x1;

    public static String roundDecimal(int place, float num){
        String format_str = "%."+String.valueOf(place)+"f";
        String rv = String.valueOf(num);
        String.format(format_str, rv);
        return rv;
    }

    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

}
