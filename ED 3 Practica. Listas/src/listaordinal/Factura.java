package listaordinal;

import java.util.PriorityQueue;

public class Factura {
    private String dni;
    private String fecha;
    private ListaOrdinal listaProductos;
    private boolean cobrada;

    public Factura(String dni, String fecha) {
        this.dni = dni;
        this.fecha = fecha;
        listaProductos = new ListaOrdinal();
        cobrada = false;
    }

    public String getDNI() {
        return dni;
    }

    public String getFecha() {
        return fecha;
    }

    public boolean estaCobrada() {
        return cobrada;
    }

    public void cobrada() {
        cobrada = true;
    }

    public void añadirProducto(Producto producto) {
        Iterador iter = listaProductos.getIterador();
        Producto productoAux;
        int unidades = producto.getUnidades();
        int centinela=0;
        while (iter.hasNext()) {
            productoAux = iter.next();
            if (producto.equals(productoAux)) {
                centinela = 1;
                productoAux.setUnidades(productoAux.getUnidades() + unidades);
            }
        }
        if(centinela==0) {
            listaProductos.insertar(producto);
        }
    }

    public void mostrar() {
        System.out.println("Factura de: " + dni + ". Fecha: " + fecha);
        if (listaProductos.vacia()) {
            System.out.println("Lista vacía");
        } else {
            listaProductos.mostrar();
        }
        System.out.println("IMPORTE TOTAL: "+importeTotal()+" €");
    }

    public float importeTotal() {
        Iterador iter = listaProductos.getIterador();
        Producto productoAux;
        float importe=0;
        while(iter.hasNext()) {
            productoAux=iter.next();
            importe+=(productoAux.getPrecio()*productoAux.getUnidades());
        }
        return importe;
    }

    public int eliminarProducto(Producto producto) {
        Iterador iter = listaProductos.getIterador();
        Producto productoAux;
        int eliminado=0;
        while (iter.hasNext()) {
            productoAux = iter.next();
            if (producto.equals(productoAux)) {
                productoAux.setUnidades(productoAux.getUnidades() - producto.getUnidades());
                eliminado+=producto.getUnidades();
                if(productoAux.getUnidades()<=0){
                    listaProductos.borrar(producto);
                    eliminado = eliminado + productoAux.getUnidades();
                }
            }
        }
        return eliminado;
    }

    public ListaOrdinal mayoresPrecios(float precio) {
        ListaOrdinal lista = new ListaOrdinal();
        Iterador iter = listaProductos.getIterador();
        Producto productoAux;
        int numero = 0;
        while(iter.hasNext()) {
            productoAux = iter.next();
            if(productoAux.getPrecio()>precio) {
                lista.insertar(productoAux);
                numero++;
            }
        }

        System.out.println("Se han obtenido "+ numero + " productos con precio mayor a "+precio+" € por unidad");
        lista.mostrar();
        return null;
    }
}