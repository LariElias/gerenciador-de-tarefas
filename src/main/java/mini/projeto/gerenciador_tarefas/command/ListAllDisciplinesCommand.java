package mini.projeto.gerenciador_tarefas.command;

import mini.projeto.gerenciador_tarefas.controller.DisciplineController;

public class ListAllDisciplinesCommand implements Command {
    private final DisciplineController disciplineController;

    public ListAllDisciplinesCommand(DisciplineController disciplineController) {
        this.disciplineController = disciplineController;
    }

    @Override
    public void execute() {
        disciplineController.listAllDisciplines();
    }
}