package mini.projeto.gerenciador_tarefas.command;

import mini.projeto.gerenciador_tarefas.controller.StudentController;

public class ListAllStudentsCommand implements Command {
    private final StudentController studentController;

    public ListAllStudentsCommand(StudentController studentController) {
        this.studentController = studentController;
    }

    @Override
    public void execute() {
        System.out.println("=== Listando todos os estudantes ===");
        studentController.listAllStudents();
    }
}