package cmput301.xuefei1_fueltrack;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by xuefei1 on 1/12/16.
 */
public class FuelLog implements Comparable<FuelLog>{

    private Calendar date = Calendar.getInstance();
    private String station;
    private Float odometer;
    private String grade;
    private Float amount;
    private Float unit_cost;
    private Calendar timestamp;

    public FuelLog(int year, int month, int day, Float amount, Float cost, Float odometer, String grade, String station){
        this.date.set(year,month, day);
        this.station = station;
        this.odometer = odometer;
        this.grade = grade;
        this.amount = amount;
        this.unit_cost = cost;
        this.timestamp = Calendar.getInstance();
    }

    public String getDate(){
        Date d = this.date.getTime();
        SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd");
        return f1.format(d);
    }

    public void setDate(int year, int month, int day){
        this.date.set(year, month, day);
    }

    public void setStation(String station){
        this.station = station;
    }

    public void setGrade(String grade){
        this.grade = grade;
    }

    public void setOdometer(Float odo){
        this.odometer = odo;
    }

    public void setAmount(Float amount){
        this.amount = amount;
    }

    public void setUnitCost(Float c){
        this.unit_cost = c;
    }

    public String getStation(){
        return this.station;
    }

    public String getGrade(){
        return this.grade;
    }

    public Float getOdometer(){
        return this.odometer;
    }

    public Float getAmount(){
        return this.amount;
    }

    public Float getUnitCost(){
        return this.unit_cost;
    }

    public Float getTotalCost(){

        return (this.unit_cost/100) * this.amount;

    }

    public Calendar getDateCalendar(){
        return this.date;
    }

    public Calendar getTimeStamp(){
        return this.timestamp;
    }

    @Override
    public int compareTo(FuelLog another) {
        return - this.timestamp.compareTo(another.getTimeStamp());
    }

}
