package menuclasses;

import org.run.Main;
import utilities.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AdicionaCandidato {
        ContadorDeFormularios contador = new ContadorDeFormularios();
        PadronizadorDeTexto padronizador = new PadronizadorDeTexto();
        MapeadorDePerguntas mapeador = new MapeadorDePerguntas();
        String retornoEmString = contador.contadorDeArquivos();
        String caminhoFormulario = "C:\\Go\\src\\github.com\\java-testes-2022\\src\\main\\java\\org\\run\\formulario.txt";
        String caminhoModels = "C:\\Go\\src\\github.com\\java-testes-2022\\src\\main\\java\\models\\";



        public void candidatar() throws IOException {

        Map <Integer, String> mapaDePerguntas = new HashMap<>();
        Map<Integer, String> mapaDeRespostas = new HashMap<>();

        Scanner scannerLeitorDePerguntas = new Scanner(new File(caminhoFormulario));
        Scanner scannerCapturaResposta = new Scanner(System.in);

        while (scannerLeitorDePerguntas.hasNextLine()){
               String linhaPergunta = scannerLeitorDePerguntas.nextLine();
               if (!linhaPergunta.isEmpty()){
                       Integer numeroDaPergunta = mapeador.obterNumeroDaPergunta(linhaPergunta);
                       String pergunta = mapeador.obterTextoPergunta(linhaPergunta);
                       mapaDePerguntas.put(numeroDaPergunta, pergunta);
               }
        }

        //For each e criação do MAPA para ler cada linha do TXT de perguntas e respostas.
        mapaDePerguntas.forEach((k,v)-> {
                System.out.println(v);
                String resposta = scannerCapturaResposta.nextLine();
                if (k.equals(3) && Integer.parseInt(resposta) < 16) {
                        String respostaIdade;
                        do {
                                System.out.println("Idade Incorreta Preencha Novamente");
                                respostaIdade = scannerCapturaResposta.nextLine();
                        } while (Integer.parseInt(respostaIdade) < 16);
                        resposta = respostaIdade;
                }
                mapaDeRespostas.put(k, resposta);
        });
        // Cria o nome padrão pro arquivo e gera o txt.
        String nomeDoArquivo = retornoEmString + " - " + padronizador.padronizadorDeTexto(mapaDeRespostas.get(1)) + ".txt";
        PrintWriter gravadorDeTXT = new PrintWriter(caminhoModels + nomeDoArquivo, "UTF-8");

        //Adiciona o conteúdo ao txt do candidato.
        List<String> respostasCandidato = mapaDeRespostas.values().stream().toList();
        StringBuilder formatadorDaListaAparaGravar = new StringBuilder();
        respostasCandidato.forEach(x -> {
                formatadorDaListaAparaGravar.append(x+"\n");
        });
        gravadorDeTXT.print(formatadorDaListaAparaGravar);

        //Fecha os scanners e chama o menu principal

        gravadorDeTXT.close();
        scannerCapturaResposta.close();
        scannerLeitorDePerguntas.close();
        Main.chamarMenuPrincipal();

        }

}
