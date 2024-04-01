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


public class Main {
    public static void main(String[] args) {
        LinkedList<Pessoa> bdPessoas = new LinkedList<>();
        int escolha;
        boolean finalizar = false;
        Scanner leitor = new Scanner(System.in);

        System.out.println("Bem vindo ao sistema de cadastro de alunos!");
        do {
            System.out.println("O que voce deseja fazer?");
            System.out.println("0 - Finalizar operações");
            System.out.println("1 - Inserir nova pessoa");
            System.out.println("2 - Checar lista de pessoas");
            System.out.println("3 - Checar CPF das pessoas");
            System.out.println("4 - Adicionar novo aluno");
            escolha = leitor.nextInt();

            switch (escolha) {
                case 0:
                    finalizar = true;
                    break;
                case 1:
                    System.out.println("Insira o nome:");
                    String nome = leitor.next();
                    System.out.println("Insira o sobrenome:");
                    String sobrenome = leitor.next();
                    System.out.println("Insira a idade:");
                    int idade = leitor.nextInt();
                    Pessoa pessoa = new Pessoa(nome, sobrenome, idade);
                    pessoa.addPessoa(pessoa, bdPessoas);
                    break;

                case 2:
                    for (Pessoa x: bdPessoas) {
                        System.out.println(x);
                    }
                    System.out.println("\n");
                    break;

                case 3:
                    for (Pessoa x: bdPessoas) {
                        x.getCpf();
                    }

                case 4:


            }

        } while (finalizar == false);


        }
    }
