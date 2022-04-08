import java.util.ArrayList;

/**
 * Implementa uma loja virtual para produtos de qualquer tipo,
 * desde que tenham descrição, preço e dimensões.
 *
 * Essa classe será um singleton, isto é, permitiremos apenas
 * uma instância desde objeto no sistema.
 */
public class Loja {

    private static final Loja instanciaUnica = new Loja();

    public ArrayList usuariosCadastrados = new ArrayList<Usuario>();

    static {
        System.out.println("Estou subindo a classe Loja...");
    }

    private Loja() {
        // escrevo código normalmente para o construtor
    }

    public static Loja getInstanciaUnica() {
        return instanciaUnica;
    }

    /**
     * Inclui no estoque da loja a quantidade informado do produto.
     *
     * @param produto o produto a ser incluído
     * @param quantidadeAIncluir a quantidade que será acrescentada à quantidade existente.
     */
    public void incluirProduto(Produto produto, int quantidadeAIncluir) {
        produto.setQuantidadeEmEstoque(quantidadeAIncluir);
        // ToDo IMPLEMENT ME!!!
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuariosCadastrados.add(usuario);
    }

    /**
     * Efetua a venda do produto desejado na quantidade especificada.
     *
     * @param produto o produto
     * @param quantidadeDesejada a quantidade
     *
     * @return um Recibo indicando a venda feita, se o produto existia (em quantidade suficiente)
     *         no estoque da loja; null, caso o usuário ou o produto sejam desconhecidos,
     *         ou não haja quantidade suficiente do produto desejado
     */
    public Recibo efetuarVenda(Produto produto, int quantidadeDesejada, Usuario usuario) {
        if(!usuariosCadastrados.contains(usuario)){
            return null;
        }
        if(produto.getQuantidadeEmEstoque() == -1 || produto.getQuantidadeEmEstoque() < quantidadeDesejada){
            return null;
        }
        else{
            Recibo recibo = new Recibo(usuario,produto.getPrecoEmReais()*quantidadeDesejada,produto,quantidadeDesejada);
            produto.setQuantidadeEmEstoque(-quantidadeDesejada);
            return recibo;
        }
    }

    /**
     * @param produto o produto a ser consultado
     *
     * @return a quantidade em estoque;
     *         0 se não houver nenhuma unidade;
     *         -1 se o produto não é sequer vendido pela loja
     */
    public int informarQuantidadeEmEstoque(Produto produto) {
        return produto.getQuantidadeEmEstoque();
            // ToDo IMPLEMENT ME!!!
    }
}
