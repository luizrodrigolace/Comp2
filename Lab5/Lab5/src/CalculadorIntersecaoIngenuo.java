import java.util.ArrayList;
import java.util.List;

public class CalculadorIntersecaoIngenuo implements CalculadorIntersecao {

    @Override
    public List<Usuario> obterIntersecao(List<Usuario> lista1, List<Usuario> lista2) {

        List<Usuario> intersecaoIngenua = new ArrayList<>();

        for (Usuario usuarioNaLista1 : lista1){
            for (Usuario usuarioNaLista2 : lista2){
                if (usuarioNaLista1.equals(usuarioNaLista2)){
                    intersecaoIngenua.add(usuarioNaLista1);
                }
            }
        }

        // para cada elemento da primeira lista, percorra a segunda lista até encontrá-lo (ou não)

        return intersecaoIngenua;
    }
}
