package mini.projeto.gerenciador_tarefas.command;

import mini.projeto.gerenciador_tarefas.controller.DisciplineController;
import java.util.Scanner;

public class ListDisciplinesByCourseCommand implements Command {
    private final DisciplineController disciplineController;

    // Construtor que recebe um DisciplineController
    public ListDisciplinesByCourseCommand(DisciplineController disciplineController) {
        this.disciplineController = disciplineController;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do curso para listar as disciplinas: ");
        String course = scanner.nextLine();

        // Chama o método do DisciplineController para listar disciplinas do curso
        disciplineController.listDisciplinesByCourse(course);

        System.out.println("Operação concluída.");
    }
}

