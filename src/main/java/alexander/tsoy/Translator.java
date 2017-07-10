package alexander.tsoy;

import alexander.tsoy.utility.TranslatedUnit;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

public class Translator {

    public static List<String> translate(String input) throws IOException {
        Form form = new Form();
        form.param("text", input);
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("https://translate.yandex.net/api/v1.5/tr.json/translate?lang=en-ru&" +
                "key=trnsl.1.1.20170707T134347Z.24c0119241386287.784ce97152ae73e1606ce269cb1c3d304cb70d3a");
        Response response = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
        if (response.getStatusInfo().getFamily() == Response.Status.Family.SUCCESSFUL) {
            String jsonResult = response.readEntity(String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            TranslatedUnit translatedUnit = objectMapper.readValue(jsonResult,TranslatedUnit.class);
            return translatedUnit.getText();
        } else {
            return null;
        }
    }
}
