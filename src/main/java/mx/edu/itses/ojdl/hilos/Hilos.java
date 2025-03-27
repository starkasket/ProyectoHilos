/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mx.edu.itses.ojdl.hilos;

import Threads.ThreadSimple;

/**
 *
 * @author StarC
 */
public class Hilos {

    public static void main(String[] args) throws InterruptedException {
     Thread hilo = new ThreadSimple("Juan");
     hilo.start();
     Thread hilo2 = new ThreadSimple("José");
     hilo2.start();
        System.out.println(hilo.getState());
       
    }
}
