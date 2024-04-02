/*
Para relembrar os basicos de Java
Programa de cadastro de alunos em uma escola

cada pessoa tem: nome, sobrenome, idade
cada aluno tem: em qual ano escolar vai estudar e prontuario;
cada professor tem: materia a qual da aula...
deve ser possivel: obter sua ficha completa...
 */
import java.util.Scanner;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        /* O uso de Linked Lists ao invés de Arrays (o que é mais comum) se deu por dois motivos:
        *  - No momento de produção deste CRUD, estou estudando estruturas de dados, então quis por algo novo em prática
        *  - Podemos levar em conta que elas são dinamicas e tem uma complexidade temporal em geral mais rápida do que Arrays(normalmente O(1)), julguei que eram mais adequadas no contexto
        *    desse programa (mesmo que essa última característica não seja tão relevante para um programa tão leve e simples)
        * */
        LinkedList<Pessoa> bdPessoas = new LinkedList<>();
        LinkedList<Aluno> bdAlunos = new LinkedList<>();
        LinkedList<Professor> bdProfessores = new LinkedList<>();
        // Variável para escolher a operação a ser realizada
        int escolha;
        // Checa ao final do Do-While  se o programa deve ser finalizado ou nao
        boolean finalizar = false;
        Scanner leitor = new Scanner(System.in);

        System.out.println("Bem vindo ao sistema de cadastro de alunos!");
        System.out.println("+ ========================================== +");
        TimeUnit.SECONDS.sleep(1);
        do {
            System.out.println("O que voce deseja fazer?");
            System.out.println("0 - Finalizar operações");
            System.out.println("1 - Inserir nova pessoa");
            System.out.println("2 - Checar lista de pessoas");
            System.out.println("3 - Checar CPF das pessoas");
            System.out.println("4 - Adicionar novo aluno");
            System.out.println("5 - Tornar uma pessoa já registrada como aluno");
            System.out.println("6 - Checar lista de alunos");
            System.out.println("7 - Adicionar novo professor");
            System.out.println("8 - Tornar uma pessoa já registrada como professor");
            System.out.println("9 - Checar lista de professores");
            escolha = leitor.nextInt();

            switch (escolha) {
                // Fechar o programa
                case 0:
                    System.out.println("Obrigado por usar esse sistema!");
                    TimeUnit.SECONDS.sleep(2);
                    finalizar = true;
                    break;

                // Registrar uma pessoa nova
                case 1:
                    System.out.println("Insira o nome:");
                    String nome = leitor.next();
                    System.out.println("Insira o sobrenome:");
                    String sobrenome = leitor.next();
                    System.out.println("Insira a idade:");
                    int idade = leitor.nextInt();
                    Pessoa pessoa = new Pessoa(nome, sobrenome, idade);
                    pessoa.addPessoa(pessoa, bdPessoas);
                    TimeUnit.SECONDS.sleep(2);
                    break;

                // Listar todas as pessoas registradas
                case 2:
                    for (Pessoa x: bdPessoas) {
                        System.out.println(x);
                    }
                    System.out.println("\n");
                    TimeUnit.SECONDS.sleep(2);
                    break;

                // Listar o CPF de todas as pessoas
                case 3:
                    for (Pessoa x: bdPessoas) {
                        x.getCpf();
                    }
                    TimeUnit.SECONDS.sleep(2);
                    break;

                // Registrar novo aluno
                case 4:
                    System.out.println("Insira o nome:");
                    String nomeAluno = leitor.next();
                    System.out.println("Insira o sobrenome:");
                    String sobrenomeAluno = leitor.next();
                    System.out.println("Insira a idade:");
                    int idadeAluno = leitor.nextInt();
                    Aluno aluno = new Aluno(nomeAluno, sobrenomeAluno, idadeAluno);
                    aluno.addAluno(aluno, bdAlunos);
                    TimeUnit.SECONDS.sleep(2);
                    break;

                // Tornar uma pessoa já registrada em aluno
                case 5:
                    System.out.println("Qual pessoa voce deseja transformar em aluno?");

                    // Lista as pessoas para escolher a desejada
                    for (Pessoa x: bdPessoas) {
                        System.out.println(bdPessoas.indexOf(x) + " - " + x.nome);
                    }
                    escolha = leitor.nextInt();

                    // Escolha a pessoa desejada na Linked Lists de pessoas e cria um novo objeto da classe pessoa para armazenar a pessoa escolhida
                    Pessoa pessoaAluno = bdPessoas.get(escolha);

                    // Usa do método declarado na classe Pessoa para add um novo aluno
                    pessoaAluno.addAluno(pessoaAluno, bdAlunos);
                    // Essa mesma estrutuar se repete para o processo dos professores

                    TimeUnit.SECONDS.sleep(2);
                    break;

                // Listar alunos registrados
                case 6:
                    System.out.println("\n");
                    for (Aluno y: bdAlunos) {
                        System.out.println(y);
                    }
                    TimeUnit.SECONDS.sleep(2);
                    break;

                // Registrar novo professor
                case 7:
                    System.out.println("Insira o nome:");
                    String nomeProfessor = leitor.next();
                    System.out.println("Insira o sobrenome:");
                    String sobrenomeProfessor = leitor.next();
                    System.out.println("Insira a idade:");
                    int idadeProfessor = leitor.nextInt();
                    Aluno professor = new Aluno(nomeProfessor, sobrenomeProfessor, idadeProfessor);
                    professor.addProfessor(professor, bdProfessores);
                    TimeUnit.SECONDS.sleep(2);
                    break;

                // Tornar uma pessoa já registrada em professor
                case 8:
                    System.out.println("Qual pessoa voce deseja transformar em professor?");
                    for (Pessoa x: bdPessoas) {
                        System.out.println(bdPessoas.indexOf(x) + " - " + x.nome);
                    }
                    escolha = leitor.nextInt();
                    Pessoa pessoaProfessor = bdPessoas.get(escolha);
                    pessoaProfessor.addProfessor(pessoaProfessor, bdProfessores);
                    TimeUnit.SECONDS.sleep(2);
                    break;

                // Listar professores registrados
                case 9:
                    System.out.println("\n");
                    for (Professor z: bdProfessores) {
                        System.out.println(z);
                    }
                    TimeUnit.SECONDS.sleep(2);
                    break;

                default:
                    System.out.println("\n Opção inválida");
            }

        } while (!finalizar);

        }
    }
