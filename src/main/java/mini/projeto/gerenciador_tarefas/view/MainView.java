package mini.projeto.gerenciador_tarefas.view;


import mini.projeto.gerenciador_tarefas.controller.MainController;

import java.util.Scanner;

public class MainView {
    private final MainController mainController;

    public MainView(MainController mainController) {
        this.mainController = mainController;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("=== Gerenciador Acadêmico ===");
            System.out.println("1. Gerenciar Estudantes");
            System.out.println("2. Gerenciar Disciplinas");
            System.out.println("3. Gerenciar Biblioteca");
            System.out.println("4. Gerenciar Matrículas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            mainController.handleOption(option); // Delegar ao controlador do menu
        } while (option != 0);

        scanner.close();
    }
}
