package mini.projeto.gerenciador_tarefas.controller;

import mini.projeto.gerenciador_tarefas.model.Student;
import mini.projeto.gerenciador_tarefas.service.StudentService;

import java.util.List;
import java.util.Optional;

public class StudentController {
	private final StudentService studentService;

    public StudentController() {
        this.studentService = new StudentService();
    }

    public void listActiveStudentsByCourseAndModality(String course, String modality) {
        List<Student> students = studentService.getActiveStudentsByCourseAndModality(course, modality);
        if (students.isEmpty()) {
            System.out.println("Nenhum estudante ativo encontrado para o curso " + course + " na modalidade " + modality + ".");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    /**
     * Lista todos os estudantes.
     */
    public void listAllStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("Nenhum estudante encontrado.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    /**
     * Lista todos os estudantes ativos do curso de História na modalidade presencial.
     */
    public void listActiveHistoryStudents() {
        List<Student> activeHistoryStudents = studentService.getActiveHistoryStudents();
        if (activeHistoryStudents.isEmpty()) {
            System.out.println("Nenhum estudante ativo no curso de História na modalidade presencial encontrado.");
        } else {
            for (Student student : activeHistoryStudents) {
                System.out.println(student);
            }
        }
    }

    /**
     * Exibe os detalhes de um estudante específico pelo ID.
     * @param id ID do estudante
     */
    public void showStudentDetails(int id) {
        Optional<Student> student = studentService.getStudentById(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Estudante com ID " + id + " não encontrado.");
        }
    }
}
