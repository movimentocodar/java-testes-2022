package utilities;

import java.io.File;

public class ContadorDeFormularios {
    String caminhoFormulario = "C:\\Go\\src\\github.com\\java-testes-2022\\src\\main\\java\\models";

    public String contadorDeArquivos() {
        File arquivo = new File(caminhoFormulario);

        // Carrega todos os arquivos em um vetor
        File[] arquivos = arquivo.listFiles();

        // Conta quantos arquivos tem no vetor
           return Integer.toString(arquivos.length +1);
    }
}