import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Album <T extends Colecionavel>{

    public static final int PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR = 90;

    public static final Image IMAGEM_PADRAO_PARA_POSICAO_VAZIA = null;

    private Repositorio<T> repositorio;

    private final int quantItensPorPacotinho;

    private ArrayList<T> itensColados;  // direct addressing

    private int quantItensColados;

    // poderíamos fazer novamente direct addressing para as repetidas,
    // mas vamos usar um HashMap aqui só para treinarmos
    private Map<Integer, Integer> contRepetidasByPosicao;

    public Album(Repositorio<T> repositorio, int quantItensPorPacotinho) {
        this.repositorio = repositorio;
        this.quantItensPorPacotinho = quantItensPorPacotinho;

        int tamanhoFisicoDaLista = getTamanho() + 1;

        this.itensColados = new ArrayList<>(tamanhoFisicoDaLista);

        // inicializa as posições com nulls, para poder acessá-las diretamente
        for (int i = 0; i < tamanhoFisicoDaLista; i++) {
            this.itensColados.add(null);
        }
        this.quantItensColados = 0;

        this.contRepetidasByPosicao = new HashMap<>();
    }

    public void receberNovoPacotinho(Pacotinho<T> pacotinho) {
        List<T> itensDoPacotinho = pacotinho.getItens();
        if (itensDoPacotinho.size()!= this.quantItensPorPacotinho) {
            return;  // melhor ainda: lançaria uma checked exception
        }

        for (T item : pacotinho.getItens()) {
            final int posicao = item.getPosicao();
            if (possuiItemColado(posicao)) {
                // adiciona como repetida

                // jeito pior
//                Integer contRepetidas = this.contRepetidasByPosicao.get(posicao);
//                this.contRepetidasByPosicao.put(
//                        posicao, contRepetidas == null ? 1 : contRepetidas + 1);

                // jeito mais elegante: getOrDefault
                int contRepetidas = this.contRepetidasByPosicao.getOrDefault(posicao, 0);
                this.contRepetidasByPosicao.put(posicao, contRepetidas + 1);

            } else {
                // item inédito
                this.itensColados.set(posicao, item);
                this.quantItensColados++;
            }
        }
    }

    public Colecionavel getItemColado(int posicao) {
        return this.itensColados.get(posicao);
        // ToDo IMPLEMENT ME!!!
    }

    public boolean possuiItemColado(int posicao) {
        if(posicao < 1 || posicao>repositorio.getTotalItens()){
            return false;
        }
        return getItemColado(posicao) != null;
        // ToDo IMPLEMENT ME!!!
    }

    public boolean possuiItemRepetido(int posicao) {
        if (posicao < 1 || posicao > this.repositorio.getTotalItens()) {
            return false;
        }
        return this.contRepetidasByPosicao.containsKey(posicao);
        // ToDo IMPLEMENT ME!!!
    }

    public int getTamanho() {
        return this.repositorio.getTotalItens();
    }

    public int getQuantItensColados() {
//        int contador = 0;
//        for (Figurinha fig : this.figurinhasColadas) {
//            if (fig != null) {
//                contador++;
//            }
//        }
//        return contador;

        // melhor jeito: atributo!
        return this.quantItensColados;
    }

    public int getQuantItensFaltantes() {
        return getTamanho() - getQuantItensColados();
    }

    public void autoCompletar() {
        if(getQuantItensFaltantes() <= repositorio.getTotalItens()* PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR/100f){
            for(int i=1; i<=this.repositorio.getTotalItens();i++){
                if(this.getItemColado(i) == null){
                    T itemFaltante = repositorio.getTodosOsItens().get(i);
                    this.itensColados.set(itemFaltante.getPosicao(),itemFaltante);
                    this.quantItensColados++;
                }
            }
        }
        // ToDo IMPLEMENT ME!!!
    }

    private Image getImagem(int posicao) {
        return possuiItemColado(posicao)
                ? this.getItemColado(posicao).getImagem()
                : IMAGEM_PADRAO_PARA_POSICAO_VAZIA;
    }


//    public static void main(String[] args) {
//        ArrayList<Integer> meuArrayList = new ArrayList<>(200);
//
//        // inicializa as posições com nulls, para poder acessá-las diretamente
//        for (int i = 0; i < 200; i++) {
//            meuArrayList.add(null);
//        }
//
////        System.out.println(meuArrayList.get(3));
//
//        meuArrayList.add(3, 300000);  // insert com shift right
//
//        for (int numero : meuArrayList) {
//            System.out.println(numero);
//        }
//    }
}
