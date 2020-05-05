package Interview.CodingChallenge.service;

import Interview.CodingChallenge.model.Item;
import Interview.CodingChallenge.service.conditions.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CheckService {

    public static boolean incorrectInputs(Item item) {
        return (item.getTitle() == null || item.getSeller() == null ||
            item.getCategory() == -1 || item.getPrice() == -1);
    }

    public static boolean checkEligibility(Item item) {
        if(incorrectInputs(item))
            return false;
        for (Condition c : getConditions())
            if (!c.check(item))
                return false;

        return true;
    }

    // New conditions get added here.
    public static List<Condition> getConditions() {

        return Arrays.asList(
            new CategoryEligibility(),
            new PriceEligibility(),
            new SellerEligibility()
        );
    }
}