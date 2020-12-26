import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RandomPicker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RandomPicker extends Picker
{
    private int typesOfGumballs = 2;
    
    /**
     * Act - do whatever the RandomPicker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    // creates a new instance of green gumball
    public Gumball getGumball()
    {
        Gumball gumball;
        switch (Greenfoot.getRandomNumber(this.typesOfGumballs))
        {
            case 0:
                gumball = new RedGumball();
                break;
            case 1:
                gumball = new GreenGumball();
                break;
            case 2:
                gumball = new BlueGumball();
                break;
            default:
                gumball = new GreenGumball();
                break;
        }
        
        drawGumball(gumball);
        return gumball;
    }
}
