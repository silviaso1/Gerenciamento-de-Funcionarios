
import Controller.FuncionarioController;
import View.FuncionarioView;

public class Main {
    public static void main(String[] args) {
        FuncionarioController controller = new FuncionarioController();
        FuncionarioView view = new FuncionarioView(controller);

        controller.carregarDados();
        view.exibirMenu();
    }
}

