import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Repositorio<T extends Colecionavel>{

    private static final String PREFIXO_URL_IMAGENS = "http://www.nossoalbum.com.br/imagens/";

    private List<T> todosOsItens;

    public Repositorio(String sufixoUrlImagens, int quantItens,String tipo) {
        todosOsItens = new ArrayList<>(quantItens);

        for (int i = 1; i <= quantItens; i++) {
            T item;
            switch(tipo.toLowerCase()){
                case "selo":
                    item = (T) new Selo(i);
                    break;
                case "figurinha": default:
                    item = (T) new Figurinha(i,sufixoUrlImagens);
            }

            todosOsItens.add(item);
        }
    }

    public int getTotalItens() {
        return this.todosOsItens.size();
    }

    public List<T> getTodosOsItens(){
        return this.todosOsItens;
    }

}
