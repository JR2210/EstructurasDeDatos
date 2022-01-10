package arbolnario;

public class Pruebas {

	// Pruebas ------------------------------------------------------------
	public static void main(String[] args) {
		Pruebas pruebas = new Pruebas();
		pruebas.ejecutar();
	}

	private void ejecutar() {
		// Hojas
		ArbolNario arbol2 = new ArbolNario(2);
		ArbolNario arbol5 = new ArbolNario(5);
		ArbolNario arbol6 = new ArbolNario(6);
		ArbolNario arbol7 = new ArbolNario(7);

		// Subarbol 3
		ArbolNario arbol3 = new ArbolNario(3);
		arbol3.insertar(arbol5);
		arbol3.insertar(arbol6);


		// Subarbol 4
		ArbolNario arbol4 = new ArbolNario(4);
		arbol4.insertar(arbol7);

		// Arbol
		ArbolNario arbol1 = new ArbolNario(1);
		arbol1.insertar(arbol2);
		arbol1.insertar(arbol3);
		arbol1.insertar(arbol4);
		// Pruebas
		System.out.println("Arbol n-ario. ");
		arbol1.mostrarProfundidadPostOrden();
		arbol1.mostrarAmplitudInversa();
		System.out.println("La profundidad maxima del arbol es " + arbol1.maximaProfundidad());
	}
}