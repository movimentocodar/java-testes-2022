package utilities;

import java.text.Normalizer;
import java.util.Locale;


public class PadronizadorDeTexto {
    public String padronizadorDeTexto (String string) {
        if (string != null){
            string = Normalizer.normalize(string, Normalizer.Form.NFD);
            string = string.replaceAll("[^\\p{ASCII}]", "");
            string = string.toUpperCase(Locale.forLanguageTag(string));
            string = string.replaceAll("\\s+","");
        }
        return string;
    }
}