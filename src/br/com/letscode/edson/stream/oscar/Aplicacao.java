package br.com.letscode.edson.stream.oscar;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Aplicacao {
    public static void main(String[] args) throws IOException {
        var leitorDeArquivos = new LeitorDeArquivos();

        var atoresPremiados = leitorDeArquivos.lerArquivo(Paths.get("files/oscar_age_male.csv"));
        final var respostasOscar = new RespostasOscar();
        respostasOscar.atorMaisJovem(atoresPremiados)
                .ifPresentOrElse(nomeDoAtor -> System.out.println(nomeDoAtor),
                        () -> System.out.println("O ator mais jovem não foi encontrado"));

        var atrizesPremiadas = leitorDeArquivos
                .lerArquivo(Paths.get("files/oscar_age_female.csv"));
        respostasOscar.atrizMaisPremiada(atrizesPremiadas)
                .ifPresentOrElse(atrizMaisPremiada -> System.out.println(atrizMaisPremiada),
                        () -> System.out.println("Não existe atriz mais premiada"));

//        Não há necessidade de ler o arquivo novamente, pois já fiz acima na linha 17
//        var atrizMaisVencedoraEntre20e30Anos = leitorDeArquivos
//                .lerArquivo(Paths.get("files/oscar_age_female.csv"));
        respostasOscar.atrizMaisVencedoraEntre20e30Anos(atrizesPremiadas)
                .ifPresentOrElse(atrizMaisVencedoraEntre20e30Anos -> System.out.println
                        (atrizMaisVencedoraEntre20e30Anos), () -> System.out.println("Não existe atrizes Premiadas"));

        System.out.println(respostasOscar.atoresAtrizesQueReceberamMaisDeUmOscar(atrizesPremiadas, atoresPremiados));

        System.out.println(respostasOscar
                .resumoDePremios("Jodie Foster", atrizesPremiadas, atoresPremiados));

    }

}
