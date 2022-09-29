package utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
//import java.poi.*;

public class RemoveEspacos {
    String caminhoFormulario = "C:\\Go\\src\\github.com\\java-testes-2022\\src\\main\\java\\org\\run\\formulario.txt";

    public void removerLinhasEmBranco() throws IOException {

        File arquivoVelho = new File(caminhoFormulario);
        Scanner deleter = new Scanner(arquivoVelho);
        String linhaPreenchida = "";

        while (deleter.hasNextLine()) {
            //Pega a próxima linha vazia e guarda em uma string
            String currentLine = deleter.nextLine();
            //Se a linha for preenchida
            if (!currentLine.isBlank()) {
                //Adiciona a linha preenchida à string linhaPreenchida
                linhaPreenchida += currentLine + System.lineSeparator(); //adds it to nonblankdata
            }
        }
        PrintWriter writer = new PrintWriter(new FileWriter(caminhoFormulario));
        writer.print(linhaPreenchida); //print the nonBlankData to the file
        writer.close();
        deleter.close();
    }

}
