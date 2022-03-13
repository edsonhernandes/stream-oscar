package br.com.letscode.edson.stream.oscar;

import java.time.Year;

public class PremiacaoOscar {
    private Year anoDaPremiacao;
    private int idade;
    private String nomeDoArtista;
    private String nomeDoFilme;

    public PremiacaoOscar(Year anoDaPremiacao, int idade, String nomeDoArtista, String nomeDoFilme) {
        this.anoDaPremiacao = anoDaPremiacao;
        this.idade = idade;
        this.nomeDoArtista = nomeDoArtista;
        this.nomeDoFilme = nomeDoFilme;
    }

    public Year getAnoDaPremiacao() {
        return anoDaPremiacao;
    }

    public int getIdade() {
        return idade;
    }

    public String getNomeDoArtista() {
        return nomeDoArtista;
    }

    public String getNomeDoFilme() {
        return nomeDoFilme;
    }

    @Override
    public String toString() {
        return "PremiacaoOscar{" +
                "anoDaPremiacao=" + anoDaPremiacao +
                ", idade=" + idade +
                ", nomeDoArtista='" + nomeDoArtista + '\'' +
                ", nomeDoFilme='" + nomeDoFilme + '\'' +
                '}';
    }
}

