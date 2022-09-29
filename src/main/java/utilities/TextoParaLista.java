package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class TextoParaLista {

        public static List<String> readFileIntoList(String file) {
            List<String> lines = Collections.emptyList();
            String caminhoFormulario = "C:\\Go\\src\\github.com\\java-testes-2022\\src\\main\\java\\org\\run\\formulario.txt";


            try {
                lines = Files.readAllLines(Paths.get(caminhoFormulario));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return lines;
        }
}