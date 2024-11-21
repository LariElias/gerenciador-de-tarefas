package mini.projeto.gerenciador_tarefas.factory;


import mini.projeto.gerenciador_tarefas.controller.StudentController;
import mini.projeto.gerenciador_tarefas.controller.DisciplineController;
import mini.projeto.gerenciador_tarefas.controller.LibraryController;

public class ControllerFactory {

    public static StudentController createStudentController() {
        return new StudentController();
    }

    public static DisciplineController createDisciplineController() {
        return new DisciplineController();
    }

    public static LibraryController createLibraryController() {
        return new LibraryController();
    }
}