package cmput301.xuefei1_fueltrack;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Fred on 2016/1/20.
 */
public class FuelTrack_EditActivity extends Activity{

    private int activityType = FuelTrack_Utils.ACTIVITY_TYPE_NEW_LOG;
    private TextView tv_main_title;
    private EditText et_amount;
    private EditText et_unit_price;
    private EditText et_type;
    private EditText et_station;
    private EditText et_odometer;
    private Button btn_date_picker;
    private Calendar cal = Calendar.getInstance();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getBundleExtra(FuelTrack_Utils.ACTIVITY_BUNDLE_TITLE);
        if (extras != null) {
            this.activityType = extras.getInt(FuelTrack_Utils.ACTIVITY_BUNDLE_ACTIVITY_TYPE);
        }

        LayoutInflater inflater = (LayoutInflater) getActionBar()
                .getThemedContext().getSystemService(
                        LAYOUT_INFLATER_SERVICE);
        View customActionBarView = inflater.inflate(
                R.layout.actionbar_btn_custom, null);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM,
                ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME
                        | ActionBar.DISPLAY_SHOW_TITLE);
        actionBar.setCustomView(customActionBarView,
                new ActionBar.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
        Button btn_save = (Button) findViewById(R.id.btn_save);
        Button btn_cancel = (Button) findViewById(R.id.btn_cancel);
        btn_save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        setContentView(R.layout.edit_log_layout);
        tv_main_title = (TextView) findViewById(R.id.tv_main_title);
        et_amount = (EditText) findViewById(R.id.et_amount);
        et_unit_price = (EditText) findViewById(R.id.et_unit_price);
        et_type = (EditText) findViewById(R.id.et_type);
        et_station = (EditText) findViewById(R.id.et_station);
        et_odometer = (EditText) findViewById(R.id.et_odometer);
        btn_date_picker = (Button) findViewById(R.id.btn_date_picker);

        if(this.activityType == FuelTrack_Utils.ACTIVITY_TYPE_EDIT_LOG){
            this.initializeValues(extras);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void initializeValues(Bundle d){

    }
}
