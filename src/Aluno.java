public class Aluno extends Pessoa {
    public static int cont = 100;
    public static String prontuario = "PN" + cont;
    Aluno(String nome, String sobrenome, int idade) {
        super(nome, sobrenome, idade);
        this.prontuario = prontuario;
        cont++;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.sobrenome + ", " + this.idade + " anos, prontuário " + this.prontuario;
    }
}
