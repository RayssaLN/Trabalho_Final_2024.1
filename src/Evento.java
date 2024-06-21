import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evento {
    private String nome;
    private String descricao;
    private Date data;
    private String hora;
    private String local;
    private int capacidade;
    private List<Participante> participantes;

    public Evento(String nome, String descricao, Date data, String hora, String local, int capacidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.capacidade = capacidade;
        this.participantes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public boolean adicionarParticipante(Participante participante) {
        if (participantes.size() < capacidade) {
            participantes.add(participante);
            return true;
        } else {
            System.out.println("Evento lotado! Não é possível adicionar mais participantes.");
            return false;
        }
    }

    public void salvarEventoEmArquivo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvarEventoEmArquivo'");
    }
}