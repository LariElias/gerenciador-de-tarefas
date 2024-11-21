package mini.projeto.gerenciador_tarefas.service;

import mini.projeto.gerenciador_tarefas.model.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private static final String STUDENT_API_URL = "https://rmi6vdpsq8.execute-api.us-east-2.amazonaws.com/msAluno";
    private final Gson gson = new Gson();

    public List<Student> getActiveStudentsByCourseAndModality(String course, String modality) {
        List<Student> students = getAllStudents();
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : students) {
            if (course.equalsIgnoreCase(student.getCourse())
                    && modality.equalsIgnoreCase(student.getModality())
                    && "Ativo".equalsIgnoreCase(student.getStatus())) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
            String response = HttpClientService.get(STUDENT_API_URL);
            Type studentListType = new TypeToken<ArrayList<Student>>() {}.getType();
            students = gson.fromJson(response, studentListType);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar os dados dos estudantes.");
        }
        return students;
    }

    /**
     * Método para buscar um estudante específico por ID.
     * @param id ID do estudante
     * @return Objeto Student se encontrado, null caso contrário
     */
    public Student getStudentById(int id) {
        List<Student> students = getAllStudents();
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        System.out.println("Estudante com ID " + id + " não encontrado.");
        return null;
    }

    /**
     * Método para buscar estudantes ativos na modalidade presencial e curso de História.
     * @return Lista de estudantes filtrados
     */
    public List<Student> getActiveHistoryStudents() {
        List<Student> students = getAllStudents();
        List<Student> activeHistoryStudents = new ArrayList<>();
        for (Student student : students) {
            if ("História".equalsIgnoreCase(student.getCourse())
                    && "Presencial".equalsIgnoreCase(student.getModality())
                    && "Ativo".equalsIgnoreCase(student.getStatus())) {
                activeHistoryStudents.add(student);
            }
        }
        return activeHistoryStudents;
    }
}