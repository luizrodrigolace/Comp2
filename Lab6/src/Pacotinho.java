import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pacotinho <T extends Colecionavel>{

    private static Random random = new Random();

    private Repositorio<T> repositorio;

    List<T> pacotinhoComItens = new ArrayList<>();

    public Pacotinho(Repositorio<T> repo, int[] posicoesDesejadas) {
        this.repositorio = repo;

        for (int posicao : posicoesDesejadas){
            T item = repositorio.getTodosOsItens().get(posicao);
            this.pacotinhoComItens.add(item);
        }

        // ToDo IMPLEMENT ME!!!
    }

    /**
     * Produz um pacotinho com quantFigurinhas sorteadas aleatoriamente
     * dentre aqueles presentes no repositório informado.
     *
     * @param repo o repositório desejado
     * @param quantItens a quantidade de figurinhas a constar no pacotinho
     */
    public Pacotinho(Repositorio repo, int quantItens) {
        this.repositorio = repo;

        for(int i = 1; i<=quantItens;i++){
            int posicao = 1+random.nextInt(repo.getTotalItens());
            T item = repositorio.getTodosOsItens().get(posicao);
            pacotinhoComItens.add(item);
        }

        // ToDo IMPLEMENT ME!!!
    }

    public List<T> getItens() {
        return pacotinhoComItens;
        // ToDo IMPLEMENT ME!!!
    }
}
