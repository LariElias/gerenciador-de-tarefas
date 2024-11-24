package mini.projeto.gerenciador_tarefas;

import mini.projeto.gerenciador_tarefas.controller.StudentController;
import mini.projeto.gerenciador_tarefas.controller.DisciplineController;
import mini.projeto.gerenciador_tarefas.controller.LibraryController;
import mini.projeto.gerenciador_tarefas.controller.EnrollmentController;
import mini.projeto.gerenciador_tarefas.service.DisciplineService;
import mini.projeto.gerenciador_tarefas.service.EnrollmentService;
import mini.projeto.gerenciador_tarefas.service.StudentService;
import mini.projeto.gerenciador_tarefas.view.MainView;
import mini.projeto.gerenciador_tarefas.view.StudentView;
import mini.projeto.gerenciador_tarefas.view.DisciplineView;
import mini.projeto.gerenciador_tarefas.view.LibraryView;
import mini.projeto.gerenciador_tarefas.view.EnrollmentView;

public class App {
    public static void main(String[] args) {
        // Instanciar os serviços
        StudentService studentService = new StudentService();
        DisciplineService disciplineService = new DisciplineService();
        EnrollmentService enrollmentService = new EnrollmentService(studentService, disciplineService);

        // Instanciar os controladores
        StudentController studentController = new StudentController();
        DisciplineController disciplineController = new DisciplineController();
        LibraryController libraryController = new LibraryController();
        EnrollmentController enrollmentController = new EnrollmentController(enrollmentService);

        // Instanciar as views
        StudentView studentView = new StudentView(studentController);
        DisciplineView disciplineView = new DisciplineView(disciplineController);
        LibraryView libraryView = new LibraryView(libraryController);
        EnrollmentView enrollmentView = new EnrollmentView(enrollmentController);

        // Instanciar a MainView
        MainView mainView = new MainView(studentView, disciplineView, libraryView, enrollmentView);

        // Exibir o menu principal
        mainView.showMenu();
    }
}