import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Picker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Picker extends Alien
{
    private int drawGumballOffset = 15;

    /**
     * Act - do whatever the Picker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    public void drawGumball(Gumball gumball)
    {
        this.getWorld().addObject(gumball, this.getX(), this.getY() + drawGumballOffset);
    }
    
    // creates a new instance of green gumball
    public Gumball getGumball()
    {
        Gumball gumball = new GreenGumball();
        drawGumball(gumball);
        return gumball;
    }
}
