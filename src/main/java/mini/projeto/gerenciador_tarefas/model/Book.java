package mini.projeto.gerenciador_tarefas.model;
import com.google.gson.annotations.SerializedName;

public class Book {
    private int id;

    @SerializedName("titulo")  // Ajuste para o nome correto no JSON
    private String title;

    @SerializedName("autor")   // Ajuste para o nome correto no JSON
    private String author;

    @SerializedName("ano")     // Ajuste para o nome correto no JSON
    private int year;

    @SerializedName("status")  // Ajuste para o nome correto no JSON
    private String status;

    // Construtor, getters e setters

    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + "', author='" + author + "', year=" + year + ", status='" + status + "'}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}