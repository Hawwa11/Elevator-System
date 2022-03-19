package elavator_application;

/**
 *
 * @author uSER
 */
import java.util.Random;

public class SensorThread extends Thread {
    
     Elevator E1;
     User[] users = new User[5];
     int curr = 1;
     int direction;
    
     private Random random = new Random();
     
    public SensorThread()
    {
        
    }
    
     public void run()
    {
       
            double weight;
            int fGetOn;
            int fGetOff;
           
       
        for(int i=0; i<5; i++)
        {
            weight = (double) (Math.random()*800);
            fGetOn = (int) (Math.random()*(4-1) + 1);
            fGetOff = (int) (Math.random()*(4-1) + 1);
            
            users[i] = new User(weight, fGetOn, fGetOff);
            System.out.println("Weight generated " + weight);
            
        }
        System.out.println(" ");
        
        E1 = new Elevator(users);
        
        run2();
        
//        for(int u = 0; u<5; u++)
//        {
//            run2(users[u].floorGetOn, users[u].floorGetOff, u);
//            
//        }
       
       
    }
     
     public void run2()
    {
         
        while(E1.isEmpty != true){
            
            if(curr == 1)
            {
                direction=0;
                elevaterMotion();
             
               
            }
            else if(curr == 2)
            {
                 elevaterMotion();
                
            }
            else if(curr == 3)
            {
              elevaterMotion();
              
            }
            else if(curr == 4)
            {
               direction=1;
               elevaterMotion();
       
            }
            
            else
            {
                System.out.println("Elevator Error...");
            }
        }
         
    }
     
     //loop to check if any user want to get in or out and then move the elevator to next floor
    public void elevaterMotion()
    {
        for(int u=0; u < 5; u++)
                {
                    if(users[u].floorGetOn == curr)
                    {
                        E1.getOn(u);
                    }
                    if(users[u].floorGetOff == curr)
                    {
                        E1.getOff(u);
                    }
                   
                }
 
        if(!E1.canMove()){
            int uno = Integer.parseInt(E1.userIDon.get(E1.userIDon.size() - 1).toString());
            E1.getOffforWeigth(uno);
        }else{}
        
             if(direction==0)
             {
                curr = up(curr);
             }
             else
                curr = down(curr);
       
     
    }
    
    //moves it up
    public int down(int curr)
    {
        curr--;
        System.out.println("Elevator going downward....");
        System.out.println("current floor = "+curr);
        return curr;
    }
    
    
    //moves it down
    public int up(int curr)
    {
        curr++;
        System.out.println("Elevator going upward....");
        System.out.println("current floor = "+curr);
        return curr;
    }
    

}
