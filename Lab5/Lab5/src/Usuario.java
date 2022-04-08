import java.util.ArrayList;
import java.util.List;

public class Usuario implements Comparable<Usuario> {

    private int id;

    private List<Usuario> amigos = new ArrayList<>();

    private CalculadorIntersecao calculadorIntersecao;

    public Usuario(int id, CalculadorIntersecao calculador) {
        this.id=id;
        this.calculadorIntersecao = calculador;
        // instancia um calculador de interseção
    }

    public int getId() {
        return id;
    }

    public List<Usuario> getAmigos() {
        return this.amigos;
    }

    public void setAmigos(Usuario usuario){
        for(Usuario usuarios : this.amigos){
            if(usuario.compareTo(usuarios) == 0){
                return;
            }
        }
        this.amigos.add(usuario);
    }

    /**
     * Retorna a quantidade de amigos em comum entre este Usuario e o
     * outro Usuario informado.
     *
     * @param outro outro Usuario da rede social
     * @return o tamanho da interseção dos conjuntos de amigos
     */
    public int obterQuantidadeDeAmigosEmComum(Usuario outro) {
        return calculadorIntersecao.obterIntersecao(this.amigos, outro.getAmigos()).size();
    }

    @Override
    public int compareTo(Usuario o) {
        return this.id - o.id;
    }
}
