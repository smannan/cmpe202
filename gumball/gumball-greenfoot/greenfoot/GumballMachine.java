import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class GumballMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GumballMachine extends Actor
{
    private Inspector inspector;
    private int numQuarters = 0;

    public GumballMachine()
    {
        GreenfootImage image = getImage();
        image.scale( 350, 400 );
        this.numQuarters = 0;
    }
    
    // can there be more than one inspector in the world?
    // is there guaranteed to be at least one inspector in the world?
    // putting this in the constructor throws a null pointer but it should only run once?
    public Inspector getInspector()
    {
        List<Inspector> inspectors = getWorld().getObjects(Inspector.class);
        if (inspectors != null)
        {
            return inspectors.get(0);
        }

        return null;
    }

    public void act() 
    {
        // Add your action code here.
        this.inspector = getInspector();
        acceptCoins();
        processPayment();
    }
    
    // Prints message if coin intersects
    // increments number of quarters if the coin is a quarter
    public void acceptCoins()
    {
        String message = "Thanks for the coin!";
        // get intersecting coins
        Coin coin = (Coin) getOneIntersectingObject(Coin.class);
        if (coin != null)
        { 
            if(coin.isQuarter())
            {
                this.numQuarters += 1;
            }
            
            // show text and remove the coin
            getWorld().showText(message, this.getX(), this.getY());
            getWorld().removeObject(coin);
        }    
    }
    
    public void giveGumball()
    {
        // how does the inspector know which picker to choose?
        // pick at random for now
        this.inspector.selectPicker().getGumball();
    }
    
    // how to tell when the user "turns the crank"
    // assuming the event is based off a mouse click
    public void processPayment()
    {
        String message = "";
        
        // user turns the crank
        if (Greenfoot.mouseClicked(this))
        {
            if (this.numQuarters > 0)
            {
                this.numQuarters -= 1;
                getWorld().showText("Processing payment", this.getX(), this.getY());
                giveGumball();
            }
        }
    }
}
