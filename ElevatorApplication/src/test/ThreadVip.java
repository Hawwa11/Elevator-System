/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author Vaio
 */
public class ThreadVip extends Thread {

    MutexClass mutexOne = new MutexClass();
    Elevator eVip;

    //constructor
    public ThreadVip(MutexClass m, Elevator e) {
        mutexOne = m;
        eVip = e;
    }

    @Override
    public void run() {
        try {
            mutexOne.setE3(eVip);
            Thread.sleep(1500);
            mutexOne.Three();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
