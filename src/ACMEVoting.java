// Imports

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ACMEVoting {

    // Atributos para redirecionamento de E/S
    private PrintStream saidaPadrao = System.out; // Guarda a saida padrao - tela (console)
    private final String nomeArquivoEntrada = "input.txt"; // Nome do arquivo de entrada de dados
    private final String nomeArquivoSaida = "output.txt"; // Nome do arquivo de saida de dados
    private Candidatura candidatura;
    private CadastroPartido cadastroPartido;
    private Scanner entrada = new Scanner(System.in);

    public ACMEVoting() {
        redirecionaEntrada(); // Redireciona Entrada para arquivos
        redirecionaSaida(); // Redireciona Saida para arquivos
        candidatura = new Candidatura();
        cadastroPartido = new CadastroPartido();
    }

    public void executar() {
        cadastraPartido();
        cadastrarCanditato();
        cadastrarVotos();
        buscaPartidoNumero();
        buscaCandidatoNumeroMunicipio();
        buscaPrefeitoNomePartido();
        maiorPartido();
        maisVotados();
        partidoComMaisVotosDeVereadores();
        buscaMunicipioComMaisVotos();

    }

    private void cadastraPartido() {
        int numero;
        String nome;
        Partido p;
        while (true) {
            numero = entrada.nextInt();
            if (numero == -1) {
                break;
            }
            entrada.nextLine(); // limpa buffer do numero
            nome = entrada.nextLine();
            p = new Partido(numero, nome);
            if (cadastroPartido.cadastraPartido(p)) {
                System.out.println("1:" + p.getNumero() + "," + p.getNome());
            }
        }
    }

    private void cadastrarCanditato() {
        int numero;
        String nome;
        String municipio;
        Candidato c;
        Partido partido;
        int numerodoPartido;
        while (true) {
            numero = entrada.nextInt();
            if (numero == -1) {
                break;
            }
            entrada.nextLine(); // limpa buffer do numero
            nome = entrada.nextLine();
            municipio = entrada.nextLine();
            numerodoPartido = Integer.parseInt(Integer.toString(numero).substring(0, 2));
            if (cadastroPartido.buscaPartido(numerodoPartido)) {
                partido = cadastroPartido.consultaPartido(numerodoPartido);
                c = new Candidato(numero, nome, municipio, partido);
                if (candidatura.cadastraCandidato(c)) {
                    partido.adicionaCandidato(c);
                    System.out.println("2:" + c.getNumero() + "," + c.getNome() + "," + c.getMunicipio());
                }
            }
        }
    }

    private void cadastrarVotos() {
        int votos;
        String municipio;
        int numero;
        Candidato c;
        while (true) {
            numero = entrada.nextInt();
            if (numero == -1) {
                break;
            }
            entrada.nextLine(); // limpa o buffer do numero
            municipio = entrada.nextLine();
            votos = entrada.nextInt();
            if (candidatura.buscaCandidatoBoolean(numero, municipio)) {
                c = candidatura.buscaCandidato(numero, municipio);
                c.setVotos(votos);
                System.out.println("3:" + c.getNumero() + "," + c.getMunicipio() + "," + c.getVotos());
            }
        }
    }

    private void buscaPartidoNumero() {
        int numero;
        Partido p;
        numero = entrada.nextInt();
        if (cadastroPartido.buscaPartido(numero)) {
            p = cadastroPartido.consultaPartido(numero);
            System.out.println("4:" + p.getNumero() + "," + p.getNome());
        } else {
            System.out.println("4:Nenhum partido encontrado.");
        }
    }

    private void buscaCandidatoNumeroMunicipio() {
        int numero;
        String municipio;
        Candidato c;
        numero = entrada.nextInt();
        entrada.nextLine(); // limpa buffer do numero
        municipio = entrada.nextLine();
        if (candidatura.buscaCandidatoBoolean(numero, municipio)) {
            c = candidatura.buscaCandidato(numero, municipio);
            System.out.println("5:" + c.getNumero() + "," + c.getNome() + "," + c.getMunicipio() + "," + c.getVotos());
        } else {
            System.out.println("5:Nenhum candidato encontrado.");
        }

    }

    private void buscaPrefeitoNomePartido() {
        ArrayList<Candidato> prefeitosEncontrados = new ArrayList<Candidato>();
        String nomePartido;
        Partido p;
        int numeroDoPartido;
        nomePartido = entrada.nextLine();
        if (cadastroPartido.buscaPartidoNome(nomePartido)) {
            p = cadastroPartido.descobrePartidoNome(nomePartido);
            numeroDoPartido = p.getNumero();
            prefeitosEncontrados = candidatura.buscaPrefeito(numeroDoPartido);
            for (int i = 0; i < prefeitosEncontrados.size(); i++) {
                System.out.println("6:"
                        + nomePartido + ","
                        + prefeitosEncontrados.get(i).getNumero() + ","
                        + prefeitosEncontrados.get(i).getNome() + ","
                        + prefeitosEncontrados.get(i).getMunicipio() + ","
                        + prefeitosEncontrados.get(i).getVotos());
            }
        } else {
            System.out.println("6:Nenhum partido encontrado.");
        }
    }

    private void maiorPartido() {
        Partido maiorPartido = cadastroPartido.buscaMaiorPartido();

        if (maiorPartido == null || maiorPartido.descobreNumeroCandidatos() == 0) {
            System.out.println("7:Nenhum partido com candidatos.");
        } else {
            System.out.println("7:" + maiorPartido.getNumero() + "," + maiorPartido.getNome() + ","
                    + maiorPartido.descobreNumeroCandidatos());
        }
    }

    private void maisVotados() {
        Candidato prefeito = candidatura.prefeitoMaisVotado();
        Candidato vereador = candidatura.vereadorMaisVotado();
        if (prefeito == null) {
            System.out.println("8:Nenhum candidato encontrado.");
        } else if (prefeito.getVotos() == 0) {

        } else {
            System.out.println("8:" + prefeito.getNumero() + ","
                    + prefeito.getNome() + ","
                    + prefeito.getMunicipio() + ","
                    + prefeito.getVotos());
        }

        if (vereador == null) {
            System.out.println("8:Nenhum candidato encontrado.");
        } else if (vereador.getVotos() == 0) {

        } else {
            System.out.println("8:" + vereador.getNumero() + ","
                    + vereador.getNome() + ","
                    + vereador.getMunicipio() + ","
                    + vereador.getVotos());
        }
    }

    private void partidoComMaisVotosDeVereadores() {
        Partido partidoMaisVotado;
        partidoMaisVotado = cadastroPartido.partidoComMaisVotosDeVereadores();
        if (partidoMaisVotado == null) {
            System.out.println("9:Nenhum partido encontrado.");
        } else if (partidoMaisVotado.somaVotosVereadores() == 0) {

        } else {

            System.out.println("9:" + partidoMaisVotado.getNumero() + ","
                    + partidoMaisVotado.getNome() + ","
                    + partidoMaisVotado.somaVotosVereadores());

        }
    }

    private void buscaMunicipioComMaisVotos() {
        String municipioComMaisVotos = candidatura.buscaMunicipioComMaisVotos();
        int totalVotos = candidatura.buscaVotosMunicipioComMaisVotos();

        if (municipioComMaisVotos == null) {
            System.out.println("10:Nenhum município com votos.");
        } else if (totalVotos == 0) {

        } else {
            System.out.println("10:" + municipioComMaisVotos + "," + totalVotos);
        }
    }

    // Redireciona Entrada de dados para arquivos em vez de teclado
    // Chame este metodo para redirecionar a leitura de dados para arquivos
    private void redirecionaEntrada() {
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader(nomeArquivoEntrada));
            entrada = new Scanner(streamEntrada); // Usa como entrada um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH); // Ajusta para ponto decimal
        entrada.useLocale(Locale.ENGLISH); // Ajusta para leitura para ponto decimal
    }

    // Redireciona Saida de dados para arquivos em vez da tela (terminal)
    // Chame este metodo para redirecionar a escrita de dados para arquivos
    private void redirecionaSaida() {
        try {
            PrintStream streamSaida = new PrintStream(new File(nomeArquivoSaida), Charset.forName("UTF-8"));
            System.setOut(streamSaida); // Usa como saida um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH); // Ajusta para ponto decimal
    }

    // Restaura Entrada padrao para o teclado
    // Chame este metodo para retornar a leitura de dados para o teclado
    private void restauraEntrada() {
        entrada = new Scanner(System.in);
    }

    // Restaura Saida padrao para a tela (terminal)
    // Chame este metodo para retornar a escrita de dados para a tela
    private void restauraSaida() {
        System.setOut(saidaPadrao);
    }

}
