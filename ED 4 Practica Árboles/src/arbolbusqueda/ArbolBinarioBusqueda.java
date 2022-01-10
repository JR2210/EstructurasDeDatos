package arbolbusqueda;

public class ArbolBinarioBusqueda {
	private class Contador { int valor = 0;}
	private NodoArbol raiz;
	public ArbolBinarioBusqueda() {
		raiz = null;
	}

	// Muestra los elementos del arbol binario en orden central ---------------
	public void mostrar() {
		this.mostrar(raiz, "  ");
	}

	private void mostrar(NodoArbol nodo, String espacios) {
		if (nodo != null) {
			this.mostrar(nodo.getIzquierdo(), espacios + "    ");
			System.out.print(espacios);
			nodo.getDato().mostrar();
			this.mostrar(nodo.getDerecho(), espacios + "    ");
		}
	}

	// Inserta un elemento con una cierta clave -------------------------------
	public void insertar(Alumno dato) {
		raiz = this.insertar(raiz, dato);
	}

	private NodoArbol insertar(NodoArbol nodo, Alumno dato) {
		if (nodo != null) {
			if (nodo.getDato().getMatricula() < dato.getMatricula()) {
				nodo.setDerecho(this.insertar(nodo.getDerecho(), dato));
			} else if (nodo.getDato().getMatricula() > dato.getMatricula()) {
				nodo.setIzquierdo(this.insertar(nodo.getIzquierdo(), dato));
			} else {
				System.out.println("la clave ya existe");
			}
		} else {
			nodo = new NodoArbol(dato);
		}
		return nodo;
	}

	// ------------------------------------------------------------------------
	// TODO 3.2: Devuelve, de forma RECURSIVA, el alumno con la matricula más cercana a la clave dada como argumento
	public Alumno getElementoMasCercano(int clave) {
		return getMasCercano(raiz,clave);
	}

	private Alumno getMasCercano(NodoArbol nodo,int clave){
		Alumno alumno;
		if (nodo==null){
			return null;
		}
		if(nodo.getDato().getMatricula() > clave){
			alumno = getMasCercano(nodo.getIzquierdo(),clave);
			if(alumno == null){
				alumno=nodo.getDato();
			}
		}else{
			alumno=getMasCercano(nodo.getDerecho(),clave);
		}
		return alumno;
	}

	// ------------------------------------------------------------------------
	// TODO 3.3: Devuelve el numero de nodos del arbol de forma RECURSIVA
	public int getNumElementos() {
		return getNumElemento(raiz);
	}
	private int getNumElemento(NodoArbol nodo) {
		int elementos;
		int derecha,izquierda;
		if(nodo == null) {
			elementos = 0;
		}else{
			derecha = getNumElemento(nodo.getDerecho());
			izquierda = getNumElemento(nodo.getIzquierdo());
			elementos = 1+derecha+izquierda;
		}
		return elementos;
	}

	// ------------------------------------------------------------------------
	// TODO 3.4: Devuelve el minimo antecesor común entre dos alumnos dada de forma RECURSIVA
	public Alumno getMenorAntecesorComun(Alumno a1, Alumno a2) {
		NodoArbol resultado = antecesor(a1,a2,raiz);
		return resultado.getDato();
	}

	private NodoArbol antecesor(Alumno a1, Alumno a2, NodoArbol nodo) {
		NodoArbol derecha, izquierda;
		if(nodo==null) {
			return null;
		}
		if(nodo.getDato()==a1 || nodo.getDato()==a2) {
			return nodo;
		}
		izquierda = antecesor(a1,a2,nodo.getIzquierdo());
		derecha = antecesor(a1,a2,nodo.getDerecho());
		if(izquierda != null && derecha != null) {
			return nodo;
		}
		return (izquierda!=null)? izquierda: derecha;
	}


	// ------------------------------------------------------------------------
	// TODO 3.5: Muestra el elemento con la k-esima menor clave de forma RECURSIVA
	public Alumno getKMayorElemento(int k) {
		NodoArbol nodoSolucion = mayorElemento(raiz,k,new Contador());
		if(nodoSolucion==null)return null;
		return nodoSolucion.getDato();
	}
	private NodoArbol mayorElemento(NodoArbol nodo, int k, Contador cont) {
		if (nodo == null) return nodo;
		NodoArbol derecha = mayorElemento(nodo.getDerecho(), k,cont);
		if (derecha != null) return derecha;
		cont.valor = cont.valor+1;
		if (cont.valor == k) return nodo;
		return mayorElemento(nodo.getIzquierdo(),k,cont);
	}

}