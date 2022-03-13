package br.com.letscode.edson.stream.oscar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

public class LeitorDeArquivos {

    public List<PremiacaoOscar> lerArquivo(Path path) throws IOException {
        try (var stream = Files.lines(path)){
            return stream
                    .skip(1)
                    .map(linha -> linha.split("; "))
                    .map(linha -> new PremiacaoOscar(Year.parse(linha[1]),
                            Integer.parseInt(linha[2]), linha[3], linha[4]))
                    .collect(Collectors.toList());

        }


    }
}
