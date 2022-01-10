public class Principal {
    public static void main (String[] args) {
        System.out.println("Practica ED Pilas y Colas de Alumno" + " Jorge Rayo La Calle");
        System.out.println("Numero Matricula:" +" bq0004");

        AlgoritmosPila algoritmosPila = new AlgoritmosPila ();
        Pila pila = algoritmosPila.crearPila();
        algoritmosPila.pruebaCopiaPilaRecursivo (pila);
        algoritmosPila.pruebaSumaEnFondo (pila);
        algoritmosPila.pruebaSegunNumQuitar (pila);

        AlgoritmosCola algoritmosCola = new AlgoritmosCola ();
        Cola cola = algoritmosCola.crearCola();
        algoritmosCola.pruebaCopiaCola (cola);
        algoritmosCola.pruebaMediaEnPrimeroCola (cola);
        algoritmosCola.pruebaNumParesImpares(cola);
    }
}
