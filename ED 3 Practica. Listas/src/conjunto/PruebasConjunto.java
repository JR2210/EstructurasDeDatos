package conjunto;

public class PruebasConjunto {

    public static void main(String[] args) {
        Conjunto conjunto = new Conjunto();
        conjunto.insertar(4);
        conjunto.insertar(6);
        conjunto.insertar(2);
        conjunto.insertar(4);
        conjunto.insertar(-2);
        System.out.println("------------ Insertar ------------");
        System.out.print("Conjunto de trabajo: ");
        conjunto.mostrar();
        System.out.println();
        System.out.println();

        System.out.println("------------ toArray ------------");
        int[] array = conjunto.toArray();
        System.out.print("El array contiene: ");
        System.out.print("[ ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.print("]");
        System.out.println();

        System.out.println("------------ mayor ------------");
        System.out.println("El mayor elemento es: " + conjunto.mayor());
        System.out.println();

        System.out.println("------------ subconjunto ------------");
        Conjunto conjuntoPruebas = conjunto.subconjunto(3, 6);
        System.out.print("El subconjunto entre 3 y 6 es: ");
        conjuntoPruebas.mostrar();
        System.out.println();

        System.out.println("------------ equals ------------");
        conjuntoPruebas = new Conjunto();

        conjuntoPruebas.insertar(2);
        conjuntoPruebas.insertar(4);

        System.out.print("Un conjunto es: ");
        conjuntoPruebas.mostrar();

        System.out.println("Es igual que el conjunto de trabajo? " + conjuntoPruebas.equals(conjunto));

        conjuntoPruebas.insertar(6);

        System.out.print("Un conjunto es: ");
        conjuntoPruebas.mostrar();
        System.out.println();
        System.out.println("Es igual que el conjunto de trabajo? " + conjuntoPruebas.equals(conjunto));
        System.out.println();

        System.out.println("------------ Algoritmos ------------");
        conjuntoPruebas = new Conjunto();
        conjuntoPruebas.insertar(4);
        conjuntoPruebas.insertar(5);

        Algoritmos algoritmo1 = new Algoritmos();
        Conjunto conjuntoAlgoritmo = algoritmo1.interseccion(conjunto, conjuntoPruebas);
        System.out.print("La interseccion de ");
        conjuntoPruebas.mostrar();
        System.out.println("con el de trabajo es :");
        conjuntoAlgoritmo.mostrar();
    }
}