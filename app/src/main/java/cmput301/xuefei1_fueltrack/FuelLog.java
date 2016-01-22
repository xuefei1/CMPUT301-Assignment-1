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

    public FuelLog(int year, int month, int day, String station, Float odometer, String grade, Float amount, Float cost){
        this.date.set(year,month, day);
        this.station = station;
        this.odometer = odometer;
        this.grade = grade;
        this.amount = amount;
        this.unit_cost = cost;
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

    @Override
    public int compareTo(FuelLog another) {
        return this.date.compareTo(another.getDateCalendar());
    }

    @Override
    public boolean equals(Object o) {
        if(o == null){
            return false;
        }
        if(o.getClass() != this.getClass()){
            return false;
        }

        return this ==  o;
    }
}
