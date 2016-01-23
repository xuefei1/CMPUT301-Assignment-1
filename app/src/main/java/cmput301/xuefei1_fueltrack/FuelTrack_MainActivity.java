package cmput301.xuefei1_fueltrack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class FuelTrack_MainActivity extends AppCompatActivity {

    private ListView lv_main;
    private LogListAdapter adapter;
    private DataManager dataManager;
    private Context context;
    private TextView tv_no_logs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_fuel_track__main);
        this.context = this;
        this.dataManager = DataManager.getInstance();
        this.dataManager.loadFromFile(this);
        this.lv_main = (ListView) findViewById(R.id.lv_main);
        this.adapter = new LogListAdapter(this, R.layout.adapter_layout, dataManager.getData()){
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
                Intent intent = new Intent(context, FuelTrack_EditActivity.class);
                Bundle b = new Bundle();
                b.putInt(FuelTrack_Utils.ACTIVITY_BUNDLE_ACTIVITY_TYPE, FuelTrack_Utils.ACTIVITY_TYPE_NEW_LOG);
                intent.putExtra(FuelTrack_Utils.ACTIVITY_BUNDLE_TITLE, b);
                context.startActivity(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.dataManager.saveToFile(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.adapter.notifyDataSetChanged();
        this.updateView();
    }

    private void updateView(){
        if(this.dataManager.getData().size() == 0){
            this.tv_no_logs.setVisibility(View.VISIBLE);
        }else{
            this.tv_no_logs.setVisibility(View.GONE);
        }
    }
}
