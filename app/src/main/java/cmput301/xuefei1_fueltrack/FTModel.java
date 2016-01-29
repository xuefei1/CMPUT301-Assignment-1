package cmput301.xuefei1_fueltrack;

import android.content.Context;

import java.util.List;


/**
 * Created by Fred on 2016/1/28.
 */
public abstract class FTModel<T> {

    public abstract void loadFromFile(Context ctx);

    public abstract void saveToFile(Context ctx);

    public abstract List<T> getData();

    public abstract void updateEntry(int pos, T new_entry);

    public abstract void removeEntry(int pos);

    public abstract void addEntry(T entry);

    public abstract void clearData();

}
