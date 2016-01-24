package unit_test;

import junit.framework.TestCase;

import org.junit.Test;

import cmput301.xuefei1_fueltrack.DataManager;

/**
 * Created by Fred on 2016/1/23.
 */
public class DataManagerTest extends TestCase{

    private DataManager dataManager;

    @Test
    public void testSingleInstance(){
        DataManager man = dataManager.getInstance();
        assertEquals(man, dataManager.getInstance());
    }

    @Test
    public void testAdd(){

    }

    @Test
    public void testDelete(){

    }
}
