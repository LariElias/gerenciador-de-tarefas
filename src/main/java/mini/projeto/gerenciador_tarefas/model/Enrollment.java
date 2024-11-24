package mini.projeto.gerenciador_tarefas.model;

public class Enrollment {
	private int studentId;
    private int disciplineId;

    public Enrollment(int studentId, int disciplineId) {
        this.studentId = studentId;
        this.disciplineId = disciplineId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineId = disciplineId;
    }

    @Override
    public String toString() {
        return "Matrícula [studentId=" + studentId + ", disciplineId=" + disciplineId + "]";
    }
}
