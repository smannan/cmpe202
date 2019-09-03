

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GumballMachineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GumballMachineTest
{
    /**
     * Default constructor for test class GumballMachineTest
     */
    public GumballMachineTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    public void insertCoins(GumballMachine gumballMachine, int numCoins, int coinValue)
    {
        for (int i = 0; i < numCoins; i++)
        {
            gumballMachine.insertCoin(coinValue);
        }
    }
    
    public void insertQuarters(GumballMachine gumballMachine, int numCoins)
    {
        insertCoins(gumballMachine, numCoins, 25);
    }
    
    public void turnCrank(GumballMachine gumballMachine, int numTurns, int totalGumballs)
    {
        for (int i = 1; i <= numTurns; i++)
        {
            gumballMachine.turnCrank();
            assertEquals(gumballMachine.getNumGumballs(), totalGumballs - i);
        }
    }
    
    public void turnCrankOnce(GumballMachine gumballMachine, int expectedGumballs, int expectedPayment)
    {
        gumballMachine.turnCrank();
        assertEquals(gumballMachine.getNumGumballs(), expectedGumballs);
        assertEquals(gumballMachine.getCurrentPayment(), expectedPayment);
    }

    @Test
    public void GivesGumballForQuarter()
    {
       GumballMachine gumballMachine = new GumballMachine(5, 25);
       insertQuarters(gumballMachine, 1);
       turnCrankOnce(gumballMachine, 4, 0);
    }
    
    @Test
    public void GivesGumballForMultipleQuarters()
    {
        GumballMachine gumballMachine = new GumballMachine(5, 25);
        insertQuarters(gumballMachine, 3);
        turnCrank(gumballMachine, 3, 5);
        turnCrankOnce(gumballMachine, 2, 0);
    }
    
    @Test
    public void DoesNotGiveGumballForQuarter()
    {
        GumballMachine gumballMachine = new GumballMachine(5, 25);
        insertCoins(gumballMachine, 1, 1);
        turnCrankOnce(gumballMachine, 5, 1);
    }
    
    @Test
    public void GivesGumballForDoubleQuarter()
    {
        GumballMachine gumballMachine = new GumballMachine(5, 50);
        insertQuarters(gumballMachine, 2);
        turnCrankOnce(gumballMachine, 4, 0);
    }
    
    @Test
    public void DoesNotGiveGumballForDoubleQuarter()
    {
        GumballMachine gumballMachine = new GumballMachine(5, 50);
        insertQuarters(gumballMachine, 1);
        turnCrankOnce(gumballMachine, 5, 25);
    }
    
    @Test
    public void GivesGumballForMixedCoins()
    {
        GumballMachine gumballMachine = new GumballMachine(5, 50);
        
        insertQuarters(gumballMachine, 1);  // 25
        insertCoins(gumballMachine, 1, 10); // 35
        insertCoins(gumballMachine, 1, 10); // 45
        insertCoins(gumballMachine, 1, 5);  // 50
        
        turnCrankOnce(gumballMachine, 4, 0);
    }
    
    @Test
    public void DoesNotGiveGumballForMixedCoins()
    {
        GumballMachine gumballMachine = new GumballMachine(5, 50);
        
        insertCoins(gumballMachine, 1, 10); // 10
        insertCoins(gumballMachine, 1, 10); // 20
        insertCoins(gumballMachine, 1, 5);  // 25
        
        turnCrankOnce(gumballMachine, 5, 25);
    }
}

