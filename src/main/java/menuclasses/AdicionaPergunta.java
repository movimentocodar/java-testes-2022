package menuclasses;

import org.run.Main;
import utilities.MapeadorDePerguntas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import utilities.*;

public class AdicionaPergunta {
    RemoveEspacos removedor = new RemoveEspacos();
    MapeadorDePerguntas mapeador = new MapeadorDePerguntas();
    String caminhoFormulario = "C:\\Go\\src\\github.com\\java-testes-2022\\src\\main\\java\\org\\run\\formulario.txt";
    public void adicionar() throws IOException {

        Map<Integer, String> mapaDePerguntasAtuais = new HashMap<>();

        // Sobrescreverá o texto
        BufferedWriter sobrescritorDeTexto = new BufferedWriter(new FileWriter(caminhoFormulario, true));
        // Vai ler as perguntas
        Scanner leitorPerguntasAtuais = new Scanner(new File(caminhoFormulario));
        // Vai pedir a nova pergunta
        Scanner novaPergunta = new Scanner(System.in);


        //Passar pelo arquivo e gravar todas perguntas para conferir se tem igual
        while (leitorPerguntasAtuais.hasNextLine()){
            String linhaPergunta = leitorPerguntasAtuais.nextLine();
            Integer numeroDaPergunta = mapeador.obterNumeroDaPergunta(linhaPergunta);
            String pergunta = mapeador.obterTextoPergunta(linhaPergunta);
            mapaDePerguntasAtuais.put(numeroDaPergunta, pergunta);
        }

        System.out.println("Digite a nova pergunta:");
        String novaPerguntaEscrita = novaPergunta.nextLine();

        if (mapaDePerguntasAtuais.containsValue(novaPerguntaEscrita)) {
            System.out.println("Não é possível adicionar a mesma pergunta.");
            return ;
        }   else {
                int idDaPerguntaNova = mapaDePerguntasAtuais.size() + 1;
                sobrescritorDeTexto.append("\n"+"P" + idDaPerguntaNova + "|" + novaPerguntaEscrita);
                System.out.println("Pergunta Adicionada com sucesso");
        }

        sobrescritorDeTexto.close();
        leitorPerguntasAtuais.close();
        novaPergunta.close();

        removedor.removerLinhasEmBranco();
        Main.chamarMenuPrincipal();
    }
}

