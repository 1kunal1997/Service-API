package Interview.CodingChallenge.service;

import Interview.CodingChallenge.model.Item;

/**
 * Interface to implement when adding a new condition.
 *
 * @author Kunal Lakhanpal
 */

public interface Condition {

    boolean check(Item item);

}