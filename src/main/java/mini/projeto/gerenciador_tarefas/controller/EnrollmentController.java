package mini.projeto.gerenciador_tarefas.controller;

import mini.projeto.gerenciador_tarefas.model.Discipline;
import mini.projeto.gerenciador_tarefas.service.EnrollmentService;



import java.util.List;

public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    public void enrollStudent(int studentId, int disciplineId) {
        String message = enrollmentService.enrollStudent(studentId, disciplineId);
        System.out.println(message);
    }

    public void listStudentEnrollments(int studentId) {
        List<Discipline> disciplines = enrollmentService.getStudentEnrollments(studentId);
        if (disciplines.isEmpty()) {
            System.out.println("Nenhuma matrícula encontrada para o estudante com ID: " + studentId);
        } else {
            System.out.println("Disciplinas matriculadas para o estudante com ID: " + studentId);
            for (Discipline discipline : disciplines) {
                System.out.println(discipline);
            }
        }
    }


    public void removeEnrollment(int studentId, int disciplineId) {
        String message = enrollmentService.removeEnrollment(studentId, disciplineId);
        System.out.println(message);
    }
}