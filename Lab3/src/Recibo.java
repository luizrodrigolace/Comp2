public class Recibo {

    private float valorTotaldaCompra;
    private Usuario usuario;
    private Produto produto;
    private int quantidadeComprada;

    public Recibo(Usuario usuario,float valorTotaldaCompra,Produto produto,int quantidadeComprada){
        this.usuario = usuario;
        this.valorTotaldaCompra = valorTotaldaCompra;
        this.produto = produto;
        this.quantidadeComprada = quantidadeComprada;
    }

    public float getValorTotalDaCompra() {
        return valorTotaldaCompra;  // ToDo IMPLEMENT ME!!!
    }

    @Override
    public String toString() {
        return "Recibo no valor de R$"+ valorTotaldaCompra + "0, para " + usuario.getNome()+
                " referente à compra de " + quantidadeComprada + " unidades de Livro: Guiness Book Of Records";
    }

    public Usuario getUsuario() {
        return usuario;
        // ToDo IMPLEMENT ME!!!
    }
}
