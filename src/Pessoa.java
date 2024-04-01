import java.util.Arrays;
import java.util.LinkedList;

public class Pessoa {
    String nome;
    String sobrenome;
    int idade, cpf;
    public static LinkedList<Integer> identifier = new LinkedList<>();
    public static int cont = - 1;

    //construtor
    Pessoa(String nome, String sobrenome, int idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;

        cont++;
        identifier.add(cont);
        this.cpf = identifier.get(cont);
    }

    //metodos
    @Override
    public String toString() {
        return this.nome + " " + this.sobrenome + ", " + this.idade + " anos";
    }

    public void getCpf() {
        System.out.println(this.identifier);
    }

    public void addPessoa(Pessoa pessoa, LinkedList<Pessoa> bdPessoas) {
        System.out.println("Nova pessoa adicionada ao registro: " + pessoa + "\n");
        bdPessoas.add(pessoa);
    }
}
