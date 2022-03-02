package br.com.letscode.edson.stream.oscar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOscar {
    public static void main(String[] args) throws IOException {
        final var streamOscar = new StreamOscar();
        var atorMaisNovo = streamOscar.lerArquivo(Path.of("files/oscar_age_male.csv"))
                .stream()
                .min(Comparator.comparing(ator -> ator.split(";")[2]))
                .map(linha -> linha.split("; ")[3] + " " + linha.split("; ")[2]);
        atorMaisNovo.ifPresent(System.out::println);

        var maiorQuantidadeDePremios = streamOscar.lerArquivo(Paths.get("files/oscar_age_female.csv"))
                .stream()
                .map(linha -> linha.split("; "))
                .filter(linha -> Integer.parseInt(linha[2]) >= 20 && Integer.parseInt(linha[2]) <= 30)
                .collect(Collectors.groupingBy(linha -> linha[3]))
                .entrySet()
                .stream()
                .max(Comparator.comparing(entry -> entry.getValue().size()))
                .map(it -> it.getValue().size())
                .orElse(-1);

        var atrizMaisPremiadaEntre20e30 = streamOscar.lerArquivo(Paths.get("files/oscar_age_female.csv"))
                .stream()
                .map(linha -> linha.split("; "))
                .filter(linha -> Integer.parseInt(linha[2]) >= 20 && Integer.parseInt(linha[2]) <= 30)
                .collect(Collectors.groupingBy(linha -> linha[3]))
                .entrySet()
                .stream()
                .filter(it -> it.getValue().size() == maiorQuantidadeDePremios)
                .map(it -> it.getKey())
                .collect(Collectors.toList());

        System.out.println(atrizMaisPremiadaEntre20e30);

        var vencedoresMaisDeUmaVez = Stream.concat(streamOscar.lerArquivo(Paths.get("files/oscar_age_female.csv")).stream(),
                streamOscar.lerArquivo(Paths.get("files/oscar_age_male.csv")).stream())
                .map(linha -> linha.split("; "))
                .collect(Collectors.groupingBy(linha -> linha[3]))
                .entrySet()
                .stream()
                .filter(it -> it.getValue().size() >= 2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(vencedoresMaisDeUmaVez);

        var nome = "Luise Rainer";
        var premiosDaAtriz = Stream.concat(streamOscar.lerArquivo(Paths.get("files/oscar_age_female.csv")).stream(),
                streamOscar.lerArquivo(Paths.get("files/oscar_age_male.csv")).stream())
                .map(linha -> linha.split("; "))
                .filter(it -> it[3].equals(nome))
                .collect(Collectors.toList());

        var numeroDePremios = premiosDaAtriz.size();

        var premios = premiosDaAtriz.stream()
                .map(it -> new Premio(Integer.parseInt(it[2]), it[4], Integer.parseInt(it[1])))
                .collect(Collectors.toList());

        System.out.println(numeroDePremios + " " + premios);



    }
    public List<String> lerArquivo(Path path) throws IOException {
        try (var linhas = Files.lines(path).skip(1)) {
            return linhas.collect(Collectors.toList());
        }
    }
}
