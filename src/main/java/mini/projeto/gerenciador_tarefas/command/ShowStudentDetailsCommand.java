package mini.projeto.gerenciador_tarefas.command;

import mini.projeto.gerenciador_tarefas.controller.StudentController;

import java.util.Scanner;

public class ShowStudentDetailsCommand implements Command {
    private final StudentController studentController;

    public ShowStudentDetailsCommand(StudentController studentController) {
        this.studentController = studentController;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID do estudante: ");
        int studentId = scanner.nextInt();

        System.out.println("=== Detalhes do Estudante ===");
        studentController.showStudentDetails(studentId);
    }
}