
import java.util.ArrayList;

public class Partido {

    private int numero;
    private String nome;
    private ArrayList<Candidato> candidatos;

    public Partido(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
        candidatos = new ArrayList<Candidato>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean buscaPartido(int numero) {
        for (int i = 0; i < candidatos.size(); i++) {
            if (candidatos.get(i).getNumero() == numero) {
                return true;
            }
        }
        return false;
    }

    public void adicionaCandidato(Candidato c) {
        candidatos.add(c);
    }

    public int descobreNumeroCandidatos() {
        return candidatos.size();
    }

    public int somaVotosVereadores() {
        int soma = 0;
        Candidato candidatoAtual;
        for (int i = 0; i < candidatos.size(); i++) {
            candidatoAtual = candidatos.get(i);

            if (candidatoAtual.getNumero() > 9_999 && candidatoAtual.getNumero() < 100_000) {
                soma = soma + candidatoAtual.getVotos();
            }
        }

        return soma;
    }

}
