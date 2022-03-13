package br.com.letscode.edson.stream.oscar;

import java.util.List;

public class ResumoDePremios {
    private int quantidadeDePremios;
    private List<Premio> premios;

    public ResumoDePremios(int quantidadeDePremios, List<Premio> premios) {
        this.quantidadeDePremios = quantidadeDePremios;
        this.premios = premios;
    }

    public int getQuantidadeDePremios() {
        return quantidadeDePremios;
    }

    public List<Premio> getPremios() {
        return premios;
    }

    @Override
    public String toString() {
        return "ResumoDePremios{" +
                "quantidadeDePremios=" + quantidadeDePremios +
                ", premios=" + premios +
                '}';
    }
}
