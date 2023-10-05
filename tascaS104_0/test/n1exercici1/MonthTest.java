package n1exercici1;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author OCuevas
 */
public class MonthTest {

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

 

    @Test
    public void testSizeMonths() {
        System.out.println("Size list Months is 12 positions");
        int result = Month.addMonths().size();
        int expResult = 12;

        assertEquals(expResult, result);
        //  fail("the list does not have 12 positions.");
    }

    @Test
    public void testIsNull() {
        System.out.println("List is not Null");
        ArrayList<String> result = Month.addMonths();
        ArrayList<String> expResult = Month.addMonths();

        assertEquals(expResult, result);
        // fail("the list is null");

    }

    @Test
    public void augustInPos8() {
        System.out.println("August in position 8");

        String result = Month.addMonths().get(7);
        String expResult = "August";

        assertEquals(expResult, result);
        // fail("the list is null");

    }

    /**
     * Test of addMonths method, of class Month.
     */
    @org.junit.jupiter.api.Test
    public void testAddMonths() {
        System.out.println("addMonths");
        ArrayList<String> expResult = null;
        ArrayList<String> result = Month.addMonths();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of monthsOrdered method, of class Month.
     */
    @org.junit.jupiter.api.Test
    public void testMonthsOrdered() {
        System.out.println("monthsOrdered");
        ArrayList<String> months = null;
        String month = "";
        Month.monthsOrdered(months, month);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showList method, of class Month.
     */
    @org.junit.jupiter.api.Test
    public void testShowList() {
        System.out.println("showList");
        ArrayList<String> months = null;
        Month.showList(months);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
