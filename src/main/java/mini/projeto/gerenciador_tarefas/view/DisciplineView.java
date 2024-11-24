package mini.projeto.gerenciador_tarefas.view;

import mini.projeto.gerenciador_tarefas.controller.DisciplineController;

import java.util.Scanner;

public class DisciplineView {
    private final DisciplineController disciplineController;

    public DisciplineView(DisciplineController disciplineController) {
        this.disciplineController = disciplineController;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Gerenciamento de Disciplinas ===");
        System.out.println("1. Listar todas as disciplinas");
        System.out.println("2. Listar disciplinas de um curso específico");
        System.out.print("Escolha uma opção: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                disciplineController.listAllDisciplines();
                break;
            case 2:
                System.out.print("Digite o nome do curso: ");
                String course = scanner.nextLine();
                disciplineController.listDisciplinesByCourse(course);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}