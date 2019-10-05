//Teniendo en cuenta el Ejemplo 2, hacer un programa con un menú de 4 opciones:
//1. Crear un proceso hijo con la calculadora
//2. Crear un proceso hijo que abra el iexplore.exe
//3. Crear un proceso hijo con un ejecutable de Java
//4. Salir

package procesos;

import java.io.IOException;
import java.util.Scanner;

public class MenuRunTime {
    public static void ejecutarProceso(Runtime runtime, Process proceso, String ruta, String programa){
                    try {
                        proceso = runtime.exec(ruta);
                        int retorno = proceso.waitFor();
                        System.out.println("La ejecución de la " + programa + " devuelve " + retorno);
                        Thread.sleep(2000);
                    } catch (IOException ex) {
                        System.err.println("Error de entrada o salida");
                    } catch (InterruptedException ex) {
                        System.err.println("Ha sido interrumpido");
                    }
    }
    public static void main(String[] args) {
        int menu;
        Scanner sc = new Scanner(System.in);

        Runtime runtime = Runtime.getRuntime();
        Process process = null;
        do {

            do {
                System.out.println("\n\nElige una opcion del siguiente menu:");
                System.out.println("1. Crear proceso Calculadora");
                System.out.println("2. Crear proceso bloc de notas");
                System.out.println("3. Crear proceso ejecutable Java");
                System.out.println("4. Fin programa");

                try {
                    menu = sc.nextInt();
                } catch (Exception e) {
                    menu = 5;
                    sc.nextLine();
                }
                if (menu < 0 || menu > 4) {
                    System.out.println("No es una opcion valida, tiene que ser del 1 al 4");
                }
            } while (menu < 1 || menu > 4);
            sc.nextLine();
            switch (menu) {
                case 1:
                    ejecutarProceso(runtime, process, "C:\\Windows\\System32\\calc.exe", "calculadora");
                    break;
                case 2:
                    ejecutarProceso(runtime, process, "C:\\Program Files\\Mozilla Firefox\\firefox.exe", "explorador");
                    break;
                case 3:
                    ejecutarProceso(runtime, process, "java -cp ./build/classes procesos.HelloGUI", "programa de java");
                    break;
            }
        } while (menu != 4);
    }
}
