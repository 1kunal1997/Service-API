package Interview.CodingChallenge.service.conditions;

import Interview.CodingChallenge.model.Item;
import Interview.CodingChallenge.service.CheckService;
import Interview.CodingChallenge.service.Condition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConditionsTest {
    List<Condition> conditions = CheckService.getConditions();
    @Test
    public void test_ItemEligibility() {
        Item eligibleCategory = new Item()
            .setTitle("22k Gold Necklace")
            .setSeller("jeff")
            .setCategory(78945)
            .setPrice(21350.00);

        Item ineligibleCategory = new Item()
            .setTitle("Macbook Pro")
            .setSeller("jeff")
            .setCategory(56921)
            .setPrice(1350.00);
        
        Condition itemChecker = conditions.get(0);
        assertTrue(itemChecker.check(eligibleCategory));
        assertFalse(itemChecker.check(ineligibleCategory));
    }

    @Test
    public void test_PriceEligibility() {
        Item eligiblePrice = new Item()
            .setTitle("Rolex Watch")
            .setSeller("jackmoe")
            .setCategory(654321)
            .setPrice(3000.00);

        Item ineligiblePrice = new Item()
            .setTitle("Nike SB Tiffany")
            .setSeller("johndoe")
            .setCategory(123456)
            .setPrice(50.00);
        
        Condition priceChecker = conditions.get(1);
        assertTrue(priceChecker.check(eligiblePrice));
        assertFalse(priceChecker.check(ineligiblePrice));
    }

    @Test
    public void test_SellerEligibility() {
        Item eligibleSeller = new Item()
            .setTitle("Jordan 11's")
            .setSeller("bob")
            .setCategory(123456)
            .setPrice(1350.00);
            
        Item ineligibleSeller = new Item()
            .setTitle("Patek Watch")
            .setSeller("joshua")
            .setCategory(654321)
            .setPrice(5000.00);
        
        Condition sellerChecker = conditions.get(2);
        assertTrue(sellerChecker.check(eligibleSeller));
        assertFalse(sellerChecker.check(ineligibleSeller));
    }
}