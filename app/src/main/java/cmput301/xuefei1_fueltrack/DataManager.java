package cmput301.xuefei1_fueltrack;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Fred on 2016/1/21.
 */
public class DataManager {

    private static final String FILENAME = "FuelTrackData.sav";

    private ArrayList<FuelLog> logs;
    private static DataManager instance = null;

    public void loadFromFile(Context ctx){
        try {
            FileInputStream fis = ctx.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();

            // Took from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 01-19 2016
            Type listType = new TypeToken<ArrayList<FuelLog>>() {}.getType();
            this.logs = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            this.logs = new ArrayList<FuelLog>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

    public void saveToFile(Context ctx){
        try {
            FileOutputStream fos = ctx.openFileOutput(FILENAME,
                    0);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(this.logs, out);
            out.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

    public ArrayList<FuelLog> getData(){
        return this.logs;
    }

    public void addNewLog(FuelLog log){
        this.logs.add(log);
        this.sortLogsByDate();
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
