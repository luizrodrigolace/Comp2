import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Turma {

    private Professor professor;
    private Disciplina disciplina;
    private Periodo periodo;

    private Map<Long,Aluno> alunosInscritos = new HashMap<>();

    public  Map<Long,Float> mediaFinal = new HashMap<>();


    public Turma(Disciplina disciplina, Periodo periodo, Professor professor){
        this.disciplina=disciplina;
        this.periodo=periodo;
        this.professor=professor;
    }

    public void inscreverAluno(Long dre,Aluno alunoParaCadastro){
        alunosInscritos.put(dre,alunoParaCadastro);
    }

    public void atribuirMediaFinal(long dre, float nota){
        mediaFinal.put(dre,nota);
    }

    public float obterMediaFinal(long dre){
        return mediaFinal.get(dre);
    }

    public void listarAlunos(){
        for (Long dre : alunosInscritos.keySet()){
            Aluno aluno = alunosInscritos.get(dre);
            System.out.println("Nome: " + aluno + " - " + "DRE: " + dre);
        }
    }


}
