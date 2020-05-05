package Interview.CodingChallenge.service;

import Interview.CodingChallenge.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckServiceTest {

    @Test
    public void test_IncorrectInputs() {
        Item correctItem = new Item()
            .setTitle("RayBans Sunglasses")
            .setSeller("bob")
            .setCategory(54832)
            .setPrice(95.50); 
        Item incorrectItem = new Item()
            .setTitle("Gold keychain")
            .setCategory(329596)
            .setPrice(40.0); 

        assertFalse(CheckService.incorrectInputs(correctItem));
        assertTrue(CheckService.incorrectInputs(incorrectItem));
    }

    @Test
    public void test_checkEligibility() {
        final String TEST_ITEMS = "src/test/java/Interview/" +
        "CodingChallenge/service/TestItemsCheckService.JSON";

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(TEST_ITEMS))
        {
            JSONObject jsonObject = (JSONObject)jsonParser.parse(reader);
            JSONArray itemList = (JSONArray)jsonObject.get("list");
            for (int i = 0; i < itemList.size(); i++) {
                JSONObject jsonItem = (JSONObject)itemList.get(i);
                Item item = new Item()
                    .setTitle((String)jsonItem.get("title"))
                    .setSeller((String)jsonItem.get("seller"))
                    .setCategory(((Long)jsonItem.get("category")).intValue())
                    .setPrice((double)jsonItem.get("price"));

                assertEquals(CheckService.checkEligibility(item), 
                    (boolean)jsonItem.get("eligible"));
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
}