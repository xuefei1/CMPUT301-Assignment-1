package cmput301.xuefei1_fueltrack;

import android.content.Context;

import java.util.List;

/**
 * Created by Fred on 2016/1/28.
 */
public class FTController {

    private FTModel<FuelLog> model = null;
    private Context context;


    public FTController(Context ctx, FTModel<FuelLog> model){
        this.model = model;
        this.context = ctx;
    }

    public void addNewLog(int year, int month, int day, float amount, float unit_price, float odometer, String grade, String station){
        this.model.addEntry(new FuelLog(year, month, day, amount, unit_price, odometer, grade, station));
    }

    public void updateLog(int position, int year, int month, int day, float amount, float unit_price, float odometer, String grade, String station){
        this.model.updateEntry(position, new FuelLog(year, month, day, amount, unit_price, odometer, grade, station));
    }

    public void removeLog(int position){
        this.model.removeEntry(position);
    }

    public List<FuelLog> requestData(){
        return this.model.getData();
    }

    public void requestViewUpdate(FTView v){
        v.updateView();
    }

    public void loadModelState(){
        this.model.loadFromFile(this.context);
    }

    public void saveModelState(){
        this.model.saveToFile(this.context);
    }

}
