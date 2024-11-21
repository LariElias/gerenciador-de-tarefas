package mini.projeto.gerenciador_tarefas.model;
import com.google.gson.annotations.SerializedName;

public class Discipline {
    private int id;

    @SerializedName("curso")  
    private String course;

    @SerializedName("nome")   
    private String name;


    @Override
    public String toString() {
        return "Discipline{id=" + id + ", course='" + course + "', name='" + name + "'}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}