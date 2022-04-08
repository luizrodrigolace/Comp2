/**
 * Representa uma fração de forma explícita, guardando numerador e denominador inteiros.
 * Frações equivalentes (matematicamente) devem ser consideradas equals().
 */
public class Fracao {

    /**
     * Cria uma fração, baseada em seu numerador e denominador.
     * O sinal da fração será inferido a partir do sinal
     * do numerador e do denominador.
     *
     * @param numerador o numerador
     * @param denominador o denominador
     */

    private int numerador;
    private int denominador;

    public Fracao(int numerador, int denominador) {

        if (denominador == 0) {
            throw new ArithmeticException("Denominador não pode ser zero!!");
        }

        if(numerador == 0 && denominador != 0){
            this.numerador = 0;
            this.denominador = 1;
        }
        else{
            this.numerador = numerador;
            this.denominador = denominador;
        }

    }

    /**
     * Retorna o sinal da fração.
     *
     * @return true, se for positiva ou nula (zero);
     *         false, se for negativa.
     */
    public boolean getSinal() {
        if(this.numerador>=0 && this.denominador>0){
            return true;
        }
        else if(this.numerador<0 && this.denominador<0){
            return true;
        }
        else if(this.numerador==0 && this.denominador>0){
            return true;
        }
        else if(this.numerador==0 && this.denominador<0){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Retorna o (valor absoluto do) numerador desta fração, ou seja, sempre não-negativo
     * @return o numerador
     */
    public int getNumerador() {
        int num = Math.abs(this.numerador);
        return num;
    }

    /**
     * Retorna o (valor absoluto do) denominador desta fração, ou seja, sempre positivo
     * @return o numerador
     */
    public int getDenominador() {
        int num = Math.abs(this.denominador);
        return num;
    }

    /**
     * Retorna o valor numérico da fração (com o sinal correto).
     *
     * @return um float, com o valor na melhor precisão possível
     *         Ex.: -1/3 vai retornar 0.33333333
     */
    public float getValorNumerico() {
        float valorNumerico = this.numerador/(float)this.denominador;
        return valorNumerico;
    }

    /**
     * Retorna uma fração equivalente à esta fração,
     * e que não pode mais ser simplificada (irredutível).
     *
     * @return um outro objeto Fracao, se esta fração for redutível;
     *         esta própria fração (this), se ela já for irredutível
     */
    public Fracao getFracaoGeratriz() {
        if (this.numerador == 0){
            return this;
        }

        int mdc = AritmeticaUtils.mdc(this.numerador,this.denominador);
        if (mdc == 1){
            return this;
        }

        Fracao geratriz = new Fracao(this.numerador/mdc,this.denominador/mdc);

        return geratriz;
    }

    @Override
    public String toString() {
        String sinal;

        if(this.getSinal() == true){
            sinal = "";
        }
        else{
            sinal = "-";
        }

        if(getNumerador()==0){
            return "0";
        }
        if(getDenominador()==1){
            return Integer.toString(this.numerador);
        }
        return sinal+Integer.toString(getNumerador())+"/"+Integer.toString(getDenominador());
    }

    @Override
    public boolean equals(Object obj) {

        if (obj.getClass() != Fracao.class) {
            return false;
        }

        Fracao auxFracao = (Fracao) obj;

        if(auxFracao.getValorNumerico() == this.getValorNumerico()){
            return true;
        }
        else{
            return false;
        }
    }

}