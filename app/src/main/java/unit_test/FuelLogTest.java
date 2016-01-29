package unit_test;

/**
 * Created by Fred on 2016/1/23.
 */


import junit.framework.TestCase;

import org.junit.Test;
import java.util.Calendar;

import cmput301.xuefei1_fueltrack.FuelLog;

public class FuelLogTest extends TestCase{

    /*

    Purpose: Unit test for our log entry class

    Design rationale: JUNIT, separation of concern. Test each component individually
    It's also a good idea to test the foundation data structure since it can be considered part of the model

    Issues: None

    */

    private FuelLog log;
    private static final String TEST_STR_STATION = "station";
    private static final String TEST_STR_GRADE = "grade";
    private static final Float TEST_FLOAT_PRICE = new Float(67.755);
    private static final Float TEST_FLOAT_AMOUNT = new Float(80);
    private static final Float TEST_FLOAT_ODO = new Float(112345.0);
    private static final Calendar calendar = Calendar.getInstance();

    @Test
    public void testSetters(){
        this.log = new FuelLog(2000, 01, 01,
               new Float(80), new Float(69), new Float(53242), "grade", "esso");
        this.log.setAmount(TEST_FLOAT_AMOUNT);
        this.log.setUnitCost(TEST_FLOAT_PRICE);
        this.log.setStation(TEST_STR_STATION);
        this.log.setOdometer(TEST_FLOAT_ODO);
        this.log.setGrade(TEST_STR_GRADE);
        this.log.setDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(log.getStation(), TEST_STR_STATION);
        assertEquals(log.getGrade(), TEST_STR_GRADE);
        assertEquals(log.getOdometer(), TEST_FLOAT_ODO);
        assertEquals(log.getAmount(), TEST_FLOAT_AMOUNT);
        assertEquals(log.getUnitCost(), TEST_FLOAT_PRICE);
        assertEquals(log.getDateCalendar().get(Calendar.YEAR), calendar.get(Calendar.YEAR));
        assertEquals(log.getDateCalendar().get(Calendar.MONTH), calendar.get(Calendar.MONTH));
        assertEquals(log.getDateCalendar().get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    public void testCostCalculation(){
        this.log = new FuelLog(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_STR_STATION);
        assertEquals(this.log.getTotalCost(), TEST_FLOAT_PRICE/100 *TEST_FLOAT_AMOUNT);
    }

    @Test
    public void testComparison(){
        this.log = new FuelLog(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_STR_STATION);
        try{Thread.sleep(1000);}catch(Exception e){throw new RuntimeException();}
        FuelLog new_log = new FuelLog(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_STR_STATION);
        assertEquals(this.log.compareTo(new_log), 1);
    }

}
