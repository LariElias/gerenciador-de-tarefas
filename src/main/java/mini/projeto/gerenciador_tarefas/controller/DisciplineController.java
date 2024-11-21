package mini.projeto.gerenciador_tarefas.controller;
import  mini.projeto.gerenciador_tarefas.model.Discipline;
import  mini.projeto.gerenciador_tarefas.service.DisciplineService;

import java.util.List;

public class DisciplineController {
    private final DisciplineService disciplineService;

    public DisciplineController() {
        this.disciplineService = new DisciplineService();
    }

    public void listDisciplinesByCourse(String course) {
        List<Discipline> disciplines = disciplineService.getDisciplinesByCourse(course);
        if (disciplines.isEmpty()) {
            System.out.println("Nenhuma disciplina encontrada para o curso: " + course);
        } else {
            for (Discipline discipline : disciplines) {
                System.out.println(discipline);
            }
        }
    }

    public void listAllDisciplines() {
        List<Discipline> disciplines = disciplineService.getAllDisciplines();
        if (disciplines.isEmpty()) {
            System.out.println("Nenhuma disciplina disponível.");
        } else {
            for (Discipline discipline : disciplines) {
                System.out.println(discipline);
            }
        }
    }
}