import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gumball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gumball extends Actor
{

    public Gumball()
    {
        GreenfootImage image = getImage() ;
        image.scale( 50, 50 ) ; 
        int mouseX, mouseY ;
        
        if(Greenfoot.mouseDragged(this))
        {          
            MouseInfo mouse = Greenfoot.getMouseInfo();  
            mouseX=mouse.getX();  
            mouseY=mouse.getY();  
            setLocation(mouseX, mouseY);
        }
    }

    public void act() 
    {
        // Add your action code here.
    }    
}
