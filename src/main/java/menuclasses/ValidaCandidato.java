package menuclasses;

import org.run.Main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ValidaCandidato {
    static List<String> listaComTodosNomesEEmails = new ArrayList<>();
    String caminhoModels = "C:\\Go\\src\\github.com\\java-testes-2022\\src\\main\\java\\models\\";

    public void validar() throws IOException {
        File diretorioDeTodosFormularios = new File(caminhoModels);

        File [] superLista = diretorioDeTodosFormularios.listFiles();
        for (File arquivo : superLista) {
            BufferedReader br = new BufferedReader(new FileReader(diretorioDeTodosFormularios +"/"+  arquivo.getName()));
            String linha = "";
            List<String> lista = new ArrayList<>();
            while (linha != null) {
                linha = br.readLine();
                if (linha != null && !linha.equals("")) {
                    lista.add(linha);
                }
            }
            listaComTodosNomesEEmails.add(lista.get(0) + " | " + lista.get(1));
            br.close();
        }
        exibeFormulariosDuplicados();
        Main.chamarMenuPrincipal();
    }
    private void exibeFormulariosDuplicados() {
        for (int i = 0; i < listaComTodosNomesEEmails.size(); i++)
            for (int j = i + 1; j < listaComTodosNomesEEmails.size(); j++) {
                if (listaComTodosNomesEEmails.get(i).equals(listaComTodosNomesEEmails.get(j))) {
                    System.out.println("O formulário:\n " + i + " - " + listaComTodosNomesEEmails.get(i) + "\n" +
                            "É duplicado com o formulário \n " + j + " - " + listaComTodosNomesEEmails.get(j));
                }
            }
    }
}