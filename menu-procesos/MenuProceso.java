//Teniendo en cuenta el Ejemplo 1, hacer un programa con un menú de 4 opciones:
//1. Crear un proceso hijo con la calculadora
//2. Crear un proceso hijo con el bloc de notas
//3. Crear un proceso hijo con un ejecutable de Java
//4. Salir

package procesos;

import java.io.IOException;
import java.util.Scanner;


public class MenuProceso {
    public static void ejecutarProceso(ProcessBuilder proceso){
        try {
                    Process process = proceso.start();
                    process.waitFor();
                } catch (IOException e) {
                    System.out.println("Excepción de entrada y salida");
                    System.exit(-1);
                } catch (InterruptedException ex) {
                     System.err.println("El proceso hijo finalizo de forma incorrecta");
                     System.exit(-1);
                }
    }
    
    public static void main(String[] args) {
        int menu;
        
        ProcessBuilder calculadora = new ProcessBuilder("calc");
        ProcessBuilder editor = new ProcessBuilder("notepad");
        ProcessBuilder programa = new ProcessBuilder("java",
                "-cp", "./build/classes",
                "procesos.HelloGUI");
        Scanner sc = new Scanner(System.in);
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
            if (menu == 1) {
                ejecutarProceso(calculadora);
            } else if (menu == 2) {
                ejecutarProceso(editor);
            } else if (menu == 3) {
                ejecutarProceso(programa);
            }
        } while (menu != 4);
    }

}