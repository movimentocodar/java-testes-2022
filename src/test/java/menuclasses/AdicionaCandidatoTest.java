package menuclasses;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import utilities.MapeadorDePerguntas;

import java.io.IOException;

class AdicionaCandidatoTest {
    
    @Test
    void candidatar() throws IOException {
        
        MapeadorDePerguntas dependencia = Mockito.mock(MapeadorDePerguntas.class);

        AdicionaCandidato adicionaCandidato = new AdicionaCandidato();

        adicionaCandidato.candidatar();

        Mockito.verify(dependencia).obterNumeroDaPergunta("1");
    }
}