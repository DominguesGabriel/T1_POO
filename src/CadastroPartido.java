
import java.util.ArrayList;

public class CadastroPartido {

    private ArrayList<Partido> partidosCadastrados;

    public CadastroPartido() {
        partidosCadastrados = new ArrayList<Partido>();
    }

    public boolean cadastraPartido(Partido p) {
        for (int i = 0; i < partidosCadastrados.size(); i++) {
            if (p.getNumero() == partidosCadastrados.get(i).getNumero()) {
                return false;
            }
        }
        partidosCadastrados.add(p);
        return true;
    }

    public Partido consultaPartido(String nome) {
        for (int i = 0; i < partidosCadastrados.size(); i++) {
            if (partidosCadastrados.get(i).getNome().equals(nome)) {
                return partidosCadastrados.get(i);
            }
        }
        return null;
    }

    public Partido consultaPartido(int numero) {
        for (int i = 0; i < partidosCadastrados.size(); i++) {
            if (partidosCadastrados.get(i).getNumero() == numero) {
                return partidosCadastrados.get(i);
            }
        }
        return null;
    }

    public boolean buscaPartido(int numero) {
        for (int i = 0; i < partidosCadastrados.size(); i++) {
            if (partidosCadastrados.get(i).getNumero() == numero) {
                return true;
            }
        }
        return false;
    }

    public boolean buscaPartidoNome(String nome) {
        for (int i = 0; i < partidosCadastrados.size(); i++) {
            if (partidosCadastrados.get(i).getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public Partido descobrePartidoNome(String nome) {
        for (int i = 0; i < partidosCadastrados.size(); i++) {
            if (partidosCadastrados.get(i).getNome().equals(nome)) {
                return partidosCadastrados.get(i);
            }
        }
        return null;
    }

    public Partido buscaMaiorPartido() {
        Partido maiorPartido = null;
        int maiorNumeroDeCandidatos = 0;
        Partido partidoAtual;
        int numeroDeCandidatos;
        if (partidosCadastrados.isEmpty()) {
            return null; 
        }

        for (int i = 0; i < partidosCadastrados.size(); i++) {
            partidoAtual = partidosCadastrados.get(i);
            numeroDeCandidatos = partidoAtual.descobreNumeroCandidatos();

            if (numeroDeCandidatos > maiorNumeroDeCandidatos) {
                maiorNumeroDeCandidatos = numeroDeCandidatos;
                maiorPartido = partidoAtual;
            }
        }

        return maiorPartido; 
    }

    public Partido partidoComMaisVotosDeVereadores() {
        Partido partidoMaisVotado = null;
        int maiorSomaDeVotos = 0;
        Partido partidoAtual;
        int votosVereadores;

        for (int i = 0; i < partidosCadastrados.size(); i++) {
            partidoAtual = partidosCadastrados.get(i);
            votosVereadores = partidoAtual.somaVotosVereadores();

            if (votosVereadores >= maiorSomaDeVotos) {
                maiorSomaDeVotos = votosVereadores;
                partidoMaisVotado = partidoAtual;
            }
        }
        return partidoMaisVotado;
    }
}
