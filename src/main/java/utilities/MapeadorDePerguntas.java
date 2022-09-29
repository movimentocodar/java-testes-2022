package utilities;

public class MapeadorDePerguntas {

    public Integer obterNumeroDaPergunta(String pergunta) {
        pergunta = pergunta.substring(pergunta.indexOf("P") + 1);
        pergunta = pergunta.substring(0, pergunta.indexOf("|"));
        return Integer.parseInt(pergunta);
    }

    public String obterTextoPergunta(String pergunta) {
        pergunta = pergunta.substring(pergunta.indexOf("|") + 1);
        pergunta = pergunta.substring(0, pergunta.indexOf("?"));
        StringBuilder perguntaBuilder = new StringBuilder(pergunta).append("?");
        return perguntaBuilder.toString();
    }
}
