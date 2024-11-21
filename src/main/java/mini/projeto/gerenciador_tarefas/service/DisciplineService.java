package mini.projeto.gerenciador_tarefas.service;

import mini.projeto.gerenciador_tarefas.model.Discipline;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DisciplineService {
    private static final String DISCIPLINE_API_URL = "https://sswfuybfs8.execute-api.us-east-2.amazonaws.com/disciplinaServico/msDisciplina";
    private final Gson gson = new Gson();

    /**
     * Método para buscar todas as disciplinas da API.
     * @return Lista de disciplinas
     */
    public List<Discipline> getAllDisciplines() {
        List<Discipline> disciplines = new ArrayList<>();
        try {
            String response = HttpClientService.get(DISCIPLINE_API_URL);
            Type disciplineListType = new TypeToken<ArrayList<Discipline>>(){}.getType();
            disciplines = gson.fromJson(response, disciplineListType);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar os dados das disciplinas.");
        }
        return disciplines;
    }

    /**
     * Método para buscar disciplinas de um curso específico.
     * @param course Nome do curso
     * @return Lista de disciplinas do curso especificado
     */
    public List<Discipline> getDisciplinesByCourse(String course) {
        List<Discipline> disciplines = getAllDisciplines();
        List<Discipline> courseDisciplines = new ArrayList<>();
        for (Discipline discipline : disciplines) {
            if (discipline.getCourse().equalsIgnoreCase(course)) {
                courseDisciplines.add(discipline);
            }
        }
        return courseDisciplines;
    }
}