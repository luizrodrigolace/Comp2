public class Livro extends Produto {

    private int numeroDePaginas;
    private String trechoEmDestaque;
    private String autor;
    private int anoDePublicacao;


    public Livro(String nome, String editora) {
        super(String.format("Livro: %s , editora %s", nome,editora),"" );
        // ToDo IMPLEMENT ME!!!!
    }

    public int numeroDePaginas() {
        return numeroDePaginas;  // ToDo IMPLEMENT ME!!!!
    }

    public String getTrechoEmDestaque() {
        return trechoEmDestaque;  // ToDo IMPLEMENT ME!!!!
    }

    public String getAutor() {
        return autor;  // ToDo IMPLEMENT ME!!!!
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;  // ToDo IMPLEMENT ME!!!!
    }

}
