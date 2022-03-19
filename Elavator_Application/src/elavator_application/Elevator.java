package elavator_application;
import java.util.ArrayList;
import java.util.List;


public class Elevator {
    double totalWeight=0;
    
    List userIDon = new ArrayList();
    List userIDoff = new ArrayList();
    
    User[] users;
    boolean isEmpty;
    
    public Elevator(User[] u)
    {
        users = u;
    }
    
    //checks the weight
    public boolean canMove()
    {
           if(totalWeight > 1000)
            {
                System.out.println("Weight exceeded! Please leave the elevator");
                return false;
            }
            else if(totalWeight <= 1000)
            {
                return true;
            }
            else
            {
                System.out.println("Error");
                return false;
            }
    }
    
    //user get on the elevator
    public void getOn(int uNo)
    {
        if(userIDoff.contains(uNo) || userIDon.contains(uNo))
        {}
        else
        {
        totalWeight += users[uNo].weight;
        userIDon.add(uNo);
        System.out.println("User "+ uNo +" got in at floor "+ users[uNo].floorGetOn + " floor choosen to GetOff = " + users[uNo].floorGetOff);
        System.out.println(" ");
        System.out.println("Total Weight "+ totalWeight);
        System.out.println(" ");
       
        }
        
        
        
    }
    
    //user get off
    public void getOff(int uNo)
    {
        if(userIDon.contains(uNo))//to check if user in on elevator or not (like get on floor 3 but get off floor 1 so to stop user get off before they even get on)
        {
            totalWeight -= users[uNo].weight;

            userIDon.remove(Integer.valueOf(uNo));
            userIDoff.add(uNo);
               System.out.println("Array user " +userIDon.toString()+" so removed user  "+ uNo);
            
            System.out.println("User "+ uNo +" got off");
            System.out.println("You reached your destination! Thank You! Visit Again");
            System.out.println(" ");
            System.out.println("Total Weight "+ totalWeight);
            System.out.println(" ");
            if(userIDoff.size()==5) 
            {
                isEmpty=true; //if empty stop end elevator while loop in sensor class
            }
        }
    }
    
    public void getOffforWeigth(int uNo)
    {
        if(userIDon.contains(uNo))//to check if user in on elevator or not (like get on floor 3 but get off floor 1 so to stop user get off before they even get on)
        {
            totalWeight -= users[uNo].weight;

            userIDon.remove(Integer.valueOf(uNo));
            userIDoff.add(uNo);
               //System.out.println("Array user " +userIDon.toString()+" so removed user  "+ uNo);
                //System.out.println(" ");
            System.out.println("User "+ uNo +" got off");
            System.out.println("User overweigth");
            System.out.println(" ");
            System.out.println("Total Weight "+ totalWeight);
            System.out.println(" ");
            if(userIDoff.size()==5) 
            {
                isEmpty=true; //if empty stop end elevator while loop in sensor class
            }
        }
    }
    
    
    
    
}
   

