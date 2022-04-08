public class Produto {

    private String descricao;
    private int pesoEmGramas;
    private Dimensoes dimensoes;
    private float precoEmReais;
    private String urlDaImagem;

    private int quantidadeEmEstoque = -1;

    public Produto (String descricao, String urlDaImagem) {
        this.descricao = descricao;
        this.urlDaImagem = urlDaImagem;
        // ToDo IMPLEMENT ME!!!
    }

    /**
     * @return uma descrição textual do produto
     */
    public String getDescricao() {
        return descricao;  // ToDo IMPLEMENT ME!!!
    }

    public int getPesoEmGramas() {
        return pesoEmGramas;  // ToDo IMPLEMENT ME!!!
    }

    public Dimensoes getDimensoes() {
        return dimensoes;  // ToDo IMPLEMENT ME!!!
    }

    public float getPrecoEmReais() {
        return precoEmReais;  // ToDo IMPLEMENT ME!!!
    }

    public void setPrecoEmReais(float preco) {
        this.precoEmReais = preco;// ToDo IMPLEMENT ME!!!
    }

    public String getUrlDaImagem() {
        return urlDaImagem;  // ToDo IMPLEMENT ME!!!
    }

    public int getQuantidadeEmEstoque(){
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidade){
        if (this.getQuantidadeEmEstoque() == -1){
            this.quantidadeEmEstoque += quantidade + 1;
        }
        else{
            this.quantidadeEmEstoque += quantidade;
        }
    }

    public String getClasse(){
        return "Livro";
    }
}
