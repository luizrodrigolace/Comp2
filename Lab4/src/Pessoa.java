public class Pessoa {

    protected int anoNascimento;
    protected String nome;

    public Pessoa(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setAnoNascimento(int ano){
        this.anoNascimento = ano;
    }

    public int getAnoNascimento(){
        return this.anoNascimento;
    }

}
