package conjunto;

public class Algoritmos {
    public Conjunto interseccion(Conjunto conjunto1, Conjunto conjunto2) {
        Conjunto conjuntoInter = new Conjunto();
        int[] arrayA = conjunto1.toArray();
        int[] arrayB = conjunto2.toArray();
        if (conjunto1.getNumElementos() > conjunto2.getNumElementos()) {
            for (int i = 0; i < conjunto2.getNumElementos(); i++) {
                for (int j = 0; j < conjunto1.getNumElementos(); j++) {
                    if (arrayB[i] == arrayA[j]) {
                        conjuntoInter.insertar(arrayB[i]);
                    }
                }
            }
        } else {
            for (int i = 0; i < conjunto1.getNumElementos(); i++) {
                for (int j = 0; j < conjunto2.getNumElementos(); j++) {
                    if (arrayA[i] == arrayB[j]) {
                        conjuntoInter.insertar(arrayA[i]);
                    }
                }
            }
        }
        return conjuntoInter;
    }
}