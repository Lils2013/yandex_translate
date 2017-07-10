package alexander.tsoy;

import static org.junit.Assert.*;

public class TranslatorTest {
    @org.junit.Test
    public void translate() throws Exception {
        assertEquals(Translator.translate("hello my name is alexander").get(0),"Здравствуйте, меня зовут Александр");
    }

    @org.junit.Test
    public void translateNull() throws Exception {
        assertEquals(Translator.translate(""),null);
    }
}