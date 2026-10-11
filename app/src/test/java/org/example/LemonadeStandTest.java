
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LemonadeStandTest {

    @Test
    void testStartingCash() {
        LemonadeStand stand = new LemonadeStand();

        assertEquals(10000 , stand.getCash());
    }

    @Test
    void testStartingIngredients() {
        LemonadeStand stand = new LemonadeStand();

        assertEquals(0 , stand.getLemons());
        assertEquals(0 , stand.getSugar());
        assertEquals(0 , stand.getPitchers());
    }

    @Test
    void testBuyLemons() {
        LemonadeStand stand = new LemonadeStand();

        stand.buyIngredients(10 , 0);

        assertEquals(10 , stand.getLemons());
        assertEquals(9000 , stand.getCash());
    }

    @Test
    void testBuySugar() {
        LemonadeStand stand = new LemonadeStand();

        stand.buyIngredients(0 , 10);

        assertEquals(10 , stand.getSugar());
        assertEquals(9500 , stand.getCash());
    }

    @Test
    void testBuyBothIngredients() {
        LemonadeStand stand = new LemonadeStand();

        stand.buyIngredients(50 , 40);

        assertEquals(50 , stand.getLemons());
        assertEquals(40 , stand.getSugar());
        assertEquals(3000 , stand.getCash());
    }

    @Test
    void testNotEnoughMoney() {
        LemonadeStand stand = new LemonadeStand();

        assertEquals(false , stand.buyIngredients(200 , 50));
        assertEquals(10000 , stand.getCash());
        assertEquals(0 , stand.getLemons());
    }

    @Test
    void testNegativeIngredients() {
        LemonadeStand stand = new LemonadeStand();

        assertEquals(false , stand.buyIngredients(-5 , 10));
    }

    @Test
    void testSetPrice() {
        LemonadeStand stand = new LemonadeStand();

        stand.setPrice(250);

        assertEquals(250 , stand.getPrice());
    }

    @Test
    void testNegativePrice() {
        LemonadeStand stand = new LemonadeStand();

        assertEquals(false , stand.setPrice(-100));
    }

    @Test
    void testMakePitchers() {
        LemonadeStand stand = new LemonadeStand();

        stand.buyIngredients(50 , 40);
        stand.getRecipe().setRecipe(5 , 2 , 6);
        stand.makePitchers(8);

        assertEquals(8 , stand.getPitchers());
        assertEquals(10 , stand.getLemons());
        assertEquals(24 , stand.getSugar());
    }

    @Test
    void testNotEnoughIngredients() {
        LemonadeStand stand = new LemonadeStand();

        stand.buyIngredients(5 , 2);
        stand.getRecipe().setRecipe(5 , 2 , 6);

        assertEquals(false , stand.makePitchers(2));
        assertEquals(0 , stand.getPitchers());
    }

    @Test
    void testNegativePitchers() {
        LemonadeStand stand = new LemonadeStand();

        assertEquals(false , stand.makePitchers(-2));
    }

    @Test
    void testSellLemonade() {
        LemonadeStand stand = new LemonadeStand();

        stand.buyIngredients(10 , 10);
        stand.makePitchers(5);

        int sold = stand.sellLemonade(30);

        assertEquals(30 , sold);
        assertEquals(11500 , stand.getCash());
    }

    @Test
    void testSoldOut() {
        LemonadeStand stand = new LemonadeStand();

        stand.buyIngredients(2 , 2);
        stand.makePitchers(2);

        int sold = stand.sellLemonade(100);

        assertEquals(16 , sold);
        assertEquals(11300 , stand.getCash());
    }

    @Test
    void testLeftoverLemonade() {
        LemonadeStand stand = new LemonadeStand();

        stand.buyIngredients(10 , 10);
        stand.makePitchers(5);

        stand.sellLemonade(10);

        assertEquals(0 , stand.getPitchers());
    }

    @Test
    void testNoLemonade() {
        LemonadeStand stand = new LemonadeStand();

        int sold = stand.sellLemonade(50);

        assertEquals(0 , sold);
        assertEquals(10000 , stand.getCash());
    }
}
