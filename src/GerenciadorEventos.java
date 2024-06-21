import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GerenciadorEventos {
    private List<Evento> listaEventos;
    private List<Participante> listaParticipantes;
    private List<Palestrante> listaPalestrantes;

    public GerenciadorEventos() {
        this.listaEventos = new ArrayList<>();
        this.listaParticipantes = new ArrayList<>();
        this.listaPalestrantes = new ArrayList<>();
    }

    public void adicionarEvento(Evento evento) {
        listaEventos.add(evento);
    }

    public void inscreverParticipante(Participante participante, Evento evento) {
        if (evento.adicionarParticipante(participante)) {
            listaParticipantes.add(participante);
        }
    }

    public void cadastrarPalestrante(Palestrante palestrante) {
        listaPalestrantes.add(palestrante);
    }

    public void gerarRelatorio() {
        System.out.println("Relatório de Eventos:");
        for (Evento evento : listaEventos) {
            System.out.println("Evento: " + evento.getNome());
            System.out.println("Descrição: " + evento.getDescricao());
            System.out.println("Data: " + evento.getData());
            System.out.println("Hora: " + evento.getHora());
            System.out.println("Local: " + evento.getLocal());
            System.out.println("Capacidade: " + evento.getCapacidade());
            System.out.println("Participantes: ");
            for (Participante participante : evento.getParticipantes()) {
                System.out.println("\tNome: " + participante.getNome() + ", Email: " + participante.getEmail());
            }
            System.out.println();
        }
    }

    public void salvarEventosEmArquivo() {
        for (Evento evento : listaEventos) {
            evento.salvarEventoEmArquivo();
        }
    }

    public void carregarEventosDeArquivo() {
        try (BufferedReader br = new BufferedReader(new FileReader("eventos.txt"))) {
            String linha;
            Evento eventoAtual = null;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("\t")) {
                    String[] dadosParticipante = linha.trim().split(";");
                    Participante p = new Participante(dadosParticipante[0], dadosParticipante[1], dadosParticipante[2], dadosParticipante[3]);
                    if (eventoAtual != null) {
                        eventoAtual.adicionarParticipante(p);
                    }
                } else {
                    String[] dadosEvento = linha.split(";");
                    Date data = sdf.parse(dadosEvento[2]);
                    eventoAtual = new Evento(dadosEvento[0], dadosEvento[1], data, dadosEvento[3], dadosEvento[4], Integer.parseInt(dadosEvento[5]));
                    listaEventos.add(eventoAtual);
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("Erro ao carregar eventos de arquivo: " + e.getMessage());
        }
    }
}