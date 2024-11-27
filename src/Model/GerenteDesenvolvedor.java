package Model;

import Model.Interfaces.Gerencia;
import Model.Interfaces.Desenvolve;

public class GerenteDesenvolvedor extends Funcionario implements Gerencia, Desenvolve {

    public GerenteDesenvolvedor(int id, String nome, double salario) {
        super(id, nome, salario);
    }

    @Override
    public void organizarEquipe() {
        System.out.println("Organizando a equipe...");
    }

    @Override
    public void conduzirReunioes() {
        System.out.println("Conduzindo reuniões...");
    }

    @Override
    public void codar() {
        System.out.println("Codificando...");
    }

    @Override
    public void resolverProblemas() {
        System.out.println("Resolvendo problemas técnicos...");
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Gerente Desenvolvedor - ID: " + id + ", Nome: " + nome + ", Salário: " + salario);
    }
}
