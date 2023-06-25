package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.NORTH;
import javax.swing.plaf.basic.BasicArrowButton;

public class ElevatorBehaviour extends JFrame {

    Elevator E;
    int curr = 1;
    boolean start = true;
    int direction = 0;
    int direction3 = 0;
    int type;
    private static final long serialVersionUID = 1L;
    static boolean setColorDown = false;
    static boolean setColorUp = true;
    int No;
    static int number = 1;
    static double Weight;
    int count = 0;

    public ElevatorBehaviour(boolean setColorDown, boolean setColorUp, int number) {

        this.getContentPane().setLayout(new FlowLayout());

        JLabel labelHeader = new JLabel("<htmL><h1>Elevator number: " + number + "</h1><html>");

        JButton buttonUp = new JButton();
        JButton buttonDown = new JButton();
        buttonUp.add(new BasicArrowButton(BasicArrowButton.NORTH), BorderLayout.NORTH, SwingConstants.CENTER);

        buttonUp.setPreferredSize(new Dimension(80, 80));

        buttonDown.add(new BasicArrowButton(BasicArrowButton.SOUTH), BorderLayout.NORTH, SwingConstants.CENTER);
        buttonDown.setPreferredSize(new Dimension(80, 80));

        JLabel labelWeight = new JLabel("<html><br><br><br><br>Elevator " + number + " Weight = " + Weight + "</br></br></br></br></html>");
        buttonUp.add(new BasicArrowButton(BasicArrowButton.NORTH), BorderLayout.NORTH, SwingConstants.CENTER);
        buttonUp.setPreferredSize(new Dimension(80, 80));

        buttonDown.add(new BasicArrowButton(BasicArrowButton.SOUTH), BorderLayout.NORTH, SwingConstants.CENTER);
        buttonDown.setPreferredSize(new Dimension(80, 80));

        //labelElevator.setFont(new Font("ROBOTO", Font.BOLD, 18));
        labelWeight.setFont(new Font("ROBOTO", Font.BOLD, 16));

        //JLabel label = new JLabel("<html><br>Going Downwards </br></html>", SwingConstants.CENTER);
        //JLabel label2 = new JLabel("<html><br>Going Upwards</br></html>", SwingConstants.CENTER);
        // if true the component paints every pixel within its bounds
        labelHeader.setOpaque(true);
        buttonUp.setOpaque(true);
        buttonDown.setOpaque(true);
        labelWeight.setOpaque(true);

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
        add(labelWeight);
    }

    private static void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new ElevatorBehaviour(setColorDown, setColorUp, number);
        frame.setLocationRelativeTo(null);
        //Display the window.
        frame.setSize(300, 400);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void setElevator(Elevator ele, int n) {
        E = ele;
        type = n;
        No = n;
    }

    public int moveElavator() throws InterruptedException {

        while (E.isEmpty != true) {

            if (curr == 1) {

                direction = 0;

                elevaterMotion();

                return 0;

            } else if (curr == 2) {
                elevaterMotion();
                return 0;

            } else if (curr == 3) {

                elevaterMotion();
                return 0;

            } else if (curr == 4) {

                elevaterMotion();
                return 0;

            } else if (curr == 5) {

                elevaterMotion();
                return 0;

            } else if (curr == 6) {

                elevaterMotion();
                return 0;

            } else if (curr == 7) {

                elevaterMotion();
                return 0;

            } else if (curr == 8) {

                elevaterMotion();
                return 0;

            } else if (curr == 9) {

                elevaterMotion();
                return 0;

            } else if (curr == 10) {
                direction = 1;

                elevaterMotion();
                return 0;

            } else if (curr == 11) {

                direction = 1;

                elevaterMotion();
                return 0;

            } else {
                System.out.println("Elevator " + No + " Elevator Error... Current " + curr);
                //return E;
            }
        }
        if (E.isEmpty) {
            return 1;
        }

        return 3;
    }

