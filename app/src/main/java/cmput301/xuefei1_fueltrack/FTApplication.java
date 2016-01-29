package cmput301.xuefei1_fueltrack;

import android.app.Application;

/**
 * Created by Fred on 2016/1/28.
 */
public class FTApplication extends Application{

    /*

    Purpose: Custom Application class for the app, in here we will instantiate the controller and model object and relate them

    Design rationale: This class is an abstract representation of the entire App, the model and controller objects are best instantiated here than in an activity class

    Issues: None

    */

    private FTModel<FuelLog> model;
    private FTController controller;

    @Override
    public void onCreate() {
        super.onCreate();
        this.model = DataManager.getInstance();
        this.controller = new FTController(getApplicationContext(), this.model);
    }

    public FTController getAppController(){
        return this.controller;
    }
}
