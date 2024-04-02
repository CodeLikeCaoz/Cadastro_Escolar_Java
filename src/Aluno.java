import java.util.LinkedList;

public class Aluno extends Pessoa {
    public static int cont = 100;
    String prontuario;
    Aluno(String nome, String sobrenome, int idade) {
        super(nome, sobrenome, idade);
        this.prontuario = "PA" + cont;
        cont += 10;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.sobrenome + ", " + this.idade + " anos, prontuário " + this.prontuario;
    }

    public void addAluno(Aluno aluno, LinkedList<Aluno> bdAlunos) {
        System.out.println("Novo aluno adicionada ao registro: " + aluno + "\n");
        bdAlunos.add(aluno);
    }

    public String getProntuario() {
        return this.prontuario;
    }
}
