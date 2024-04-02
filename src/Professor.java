import java.util.LinkedList;

public class Professor extends Pessoa{

    public static int cont = 100;
    String prontuario;
    Professor(String nome, String sobrenome, int idade) {
        super(nome, sobrenome, idade);
        this.prontuario = "PP" + cont;
        cont += 10;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.sobrenome + ", " + this.idade + " anos, prontuário " + this.prontuario;
    }

    public void addProfessor(Professor professor, LinkedList<Professor> bdProfessores) {
        System.out.println("Novo aluno adicionada ao registro: " + professor + "\n");
        bdProfessores.add(professor);
    }

    public String getProntuario() {
        return this.prontuario;
    }
}
