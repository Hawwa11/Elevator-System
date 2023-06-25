package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicArrowButton;
/**
 *
 * @author hawwa,rula
 */
public class ElevatorBehaviour extends JFrame {

    Elevator E;
    int curr = 1;
    boolean start = true;
    int direction = 0;
    int type;
    
    //GUI
    private static final long serialVersionUID = 1L;
    static boolean setColorDown = false;
    static boolean setColorUp = false;
    int No;
    static int number = 1;
    static double Weight;
    static int Floor = 1;
    int count = 0;

    //------------------Set GUI Properties-------------------
    public ElevatorBehaviour(boolean setColorDown, boolean setColorUp, int number) {

        this.getContentPane().setLayout(new FlowLayout());

        JLabel labelHeader = new JLabel("<htmL><h1>Elevator number: " + number + "</h1><html>");

        JButton buttonUp = new JButton();
        JButton buttonDown = new JButton();
        buttonUp.add(new BasicArrowButton(BasicArrowButton.NORTH), BorderLayout.NORTH, SwingConstants.CENTER);

        buttonUp.setPreferredSize(new Dimension(80, 80));

        buttonDown.add(new BasicArrowButton(BasicArrowButton.SOUTH), BorderLayout.NORTH, SwingConstants.CENTER);
        buttonDown.setPreferredSize(new Dimension(80, 80));
        
        JLabel labelFloor = new JLabel("<html><br>Current Floor: " + Floor + "</br> </html>");
        buttonUp.add(new BasicArrowButton(BasicArrowButton.NORTH), BorderLayout.NORTH, SwingConstants.CENTER);
        buttonUp.setPreferredSize(new Dimension(80, 80));
        
        JLabel labelWeight = new JLabel("<html><br><br><br>Elevator " + number + " Weight = " + Weight + "</br></br></br></html>");
        buttonUp.add(new BasicArrowButton(BasicArrowButton.NORTH), BorderLayout.NORTH, SwingConstants.CENTER);
        buttonUp.setPreferredSize(new Dimension(80, 80));

        buttonDown.add(new BasicArrowButton(BasicArrowButton.SOUTH), BorderLayout.NORTH, SwingConstants.CENTER);
        buttonDown.setPreferredSize(new Dimension(80, 80));

        labelFloor.setFont(new Font("ROBOTO", Font.BOLD, 16));

        labelWeight.setFont(new Font("ROBOTO", Font.BOLD, 16));

        //JLabel label = new JLabel("<html><br>Going Downwards </br></html>", SwingConstants.CENTER);
        //JLabel label2 = new JLabel("<html><br>Going Upwards</br></html>", SwingConstants.CENTER);
        // if true the component paints every pixel within its bounds
        labelHeader.setOpaque(true);
        buttonUp.setOpaque(true);
        buttonDown.setOpaque(true);
        labelWeight.setOpaque(true);
        labelFloor.setOpaque(true);

        // sets the background color of this component
        // the background color is used only if the component is opaque
        if (setColorDown) {
            buttonDown.setBackground(Color.GREEN);

        } else if (!setColorDown) {
            //label.setBackground(Color.white);
            //label.setFont(new Font("ROBOTO", Font.BOLD, 20));
            buttonDown.setBackground(Color.GRAY);
        }

        if (setColorUp) {

            buttonUp.setBackground(Color.GREEN);

        } else if (!setColorUp) {

            buttonUp.setBackground(Color.GRAY);

        }
        // add label to frame
        add(labelHeader);
        add(buttonUp);
        add(buttonDown);
        add(labelFloor);
        add(labelWeight);
    }

