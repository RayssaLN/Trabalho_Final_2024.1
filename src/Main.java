import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GerenciadorEventos gerenciador = new GerenciadorEventos();

        // Criando um evento
        Evento evento = new Evento("Tech Conference 2024", "Conferência de tecnologia", new Date(), "09:00", "Centro de Convenções", 100);
        gerenciador.adicionarEvento(evento);

        // Cadastrando participantes
        Participante participante1 = new Participante("João Silva", "joao.silva@gmail.com", "123456789", "Empresa X");
        Participante participante2 = new Participante("Maria Oliveira", "maria.oliveira@gmail.com", "987654321", "Empresa Y");

        gerenciador.inscreverParticipante(participante1, evento);
        gerenciador.inscreverParticipante(participante2, evento);

        // Cadastrando palestrantes
        List<String> temas = new ArrayList<>();
        temas.add("Inteligência Artificial");
        temas.add("Desenvolvimento de Software");

        Palestrante palestrante = new Palestrante("Carlos Souza", "Especialista em IA", temas, "10:00");
        gerenciador.cadastrarPalestrante(palestrante);

        // Gerando relatório
        gerenciador.gerarRelatorio();
    }
}