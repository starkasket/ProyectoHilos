# Hilos

Este es un proyecto que demuestra los usos que pueden tener los hilos haciendo uso de algunas herramientas que tiene Java 8 como lo es Threads, Runnable, y Executor, incluyendo programación funcional. Incluye ejemplos simples de la implementación de estos dentro de un programa.

## Archivos
### RunnableSimple
Se realiza la implementación de la interfaz Runnable en el código. Runnable es una interfaz que será implementaba por una clase de manera que las instancias de la misma puedan ser ejecutadas por un hilo. Se realiza un pequeño programa en el cual se instancia una variable, se le realiza su constructor y un getter, y se añade (y sobreescribe) el método run(), que será lo que se ejecute. Dentro, se hacen impresiones del getter y se realiza un ciclo en el cual se para la ejecución del hilo actual durante un tiempo (que es randomizado usando Math.random()).

### ThreadSimple
Se extiende la clase Thread, se realiza un constructor y luego se añade (y sobreescribe) el método run(), que será lo que se ejecute, en este se realizan impresiones del getter para conocer el hilo actual, y se realiza un ciclo en el cual se para la ejecución del hilo actual durante un tiempo (que es randomizado con el uso de Math.random()).

### Hilos 
Se añade un método main que lanzará la excepción InterruptedException (cuando un hilo esté esperando, 'durmiendo', u ocupado y sea interrumpido).  Dentro del main() se instancia un nuevo hilo que usará las funciones de ThreadSimple y al que se le indica un nombre, luego se "inicia" dicho hilo. Se realiza lo mismo con otra instanciación. Al final se imprime el estado en el que se encuentra uno de los hilos.

### HilosR
Se instancia un nuevo objeto Runnable el cual implementa un método en el que se generan impresiones del hilo actual usando los métodos de la clase Thread, asimismo se ejecuta el método que para el hilo actual durante un timepo (ranodmizado haciendo uso de Math.random()). También se obtiene el estado en el que se encuentra el hilo. Se realizan distintas instanciaciones de hilos, se "inician", y luego se usa join() que permite que un hilo espere a que otro termine su ejecución, y se vuelve a obtener el estado de todos los hilos creados.


## Conceptos
### Flags
Variables que se utilizan como indicador para controlar el flujo de ejecución de los hilos. Generalmente es una variable booleana que actúa como un mecanismo para indicar a un hilo si debe continuar, detenerse o realizar otra acción.

```
Class ejemploHilo extends Thread{
private boolean flag = true;

public void run() {
while(flag){
// Código que se realizará mientras flag sea True
}
}

public void detener(){
  flag = false;
}

```

### Wait()
Método que fuerza al hilo actual a esperar hasta que otro hilo invoque notify() o notifyAll() en el mismo objeto. Dentro de este método se puede especificar un tiempo de espera tras el cual se reactivará automáticamente.

### Notify()
Método que se usa para despertar arbitrariamente un hilo que esté esperando en el objeto monitor. Este método levanta un hilo aleatorio. Tiene como función el notificar a  un hilo que se encuentra en espera de que puede continuar su ejecución.


## Diferencias entre programación normal y programación funcional
### Programación normal
- Es un paradigma de programación que enfatiza el uso de funciones en el que cada función realiza una tarea específica.
- Se usan funciones y variables. Los datos en las funciones son inmutables.
- Utiliza recursión para la iteración.
- No tiene un especificador de acceso.
- Se declara que hacer, no cómo hacerlo.
- Las funciones no tienen efectos secundarios y devuelven siempre el mismo resultado para los mismos argumentos.
```
public class programacionFuncional {
      // Lista de números
         List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);


      // Se convierte a Streams, calcula el cuadrado de cada número, y los suma.
        int sumaDeCuadrados = numeros.stream().mapToInt(x -> x * x).sum();  


        System.out.println(sumaDeCuadrados);  // Output: 55

    }
```
### Programación funcional
- Permite datos mutables y cambios de estado.
- Se basa en instrucciones secuenciales que modifican el estado del programa paso a paso.
- Hace uso de ciclos y condicionales que ayudan a controlar el flujo de ejecución.
- La computadora recibe una serie de comandos en pasos del programa para alcanzar el resultado.
- En general, se manipulan variables y su estado durante la ejecución.

```
public class ProgramacionImperativa {
    public static void main(String[] args) {
        // Lista de números
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        // Variable para acumular la suma de los cuadrados
        int sumaDeCuadrados = 0;

        // Bucle para calcular la suma de los cuadrados
        for (int numero : numeros) {
            sumaDeCuadrados += numero * numero;
        }

        System.out.println(sumaDeCuadrados);  // Output: 55
    }
```
