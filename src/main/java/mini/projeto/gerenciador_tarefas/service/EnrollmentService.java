package mini.projeto.gerenciador_tarefas.service;

import mini.projeto.gerenciador_tarefas.model.Enrollment;
import mini.projeto.gerenciador_tarefas.model.Student;
import mini.projeto.gerenciador_tarefas.model.Discipline;

import java.util.ArrayList;
import java.util.List;


public class EnrollmentService {
    private final List<Enrollment> enrollments = new ArrayList<>();
    private final StudentService studentService;
    private final DisciplineService disciplineService;

    public EnrollmentService(StudentService studentService, DisciplineService disciplineService) {
        this.studentService = studentService;
        this.disciplineService = disciplineService;
    }

    public String enrollStudent(int studentId, int disciplineId) {
        // Verificar se o estudante é ativo e presencial
        Student student = studentService.getStudentById(studentId)
                .orElse(null);
        if (student == null || !"Ativo".equalsIgnoreCase(student.getStatus())
                || !"Presencial".equalsIgnoreCase(student.getModality())) {
            return "Estudante não está apto para matrícula.";
        }

        // Verificar se a disciplina é do curso de História
        Discipline discipline = null;
        for (Discipline d : disciplineService.getAllDisciplines()) {
            if (d.getId() == disciplineId && "História".equalsIgnoreCase(d.getCourse())) {
                discipline = d;
                break;
            }
        }
        if (discipline == null) {
            return "Disciplina não encontrada ou não pertence ao curso de História.";
        }


        // Adicionar a matrícula
        enrollments.add(new Enrollment(studentId, disciplineId));
        return "Matrícula realizada com sucesso!";
    }

    public List<Discipline> getStudentEnrollments(int studentId) {
        List<Discipline> enrolledDisciplines = new ArrayList<>();
        
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == studentId) {
                for (Discipline discipline : disciplineService.getAllDisciplines()) {
                    if (discipline.getId() == enrollment.getDisciplineId()) {
                        enrolledDisciplines.add(discipline);
                        break;
                    }
                }
            }
        }
        return enrolledDisciplines;
    }


    public String removeEnrollment(int studentId, int disciplineId) {
        Enrollment enrollmentToRemove = null;

        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == studentId && enrollment.getDisciplineId() == disciplineId) {
                enrollmentToRemove = enrollment;
                break;
            }
        }

        if (enrollmentToRemove != null) {
            enrollments.remove(enrollmentToRemove);
            return "Matrícula removida com sucesso!";
        }
        return "Matrícula não encontrada.";
    }
}