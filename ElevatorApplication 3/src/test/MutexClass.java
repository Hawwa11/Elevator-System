
package test;

import java.util.Random;
import static test.ElevatorBehaviour.number;
import static test.ElevatorBehaviour.setColorDown;
import static test.ElevatorBehaviour.setColorUp;

/**
 *
 * @author hawwa,rula
 */
public class MutexClass {

    ElevatorBehaviour EB1;
    ElevatorBehaviour EB2;
    ElevatorBehaviour EB3;
    int status1 = 0, status2 = 0, status3 = 0;
    int sumStatus = 0;
    boolean turnOne = false;
    boolean turnTwo = false;
    boolean turnThree = false;

    public MutexClass() {
        this.EB1 = new ElevatorBehaviour(setColorDown, setColorUp, number);
        this.EB2 = new ElevatorBehaviour(setColorDown, setColorUp, number);
        this.EB3 = new ElevatorBehaviour(setColorDown, setColorUp, number);
    }

    public void setE1(Elevator e1) {
        EB1.setElevator(e1, 1);
    }

    public void setE2(Elevator e2) {
        EB2.setElevator(e2, 2);
    }

    public void setE3(Elevator e3) {
        EB3.setElevator(e3, 3);
    }

    public synchronized void One() throws InterruptedException {
        while (turnTwo || turnThree)//true
        {
            wait();
        }
        Thread.sleep(1000);
        status1 = EB1.moveElavator();           
        status2 = EB2.moveElavator();    
        status3 = EB3.moveElavator();
        
        if (status1 != 1) {
            turnOne = true;       
            One();
        } 
        else if (status3 != 1) {

            turnOne = false;
            turnTwo = false;
            turnThree = true;
            
            Three();
        } 
        else if (status2 != 1) {
            turnOne = false;
            turnTwo = true;

            Two();

        } 
        else if (sumStatus != 1){
            sumStatus = displaySummary();
        }

        notify();
    }

    public synchronized void Two() throws InterruptedException {
        while (turnOne || turnThree)//true
        {
            wait();
        }
        
        Thread.sleep(1000);
        status1 = EB1.moveElavator();
        status2 = EB2.moveElavator();
        status3 = EB3.moveElavator();
 
        if (status1 != 1) {

            turnTwo = false;
            turnThree = false;
            turnOne = true;
            One();

        } 
        else if (status2 != 1) {
            turnThree = false;
            turnOne = false;
            turnTwo = true;
            Two();

        } 
        else if (status3 != 1) {

            turnTwo = false;
            turnOne = false;
            turnThree = true;
            Three();
        } 
        else if (sumStatus != 1){
            sumStatus = displaySummary();
        }

        notify();
    }

    public synchronized void Three() throws InterruptedException {
        while (turnOne || turnTwo)//true
        {
            wait();
        }
        Thread.sleep(1000);
        status1 = EB1.moveElavator();
        status2 = EB2.moveElavator();
        status3 = EB3.moveElavator();

        turnThree = false;

        if (status2 != 1) {
            turnThree = false;
            turnOne = false;
            turnTwo = true;
            Two();

        } 
        else if (status1 != 1) {
            turnOne = true;
            turnThree = false;
            turnTwo = false;
            One();
        } 
        else if (status3 != 1) {
            turnOne = false;
            turnTwo = false;
            turnThree = true;
            Three();

        } 
        else if (sumStatus != 1){
            sumStatus = displaySummary();
        }

        notify();
    }

    public int displaySummary()
    {
        if(status1 == 1 && status2 == 1 && status3 == 1){
            EB1.summary();
            EB2.summary();
            EB3.summary();
        }
        return 1;
    }
}
