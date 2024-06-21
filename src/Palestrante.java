import java.util.List;

public class Palestrante {
    private String nome;
    private String biografia;
    private List<String> temas;
    private String horario;

    public Palestrante(String nome, String biografia, List<String> temas, String horario) {
        this.nome = nome;
        this.biografia = biografia;
        this.temas = temas;
        this.horario = horario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public List<String> getTemas() {
        return temas;
    }

    public void setTemas(List<String> temas) {
        this.temas = temas;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}