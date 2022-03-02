package br.com.letscode.edson.stream.oscar;

public class Premio {

    public Premio(int idade, String nomeDoFilme, int anoPremiacao) {
        this.idade = idade;
        this.nomeDoFilme = nomeDoFilme;
        this.anoPremiacao = anoPremiacao;
    }

    private final int idade;
    private final String nomeDoFilme;
    private final int anoPremiacao;

    @Override
    public String toString() {
        return "Premio{" +
                "idade=" + idade +
                ", nomeDoFilme='" + nomeDoFilme + '\'' +
                ", anoPremiacao=" + anoPremiacao +
                '}';
    }
}
