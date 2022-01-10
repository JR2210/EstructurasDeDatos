package arbolbusqueda;

public class Pruebas {

	// Pruebas ------------------------------------------------------------
	public static void main(String[] args) {
		Pruebas pruebas = new Pruebas();
		pruebas.ejecutar();
	}

	private void ejecutar() {
		// Alumnos ------------------------------------------------------------
		Alumno alicia = new Alumno("Alicia Blazquez Martin", 5622);
		Alumno pedro = new Alumno("Pedro Jimenez del Pozo", 8510);
		Alumno adriana = new Alumno("Adriana Torres Pardo", 2345);
		Alumno felipe = new Alumno("Felipe Garcia Gomez", 1253);
		Alumno eduardo = new Alumno("Eduardo Parra Martin", 8765);
		Alumno diego = new Alumno("Diego Perez Gonzalez", 8135);
		Alumno mar = new Alumno("Mar Hernando Lopez", 8217);

		// Arbol --------------------------------------------------------------
		ArbolBinarioBusqueda arbolBinarioBusqueda = new ArbolBinarioBusqueda();
		arbolBinarioBusqueda.insertar(alicia);
		arbolBinarioBusqueda.insertar(pedro);
		arbolBinarioBusqueda.insertar(adriana);
		arbolBinarioBusqueda.insertar(felipe);
		arbolBinarioBusqueda.insertar(eduardo);
		arbolBinarioBusqueda.insertar(diego);
		arbolBinarioBusqueda.insertar(mar);
		System.out.println("----------------- Arbol ----------------");
		System.out.printf("El arbol tiene " + arbolBinarioBusqueda.getNumElementos() + " elementos:");
		System.out.println();
		arbolBinarioBusqueda.mostrar();
		System.out.println("----------------------------------------");

		System.out.println();
		System.out.print("El alumno con la clave más cercana a la clave " + 8200 + " es: ");
		this.mostrarAlumno(arbolBinarioBusqueda.getElementoMasCercano(8200));
		System.out.print("El alumno con la clave más cercana a la clave " + 2000 + " es: ");
		this.mostrarAlumno(arbolBinarioBusqueda.getElementoMasCercano(2000));

		System.out.println();
		System.out.print("El alumno con la tercera mayor clave es: ");
		this.mostrarAlumno(arbolBinarioBusqueda.getKMayorElemento(3));
		System.out.print("El alumno con la sexta mayor clave es: ");
		this.mostrarAlumno(arbolBinarioBusqueda.getKMayorElemento(6));

		System.out.println();
		System.out.println("El menor comun antecesor entre " + diego.getMatricula() + " y " + eduardo.getMatricula() + " es: ");
		this.mostrarAlumno(arbolBinarioBusqueda.getMenorAntecesorComun(diego, eduardo));
		System.out.println("El menor comun antecesor entre " + felipe.getMatricula() + " y " + mar.getMatricula() + " es: ");
		this.mostrarAlumno(arbolBinarioBusqueda.getMenorAntecesorComun(felipe, mar));
		System.out.println("El menor comun antecesor entre " + diego.getMatricula() + " y " + mar.getMatricula() + " es: ");
		this.mostrarAlumno(arbolBinarioBusqueda.getMenorAntecesorComun(diego, mar));


	}
	private void mostrarAlumno(Alumno alumno) {
		if (alumno == null) {
			System.out.println("NINGUNO");
		} else {
			alumno.mostrar();
		}
	}
}