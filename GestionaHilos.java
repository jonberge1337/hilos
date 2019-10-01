package hilos;

public class GestionaHilos {

	public static void main(String[] args) {
		Aleatorio hilo1 = new Aleatorio("Hilo Aleatorio");
		Multiplicar hilo2= new Multiplicar("Hilo Multiplicacion");
		
		hilo1.start();
		hilo2.start();
	}

}
