package mini.projeto.gerenciador_tarefas.model;

import com.google.gson.annotations.SerializedName;
public class Student {
    private int id;

    @SerializedName("nome")
    private String name;

    @SerializedName("curso") 
    private String course;

    @SerializedName("modalidade")  
    private String modality;

    @SerializedName("status")  
    private String status;

  
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', course='" + course + "', modality='" + modality + "', status='" + status + "'}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
