package cmput301.xuefei1_fueltrack;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.List;

/**
 * Created by Fred on 2016/1/19.
 */
public class LogListAdapter<Log> extends ArrayAdapter {

    private Context ctx;
    private List<FuelLog> data;

    public LogListAdapter(Context context, int layoutResourceId, List<FuelLog> data){
        super(context, layoutResourceId, data);
        this.data = data;
    }

    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public FuelLog getItem(int position) {
        return this.data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.data.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
