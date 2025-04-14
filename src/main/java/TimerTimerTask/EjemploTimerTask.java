/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TimerTimerTask;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author StarC
 */
public class EjemploTimerTask {

    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int contador = 0;
            @Override
            public void run() {
                if (contador <= 3) {
                    System.out.println("Tarea realizada: " + new Date() + "; nombre del Thread: " + Thread.currentThread().getName());
                    System.out.println("Finalizado.");
                    contador++;
                } else {
                    timer.cancel();
                }

  
            }
        }, 5000, 3000);
        System.out.println("Tareas iniciadas: ");

    }
    
    
    /*
    public enum Tipo {
        NUMERO,
        LETRA
    }

    private Tipo tipo;
    private final static Object lock = new Object(); // Para sincronización

    // Constructor
    public AlfanumericoTarea(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public void run() {
        imprimir();
    }

    // Método que imprime según tipo
    public void imprimir() {
        switch (tipo) {
            case NUMERO:
                for (int i = 1; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " - Número: " + i);
                }
                break;
            case LETRA:
                for (char c = 'A'; c <= 'Z'; c++) {
                    System.out.println(Thread.currentThread().getName() + " - Letra: " + c);
                }
                break;
        }
    }

    // Clase interna para TimerTask
    public static class TareaTimer extends TimerTask {
        private AlfanumericoTarea tarea;

        public TareaTimer(Tipo tipo) {
            this.tarea = new AlfanumericoTarea(tipo);
        }

        @Override
        public void run() {
            tarea.imprimir();
        }
    }

    // Clase para Runnable sincronizado
    public static class TareaSincronizada implements Runnable {
        private AlfanumericoTarea tarea;

        public TareaSincronizada(Tipo tipo) {
            this.tarea = new AlfanumericoTarea(tipo);
        }

        @Override
        public void run() {
            synchronized (lock) {
                tarea.imprimir();
            }
        }
    }

    // Main
    public static void main(String[] args) {

        // 1. Runnable directo
        Thread hiloRunnable = new Thread(new AlfanumericoTarea(Tipo.NUMERO), "Runnable-Hilo");

        // 2. TimerTask
        Timer timer = new Timer();
        TareaTimer tareaTimer = new TareaTimer(Tipo.LETRA);

        // 3. Runnable con synchronized
        Thread hiloSync = new Thread(new TareaSincronizada(Tipo.NUMERO), "Sync-Hilo");

        // 4. ExecutorService
        ExecutorService executor = Executors.newSingleThreadExecutor();
        AlfanumericoTarea tareaExecutor = new AlfanumericoTarea(Tipo.LETRA);

        // Iniciar hilos
        hiloRunnable.start();                      // Hilo 1
        timer.schedule(tareaTimer, 500);           // Hilo 2 con un pequeño delay
        hiloSync.start();                          // Hilo 3 sincronizado
        executor.submit(tareaExecutor);            // Hilo 4 con Executor

        // Cerrar executor luego de la tarea
        executor.shutdown();
    }*/
}
