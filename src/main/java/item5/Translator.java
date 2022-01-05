package item5;

/**
 * packageName : item5
 * fileName : Translator
 * author : haedoang
 * date : 2022-01-05
 * description :
 */
public class Translator {

    private final Translate translator;

    public Translator(Translate translator) {
        this.translator = translator;
    }


    public String translate(String str) {
        return this.translator.translate(str);
    }

}
