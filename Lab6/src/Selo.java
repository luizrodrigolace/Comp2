import java.awt.*;

public class Selo implements Colecionavel{

    private String pais;

    private float valorNominal;

    private final int posicao;

    public Selo(int posicao){
        this.posicao = posicao;
    }

    float getValorNominal(){
        return this.valorNominal;
    };

    String getPais(){
        return this.pais;
    }

    @Override
    public Image getImagem() {
        return null;
    }

    @Override
    public int getPosicao() {
        return this.posicao;
    }
}
