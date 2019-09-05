

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
    
    public void ejectPayment(GumballMachine gm, int count)
    {
        for (int i = 0; i < count; i++)
        {
            gm.ejectPayment();
        }
    }
 
    public void addPayment(GumballMachine gm, int count)
    {
        for (int i = 0; i < count; i++)
        {
            gm.addPayment();
        }
    }

    public void turnCrank(GumballMachine gm, int count)
    {
        for (int i = 0; i < count; i++)
        {
            gm.turnCrank();
        }
    }

    @Test
    public void cantDispenseWithoutPayment()
    {
        GumballMachine gumballMachine = new GumballMachine(5);
        gumballMachine.turnCrank();
        assertEquals(gumballMachine.getCount(), 5);
    }

    @Test
    public void DispenseOneGumball()
    {
        GumballMachine gumballMachine = new GumballMachine(5);
        gumballMachine.addPayment();
        gumballMachine.turnCrank();
        assertEquals(gumballMachine.getCount(), 4);
    }

    @Test
    // one payment at a time, only one gumball per payment
    public void AddPaymentMultipleTimes()
    {
        GumballMachine gumballMachine = new GumballMachine(5);
        addPayment(gumballMachine, 2);
        turnCrank(gumballMachine, 2);
        assertEquals(gumballMachine.getCount(), 4);
        turnCrank(gumballMachine, 1);
        assertEquals(gumballMachine.getCount(), 4);
    }

    @Test
    // Attempt to get a gumball when there are no more
    public void CantDispenseIfNoGumballs()
    {
        GumballMachine gumballMachine = new GumballMachine(1);
        addPayment(gumballMachine, 1);
        turnCrank(gumballMachine, 1);
        assertEquals(gumballMachine.getCount(), 0);
        addPayment(gumballMachine, 1);
        turnCrank(gumballMachine, 1);
        assertEquals(gumballMachine.getCount(), 0);
    }
    
    @Test
    // eject payment and try to get a gumball
    public void EjectPaymentAndCrank()
    {
        GumballMachine gumballMachine = new GumballMachine(1);
        addPayment(gumballMachine, 1);
        ejectPayment(gumballMachine, 1);
        turnCrank(gumballMachine, 1);
        assertEquals(gumballMachine.getCount(), 1);

        addPayment(gumballMachine, 1);
        turnCrank(gumballMachine, 1);
        assertEquals(gumballMachine.getCount(), 0);
    }
    
    @Test
    // eject payment multiple times
    public void EjectPaymentMultipleTimes()
    {
        GumballMachine gumballMachine = new GumballMachine(1);
        addPayment(gumballMachine, 1);
        ejectPayment(gumballMachine, 3);
        turnCrank(gumballMachine, 1);
        assertEquals(gumballMachine.getCount(), 1);
    }
}
