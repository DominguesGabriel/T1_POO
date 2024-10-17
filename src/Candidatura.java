
import java.util.ArrayList;

public class Candidatura {

    private ArrayList<Candidato> candidatos;

    public Candidatura() {
        candidatos = new ArrayList<Candidato>();
    }

    public boolean cadastraCandidato(Candidato c) {
        for (int i = 0; i < candidatos.size(); i++) {
            if (candidatos.get(i).getMunicipio().equals(c.getMunicipio())
                    && candidatos.get(i).getNumero() == c.getNumero()) {
                return false;
            }
        }
        candidatos.add(c);
        return true;
    }

    public boolean buscaCandidatoBoolean(int numero, String municipio) {
        for (int i = 0; i < candidatos.size(); i++) {
            if (candidatos.get(i).getNumero() == numero && candidatos.get(i).getMunicipio().equals(municipio)) {
                return true;
            }
        }
        return false;
    }

    public Candidato buscaCandidato(int numero, String municipio) {
        for (int i = 0; i < candidatos.size(); i++) {
            if (candidatos.get(i).getNumero() == numero && candidatos.get(i).getMunicipio().equals(municipio)) {
                return candidatos.get(i);
            }
        }
        return null;
    }

    public ArrayList<Candidato> buscaPrefeito(int numero) {
        ArrayList<Candidato> prefeitosEncontrados = new ArrayList<>();
        for (int i = 0; i < candidatos.size(); i++) {
            if (candidatos.get(i).getNumero() == numero) {
                prefeitosEncontrados.add(candidatos.get(i));
            }
        }
        return prefeitosEncontrados;
    }

    public Candidato prefeitoMaisVotado() {
        Candidato maisVotado = null;
        Candidato canditdatoAtual;
        int votosAtual;
        int maiorNumeroVotos = 0;
        for (int i = 0; i < candidatos.size(); i++) {
            if (candidatos.get(i).getNumero() > 9 && candidatos.get(i).getNumero() < 100) {
                canditdatoAtual = candidatos.get(i);
                votosAtual = candidatos.get(i).getVotos();
                if (votosAtual >= maiorNumeroVotos) {
                    maisVotado = canditdatoAtual;
                    maiorNumeroVotos = votosAtual;
                }

            }

        }
        return maisVotado;
    }

    public Candidato vereadorMaisVotado() {

        Candidato maisVotado = null;
        Candidato canditdatoAtual;
        int votosAtual;
        int maiorNumeroVotos = 0;
        for (int i = 0; i < candidatos.size(); i++) {
            if (candidatos.get(i).getNumero() > 9_999 && candidatos.get(i).getNumero() < 100_000) {
                canditdatoAtual = candidatos.get(i);
                votosAtual = candidatos.get(i).getVotos();
                if (votosAtual >= maiorNumeroVotos) {
                    maisVotado = canditdatoAtual;
                    maiorNumeroVotos = votosAtual;
                }

            }

        }
        return maisVotado;
    }

    public String buscaMunicipioComMaisVotos() {
        ArrayList<String> municipiosContabilizados = new ArrayList<String>();
        ArrayList<Integer> votosPorMunicipio = new ArrayList<Integer>();
        Candidato c;
        String municipio;
        String municipioComMaisVotos = null;
        int maiorNumeroDeVotos = 0;
        String municipioAtual;
        int votosTotais;

        for (int i = 0; i < candidatos.size(); i++) {
            c = candidatos.get(i);
            municipio = c.getMunicipio();

            if (!municipiosContabilizados.contains(municipio)) {
                municipiosContabilizados.add(municipio);
            }
        }

        for (int i = 0; i < municipiosContabilizados.size(); i++) {
            municipioAtual = municipiosContabilizados.get(i);
            votosTotais = somaVotosPorMunicipio(municipioAtual);

            if (votosTotais >= maiorNumeroDeVotos) {
                maiorNumeroDeVotos = votosTotais;
                municipioComMaisVotos = municipioAtual;
            }
        }

        return municipioComMaisVotos;
    }

    public int buscaVotosMunicipioComMaisVotos() {
        ArrayList<String> municipiosContabilizados = new ArrayList<String>();
        ArrayList<Integer> votosPorMunicipio = new ArrayList<Integer>();
        Candidato candidatoAtual;
        String municipio;
        String municipioAtual;
        int votosTotais;

        for (int i = 0; i < candidatos.size(); i++) {
            candidatoAtual = candidatos.get(i);
            municipio = candidatoAtual.getMunicipio();

            if (!municipiosContabilizados.contains(municipio)) {
                municipiosContabilizados.add(municipio);
            }
        }

        int maiorNumeroDeVotos = 0;

        for (int i = 0; i < municipiosContabilizados.size(); i++) {
            municipioAtual = municipiosContabilizados.get(i);
            votosTotais = somaVotosPorMunicipio(municipioAtual);

            if (votosTotais > maiorNumeroDeVotos) {
                maiorNumeroDeVotos = votosTotais;
            }
        }

        return maiorNumeroDeVotos;
    }

    private int somaVotosPorMunicipio(String municipio) {
        int totalVotos = 0;
        Candidato candidatoAtual;

        for (int i = 0; i < candidatos.size(); i++) {
            candidatoAtual = candidatos.get(i);
            if (candidatoAtual.getMunicipio().equals(municipio)) {
                totalVotos = totalVotos + candidatoAtual.getVotos();
            }
        }

        return totalVotos;
    }

}
