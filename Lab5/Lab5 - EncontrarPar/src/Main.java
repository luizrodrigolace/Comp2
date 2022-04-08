import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void encontrarPar(List<Integer> lista, int k) {

        HashSet<Integer> conjuntoDeNumeros = new HashSet<>();

        for (Integer numeros : lista) {
            conjuntoDeNumeros.add(numeros);
        }

        for (Integer numero : lista) {
            int x = k - numero;
            if (conjuntoDeNumeros.contains(x)) {
                System.out.printf("k = %d + (%d); ",numero,x);
            }
        }
    }

    public static void main(String[] args) {

        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(5);
        lista.add(-10);
        lista.add(56);
        lista.add(44);
        lista.add(12);
        lista.add(18);
        encontrarPar(lista,34);
    }

}
