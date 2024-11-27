package Model;

import Model.Interfaces.Treina;

public class Treinador extends Funcionario implements Treina {

    public Treinador(int id, String nome, double salario) {
        super(id, nome, salario);
    }

    @Override
    public void ensinarTecnologia() {
        System.out.println("Ensinando nova tecnologia...");
    }

    @Override
    public void motivarEquipe() {
        System.out.println("Motivando a equipe...");
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Treinador - ID: " + id + ", Nome: " + nome + ", Salário: " + salario);
    }
}
