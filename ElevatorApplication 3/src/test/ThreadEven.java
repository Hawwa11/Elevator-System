/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author hawwa
 */
public class ThreadEven extends Thread {

    MutexClass mutexOne = new MutexClass();
    Elevator eEven;

    //constructor
    public ThreadEven(MutexClass m, Elevator e) {
        mutexOne = m;
        eEven = e;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            mutexOne.setE1(eEven);
           
            mutexOne.One();
        } catch (InterruptedException e) {
            
        }
    }

}
