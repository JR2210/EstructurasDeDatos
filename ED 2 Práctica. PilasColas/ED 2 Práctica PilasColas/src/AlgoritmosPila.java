    public class AlgoritmosPila {

    public Pila crearPila() {
        Pila pila = new Pila();
        for(int i=0;i<5;i++) //Apilo con un for para optimizar el número de lineas
        pila.apilar(i);
        pila.apilar(19);
        pila.apilar(24);
        pila.apilar(48);
        return pila; //retornamos la pila con los elementos
    }

    public Pila copiaPilaRecursivo(Pila pilaOrigen) {
        Pila pilaCopia = new Pila(); //creamos la pila copia
        if(!pilaOrigen.vacia()){ //si la pilaOrigen no está vacía
            int aux = pilaOrigen.desapilar(); //guardamos en el entero aux cada elemento desapilado
            pilaCopia = copiaPilaRecursivo(pilaOrigen); // hacemos la recursividad
            pilaOrigen.apilar(aux); //apilamos en la original
            pilaCopia.apilar(aux); //apilamos en la copia
        }
        return pilaCopia; //devolvemos la copia
    }

    private void sumarPila(Pila pila,int sumar){
        if(!pila.vacia()){ //si la pila no está vacía
            int aux= pila.desapilar(); //guardamos en el entero aux cada elemento desapilado
            sumar += aux; // actualizamos el entero suma que hemos inicializado en 0 en el método sumaEnFondoPila
            sumarPila(pila,sumar); // hacemos la recursividad
            pila.apilar(aux); // cuando hagamos la vuelta de la recursividad apilamos los elementos aux
        }else{
            pila.apilar(sumar); //cuando se termine la ida de la recursividad, si la pila está vacía, apilamos el entero sumar para que sea el fondo (FILO)
        }
    }

    public void sumaEnFondoPila(Pila pila) {
        int sumar_elementos = 0; // le mando el entero inicializado en 0, ya que si hago la recursividad en este método no me actualiza la suma, ya que se resetea en cada ciclo
        sumarPila(pila,sumar_elementos); //enviamos la pila y el entero inicializado en 0
    }

    private void quitarFondo(Pila pila,int elem){
        if(!pila.vacia()){ //si la pila no está vacía
            int aux = pila.desapilar(); //guardamos en el entero aux cada elemento desapilado
            elem--;  //disminuimos el número de elementos
            quitarFondo(pila,elem); //hacemos la recursividad
            if(elem==0){ //al hacer la vuelta de la recursividad, si el numero de elementos es 0 ---> pila==vacia
                pila.apilar(aux); //apilamos el primer elemento (fondo)
                pila.desapilar(); //desapilamos instantaneamente después el fondo
                elem++; //y aumentamos la variable elem en 1 para no poder acceder de nuevo a la condición, y por lo tanto eliminando el fondo
            }else{
                pila.apilar(aux); //si elem!=0 apilamos el resto de elementos de la pila
                elem++;
            }
        }
    }

    public void segunNumQuitar(Pila pilaOrigen) {
        int aux=pilaOrigen.getNumElementos(); //guardamos en aux el numero de elementos de la pila con el metodo getNumElementos()
        if(!pilaOrigen.vacia()){ //si la pila no está vacía
            if(aux%2==0){ // si el resto de dividir el numero de elementos entre 2 es 0 ---> par
                quitarFondo(pilaOrigen,aux); // llamamos al método quitarFondo enviando la pila y el numero de elementos
            }else if(aux%2!=0){ // si el resto de dividir el numero de elementos entre 2 es distinto de 0 ---> impar
                pilaOrigen.desapilar(); // desapilamos la cima
            }
        }
    }


    public void pruebaCopiaPilaRecursivo(Pila pila) {
        System.out.println("\n---------------------Pruebas sobre copiaRPila---------------");
        Pila pilaCopia;
        System.out.println("Antes de copiar:");
        pila.mostrar();
        pilaCopia = copiaPilaRecursivo(pila);
        pilaCopia.apilar(2);
        System.out.println("Pila original:");
        pila.mostrar();
        System.out.println("Pila copia:");
        pilaCopia.mostrar();
    }

    public void pruebaSumaEnFondo(Pila pila1) {
        System.out.println("\n---------------------Pruebas sobre sumaEnFondoPila---------------");
        pila1.mostrar();
        System.out.println("Al sumar primera vez sumaEnFondopila ");
        sumaEnFondoPila(pila1);
        System.out.println("Resultado obtenido:");
        pila1.mostrar();
        System.out.println("Al sumar segunda vez sumaEnFondopila ");
        sumaEnFondoPila(pila1);
        System.out.println("Resultado obtenido:");
        pila1.mostrar();
    }

    public void pruebaSegunNumQuitar (Pila pila1) {
        System.out.println("\n---------------------Pruebas sobre segunNumQuitar---------------");
        pila1.mostrar();
        System.out.println("Al lanzar primera vez segunNumQuitar ");
        segunNumQuitar(pila1);
        System.out.println("Pila original:");
        pila1.mostrar();
        System.out.println("Al lanzar segunda vez segunNumQuitar ");
        segunNumQuitar(pila1);
        System.out.println("Pila original:");
        pila1.mostrar();
    }
}