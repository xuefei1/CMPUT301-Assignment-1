package cmput301.xuefei1_fueltrack;

/**
 * Created by Fred on 2016/1/19.
 */
public final class Tools {

    public static String roundDecimal(int place, float num){
        String format_str = "%."+String.valueOf(place)+"f";
        String rv = String.valueOf(num);
        String.format(format_str, rv);
        return rv;
    }
}
