package cmput301.xuefei1_fueltrack;

import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Fred on 2016/1/21.
 */
public class DataManager {

    private ArrayList<FuelLog> logs;
    private static DataManager instance = null;

    public void saveToFile(){

    }

    public ArrayList<FuelLog> getLogs(){
        return this.logs;
    }

    public void addNewLog(FuelLog log){
        this.logs.add(log);
        this.sortLogsByDate();
    }

    public void deleteLog(int position){
        this.logs.remove(position);
    }

    public void updateLog(int position, FuelLog log){
        this.logs.remove(position);
        this.logs.add(log);
        this.sortLogsByDate();
    }

    public void sortLogsByDate(){
        Collections.sort(logs);
    }

    public static DataManager getInstance(){
        if(instance == null){
            instance = new DataManager();
        }
        return instance;
    }

}
