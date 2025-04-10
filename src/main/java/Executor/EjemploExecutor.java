/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author StarC
 */
public class EjemploExecutor {

    public static void main(String[] args) throws InterruptedException{
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable tarea = () -> {
            System.out.println("Inicio de la tarea");
            try {
                System.out.println("Nombre del Thread" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(5);
                System.out.println("FIN");
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                System.out.println(ex);
            }

        };
        //Ejecutar la tarea
        executor.submit(tarea);
        //Cerrar la entrada de tareas
        executor.shutdown();
        
        System.out.println("Método main se está ejecutando +++");
        executor.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("Método Main se sigue ejecutando ---");

    }
}
