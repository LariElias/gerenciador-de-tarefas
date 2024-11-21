package mini.projeto.gerenciador_tarefas.command;


import mini.projeto.gerenciador_tarefas.controller.StudentController;

import java.util.Scanner;

public class ListActiveStudentsCommand implements Command {
    private final StudentController studentController;

    public ListActiveStudentsCommand(StudentController studentController) {
        this.studentController = studentController;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do curso: ");
        String course = scanner.nextLine();
        System.out.print("Digite a modalidade (Presencial ou EAD): ");
        String modality = scanner.nextLine();

        System.out.println("=== Listando estudantes ativos do curso: " + course + " na modalidade: " + modality + " ===");
        studentController.listActiveStudentsByCourseAndModality(course, modality);
    }
}
