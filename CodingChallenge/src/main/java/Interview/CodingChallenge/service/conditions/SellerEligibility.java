package Interview.CodingChallenge.service.conditions;

import Interview.CodingChallenge.model.Item;
import Interview.CodingChallenge.service.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Checks if the seller of the item is enrolled in the
 * shipping program.
 * 
 * @field  SELLER_LIST   JSON file that stores the enrolled
 *                       sellers
 *
 * @author Kunal Lakhanpal
 */

public class SellerEligibility implements Condition {
    private final String SELLER_LIST = "src/main/java/Interview/" +
        "CodingChallenge/service/conditions/EnrolledSellers.JSON";

    public boolean check(Item item) {
        String sellerName = item.getSeller();
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(SELLER_LIST))
        {
            JSONArray sellerList = (JSONArray)jsonParser.parse(reader);
            Iterator<?> iterator = sellerList.iterator();
            while (iterator.hasNext()) {
                if (sellerName.equals(iterator.next()))
                    return true;
            }
            return false;
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}