
public class AmigosETSISI {
    //Nombre: Jorge Rayo La Calle | Grupo: CIM11
    private GrafoMA miREd;
    private Persona[] contactos;


    public AmigosETSISI(int n,Persona[] contactos) { //construye una matriz de nxn sin aristas
        miREd= new GrafoMA(n,false);
        this.contactos = contactos;
    }

    public int getNumPersonas() {
        return miREd.getNumVertices();
    }


    // MÉTODOS PARA INSERTAR Y ELIMINAR relaciones(ARISTAS)

    // ------------------------------------
 // método que inserta una relación de amistad directa (una arista en el grafo)
    public void insertaRelacion(int o, int d) {
            miREd.insertarArista(o,d);
    }

    // método que elimina una relación de amistad directa (una arista en el grafo)
    public void eliminaRelacion(int o, int d) {
        miREd.eliminarArista(o,d);
    }
// método que indica si existe una relación de amistad directa (una arista en el grafo)
    public boolean existeRelacion(int o, int d) {
        return miREd.existeArista(o,d);
    }

    //Metodo que compara dos cadenas que representan dos nombres ignorando mayusculas y minusculas
    public boolean nombresIguales(String cad1, String cad2){
        return (cad1.equalsIgnoreCase(cad2));
    }


    // encuentra la posición asociado a un nombre de persona en la tablade contactos que
    // ademas se corresponde con el vertice que le representa en el grafo
    public int devuelvePosNombre(String nombre){
        int i=0;
        boolean encontrado=false;
        while (i<contactos.length && !encontrado){
            encontrado= nombresIguales(nombre,contactos[i].getNombre());
            if (!encontrado) i++;
        }
        if (!encontrado) i=-1;
        return i;
    }

    // Imprime la Matriz del relaciones( Matriz de adyacencia del grafo) por consola
    public void imprimirRelaciones() {
        System.out.println("Contenido de la matriz: ");
        for (int i = 0; i < miREd.getNumVertices(); i++) {
            for (int j = 0; j < miREd.getNumVertices(); j++) {
                if (miREd.existeArista(i,j)) System.out.print(" S ");
                else System.out.print(" N ");
            }
            System.out.println();
        }
    }
    //Imprime la información de la red y la matriz de Relaciones por consola
    public void mostrarRed() {
        System.out.println("Existen " + miREd.getNumVertices() + " contactos: \n");
        for (int i = 0; i < miREd.getNumVertices(); i++)
            System.out.println(i + ": " + contactos[i].getNombre());
        imprimirRelaciones();
        System.out.println();
    }

// ------------------------------------

    // MÉTODOS A COMPLETAR


// Apartado 2.2 Primer método
    public int contarGrupos() {
        int res = 0;
        boolean[] visitados = new boolean[miREd.getNumVertices()];
        for (int i = 0; i < miREd.getNumVertices() * 2; i++) {
            if (!visitados[i % miREd.getNumVertices()] && i > miREd.getNumVertices()) {
                miREd.recorridoEnProfundidadComponenteConexa(i % miREd.getNumVertices(), visitados);
                res++;
            } else
                visitados[i % miREd.getNumVertices()] = false;
        }
        return res;
    }


    // Apartado 2.2 Segundo método
    public void mostrarAmigos(String nombre) {
        int pos = devuelvePosNombre(nombre);
        if (pos == -1) {
            System.out.println("Ese nombre no existe");
        } else {
            System.out.println("Amigos de " + nombre + ":");
            for (int i = 0; i < miREd.getNumVertices(); i++) {
                if (existeRelacion(pos, i)) {
                    System.out.println("-" + contactos[i].getNombre());
                }
            }
        }
    }


    // Apartado 2.2 Tercer método
    public boolean sonDelMismoGrupo(Persona p, Persona p1) {
        boolean[] guardados = new boolean[miREd.getNumVertices()];
        for(int i = 0 ; i < miREd.getNumVertices() ; i++)
            guardados[i] = false;
        boolean amigos;
        int a = devuelvePosNombre(p.getNombre()), b = devuelvePosNombre(p1.getNombre());
        miREd.recorridoEnProfundidadComponenteConexa(a,guardados);
        amigos = guardados[b];
        return amigos;
    }


    // Apartado 2.2 Cuarto método
    public void mostrarMiembrosGrupo(Persona p) {
        String nombre = p.getNombre();
        int pos = devuelvePosNombre(nombre);
        if (pos == -1) {
            System.out.println("Ese nombre no está en la lista");
        } else {
            miREd.amplitudDesdeVertice(pos);
        }
    }
}
	  




