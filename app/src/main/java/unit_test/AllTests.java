package unit_test;

/**
 * Created by Fred on 2016/1/23.
 */

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

    public static Test suite() {
        TestSuite suite = new TestSuite("Test for default package");
        //$JUnit-BEGIN$
        suite.addTestSuite(FuelLogTest.class);
        suite.addTestSuite(DataManagerTest.class);

        //$JUnit-END$
        return suite;
    }
}
