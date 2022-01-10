package arbolnario;

import arbolbusqueda.Nodo;

public class ArbolNario {

    private NodoArbolNario raiz;

    public ArbolNario(int dato) {
        raiz = new NodoArbolNario(dato);
    }

    public void insertar(ArbolNario arbol) {
        raiz.getHijos().insertar(arbol.raiz);
    }

    // ------------------------------------------------------------------------
    // TODO 2.2: Mostrar el arbol recorriendo en profundidad en postorden (RECURSIVO)
    public void mostrarProfundidadPostOrden() {
        System.out.print("Profundidad PostOrden: ");
        if (raiz != null) {
            mostrarProfundidadPostOrden(raiz);
        }
        System.out.println();
    }

    private void mostrarProfundidadPostOrden(NodoArbolNario nodo) {
        IteradorAdelanteListaNodosArbolNario iterador;
        if (nodo.getHijos().getNumElementos() != 0) {
            iterador = nodo.getHijos().getIteradorAdelante();
            while (iterador.hasNext()) {
                mostrarProfundidadPostOrden(iterador.next());
            }
        }
        System.out.print(nodo.getDato() + " ");
    }


    // ------------------------------------------------------------------------
    // TODO 2.3: Mostrar el arbol n-ario recorriendolo en amplitud, de derecha a izquierda (iterativo)
    public void mostrarAmplitudInversa() {
        IteradorAtrasListaNodosArbolNario iterador;
        NodoArbolNario nodo;
        ColaNodosArbolNario cola = new ColaNodosArbolNario();
        System.out.print("Amplitud inversa: ");
        if (raiz != null) {
            cola.encolar(raiz);
            while (!cola.vacia()) {
                nodo = cola.desencolar();
                System.out.print(nodo.getDato() + " ");
                if (nodo.getHijos().getNumElementos() != 0) {
                    iterador = nodo.getHijos().getIteradorAtras();
                    while (iterador.hasPrevious()) {
                        cola.encolar(iterador.previous());
                    }
                }
            }
        }
        System.out.println();
    }

    // ------------------------------------------------------------------------
    // TODO 2.4: maxima profundidad de un arbol n-ario
    public int maximaProfundidad() {
        return maximaProfundidad(this.raiz);
    }

    private int maximaProfundidad(NodoArbolNario nodo) {
        int altura = 0, actual;
        IteradorAdelanteListaNodosArbolNario iter = nodo.getHijos().getIteradorAdelante();
        while(iter.hasNext()) {
            actual = maximaProfundidad(iter.next());
            if(actual > altura)
                altura = actual;
        }
        return altura+1;
    }
}