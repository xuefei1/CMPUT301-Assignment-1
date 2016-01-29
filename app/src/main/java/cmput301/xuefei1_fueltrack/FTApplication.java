package cmput301.xuefei1_fueltrack;

import android.app.Application;

/**
 * Created by Fred on 2016/1/28.
 */
public class FTApplication extends Application{

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
