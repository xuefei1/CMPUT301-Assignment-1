package com.cmput301.xuefei1.xuefei1_fueltrack;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by xuefei1 on 1/12/16.
 */
public class Log {

    private Calendar date = Calendar.getInstance();
    private String station;
    private Float odometer;
    private String grade;
    private Float amount;
    private Float cost;

    public Log(int year, int month, int day, String station, Float odometer, String grade, Float amount, Float cost){
        this.date.set(year,month, day);
        this.station = station;
        this.odometer = odometer;
        this.grade = grade;
        this.amount = amount;
        this.cost = cost;
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
        this.station = station;d ..
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

    public Float getCost(){
        return this.cost;
    }
}
