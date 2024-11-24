package mini.projeto.gerenciador_tarefas.view;

import mini.projeto.gerenciador_tarefas.controller.EnrollmentController;

import java.util.Scanner;

public class EnrollmentView {
    private final EnrollmentController enrollmentController;

    public EnrollmentView(EnrollmentController enrollmentController) {
        this.enrollmentController = enrollmentController;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Gerenciamento de Matrículas ===");
        System.out.println("1. Matricular estudante em uma disciplina");
        System.out.println("2. Listar disciplinas matriculadas de um estudante");
        System.out.println("3. Remover matrícula de uma disciplina");
        System.out.print("Escolha uma opção: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                System.out.print("Digite o ID do estudante: ");
                int studentIdForEnrollment = scanner.nextInt();
                System.out.print("Digite o ID da disciplina: ");
                int disciplineIdForEnrollment = scanner.nextInt();
                enrollmentController.enrollStudent(studentIdForEnrollment, disciplineIdForEnrollment);
                break;
            case 2:
                System.out.print("Digite o ID do estudante: ");
                int studentIdForEnrollments = scanner.nextInt();
                enrollmentController.listStudentEnrollments(studentIdForEnrollments);
                break;
            case 3:
                System.out.print("Digite o ID do estudante: ");
                int studentIdToRemoveEnrollment = scanner.nextInt();
                System.out.print("Digite o ID da disciplina: ");
                int disciplineIdToRemoveEnrollment = scanner.nextInt();
                enrollmentController.removeEnrollment(studentIdToRemoveEnrollment, disciplineIdToRemoveEnrollment);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}