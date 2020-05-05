package Interview.CodingChallenge.controller;

import Interview.CodingChallenge.CodingChallengeApplication;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Entity;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientControllerTest extends JerseyTest {

    private static final String PATH = "/item";
    
    @Test
    public void test_itemCheck() {
        final String TEST_ITEMS = "src/test/java/Interview/" +
        "CodingChallenge/controller/TestItemsController.JSON";

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(TEST_ITEMS))
        {
            JSONArray itemList = (JSONArray)jsonParser.parse(reader);
            Iterator<?> iterator = itemList.iterator();
            while (iterator.hasNext()) {

                JSONObject jsonItem = (JSONObject)iterator.next();
                Response response = target(PATH).request().post(Entity.entity(
                    jsonItem, MediaType.APPLICATION_JSON));

                assertEquals(HttpStatus.OK_200.getStatusCode(), response.getStatus());
                assertEquals(MediaType.APPLICATION_JSON, response.getMediaType().toString());
                String actual = jsonItem.get("eligible").toString();
                assertEquals(actual, response.readEntity(String.class));
            }
            
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Application configure() {
        final ApplicationContext context = new AnnotationConfigApplicationContext(CodingChallengeApplication.class);
        return new ResourceConfig(ClientController.class).property("contextConfig", context);
    }
}