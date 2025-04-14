/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Runnable;

import Threads.ThreadSimple;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author StarC
 */
public class AlfanumericoTarea implements Runnable {

    public static enum TIPO {
        NUMERO("12345678910"),
        LETRA("abcdefghijklmnñopqrstuvwxyz");
        private final String tipo;

        private TIPO(String tipo) {
            this.tipo = tipo;
        }

        public String getTipo() {
            return tipo;
        }

        @Override
        public String toString() {
            return tipo;
        }

    }

    private static String nombre;
    private static TIPO tipo;

    public static String getType(TIPO tipo) {
        if (tipo.equals(TIPO.LETRA)) {
            AlfanumericoTarea.nombre = TIPO.LETRA.toString();
        } else {
            AlfanumericoTarea.nombre = tipo.toString();
        }
        return AlfanumericoTarea.nombre;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        //Hilo Runnable
        Runnable hilo = () -> {
            System.out.println("Hilo Runnable: " +  Thread.currentThread().getName());
        };

        Thread hilo1 = new Thread(hilo, getType(TIPO.NUMERO));

        hilo1.start();

        //Hilo TimerTask
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hilo TimerTask: " + new Thread(getType(TIPO.LETRA)).getName());
                timer.cancel();
            }
        }, 3000);

        //Hilo Synchronized
        Thread hiloSynchronized = new Thread(() -> {
            imprimir(TIPO.NUMERO);
        });
        hiloSynchronized.start();

        //Hilo Executor
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        Runnable ejecutor = () -> {
            System.out.println("Hilo Executor: " + new Thread(getType(TIPO.LETRA)).getName());
        };
        
        executor.submit(ejecutor);
        executor.shutdown();
        
        
    }

    public static synchronized void imprimir(TIPO tipo) {
        System.out.println("Hilo Synchronized: " + new Thread(getType(tipo)).getName());
    }

}


/*   public enum TIPO {
        NUMERO("12345678910"),
        LETRA("abcdefghijklmnñopqrstuvwxyz");
        private final String tipo;

        private TIPO(String tipo) {
            this.tipo = tipo;
        }

        public String getTipo() {
            return tipo;
        }

        @Override
        public String toString() {
            return "TIPO{" + "tipo=" + tipo + '}';
        }

    }
    private String nombre;

    private TIPO tipo;

    public AlfanumericoTarea() {
        if (tipo.equals(TIPO.LETRA)) {
            System.out.println("");
        } else {
            this.nombre = "12345678910";
        }
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        System.out.println("Se inicia el método run del hilo runnable: " + getNombre());
        /*   for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep((long) ((Math.random()) * 1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadSimple.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Hilo" + getNombre());
        }

    }

    public static void print() {
        
    }
 */
