package Controller;

import Model.Funcionario;
import Model.Desenvolvedor;
import Model.Gerente;
import Model.Treinador;
import Model.GerenteDesenvolvedor;

import java.io.*;
import java.util.ArrayList;

public class FuncionarioController {
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private final String arquivo = "./funcionarios.txt";

    // Adiciona um funcionário e salva os dados
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        salvarDados();
    }

    // Lista todos os funcionários
    public void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("\nNenhum funcionário cadastrado.");
        } else {
            funcionarios.forEach(Funcionario::mostrarDetalhes);
        }
    }

    // Atualiza os dados de um funcionário
    public void atualizarFuncionario(int id, String novoNome, double novoSalario) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) {
                f.setNome(novoNome);
                f.setSalario(novoSalario);
                salvarDados();
                System.out.println("\nFuncionário atualizado com sucesso!");
                return;
            }
        }
        System.out.println("\nFuncionário com ID " + id + " não encontrado.");
    }

    // Remove um funcionário pelo ID
    public void removerFuncionario(int id) {
        boolean removido = funcionarios.removeIf(f -> f.getId() == id);
        if (removido) {
            salvarDados();
            System.out.println("\nFuncionário removido com sucesso!");
        } else {
            System.out.println("\nFuncionário com ID " + id + " não encontrado.");
        }
    }

    // Carrega os dados de funcionários a partir do arquivo
    public void carregarDados() {
        funcionarios.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length != 4) continue;

                int id = Integer.parseInt(partes[0]);
                String tipo = partes[1];
                String nome = partes[2];
                double salario = Double.parseDouble(partes[3]);

                Funcionario funcionario = switch (tipo) {
                    case "Desenvolvedor" -> new Desenvolvedor(id, nome, salario);
                    case "Gerente" -> new Gerente(id, nome, salario);
                    case "Treinador" -> new Treinador(id, nome, salario);
                    case "GerenteDesenvolvedor" -> new GerenteDesenvolvedor(id, nome, salario);
                    default -> null;
                };

                if (funcionario != null) {
                    funcionarios.add(funcionario);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
        }
    }

    // Salva os dados dos funcionários no arquivo
    private void salvarDados() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo))) {
            for (Funcionario f : funcionarios) {
                String tipo = f.getClass().getSimpleName(); // Obtém o nome da classe (ex.: Desenvolvedor)
                pw.println(f.getId() + ";" + tipo + ";" + f.getNome() + ";" + f.getSalario());
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    // Verifica se a lista de funcionários está vazia
    public boolean funcionariosVazios() {
        return funcionarios.isEmpty();
    }

    // Obtém um funcionário pelo ID
    public Funcionario getFuncionarioPorId(int id) {
        return funcionarios.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
