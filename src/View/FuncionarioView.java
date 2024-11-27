package View;

import Controller.FuncionarioController;
import Model.Desenvolvedor;
import Model.Funcionario;
import Model.Gerente;
import Model.Treinador;
import Model.GerenteDesenvolvedor;

import java.util.Scanner;

public class FuncionarioView {
    private FuncionarioController controller;
    private final Scanner scanner;

    public FuncionarioView(FuncionarioController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in); // Inicializa o Scanner
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== Menu de Funcionários ===");
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Listar Funcionários");
            System.out.println("3. Atualizar Funcionário");
            System.out.println("4. Remover Funcionário");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = lerInt();

            switch (opcao) {
                case 1 -> adicionarFuncionario();
                case 2 -> listarFuncionarios();
                case 3 -> atualizarFuncionario();
                case 4 -> removerFuncionario();
                case 5 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);
    }

    private void adicionarFuncionario() {
        System.out.println("\n=== Adicionar Funcionário ===");
        System.out.print("ID: ");
        int id = lerInt();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Salário: ");
        double salario = lerDouble();

        System.out.println("Selecione o tipo de funcionário:");
        System.out.println("1. Desenvolvedor");
        System.out.println("2. Gerente");
        System.out.println("3. Treinador");
        System.out.println("4. Gerente Desenvolvedor");
        System.out.print("Escolha: ");

        int tipo = lerInt();
        Funcionario funcionario = switch (tipo) {
            case 1 -> new Desenvolvedor(id, nome, salario);
            case 2 -> new Gerente(id, nome, salario);
            case 3 -> new Treinador(id, nome, salario);
            case 4 -> new GerenteDesenvolvedor(id, nome, salario);
            default -> null;
        };

        if (funcionario == null) {
            System.out.println("Tipo inválido! Funcionário não adicionado.");
        } else {
            controller.adicionarFuncionario(funcionario);
            System.out.println("Funcionário adicionado com sucesso!");
        }
    }

    private void listarFuncionarios() {
        System.out.println("\n=== Lista de Funcionários ===");
        controller.listarFuncionarios();
    }

    private void atualizarFuncionario() {
        System.out.println("\n=== Atualizar Funcionário ===");
        System.out.print("ID do funcionário: ");
        int id = lerInt();

        Funcionario funcionario = controller.getFuncionarioPorId(id);
        if (funcionario == null) {
            System.out.println("Funcionário com ID " + id + " não encontrado.");
            return;
        }

        System.out.print("Novo nome: ");
        String novoNome = scanner.nextLine();

        System.out.print("Novo salário: ");
        double novoSalario = lerDouble();

        controller.atualizarFuncionario(id, novoNome, novoSalario);
    }

    private void removerFuncionario() {
        System.out.println("\n=== Remover Funcionário ===");
        System.out.print("ID do funcionário: ");
        int id = lerInt();

        controller.removerFuncionario(id);
    }

    // Métodos auxiliares para validação de entrada
    private int lerInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida! Digite um número inteiro: ");
            }
        }
    }

    private double lerDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida! Digite um número decimal: ");
            }
        }
    }
}
