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
 * Checks if the item is from a pre-approved category.
 * 
 * @field  CATEGORY_LIST   JSON file that stores the pre-
 *                         approved categories
 *
 * @author Kunal Lakhanpal
 */

public class CategoryEligibility implements Condition {
    private final String CATEGORY_LIST = "src/main/java/Interview/" +
        "CodingChallenge/service/conditions/ItemCategories.JSON";

    public boolean check(Item item) {
        int sellerCategory = item.getCategory();
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(CATEGORY_LIST))
        {
            JSONArray categoryList = (JSONArray)jsonParser.parse(reader);
            Iterator<?> iterator = categoryList.iterator();
            while (iterator.hasNext()) {
                int eligibleCategory = ((Long)iterator.next()).intValue();
                if (sellerCategory == eligibleCategory)
                    return true;
            }

            return false;
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

        return false;
    }
}