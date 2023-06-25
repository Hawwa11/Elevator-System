
package test;

import java.util.Random;
import static test.ElevatorBehaviour.number;
import static test.ElevatorBehaviour.setColorDown;
import static test.ElevatorBehaviour.setColorUp;

/**
 *
 * @author uSER
 */
public class MutexClass {

    ElevatorBehaviour EB1 = new ElevatorBehaviour(setColorDown, setColorUp, number);
    ElevatorBehaviour EB2 = new ElevatorBehaviour(setColorDown, setColorUp, number);
    ElevatorBehaviour EB3 = new ElevatorBehaviour(setColorDown, setColorUp, number);
    int status1 = 0, status2 = 0, status3 = 0;
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
            //System.out.println(" Thread 1 is idle ");
            wait();
        }
        status1 = EB1.moveElavator();
             
        status2 = EB2.moveElavator();
        
        status3 = EB3.moveElavator();
        
        if (status1 != 1) {
            turnOne = true;
             Thread.sleep(1500);
            One();
        } else if (status3 != 1) {

            turnOne = false;
            turnTwo = false;
            turnThree = true;
             Thread.sleep(1500);
            Three();

        } else if (status2 != 1) {
            turnOne = false;
            turnTwo = true;
             Thread.sleep(1500);

            Two();

        } else {
        }

        notify();
              Thread.sleep(1500);
    }

    public synchronized void Two() throws InterruptedException {
        while (turnOne || turnThree)//true
        {
            //System.out.println(" Thread 2 is idle ");
            wait();
        }

        status1 = EB1.moveElavator();
        status2 = EB2.moveElavator();

        status3 = EB3.moveElavator();
   

        //System.out.println("status 1 is " + status1 + " status 2 is " + status2);
        if (status1 != 1) {

            turnTwo = false;
            turnThree = false;
            turnOne = true;
            Thread.sleep(1500);
            One();

        } else if (status2 != 1) {
            turnThree = false;
            turnOne = false;
            turnTwo = true;
            Thread.sleep(1500);
            Two();

        } else if (status3 != 1) {

            turnTwo = false;
            turnOne = false;
            turnThree = true;
            Thread.sleep(1500);
            Three();
        } else {

        }

        notify();
    }

    public synchronized void Three() throws InterruptedException {
        while (turnOne || turnTwo)//true
        {

            wait();
        }

        status1 = EB1.moveElavator();
        status2 = EB2.moveElavator();
        status3 = EB3.moveElavator();
        Thread.sleep(1500);

        turnThree = false;

        if (status2 != 1) {
            turnThree = false;
            turnOne = false;
            turnTwo = true;
             Thread.sleep(1500);
            Two();

        } else if (status1 != 1) {
            turnOne = true;
            turnThree = false;
            turnTwo = false;
             Thread.sleep(1500);
            One();
        } else if (status3 != 1) {

            turnOne = false;
            turnTwo = false;
            turnThree = true;
             Thread.sleep(1500);
            Three();

        } else {

        }

        notify();
    }

}
