package mini.projeto.gerenciador_tarefas.view;


import java.util.Scanner;

public class MainView {
    private final StudentView studentView;
    private final DisciplineView disciplineView;
    private final LibraryView libraryView;
    private final EnrollmentView enrollmentView;

    public MainView(StudentView studentView, DisciplineView disciplineView, LibraryView libraryView, EnrollmentView enrollmentView) {
        this.studentView = studentView;
        this.disciplineView = disciplineView;
        this.libraryView = libraryView;
        this.enrollmentView = enrollmentView;
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

            switch (option) {
                case 1:
                    studentView.showMenu();
                    break;
                case 2:
                    disciplineView.showMenu();
                    break;
                case 3:
                    libraryView.showMenu();
                    break;
                case 4:
                    enrollmentView.showMenu();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);

        scanner.close();
    }
}
	
