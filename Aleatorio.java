package hilos;

public class Aleatorio extends Thread {
	public Aleatorio(String nombre) {
		super(nombre);
	}

	public void run() {
		System.out.println("Empieza el hilo: " + getName());
		for (int i = 0; i < 100; i++) {
			System.out.println((int) (Math.random() * 100) + 1);
		}
		System.out.println("Ha terminado el hilo: " + getName());
	}
}
