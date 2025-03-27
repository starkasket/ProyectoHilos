/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.ojdl.hilos;

import Runnable.RunnableSimple;
import Threads.ThreadSimple;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author StarC
 */
public class HilosR {
    
    public static void main(String[] args) throws InterruptedException {
        
        Runnable hilo =() ->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " " + Thread.currentThread().getName());
                try {
                    Thread.sleep((long) (Math.random()*1000));
                } catch (Exception e) {
                    System.out.println(e);
                }
                
            System.out.println("Estado: " + Thread.currentThread().getState());
            }
        };
        
         /*Runnable hilo = new Runnable(){
               @Override
    public void run() {
        System.out.println("Se inicia el método run del hilo: " + Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
              try {
                Thread.sleep((long) ((Math.random())*1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadSimple.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Hilo" + Thread.currentThread().getName());
        }
        System.out.println("Hilo finalizado: " + Thread.currentThread().getName());
                   System.out.println("Estado: " + Thread.currentThread().getState());
                   
    } 
        };*/
         
      
         

        
       /* new Thread(new RunnableSimple("Carrera de caballitos 1")).start();
        new Thread(new RunnableSimple("Carrera de caballitos 2")).start();
        new Thread(new RunnableSimple("Carrera de caballitos 3")).start();
        new Thread(new RunnableSimple("Carrera de caballitos 4")).start();
*/
       
       // Método main
       
       Thread hilo1 = new Thread(hilo,"Carrera de caballitos 1");
       Thread hilo2 = new Thread(hilo,"Carrera de caballitos 2");
       Thread hilo3 = new Thread(hilo,"Carrera de caballitos 3");
       Thread hilo4 = new Thread(hilo,"Carrera de caballitos 4");
        
       hilo1.start();
       hilo2.start();
       hilo3.start();
       hilo4.start();
       
       hilo1.join();
       hilo2.join();
       hilo3.join();
       hilo4.join();
       
        System.out.println(hilo1.getState());
        System.out.println(hilo2.getState());
        System.out.println(hilo3.getState());
        System.out.println(hilo4.getState());
       
       
       Thread.sleep(10000);
        System.out.println("Continuando con el main " + Thread.currentThread().getName());
      
       
       /*
       new Thread(hilo,"Carrera de caballitos 1").start();
        new Thread(hilo,"Carrera de caballitos 2").start();
        new Thread(hilo,"Carrera de caballitos 3").start();
        new Thread(hilo,"Carrera de caballitos 4").start();
        */
       
    }
    
}