    //loop to check if any user want to get in or out and then move the elevator to next floor
    public void elevaterMotion() throws InterruptedException {
        System.out.println(" ");
        for (int u = 0; u < 5; u++) 
        {
            E.request(u);
        }
           
        System.out.println("Current Floor = " + curr);
        if(!start)
        {
        if (direction == 0) {
            curr = up(curr);
        } else if (direction == 1 && curr <= 11) {

            curr = down(curr);

        }
        }
        start = false;

        OUTER:
        for (int u = 0; u < 5; u++) {
            if (E.users[u].floorGetOn == curr) {
                Thread.sleep(1500);
                E.getOn(u, No);

            }
            if (E.users[u].floorGetOff == curr) {
                Thread.sleep(1500);
                E.getOff(u, No);

            }

        }

        System.out.println("Elevator " + No + " Total Weight " + E.totalWeight);
        number = No;
        Weight = E.totalWeight;

        Thread.sleep(1500);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                createAndShowGUI();

            }

        });
        
        int couunter = 0;
        if (!E.canMove()) {
            System.out.println("****Elevator " + No + " is idle****");
            
            
            while (!E.canMove()) {
                int uno = Integer.parseInt(E.userIDon.get(E.userIDon.size() - 1).toString());
                number = No;
                Weight = E.totalWeight;
                E.getOffforWeigth(uno, No);
                javax.swing.SwingUtilities.invokeLater(new Runnable() {

                    public void run() {

                        createAndShowGUI();

                    }

                });
                System.out.println("Elevator " + No + " Total Weight " + E.totalWeight);
                couunter++;

            }

        } 
        
        
     

    }

    //moves it up
    public int down(int curr) throws InterruptedException {

        if (type ==3) {

            curr = curr - 1;
            number = No;
            Weight = E.totalWeight;
            javax.swing.SwingUtilities.invokeLater(new Runnable() {

                public void run() {
                    if (setColorDown) {

                        createAndShowGUI();
                    }
                }

            });

            Thread.sleep(2000);

            if (curr != 1 && curr <= 12) {
                curr -= 1;

                number = No;
                Weight = E.totalWeight;
                javax.swing.SwingUtilities.invokeLater(new Runnable() {

                    public void run() {

                        if (setColorDown) {

                            createAndShowGUI();

                        }

                    }

                });
                Thread.sleep(1500);
            }

            System.out.println("**** Elevator " + No + " going downward **** \nCurrent Floor = " + curr);
            Thread.sleep(1500);
            setColorDown = true;
            setColorUp = false;

            Thread.sleep(1500);
            return curr;
        }

      
           number = No;
           Weight = E.totalWeight;

        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                if (setColorDown) {

                    createAndShowGUI();

                }

            }

        });
        //System.out.println(" Elevator " + No + " current floor = " + curr);
     
        Thread.sleep(1500);
        if (type == 1)//false
        {
            curr = curr - 1;

            System.out.println("**** Elevator " + No + " going downward **** \nCurrent Floor = " + curr);
            number = No;
            Weight = E.totalWeight;
            javax.swing.SwingUtilities.invokeLater(new Runnable() {

                public void run() {

                    if (setColorDown) {

                        setColorUp = false;
                        createAndShowGUI();
                    }

                }

            });
            Thread.sleep(2000);

            if (curr % 2 != 0 && curr != 1) {
            curr -= 1;

            System.out.println("**** Elevator " + No + " going downward **** \nCurrent Floor = " + curr);
           Thread.sleep(1500);

            }
            number = No;
            Weight = E.totalWeight;
            javax.swing.SwingUtilities.invokeLater(new Runnable() {

                public void run() {

                    if (setColorDown) {

                        createAndShowGUI();

                    }

                }

            });
            Thread.sleep(1500);
            return curr;
        }  else {
            curr = curr - 1;
            System.out.println("**** Elevator " + No + " going downward **** \nCurrent Floor = " + curr);
            number = No;
            Weight = E.totalWeight;
            javax.swing.SwingUtilities.invokeLater(new Runnable() {

                public void run() {
                    if (setColorDown) {

                        setColorUp = false;
                        createAndShowGUI();
                    }
                }

            });
            Thread.sleep(1500);

            if (curr % 2 == 0 && curr != 1) {
                curr -= 1;
                System.out.println("**** Elevator " + No + " going downward **** \nCurrent Floor = " + curr);
                number = No;
                Weight = E.totalWeight;
                javax.swing.SwingUtilities.invokeLater(new Runnable() {

                    public void run() {
                        if (setColorDown) {

                            setColorUp = false;
                            createAndShowGUI();
                        }
                    }

                });

                Thread.sleep(1500);

            }

            number = No;
            Weight = E.totalWeight;
            javax.swing.SwingUtilities.invokeLater(new Runnable() {

                public void run() {

                    if (setColorDown) {

                        createAndShowGUI();

                    }

                }

            });
            Thread.sleep(1500);
            return curr;
        }
    }

    //moves it down
    public int up(int curr) throws InterruptedException {

        if (type == 3) {

            setColorUp = true;

            number = No;
            Weight = E.totalWeight;
            javax.swing.SwingUtilities.invokeLater(new Runnable() {

                public void run() {
                    if (setColorUp) {

                        setColorDown = false;
                        createAndShowGUI();
                    }
                }

            });

            Thread.sleep(1500);

            if (curr > 0 && curr <= 10) {

                curr += 1;
                number = No;
                Weight = E.totalWeight;
                javax.swing.SwingUtilities.invokeLater(new Runnable() {

                    public void run() {
                        if (setColorUp) {

                            setColorDown = false;
                            createAndShowGUI();
                        }
                    }

                });

                System.out.println("**** Elevator " + No + " going upward **** \nCurrent Floor = " + curr);
                Thread.sleep(1500);

                javax.swing.SwingUtilities.invokeLater(new Runnable() {

                    public void run() {
                        if (setColorUp) {

                            setColorDown = false;
                            createAndShowGUI();
                        }
                    }

                });
                return curr;
            }
            //System.out.println(" Elevator " + No + " current floor = " + curr);

            javax.swing.SwingUtilities.invokeLater(new Runnable() {

                public void run() {

                    if (setColorDown) {

                        createAndShowGUI();

                    }

                }

            });

            Thread.sleep(1500);
        }
        if (type == 1)//false
        {
            curr = curr + 1;
            System.out.println("**** Elevator " + No + " going upward **** \nCurrent Floor = " + curr);
            number = No;
            Weight = E.totalWeight;
            javax.swing.SwingUtilities.invokeLater(new Runnable() {

                public void run() {
                    if (setColorUp) {

                        setColorDown = false;
                        createAndShowGUI();
                    }
                }

            });

            Thread.sleep(1500);

            if (curr % 2 != 0) {
                curr += 1;
                System.out.println("**** Elevator " + No + " going upward **** \nCurrent Floor = " + curr);
                number = No;
                Weight = E.totalWeight;
                javax.swing.SwingUtilities.invokeLater(new Runnable() {

                    public void run() {
                        if (setColorUp) {

                            setColorDown = false;
                            createAndShowGUI();

                        }
                    }

                });

                Thread.sleep(1500);

                number = No;
                Weight = E.totalWeight;
                javax.swing.SwingUtilities.invokeLater(new Runnable() {

                    public void run() {

                        if (setColorDown) {

                            createAndShowGUI();

                        }

                    }

                });

                Thread.sleep(1500);
                return curr;

            } 
        } else {
                curr = curr + 1;
                System.out.println("**** Elevator " + No + " going upward **** \nCurrent Floor = " + curr);
                number = No;
                Weight = E.totalWeight;
                javax.swing.SwingUtilities.invokeLater(new Runnable() {

                    public void run() {
                        if (setColorUp) {

                            setColorDown = false;
                            createAndShowGUI();
                        }
                    }

                });
                Thread.sleep(1500);
                if (curr % 2 == 0 && curr != 11) {
                    curr += 1;
                    System.out.println("**** Elevator " + No + " going upward**** \nCurrent Floor = " + curr);

                    number = No;
                    javax.swing.SwingUtilities.invokeLater(new Runnable() {

                        public void run() {
                            if (setColorUp) {

                                setColorDown = false;
                                createAndShowGUI();
                            }
                        }

                    });
                    Thread.sleep(1500);
                }

            }

        number = No;
        Weight = E.totalWeight;
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                if (setColorDown) {

                    createAndShowGUI();

                }

            }

        });
        Thread.sleep(1500);
        return curr;

    }

}
