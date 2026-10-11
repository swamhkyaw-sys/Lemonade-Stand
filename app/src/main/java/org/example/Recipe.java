
package org.example;

public class Recipe {

    private int lemons;
    private int sugar;
    private int water;

    public Recipe() {
        lemons = 1;
        sugar = 1;
        water = 1;
    }

    public boolean setRecipe(int lemons , int sugar , int water) {
        if ( lemons <= 0 || sugar <= 0 || water < 0) {
            return false;
        }
        else {
            this.lemons = lemons;
            this.sugar = sugar;
            this.water = water;
            return true;
        }
    }

    public int getLemons() {
        return lemons;
    }

    public int getSugar() {
        return sugar;
    }

    public int getWater() {
        return water;
    }
}
