package cmput301.xuefei1_fueltrack;

import android.content.Context;

import java.util.List;


/**
 * Created by Fred on 2016/1/28.
 */
public abstract class FTModel<T> {

    /*

    Purpose: Generic abstract model class, defines the must-have features of a model class

    Design rationale: Model component in MVC, To implement the specific model simply inherit from this class and override all the abstract methods

    Issues: None

    */

    public abstract void loadFromFile(Context ctx);

    public abstract void saveToFile(Context ctx);

    public abstract List<T> getData();

    public void updateEntry(int pos, T new_entry){
        this.getData().remove(pos);
        this.getData().add(new_entry);
    };

    public void removeEntry(int pos){
        this.getData().remove(pos);
    }

    public void addEntry(T entry){
        this.getData().add(entry);
    }

    public void clearData(){
        this.getData().clear();
    }

}
