package hilos;

public class Multiplicar extends Thread {
	public Multiplicar(String nombre) {
		super(nombre);
	}
	
	public void run() {
		System.out.println("Empieza el hilo: " + getName());
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + " x 7 = " + i * 7);
		}
		System.out.println("El hilo " + getName() + " ha terminado");
	}
}
