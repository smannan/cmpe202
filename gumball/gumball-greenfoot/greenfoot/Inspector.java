import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Inspector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inspector extends Alien
{   
    private List<Picker> pickers;
    
    public Inspector()
    {
        this.pickers = new ArrayList<Picker>();
    }

    /**
     * Act - do whatever the Inspector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        this.pickers = setPickers();
    }
    
    // can there be more than one inspector in the world?
    // is there guaranteed to be at least one inspector in the world?
    // putting this in the constructor throws a null pointer but it should only run once?
    public List<Picker> setPickers()
    {
        List<Picker> pickers = getWorld().getObjects(Picker.class);
        return pickers != null ? pickers : null;
    }
    
    public List<Picker> getPickers()
    {
        return this.pickers;
    }
    
    public Picker selectPicker()
    {
        return this.pickers.get(Greenfoot.getRandomNumber(pickers.size()));
    }
    
    public boolean inspectCoin(Coin coin)
    {
        return coin.isQuarter();
    }
}
