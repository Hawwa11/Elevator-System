package test;

import java.util.ArrayList;
import java.util.List;

public class Elevator {

    double totalWeight = 0;
    int elevatorNo;
    List userIDon = new ArrayList();
    List userIDoff = new ArrayList();

    User[] users;
    boolean isEmpty;
    boolean isFull;

    public Elevator(User[] u, int n) {
        users = u;
        elevatorNo = n;
    }

    //checks the weight
    public boolean canMove() {
        if (totalWeight > 1000) {
            return false;
        } else if (totalWeight <= 1000) {
            return true;
        } else {
            System.out.println("Error");
            return false;
        }
    }
    
    public void request(int uNo)
    {
        if (userIDoff.contains(uNo) || userIDon.contains(uNo)) 
        {
            
        }
        else
        {
            System.out.println("Passenger " + users[uNo].userId + " is requesting elevator at floor " + users[uNo].floorGetOn);
        }
        
    }

    //user get on the elevator
    public void getOn(int uNo, int n) {
        if (userIDoff.contains(uNo) || userIDon.contains(uNo)) {

        } else {
            totalWeight = Math.round((totalWeight + users[uNo].weight) * 100.0) / 100.0;
            userIDon.add(uNo);
            System.out.println("Passenger " + users[uNo].userId + " got in the Elevator and chose to GetOff at the floor " + users[uNo].floorGetOff);
        }
        if (userIDon.size() == 5) {
            isFull = true;
        }
        if (users[uNo].floorGetOn == users[uNo].floorGetOff) {
            System.out.println("**** Elevator idle ****");
        }

    }

    //user get off
    public void getOff(int uNo, int n) {
        if (userIDon.contains(uNo))//to check if user in on elevator or not (like get on floor 3 but get off floor 1 so to stop user get off before they even get on)
        {
            totalWeight = Math.round((totalWeight - users[uNo].weight) * 100.0) / 100.0;

            userIDon.remove(Integer.valueOf(uNo));
            userIDoff.add(uNo);
            //System.out.println("Array user " +userIDon.toString()+" so removed user  "+ uNo);

            System.out.println("Passenger " + users[uNo].userId + " got off Elevator " + elevatorNo);
            System.out.println("Passenger " + users[uNo].userId + " reached destination!");
            if (userIDoff.size() == 5) {
                isEmpty = true; //if empty stop end elevator while loop in sensor class
            } else if (userIDon.size() == 15) {
                isFull = true;
            }
        }
    }

    public void getOffforWeigth(int uNo, int n) {
        System.out.println("Elevator " + elevatorNo + " Weight exceeded! Please leave the elevator");
        if (userIDon.contains(uNo)) 
        {
            totalWeight = Math.round((totalWeight - users[uNo].weight) * 100.0) / 100.0;

            userIDon.remove(Integer.valueOf(uNo));
        
            System.out.println("Passenger " + users[uNo].userId + " got off");
            if (userIDon.size() == 5) {
                isFull = true;
            }
        }
    }
}
