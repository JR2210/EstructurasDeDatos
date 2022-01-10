package conjunto;

public class Conjunto {

    private Nodo inicio;
    private int numElementos;

    public Conjunto() {
        inicio = null;
        numElementos = 0;
    }

    public boolean vacio() {
        return inicio == null;
    }

    /**
     * Inserta el dato en la posición que le corresponde
     */
    public boolean insertar(int dato) {
        if (dato >= 0) {
            Nodo anterior = null;
            Nodo actual = inicio;
            while ((actual != null) && (actual.getDato() < dato)) {  // Buscar posición de inserción
                anterior = actual;
                actual = actual.getSiguiente();
            }
            if ((actual == null) || (actual.getDato() > dato)) {  // Insertar antes de actual
                Nodo nuevo = new Nodo(dato, actual);
                if (actual == inicio) {  // insertar al principio de la lista
                    inicio = nuevo;
                } else {
                    anterior.setSiguiente(nuevo);
                }
                numElementos++;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    /**
     * Determina si la clave recibida como parámetro existe en la lista.
     */
    public boolean contiene(int dato) {
        Nodo actual = inicio;
        while ((actual != null) && (actual.getDato() < dato)) {  // Buscar dato
            actual = actual.getSiguiente();
        }
        return (actual != null) && (actual.getDato() == dato);
    }

    /**
     * Elimina de la lista el alumno con número de matrícula clave,
     * en caso de existir.
     */
    public boolean borrar(int dato) {
        Nodo actual = inicio;
        Nodo anterior = null;
        while ((actual != null) && (actual.getDato() < dato)) {  // Buscar dato
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if ((actual == null) || (actual.getDato() > dato)) {  // No existe clave
            return false;
        } else {  // Clave encontrada
            if (actual == inicio) {    // eliminar el primero de la lista
                inicio = actual.getSiguiente();
            } else {
                anterior.setSiguiente(actual.getSiguiente());
            }
            numElementos--;
            return true;
        }
    }

    public int getNumElementos() {
        return numElementos;
    }

    public void mostrar() {
        if (this.vacio()) {
            System.out.println("Conjunto vacío");
        } else {
            System.out.print("[ " + inicio.getDato());
            Nodo actual = inicio.getSiguiente();
            while (actual != null) {
                System.out.print(", " + actual.getDato());
                actual = actual.getSiguiente();
            }
            System.out.print(" ] ");
        }
    }


    public int[] toArray() {
        int[] array = new int[numElementos];
        Nodo aux = inicio;
        for (int i = 0; i < getNumElementos(); i++) {
            array[i] = aux.getDato();
            aux = aux.getSiguiente();
        }
        return array;
    }


    public int mayor() {
        int numMax = 0;
        Nodo nodoAux = inicio;
        if (getNumElementos() == 0) {
            return -1;
        } else {
            for (int i = 0; i < getNumElementos(); i++) {
                if (nodoAux.getDato() > numMax) {
                    numMax = nodoAux.getDato();
                }
                nodoAux = nodoAux.getSiguiente();
            }
        }
        return numMax;
    }

    public Conjunto subconjunto(int inferior, int superior) {
        Conjunto subConjunto1 = new Conjunto();
        Nodo nodoAux = inicio;
        while (nodoAux != null) {
            if (nodoAux.getDato() >= inferior && nodoAux.getDato() <= superior) {
                subConjunto1.insertar(nodoAux.getDato());
            }
            nodoAux = nodoAux.getSiguiente();
        }
        return subConjunto1;
    }

    public boolean equals(Conjunto conjunto) {
        Nodo nodoAux = inicio;
        Nodo comparado = conjunto.inicio;
        if (conjunto.getNumElementos() == numElementos) {
            while (nodoAux != null) {
                if (nodoAux.getDato() != comparado.getDato()) {
                    return false;
                }
                nodoAux = nodoAux.getSiguiente();
                comparado = comparado.getSiguiente();
            }
        } else {
            return false;
        }
        return true;
    }

}