package cmput301.xuefei1_fueltrack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Activity_Main extends AppCompatActivity implements FTView{

    /*

    Purpose: Main activity class of the app, displays a list view of all logs and a button to add a new log

    Design rationale: View component in MVC, implements FTView interface and interacts with controller class ONLY, initialize controller in onCreate()

    Issues: None

    */

    private ListView lv_main;
    private LogListAdapter adapter;
    private Context context;
    private TextView tv_no_logs;
    private FTController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_fuel_track__main);
        this.context = this;
        this.controller =  ((FTApplication)getApplication()).getAppController();
        this.controller.loadModelState();
        this.lv_main = (ListView) findViewById(R.id.lv_main);
        this.adapter = new LogListAdapter(this, R.layout.adapter_layout, this.controller){
            @Override
            public void notifyDataSetChanged() {
                super.notifyDataSetChanged();
                updateView();
            }
        };
        this.lv_main.setAdapter(this.adapter);
        this.tv_no_logs = (TextView) findViewById(R.id.tv_no_logs);
        this.updateView();
        Button btn_add_new = (Button) findViewById(R.id.btn_add_new);
        btn_add_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Activity_Edit.class);
                Bundle b = new Bundle();
                b.putInt(Helper.ACTIVITY_BUNDLE_ACTIVITY_TYPE, Helper.ACTIVITY_TYPE_NEW_LOG);
                intent.putExtra(Helper.ACTIVITY_BUNDLE_TITLE, b);
                context.startActivity(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.controller.saveModelState();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.adapter.notifyDataSetChanged();
    }

    @Override
    public void updateView(){
        if(this.controller.requestData().size() == 0){
            this.tv_no_logs.setVisibility(View.VISIBLE);
        }else{
            this.tv_no_logs.setVisibility(View.GONE);
        }
    }
}
