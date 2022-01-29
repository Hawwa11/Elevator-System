package elavator_application;

/**
 *
 * @author arifu
 */
public class Ele_Sen extends Thread 
{
    int waterV;
    Ele_Inc myValve = new Ele_Inc();
    
    public Ele_Sen()
    {System.out.println("Sensor is up and running" + System.currentTimeMillis());}
    
    public void run()
    {
        try
        {
        for(int i=0 ; i <=50 ; i++)
        {
            
        Thread.sleep(1500);
            
        waterV = (int) (Math.random() * 150);
        
        if(waterV <= 60)
        {
            System.out.println("Low Volume " + waterV);
        }
        else if (waterV > 60 && waterV<=85)
                {
                       System.out.println("Medium Volume " + waterV);
                }
        else if(waterV > 85) 
                {
               System.out.println("High Volume " + waterV);
                }
        
        myValve.openValve(waterV);
                }
        
    }
    catch(InterruptedException e) {}
    }
}
