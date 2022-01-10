package listaordinal;
public class Nodo {
    private Producto dato;
    private Nodo siguiente;

    public Nodo(Producto producto, Nodo siguiente) {
        this.dato = producto;
        this.siguiente = siguiente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Producto getDato() {
        return dato;
    }

    public void setDato(Producto dato) {
        this.dato = dato;
    }
}
