package menuclasses;

import org.run.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class PesquisaCandidato {
    String caminhoModels = "C:\\Go\\src\\github.com\\java-testes-2022\\src\\main\\java\\models\\";

    TreeMap<String,String> listaComNomeeEmail = new TreeMap<>();
    public void pesquisar() throws IOException {

        File diretorioDeTodosFormularios = new File(caminhoModels);

        File [] superLista = diretorioDeTodosFormularios.listFiles();

        for (File arquivo : superLista) {
            BufferedReader br = new BufferedReader(new FileReader(diretorioDeTodosFormularios +"/"+  arquivo.getName()));
            String linha = "";
            List<String> lista = new ArrayList<>();

            while (linha != null) {
                linha = br.readLine();
                if (linha != null && !linha.equals("")) {
                    lista.add(linha.toLowerCase());
                }
            }
            listaComNomeeEmail.put(lista.get(0),lista.get(1));

            br.close();
        }

        Scanner textoPesquisa = new Scanner(System.in);

        listaComNomeeEmail.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));

        System.out.println("Digite aqui o Nome do candidato (com letras minúsculas) que deseja procurar:");
        String pesquisadorDeNomeFormularios = textoPesquisa.nextLine();

       System.out.println("Digite aqui o Email do candidato que deseja procurar:");
       String pesquisadorDeEmailFormularios = textoPesquisa.nextLine();

        listaComNomeeEmail.forEach((k, v) -> {
            if (k.equals(pesquisadorDeNomeFormularios) && v.equals(pesquisadorDeEmailFormularios)) {
                    System.out.println("Key : " + k + ", Value : " + v);}
        });

        textoPesquisa.close();
        Main.chamarMenuPrincipal();
    }
}
