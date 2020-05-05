package Interview.CodingChallenge.service.conditions;

import Interview.CodingChallenge.model.Item;
import Interview.CodingChallenge.service.Condition;

/**
 * Checks if the item has a price greater than or equal to
 * some minimum amount.
 * 
 * @author Kunal Lakhanpal
 */

public class PriceEligibility implements Condition {
    private final double PRICE_THRESHOLD = 100.0;

    public boolean check(Item item) {
        return item.getPrice() >= PRICE_THRESHOLD;
    }
}