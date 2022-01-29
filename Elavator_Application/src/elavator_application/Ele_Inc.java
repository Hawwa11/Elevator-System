package elavator_application;

/**
 *
 * @author arifu
 */
public class Ele_Inc 
{
    public Ele_Inc() //constructor
    {
        System.out.println("Actuator is creater at " + System.currentTimeMillis() );
    }
    
    public void openValve(int water)
    {
        if(water <= 60)
        {
            openValve45();
        }
        else if (water > 60 && water <=85)
                {
                openValve90();
                }
        else if(water > 85) 
                {
                openValve180();
                }
    }
    public void openValve45(){
        System.out.println("Valve is opened for 45' ");
    }
            public void openValve90()
            {
            System.out.println("Valve is opened for 90' ");
            }
                    public void openValve180()
                    {
                    System.out.println("Valve is opened for 180' ");
                    }
}