    //------------------Create and Display GUI-------------------
    private void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new ElevatorBehaviour(setColorDown, setColorUp, number);
        frame.setLocationRelativeTo(null);
        //Display the window.
        frame.setSize(300, 400);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }  
    
    //------------------Set Elevator Properties-------------------
    public void setElevator(Elevator ele, int n) {
        E = ele;
        type = n;
        No = n;
    }

    //------------------Set Elevator Properties-------------------
    public int moveElavator() throws InterruptedException {

        while (E.isEmpty != true) {

            switch (curr) {
                case 1 -> 
                {
                    direction = 0; 
                    elevaterMotion();  
                    return 0;
                }
                case 2 -> 
                {
                    elevaterMotion();
                    return 0;
                }
                case 3 -> 
                {
                    elevaterMotion();
                    return 0;
                }
                case 4 -> 
                {
                    elevaterMotion();
                    return 0;
                }
                case 5 -> 
                {
                    elevaterMotion();
                    return 0;
                }
                case 6 -> 
                {
                    elevaterMotion();
                    return 0;
                }
                case 7 -> 
                {
                    elevaterMotion();
                    return 0;
                }
                case 8 -> 
                {
                    elevaterMotion();
                    return 0;
                }
                case 9 -> 
                {
                    elevaterMotion();
                    return 0;
                }
                case 10 -> 
                {
                    direction = 1;
                    elevaterMotion();
                    return 0;
                }
                case 11 -> {
                    direction = 1;
                    elevaterMotion();
                    return 0;
                }
                default -> System.out.println("Elevator " + No + " Elevator Error... Current " + curr);
            }
        }
        if (E.isEmpty) {
            return 1;
        }

        return 3;
    }

    //------------------Move Elevator--------------------
    public void elevaterMotion() throws InterruptedException {
        //request elevator
     System.out.println("                Elevator No. " + No + "              ");
        System.out.println("");
        System.out.println(" ");
        for (int u = 0; u < 5; u++) 
        {
            E.request(u);
        }
        
        //move elevator up or down
        System.out.println("Current Floor = " + curr);
          System.out.println();
        if(!start)//check if elevator just started
        {
            if (direction == 0) 
              curr = up(curr);
            else
              curr = down(curr);
        }
        
        start = false; 
        for (int u = 0; u < 5; u++) {
            if (E.users[u].floorGetOn == curr) {  
                E.getOn(u);
                Thread.sleep(800);
            }
            if (E.users[u].floorGetOff == curr) {
                E.getOff(u);
                 Thread.sleep(800);
            }
        }
        
        //Display current total weight in the elevator
            System.out.println("Elevator " + No + " Total Weight " + E.totalWeight);
              System.out.println("");
               
           //--------Display GUI--------
            number = No;
            Weight = E.totalWeight;
            Floor = curr;
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                        createAndShowGUI();               
                }
            });
            Thread.sleep(2000);
    
        //check if wieght exceeded
        if (!E.canMove()) {
            System.out.println("**** Elevator " + No + " is idle ****");
              System.out.println("");
            
            //while wiegth exceeded remove passengers
            while (!E.canMove()) {
                int uno = Integer.parseInt(E.userIDon.get(E.userIDon.size() - 1).toString());
                number = No;
                Weight = E.totalWeight;
                Floor = curr;
              
                E.getOffforWeigth(uno);
                
               
                //Display current total weight in the elevator
                System.out.println("Elevator " + No + " Total Weight " + E.totalWeight);
                  System.out.println("");
             
            }
            //---------GUI elevator idle-----------------
            number = No;
            Weight = E.totalWeight;
            Floor = curr;
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                        setColorDown = false;
                        setColorUp = false;
                        createAndShowGUI();  
                }
            });
            //--------------------------------------------
        } 
       
        System.out.println("-------------------------------------------------");
        
        Thread.sleep(2000);
    }

    //---------Move Elevator Down-----------------
    public int down(int curr) throws InterruptedException {
   setColorDown=true;
        if (type ==3) {

            curr = curr - 1;
            System.out.println("**** Elevator " + No + " going downward **** \nCurrent Floor = " + curr);
             System.out.println("");
            
        }
        else if (type == 1)//false
        {
            curr = curr - 1;
            System.out.println("**** Elevator " + No + " going downward **** \nCurrent Floor = " + curr);
              System.out.println("");
                         
            if (curr % 2 != 0 && curr != 1) 
            {
            curr -= 1;
            System.out.println("**** Elevator " + No + " going downward **** \nCurrent Floor = " + curr);
              System.out.println("");
            }   
        }  
        else {
            curr = curr - 1;
            System.out.println("**** Elevator " + No + " going downward **** \nCurrent Floor = " + curr);
              System.out.println("");

            if (curr % 2 == 0 && curr != 1) {
                curr -= 1;
                System.out.println("**** Elevator " + No + " going downward **** \nCurrent Floor = " + curr); 
                  System.out.println("");              
            }
        }        
            //----------------Show GUI-----------------
              number = No;
            Weight = E.totalWeight;
            Floor = curr;
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    setColorUp=false;
                        createAndShowGUI();           
                }
            });
             Thread.sleep(500);
            //----------------------------------------
            
        return curr;
    }

    //---------Move Elevator Up-----------------
    public int up(int curr) throws InterruptedException {
          
        setColorUp=true;
        if (type == 3) {
            curr += 1;
            System.out.println("**** Elevator " + No + " going upward **** \nCurrent Floor = " + curr);
              System.out.println("");
                          

             

        }
        else if (type == 1)//false
        {
            curr = curr + 1;
            System.out.println("**** Elevator " + No + " going upward **** \nCurrent Floor = " + curr);
              System.out.println("");
                         

            
    
            if (curr % 2 != 0) {
                curr += 1;
                System.out.println("**** Elevator " + No + " going upward **** \nCurrent Floor = " + curr);
                  System.out.println("");
                             

               
            } 
            
             
        } 
        else {
            
                curr = curr + 1;
                System.out.println("**** Elevator " + No + " going upward **** \nCurrent Floor = " + curr);
                  System.out.println("");

                if (curr % 2 == 0 && curr != 11) {
                    curr += 1;
                    System.out.println("**** Elevator " + No + " going upward **** \nCurrent Floor = " + curr);
                      System.out.println("");
                                  // Thread.sleep(1500);

                    
                }
                
            
            }
        
        
         
            //----------------Show GUI-----------------
              number = No;
            Weight = E.totalWeight;
            Floor = curr;
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    setColorDown=false;
                        createAndShowGUI();
                    
                }

            });
             Thread.sleep(500);
            //----------------------------------------
            
        return curr;

    }
    
    //------------------Display Elevator Summary--------------------
    public void summary()
    {
        System.out.println(" ");
        for(int i=0; i < 5; i++)
            {
                System.out.println("Passenger " + E.users[i].userId + " entered Elevator " + No +" at floor " 
                        + E.users[i].floorGetOn + " and got off at floor " + E.users[i].floorGetOff); 
                  System.out.println("");
            }
    }

}
