package unit_test;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;

import cmput301.xuefei1_fueltrack.DataManager;
import cmput301.xuefei1_fueltrack.FuelTrack_MainActivity;

/**
 * Created by Fred on 2016/1/23.
 */
public class DataManagerTest extends ActivityInstrumentationTestCase2{

    private DataManager dataManager;

    private static final String TEST_STR_STATION = "station";
    private static final String TEST_STR_GRADE = "grade";
    private static final Float TEST_FLOAT_PRICE = new Float(67.755);
    private static final Float TEST_FLOAT_AMOUNT = new Float(80);
    private static final Float TEST_FLOAT_ODO = new Float(112345.0);
    private static final int TEST_YEAR = 2016;
    private static final int TEST_MONTH = 1;
    private static final int TEST_DAY = 31;


    public DataManagerTest(){
        super(FuelTrack_MainActivity.class);

    }

    @Test
    public void testSingleInstance(){
        DataManager man = dataManager.getInstance();
        assertEquals(man, dataManager.getInstance());
    }

    @Test
    public void testInit(){
        DataManager manager = DataManager.getInstance();
        manager.loadFromFile(getActivity());
        assertEquals(ArrayList.class, manager.getData().getClass());
    }

    @Test
    public void testAdd(){
        DataManager manager = DataManager.getInstance();
        manager.loadFromFile(getActivity());
        manager.clearData();
        assertEquals(manager.getData().size(), 0);
        manager.addNewLog(TEST_YEAR, TEST_MONTH, TEST_DAY, TEST_STR_STATION, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE);
        assertEquals(manager.getData().size(), 1);
        assertEquals(manager.getData().get(0).getAmount(), TEST_FLOAT_AMOUNT);
        manager.addNewLog(TEST_YEAR, TEST_MONTH, TEST_DAY, TEST_STR_STATION, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE);
        assertEquals(manager.getData().size(), 2);
    }

    @Test
    public void testDelete(){
        DataManager manager = DataManager.getInstance();
        manager.loadFromFile(getActivity());
        manager.clearData();
        assertEquals(manager.getData().size(), 0);
        manager.addNewLog(TEST_YEAR, TEST_MONTH, TEST_DAY, TEST_STR_STATION, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE);
        assertEquals(manager.getData().size(), 1);
        manager.removeLog(0);
        assertEquals(manager.getData().size(), 0);
        manager.addNewLog(TEST_YEAR, TEST_MONTH, TEST_DAY, TEST_STR_STATION, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE);
        manager.addNewLog(TEST_YEAR, TEST_MONTH, TEST_DAY, TEST_STR_STATION, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE);
        assertEquals(manager.getData().size(), 2);
        manager.clearData();
        assertEquals(manager.getData().size(), 0);
    }

    @Test
    public void testSort(){
        DataManager manager = DataManager.getInstance();
        manager.loadFromFile(getActivity());
        manager.clearData();
        assertEquals(manager.getData().size(), 0);
        manager.addNewLog(TEST_YEAR, TEST_MONTH, TEST_DAY, TEST_STR_STATION, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE);
        manager.addNewLog(TEST_YEAR - 1, TEST_MONTH, TEST_DAY, TEST_STR_STATION, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE);
        manager.addNewLog(TEST_YEAR, TEST_MONTH+1, TEST_DAY, TEST_STR_STATION, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE);
        manager.sortLogsByDate();
        assertEquals(manager.getData().get(2).getDateCalendar().get(Calendar.YEAR), TEST_YEAR - 1);
        assertEquals(manager.getData().get(1).getDateCalendar().get(Calendar.YEAR), TEST_YEAR);
        assertEquals(manager.getData().get(0).getDateCalendar().get(Calendar.MONTH), TEST_MONTH + 1);
    }

    @Test
    public void testUpdate(){
        DataManager manager = DataManager.getInstance();
        manager.loadFromFile(getActivity());
        manager.clearData();
        assertEquals(manager.getData().size(), 0);
        manager.addNewLog(TEST_YEAR, TEST_MONTH, TEST_DAY, TEST_STR_STATION, TEST_FLOAT_ODO, TEST_STR_GRADE, TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE);
        manager.updateLog(0, TEST_FLOAT_AMOUNT, TEST_FLOAT_PRICE, TEST_FLOAT_ODO, TEST_STR_STATION, TEST_STR_GRADE, TEST_YEAR - 1, TEST_MONTH + 1, TEST_DAY - 10);
        assertEquals(manager.getData().get(0).getDateCalendar().get(Calendar.YEAR), TEST_YEAR - 1);
        assertEquals(manager.getData().get(0).getDateCalendar().get(Calendar.MONTH), TEST_MONTH + 1);
        assertEquals(manager.getData().get(0).getDateCalendar().get(Calendar.DAY_OF_MONTH), TEST_DAY - 10);

    }

}
