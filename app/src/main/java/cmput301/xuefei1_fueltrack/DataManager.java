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
import java.util.List;

/**
 * Created by Fred on 2016/1/21.
 */
public class DataManager extends FTModel<FuelLog> {

    private static final String FILENAME = "FuelTrackData.sav";

    private ArrayList<FuelLog> logs;
    private static DataManager instance = null;

    public void loadFromFile(Context ctx){
        try {
            FileInputStream fis = ctx.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();

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

    public List<FuelLog> getData(){
        return this.logs;
    }

    public void addEntry(FuelLog log){
        this.logs.add(log);
        this.sortLogs();
    }

    public void updateEntry(int pos, FuelLog new_log){
        this.logs.remove(pos);
        this.logs.add(new_log);
        this.sortLogs();
    }

    public void removeEntry(int pos){
        this.logs.remove(pos);
    }

    public void clearData(){
        this.logs.clear();
    }

    public void sortLogs(){
        Collections.sort(logs);
    }

    public static DataManager getInstance(){
        if(instance == null){
            instance = new DataManager();
        }
        return instance;
    }

}
