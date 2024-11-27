package Model;

import Model.Interfaces.Gerencia;

public class Gerente extends Funcionario implements Gerencia {

    public Gerente(int id, String nome, double salario) {
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
    public void mostrarDetalhes() {
        System.out.println("Gerente - ID: " + id + ", Nome: " + nome + ", Salário: " + salario);
    }
}
