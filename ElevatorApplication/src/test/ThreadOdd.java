/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author uSER
 */
public class ThreadOdd extends Thread {

    MutexClass mutexOne = new MutexClass();
    Elevator eOdd;

    //constructor
    public ThreadOdd(MutexClass m, Elevator e) {
        mutexOne = m;
        eOdd = e;
    }

    @Override

    public void run() {
        try {
            mutexOne.setE2(eOdd);
            Thread.sleep(1500);
            mutexOne.Two();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
