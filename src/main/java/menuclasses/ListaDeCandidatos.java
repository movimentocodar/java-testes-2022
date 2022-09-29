package menuclasses;

import org.run.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ListaDeCandidatos {
    String caminhoModels = "C:\\Go\\src\\github.com\\java-testes-2022\\src\\main\\java\\models\\";

    public void listarCandidatos() throws IOException {

        File diretorioDeTodosFormularios = new File(caminhoModels);
        List<List<String>> listaComTodosFormularios = new ArrayList<>();
        File [] superLista = diretorioDeTodosFormularios.listFiles();

        for (File arquivo : superLista) {
            BufferedReader br = new BufferedReader(new FileReader(diretorioDeTodosFormularios +"/"+  arquivo.getName()));
            List<String> lista = new ArrayList<>();
            String linha = "";
            while (linha != null) {
                linha = br.readLine();
                if (linha != null && !linha.equals("")) {
                    lista.add(linha);
                }
            }
            listaComTodosFormularios.add(lista);
            br.close();
        }

        Scanner opcao = new Scanner(System.in);

        System.out.println("Digite 1 para listar candidatos agrupados por idade ou 2 para listar cada candidato e sua idade");
        int escolha = opcao.nextInt();

        switch (escolha){
            case 1:
                System.out.println("Candidatos agrupados por idade");
                listaComTodosFormularios.sort(Comparator.comparing(idade2 -> idade2.get(2)));
                System.out.println("Idade | Nomes");
                listaComTodosFormularios.forEach(nome -> System.out.println(nome.get(2) + " | " + nome.get(0)));
                break;

            case 2:
                listaComTodosFormularios.sort(Comparator.comparing(idade2 -> idade2.get(2)));
                System.out.println("Nome | Idade");
                listaComTodosFormularios.forEach(nome -> System.out.println(nome.get(0) + " | " + nome.get(2)));
                break;
        }
        opcao.close();
        Main.chamarMenuPrincipal();
    }
    }



