package mini.projeto.gerenciador_tarefas.view;

import mini.projeto.gerenciador_tarefas.controller.StudentController;

import java.util.Scanner;

public class StudentView {
    private final StudentController studentController;

    public StudentView(StudentController studentController) {
        this.studentController = studentController;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Gerenciamento de Estudantes ===");
        System.out.println("1. Listar todos os estudantes");
        System.out.println("2. Listar estudantes ativos de um curso específico");
        System.out.println("3. Ver detalhes de um estudante específico");
        System.out.print("Escolha uma opção: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                studentController.listAllStudents();
                break;
            case 2:
                System.out.print("Digite o nome do curso: ");
                String course = scanner.nextLine();
                System.out.print("Digite a modalidade (Presencial ou EAD): ");
                String modality = scanner.nextLine();
                studentController.listActiveStudentsByCourseAndModality(course, modality);
                break;
            case 3:
                System.out.print("Digite o ID do estudante: ");
                int studentId = scanner.nextInt();
                studentController.showStudentDetails(studentId);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}