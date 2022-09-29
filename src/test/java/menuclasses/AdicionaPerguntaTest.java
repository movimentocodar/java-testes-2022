package menuclasses;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import utilities.RemoveEspacos;

import java.io.IOException;

class AdicionaPerguntaTest {

    @Test
    void adicionar() throws IOException {

        RemoveEspacos dependencia = Mockito.mock(RemoveEspacos.class);

        AdicionaPergunta adicionarPergunta = new AdicionaPergunta();

        adicionarPergunta.adicionar();

        Mockito.verify(dependencia).removerLinhasEmBranco();

    }
}