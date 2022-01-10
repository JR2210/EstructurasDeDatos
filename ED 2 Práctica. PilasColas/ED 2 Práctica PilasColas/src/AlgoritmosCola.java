public class AlgoritmosCola {
    public Cola crearCola() {
        Cola cola = new Cola(); //Se crea el objeto cola
        for(int i=0 ; i<5 ; i++) //encolamos cada elemento solicitado
            cola.encolar(i);
        cola.encolar(19);
        cola.encolar(24);
        cola.encolar(48);
        return cola; //retornamos la cola creada
    }

    public Cola copiaCola(Cola cola) {
        Cola copiaCola = new Cola(); //creamos una colaCopia, para poder copiar los elementos de la cola original
        int aux; // creamos un entero aux
        for(int i=0 ; i <cola.getNumElementos(); i++){ //recorremos con un for la cola entera (desde 0 hasta cola.getNumElementos())
            aux = cola.desencolar(); //guardamos en el entero aux cada elemento desencolado
            copiaCola.encolar(aux); //encolamos ese elemento en copiaCola
            cola.encolar(aux); //encolmaos de nuevo en la cola original , recordemos que las colas siguen el FIFO (First in, first out)
        }
        return copiaCola; //devolvemos la cola copiada
    }

    public void mediaEnPrimeroCola(Cola cola) {
        int media = 0,aux; //creamos dos enteros, el entero media lo inicializamos en 0 ya que va a ir actualizando su valor
        if(!cola.vacia()){ //si la cola no está vacía
            for(int i=0 ; i< cola.getNumElementos();i++){ //recorremos con un for la cola entera (desde 0 hasta cola.getNumElementos())
                aux = cola.desencolar(); //guardamos en el entero aux cada elemento desencolado
                media += aux; //actualizamos el valor de la media sumando media=media + aux(que contiene el valor del elemento desencolado anteriormente)
                cola.encolar(aux); //volvemos a encolar en la cola
            }

            media = media / cola.getNumElementos(); //hallamos la media dividiendo la suma de los elementos anteriormente actualizados / el numero de elementos
            cola.encolar(media); //encolamos directamente la media, ya que tiene que ser el primer elemento

            for(int i=0 ;i<cola.getNumElementos()-1;i++){ //recorremos con un for la cola entera (desde 0 hasta cola.getNumElementos()-1), disminuimos en 1 ya que sino la media acaba al final
                aux = cola.desencolar(); //guardamos en el entero aux cada elemento desencolado
                cola.encolar(aux); // volvemos a encolar
            }
        }
    }

    public int numParesImpares(Cola cola, int valor) {
        int aux,contP=0,contI=0,retorno=0; //creamos 4 enteros, dos contadores de pares e impares, una variable retorno y un aux
        if(!cola.vacia()){ //si la cola está vacía
            if(valor==1){ //si el valor es igual a 1, contamos los impares
                for(int i=0; i<cola.getNumElementos();i++){ //recorremos con un for la cola entera (desde 0 hasta cola.getNumElementos())
                    aux= cola.desencolar(); //guardamos en el entero aux cada elemento desencolado
                    if(aux%2!=0){ // si el resto de dividir aux entre 2 no es igual a 0
                        contI++; //aumentamos en 1 el contador de impares
                    }
                    cola.encolar(aux); //volvemos a encolar
                }
                retorno=contI; // la variable retorno será igual al numero de impares
            }else if(valor==2){ //si el valor es igual a 2, contamos los pares
                for(int i=0; i<cola.getNumElementos();i++){ //recorremos con un for la cola entera (desde 0 hasta cola.getNumElementos())
                    aux= cola.desencolar(); //guardamos en el entero aux cada elemento desencolado
                    if(aux%2==0&&aux!=0){ //si el resto de dividir aux entre 2 es igual a 0 y a su vez aux es distinto de 0
                        contP++; //aumentamos el contador de pares
                    }
                    cola.encolar(aux); //volvemos a encolar
                }
                retorno=contP; //igualamos la variable retorno al contador de pares
            }
        }
        return retorno; //si no cumple ninguna condición devuelve 0, esto ocurre cuando la pila está vacía o cuando el valor es distinto de 1 o 2
    }


    public void pruebaCopiaCola(Cola cola1) {
        System.out.println("\n---------------------Pruebas sobre copiaCola---------------");
        System.out.println("Antes de copiar:");
        cola1.mostrar();
        Cola colaCopia = copiaCola(cola1);
        System.out.println("Después de copiar:");
        colaCopia.encolar(2);
        System.out.println("Cola original:");
        cola1.mostrar();
        System.out.println("Cola copia:");
        colaCopia.mostrar();
    }

    public void pruebaMediaEnPrimeroCola(Cola cola1) {
        System.out.println("\n---------------------Pruebas sobre mediaEnPrimeroCola---------------");
        cola1.mostrar();
        mediaEnPrimeroCola(cola1);
        System.out.println("Después de ejecutar mediaEnPrimeroCola:");
        cola1.mostrar();
        System.out.println("La media de los elementos de la cola: " + cola1.desencolar());
        cola1.mostrar();
        Cola colaVacia = new Cola();
        mediaEnPrimeroCola(colaVacia);
        System.out.println("Al ejecutar mediaEnPrimeroCola de una cola vacía:");
        colaVacia.mostrar();
    }

    public void pruebaNumParesImpares(Cola cola1) {
        System.out.println("\n---------------------Pruebas sobre numeroElementosPI---------------");
        cola1.mostrar();
        System.out.println("Numeros impares en cola: " + numParesImpares(cola1, 1));
        System.out.println("Después de ejecutar Numeros impares en cola:");
        cola1.mostrar();
        System.out.println("Numeros pares en cola: " + numParesImpares(cola1, 2));
        System.out.println("Después de ejecutar Numeros pares en cola:");
        cola1.mostrar();
        System.out.println("Valor fuera de 1 y 2 de Numeros  en cola: " + numParesImpares(cola1, 4));
        System.out.println("Después de ejecutar Numeros pares en cola:");
        cola1.mostrar();
        Cola colaVacia = new Cola ();
        System.out.println("Numeros impares  en cola vacia: "+ numParesImpares(colaVacia,1));;
        System.out.println("Después de ejecutar Numeros impares  en cola vacia:");
        colaVacia.mostrar();
    }
}