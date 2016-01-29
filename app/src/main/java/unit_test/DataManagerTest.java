package unit_test;

import android.test.ActivityInstrumentationTestCase2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;

import cmput301.xuefei1_fueltrack.DataManager;
import cmput301.xuefei1_fueltrack.Activity_Main;
import cmput301.xuefei1_fueltrack.FuelLog;

/**
 * Created by Fred on 2016/1/23.
 */
public class DataManagerTest extends ActivityInstrumentationTestCase2{

    /*

    Purpose: Unit test for our model class

    Design rationale: JUNIT, separation of concern. Test each component individually

    Issues: None

    */

    private static final String TEST_STR_STATION = "station";
    private static final String TEST_STR_GRADE = "grade";
    private static final Float TEST_FLOAT_PRICE = new Float(67.755);
    private static final Float TEST_FLOAT_AMOUNT = new Float(80);
    private static final Float TEST_FLOAT_ODO = new Float(112345.0);
    private static final int TEST_YEAR = 2016;
    private static final int TEST_MONTH = 1;
    private static final int TEST_DAY = 31;


    public DataManagerTest(){
        super(Activity_Main.class);

    }

    @Test
    public void testSingleInstance(){
        DataManager man = DataManager.getInstance();
        assertEquals(man, DataManager.getInstance());
    }

    @Test
    public void testInit(){
        DataManager manager = DataManager.getInstance();
        manager.loadFromFile(getActivity().getApplicationContext());
        assertEquals(ArrayList.class, manager.getData().getClass());
    }

    @Test
    public void testAdd(){
        DataManager manager = DataManager.getInstance();
        manager.loadFromFile(getActivity().getApplicationContext());
        manager.clearData();
        assertEquals(manager.getData().size(), 0);
        manager.addEntry(new FuelLog(TEST_YEAR, TEST_MONTH, TEST_DAY, TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_STR_STATION));
        assertEquals(manager.getData().size(), 1);
        assertEquals(manager.getData().get(0).getAmount(), TEST_FLOAT_AMOUNT);
        manager.addEntry(new FuelLog(TEST_YEAR, TEST_MONTH, TEST_DAY, TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_STR_STATION));
        assertEquals(manager.getData().size(), 2);
    }

    @Test
    public void testDelete(){
        DataManager manager = DataManager.getInstance();
        manager.loadFromFile(getActivity().getApplicationContext());
        manager.clearData();
        assertEquals(manager.getData().size(), 0);
        manager.addEntry(new FuelLog(TEST_YEAR, TEST_MONTH, TEST_DAY, TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_STR_STATION));
        assertEquals(manager.getData().size(), 1);
        manager.removeEntry(0);
        assertEquals(manager.getData().size(), 0);
        manager.addEntry(new FuelLog(TEST_YEAR, TEST_MONTH, TEST_DAY, TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_STR_STATION));
        manager.addEntry(new FuelLog(TEST_YEAR, TEST_MONTH, TEST_DAY, TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_STR_STATION));
        assertEquals(manager.getData().size(), 2);
        manager.clearData();
        assertEquals(manager.getData().size(), 0);
    }

    @Test
    public void testSort(){
        DataManager manager = DataManager.getInstance();
        manager.loadFromFile(getActivity().getApplicationContext());
        manager.clearData();
        assertEquals(manager.getData().size(), 0);
        manager.addEntry(new FuelLog(TEST_YEAR-1, TEST_MONTH, TEST_DAY, TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_STR_STATION));
        try{Thread.sleep(1000);}catch(Exception e){throw new RuntimeException();}
        manager.addEntry(new FuelLog(TEST_YEAR-2, TEST_MONTH, TEST_DAY, TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_STR_STATION));
        try{Thread.sleep(1000);}catch(Exception e){throw new RuntimeException();}
        manager.addEntry(new FuelLog(TEST_YEAR-3, TEST_MONTH, TEST_DAY, TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_STR_STATION));
        manager.sortLogs();
        assertEquals(manager.getData().get(0).getDateCalendar().get(Calendar.YEAR), TEST_YEAR - 3);
        assertEquals(manager.getData().get(1).getDateCalendar().get(Calendar.YEAR), TEST_YEAR - 2);
        assertEquals(manager.getData().get(2).getDateCalendar().get(Calendar.YEAR), TEST_YEAR - 1);
    }

    @Test
    public void testUpdate(){
        DataManager manager = DataManager.getInstance();
        manager.loadFromFile(getActivity().getApplicationContext());
        manager.clearData();
        assertEquals(manager.getData().size(), 0);
        manager.addEntry(new FuelLog(TEST_YEAR, TEST_MONTH, TEST_DAY, TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_STR_STATION));
        manager.updateEntry(0, new FuelLog(TEST_YEAR - 1, TEST_MONTH + 1, TEST_DAY - 1, TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_STR_STATION));
        assertEquals(manager.getData().get(0).getDateCalendar().get(Calendar.YEAR), TEST_YEAR - 1);
        assertEquals(manager.getData().get(0).getDateCalendar().get(Calendar.MONTH), TEST_MONTH + 1);
        assertEquals(manager.getData().get(0).getDateCalendar().get(Calendar.DAY_OF_MONTH), TEST_DAY - 1);
    }

}
