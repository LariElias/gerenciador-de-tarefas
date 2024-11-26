package mini.projeto.gerenciador_tarefas.controller;

import mini.projeto.gerenciador_tarefas.view.StudentView;
import mini.projeto.gerenciador_tarefas.view.DisciplineView;
import mini.projeto.gerenciador_tarefas.view.LibraryView;
import mini.projeto.gerenciador_tarefas.view.EnrollmentView;

public class MainController {
    private final StudentView studentView;
    private final DisciplineView disciplineView;
    private final LibraryView libraryView;
    private final EnrollmentView enrollmentView;

    public MainController(StudentView studentView, DisciplineView disciplineView, LibraryView libraryView, EnrollmentView enrollmentView) {
        this.studentView = studentView;
        this.disciplineView = disciplineView;
        this.libraryView = libraryView;
        this.enrollmentView = enrollmentView;
    }

    public void handleOption(int option) {
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
    }
}