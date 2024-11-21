package mini.projeto.gerenciador_tarefas.command;

import mini.projeto.gerenciador_tarefas.controller.DisciplineController;
import java.util.Scanner;

public class ListDisciplinesByCourseCommand implements Command {
    private final DisciplineController disciplineController;

    public ListDisciplinesByCourseCommand(DisciplineController disciplineController) {
        this.disciplineController = disciplineController;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do curso para listar as disciplinas: ");
        String course = scanner.nextLine();

        disciplineController.listDisciplinesByCourse(course);

        System.out.println("Operação concluída.");
    }
}

