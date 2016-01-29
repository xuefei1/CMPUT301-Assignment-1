package cmput301.xuefei1_fueltrack;

import android.content.Context;

import java.util.List;

/**
 * Created by Fred on 2016/1/28.
 */
public class FTController {

    /*

    Purpose: Controller class for the entire app. It's responsibilities include:
    1. Interact with model to request operations to be done on the data
    2. Relay requests for data from the View classes to the model. Thus, view NEVER talks to model directly
    3. Handle view refresh requests, this method is relatively simple to implement for a simple App like this,
        but for a more complicated system, we might want to deny some view update requests to improve performance, so it's
        better design to have the controller decide when to update the view and let the view objects provide an implementation about
        what to update.

    Design rationale: Controller component in MVC

    Issues: None

    */

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
