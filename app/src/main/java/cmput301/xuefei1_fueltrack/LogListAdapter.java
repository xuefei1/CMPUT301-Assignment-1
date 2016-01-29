package cmput301.xuefei1_fueltrack;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Fred on 2016/1/19.
 */
public class LogListAdapter extends ArrayAdapter{

    private Context ctx;
    private int layoutResID;
    private FTController controller;

    public LogListAdapter(Context context, int layoutResourceId, FTController controller){
        super(context, layoutResourceId, controller.requestData());
        this.controller = controller;
        this.ctx = context;
        this.layoutResID = layoutResourceId;

    }

    @Override
    public int getCount() {
        return this.controller.requestData().size();
    }

    @Override
    public FuelLog getItem(int position) {
        return this.controller.requestData().get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = ((Activity) ctx).getLayoutInflater();
            convertView = inflater.inflate(layoutResID, parent, false);
        }

        Button bt_edit = (Button) convertView.findViewById(R.id.btn_edit_log);
        Button bt_delete = (Button) convertView.findViewById(R.id.btn_del_log);
        TextView tv_total_cost = (TextView) convertView.findViewById(R.id.tv_total_cost);
        TextView tv_odometer = (TextView) convertView.findViewById(R.id.tv_odometer);
        TextView tv_unit_cost = (TextView) convertView.findViewById(R.id.tv_unit_cost);
        TextView tv_amount = (TextView) convertView.findViewById(R.id.tv_amount);
        TextView tv_type = (TextView) convertView.findViewById(R.id.tv_type);
        TextView tv_date = (TextView) convertView.findViewById(R.id.tv_date);
        TextView tv_location = (TextView) convertView.findViewById(R.id.tv_location);

        final String cost =  Helper.roundDecimal(2, this.controller.requestData().get(position).getTotalCost());
        final String odometer = Helper.roundDecimal(1, this.controller.requestData().get(position).getOdometer());
        final String amount = Helper.roundDecimal(3, this.controller.requestData().get(position).getAmount());
        final String price = Helper.roundDecimal(1, this.controller.requestData().get(position).getUnitCost());

        tv_total_cost.setText("$" + cost);
        tv_odometer.setText(odometer +" km");
        tv_amount.setText(amount + " L");
        tv_unit_cost.setText(price + " cents/L");
        tv_date.setText(this.controller.requestData().get(position).getDate());
        tv_type.setText(this.controller.requestData().get(position).getGrade());
        tv_location.setText("At " + this.controller.requestData().get(position).getStation());

        bt_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, Activity_Edit.class);
                Bundle b = new Bundle();
                int year = controller.requestData().get(position).getDateCalendar().get(Calendar.YEAR);
                int month = controller.requestData().get(position).getDateCalendar().get(Calendar.MONTH);
                int day = controller.requestData().get(position).getDateCalendar().get(Calendar.DAY_OF_MONTH);
                b.putInt(Helper.ACTIVITY_BUNDLE_ACTIVITY_TYPE, Helper.ACTIVITY_TYPE_EDIT_LOG);
                b.putString(Helper.ACTIVITY_BUNDLE_GRADE, controller.requestData().get(position).getGrade());
                b.putString(Helper.ACTIVITY_BUNDLE_AMOUNT, amount);
                b.putString(Helper.ACTIVITY_BUNDLE_STATION, controller.requestData().get(position).getStation());
                b.putString(Helper.ACTIVITY_BUNDLE_ODOMETER, odometer);
                b.putString(Helper.ACTIVITY_BUNDLE_UNIT_PRICE, price);
                b.putInt(Helper.ACTIVITY_BUNDLE_DATE_YEAR, year);
                b.putInt(Helper.ACTIVITY_BUNDLE_DATE_MONTH, month);
                b.putInt(Helper.ACTIVITY_BUNDLE_DATE_DAY, day);
                b.putInt(Helper.ACTIVITY_BUNDLE_INDEX, position);
                intent.putExtra(Helper.ACTIVITY_BUNDLE_TITLE, b);
                ctx.startActivity(intent);
            }
        });
        bt_delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ctx);
                dialog.setTitle(ctx.getResources().getString(R.string.delete_title_en));
                dialog.setMessage(ctx.getResources().getString(R.string.delete_msg_en));
                dialog.setPositiveButton(ctx.getResources().getString(R.string.yes_en), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        controller.removeLog(position);
                        notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                dialog.setNegativeButton(ctx.getResources().getString(R.string.no_en), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        return convertView;
    }

}
