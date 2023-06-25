/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author Rula
 */
public class ThreadAll extends Thread {

    MutexClass mutexOne = new MutexClass();
    Elevator eAll;

    //constructor
    public ThreadAll(MutexClass m, Elevator e) {
        mutexOne = m;
        eAll = e;
    }

    @Override
    public void run() {
        try {
             Thread.sleep(1000);
            mutexOne.setE3(eAll);
            
            mutexOne.Three();
        } catch (InterruptedException e) {
            
        }
    }

}

