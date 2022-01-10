package listaordinal;
import java.util.Iterator;
import java.util.LinkedList;

public class FacturaBib {
    private String dni;
    private String fecha;
    private LinkedList<Producto> listaBib;
    private boolean cobrada;

    public FacturaBib(String dni, String fecha) {
        this.dni = dni;
        this.fecha = fecha;
        listaBib = new LinkedList<Producto>();
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
        Iterator<Producto> it = listaBib.iterator();
        Producto aux;
        int cantidad = producto.getUnidades();
        int cambio=0;
        while (it.hasNext()) {
            aux = it.next();
            if (producto.equals(aux)) {
                cambio = 1;
                aux.setUnidades(aux.getUnidades() + cantidad);
            }
        }
        if(cambio==0) {
            listaBib.add(producto);
        }
    }

    public void mostrar() {
        Iterator<Producto> iter = listaBib.iterator();
        System.out.println("Factura de: " + dni + ". Fecha: " + fecha);
        if (listaBib.isEmpty()) {
            System.out.println("Lista vacía");
        } else {
            while(iter.hasNext()) {
                System.out.println(iter.next());
            }
        }
        System.out.println("IMPORTE TOTAL: "+importeTotal());
    }

    public float importeTotal() {
        Iterator<Producto> iter = listaBib.iterator();
        Producto aux;
        float total=0;
        while(iter.hasNext()) {
            aux=iter.next();
            total+=(aux.getPrecio()*aux.getUnidades());
        }
        return total;
    }

    public int eliminarProducto(Producto producto) {
        Iterator<Producto> iter = listaBib.iterator();
        Producto aux;
        int cantidad = producto.getUnidades();
        while (iter.hasNext()) {
            aux = iter.next();
            if (producto.equals(aux)) {
                aux.setUnidades(aux.getUnidades() - cantidad);
                if(aux.getUnidades()<=0){
                    listaBib.remove(aux);
                }
            }
        }
        return 0;
    }

    public ListaOrdinal mayoresPrecios(float precio) {
        Iterator<Producto> iter = listaBib.iterator();
        Producto productoAux;
        int cantidad = 0;
        while(iter.hasNext()) {
            productoAux = iter.next();
            if(productoAux.getPrecio()>precio) {
                listaBib.add(productoAux);
                cantidad++;
            }
        }
        System.out.println("Se han obtenido "+ cantidad + " productos con precio mayor a "+precio+" € por unidad");
        return null;
    }
}