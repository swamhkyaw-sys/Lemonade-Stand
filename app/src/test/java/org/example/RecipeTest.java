
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipeTest {

    @Test
    void testStartingRecipe() {
        Recipe recipe = new Recipe();

        assertEquals(1 , recipe.getLemons());
        assertEquals(1 , recipe.getSugar());
        assertEquals(1 , recipe.getWater());
    }

    @Test
    void testChangeRecipe() {
        Recipe recipe = new Recipe();

        recipe.setRecipe(5 , 2 , 6);

        assertEquals(5 , recipe.getLemons());
        assertEquals(2 , recipe.getSugar());
        assertEquals(6 , recipe.getWater());
    }

    @Test
    void testNegativeLemons() {
        Recipe recipe = new Recipe();

        assertEquals(false , recipe.setRecipe(-1 , 2 , 6));
    }

    @Test
    void testNegativeSugar() {
        Recipe recipe = new Recipe();

        assertEquals(false , recipe.setRecipe(5 , -2 , 6));
    }

    @Test
    void testNegativeWater() {
        Recipe recipe = new Recipe();

        assertEquals(false , recipe.setRecipe(5 , 2 , -6));
    }

    @Test
    void testZeroLemons() {
        Recipe recipe = new Recipe();

        assertEquals(false , recipe.setRecipe(0 , 2 , 6));
    }

    @Test
    void testZeroSugar() {
        Recipe recipe = new Recipe();

        assertEquals(false , recipe.setRecipe(5 , 0 , 6));
    }
}
