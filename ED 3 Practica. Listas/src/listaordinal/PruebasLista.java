package listaordinal;

import jdk.swing.interop.SwingInterOpUtils;

public class PruebasLista {
    public static void main(String[] args) {
        System.out.println("Nombre: Jorge Rayo La Calle");
        System.out.println("Matrícula: bq0004");

        System.out.println("************ PRODUCTOS EN LA LISTA ************");
        ListaOrdinal lista = new ListaOrdinal();
        Factura factura1 = new Factura("12345678B", "17/03/2021");
        Producto producto1 = new Producto("Mesa Escritorio", 185.0F, 2);
        Producto producto2 = new Producto("Silla oficina", 95.9F, 3);
        Producto producto3 = new Producto("Mesa cocina", 125.0F, 1);
        Producto producto4 = new Producto("Sillón reclinable", 230.0F, 2);
        Producto producto5 = new Producto("Silla oficina", 95.9F, 1);
        Producto producto6 = new Producto("Silla oficina", 95.9F, 2);
        Producto producto7 = new Producto("Sillón reclinable", 230.0F, 3);
        lista.insertar(producto1);
        lista.insertar(producto2);
        lista.insertar(producto3);
        lista.insertar(producto4);
        lista.mostrar();
        System.out.println("Después de borrar las sillas de oficina:");
        lista.borrar(producto2);
        lista.mostrar();

        System.out.println();

        System.out.println("************ PRUEBAS SOBRE MÉTODOS AÑADIR ,MOSTRAR FACTURA E IMPORTE TOTAL ************");
        factura1.añadirProducto(producto1);
        factura1.añadirProducto(producto2);
        factura1.añadirProducto(producto3);
        factura1.añadirProducto(producto4);
        factura1.añadirProducto(producto5);
        factura1.mostrar();

        System.out.println();

        System.out.println("************ PRUEBAS SOBRE MÉTODOS ELIMINAR Y MAYORES PRECIOS ************");
        int contador=0;
        contador+=factura1.eliminarProducto(producto6);
        contador+=factura1.eliminarProducto(producto7);
        System.out.println("Se han eliminado "+contador+" unidades");
        factura1.mostrar();
        factura1.mayoresPrecios(100);

        System.out.println("************ FACTURA USANDO LA BIBLIOTECA DE JAVA ************");
        Factura facturaBib = new Factura("88888888A", "08/08/2008");
        Producto productoBib1 = new Producto("Armario", 385.0F, 5);
        Producto productoBib2 = new Producto("Cama", 255.0F, 3);
        Producto productoBib3 = new Producto("Cama", 255.0F, 2);
        Producto productoBib4 = new Producto("Armario", 385.0F, 1);
        facturaBib.añadirProducto(productoBib1);
        facturaBib.añadirProducto(productoBib2);
        facturaBib.añadirProducto(productoBib3);
        facturaBib.eliminarProducto(productoBib4);
        facturaBib.mostrar();
        facturaBib.mayoresPrecios(250);
    }
}