package menuclasses;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.run.Main;
import utilities.*;

public class RemovePergunta {

    String caminhoFormulario = "C:\\Go\\src\\github.com\\java-testes-2022\\src\\main\\java\\org\\run\\formulario.txt";
    MapeadorDePerguntas mapeador = new MapeadorDePerguntas();
    RemoveEspacos removedorEspacos = new RemoveEspacos();

    public void remover() throws IOException {
        Map<Integer, String> mapaDePerguntas = new HashMap<>();

        Scanner apagadorDePerguntas = new Scanner(new File(caminhoFormulario));
        Scanner capturaNumeroDaPerguntaParaRemover = new Scanner(System.in);
        Scanner scannerLeitorDePerguntas = new Scanner(new File(caminhoFormulario));
        File file = new File(caminhoFormulario);

        while (scannerLeitorDePerguntas.hasNextLine()){
            String linhaPergunta = scannerLeitorDePerguntas.nextLine();
            if (!linhaPergunta.isEmpty()){
                Integer numeroDaPergunta = mapeador.obterNumeroDaPergunta(linhaPergunta);
                String pergunta = mapeador.obterTextoPergunta(linhaPergunta);
                mapaDePerguntas.put(numeroDaPergunta, pergunta);
            }
        }

        for (Integer key: mapaDePerguntas.keySet()) {
            System.out.println(key + mapaDePerguntas.get(key));
        }

        System.out.println("Escolha uma pergunta para remover, exceto de 1 a 4:");
        System.out.println(mapaDePerguntas.keySet());

        int idDaRemocao = capturaNumeroDaPerguntaParaRemover.nextInt();

        if (idDaRemocao < 4) {
            System.out.println("Não é possível remover perguntas padrões");
            Main.chamarMenuPrincipal();
        } else {
            String perguntaRemovida = mapaDePerguntas.get(idDaRemocao);
            System.out.println("A pergunta - " + mapaDePerguntas.get(idDaRemocao) + " foi removida.");

            List<String> out = Files.lines(file.toPath())
                    .filter(line -> !line.contains(perguntaRemovida))
                    .collect(Collectors.toList());
            Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        }

        scannerLeitorDePerguntas.close();
        capturaNumeroDaPerguntaParaRemover.close();
        apagadorDePerguntas.close();

        removedorEspacos.removerLinhasEmBranco();
        Main.chamarMenuPrincipal();
    }
}
