package br.com.letscode.edson.stream.oscar;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RespostasOscar {
    Optional<String> atorMaisJovem(List<PremiacaoOscar> atoresPremiados){
        return atoresPremiados.stream()
                .min(Comparator.comparingInt(premiacaoOscar -> premiacaoOscar.getIdade()))
                .map(premiacaoOscar -> premiacaoOscar.getNomeDoArtista());

    }

    Optional<String> atrizMaisPremiada(List<PremiacaoOscar> atrizesPremiadas) {
        return atrizesPremiadas.stream()
                .collect(Collectors.groupingBy(atriz -> atriz.getNomeDoArtista()))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(premiacoesPorAtriz -> premiacoesPorAtriz.getValue().size()))
                .map(atrizMaisPremiada -> atrizMaisPremiada.getKey());

    }

    Optional<String> atrizMaisVencedoraEntre20e30Anos(List<PremiacaoOscar> atrizesVencedoras) {
        return atrizesVencedoras.stream()
                .filter(atrizPremiada -> atrizPremiada.getIdade() >= 20 && atrizPremiada.getIdade() <= 30)
                .collect(Collectors.groupingBy(atrizPremiada -> atrizPremiada.getNomeDoArtista()))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(premiacao -> premiacao.getValue().size()))
                .map(atrizMaisVencedoraEntre20e30Anos -> atrizMaisVencedoraEntre20e30Anos.getKey());
    }

    List<String> atoresAtrizesQueReceberamMaisDeUmOscar(List<PremiacaoOscar> atrizesPremiadas,
                                                        List<PremiacaoOscar> atoresPremiados){
        return Stream.concat(atrizesPremiadas.stream(), atoresPremiados.stream())
                .collect(Collectors.groupingBy(artistaPremiado -> artistaPremiado.getNomeDoArtista() ))
                .entrySet()
                .stream()
                .filter(premiacoesPorArtista -> premiacoesPorArtista.getValue().size() > 1)
                .map(premiacaoPorArtista -> premiacaoPorArtista.getKey())
                .sorted()
                .collect(Collectors.toList());
    }

    ResumoDePremios resumoDePremios(String nomeDoArtista, List<PremiacaoOscar> atrizesPremiadas,
                                    List<PremiacaoOscar> atoresPremiados){
        List<Premio> listaDePremios = Stream.concat(atrizesPremiadas.stream(), atoresPremiados.stream())
                .filter(premiacaoOscar -> premiacaoOscar.getNomeDoArtista().equals(nomeDoArtista))
                .map(premiacaoOscar -> new Premio(premiacaoOscar.getIdade(), premiacaoOscar.getNomeDoFilme(),
                        premiacaoOscar.getAnoDaPremiacao().getValue()))
                .collect(Collectors.toList());

        return new ResumoDePremios(listaDePremios.size(), listaDePremios);
    }
}
