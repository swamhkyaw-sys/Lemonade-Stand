
package org.example;

public class LemonadeStand {

    private int cash;
    private int lemons;
    private int sugar;
    private int pitchers;
    private int price;

    private Recipe recipe;

    public LemonadeStand() {
        cash = 10000;
        lemons = 0;
        sugar = 0;
        pitchers = 0;
        price = 100;
        recipe = new Recipe();
    }

    public int getCash() {
        return cash;
    }

    public int getLemons() {
        return lemons;
    }

    public int getSugar() {
        return sugar;
    }

    public int getPitchers() {
        return pitchers;
    }

    public int getPrice() {
        return price;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public boolean buyIngredients(int newLemons , int newSugar) {
        if ( newLemons < 0 || newSugar < 0) {
            return false;
        }

        long cost = (long) newLemons * 100 + (long) newSugar * 50;

        if ( cost > cash) {
            return false;
        }

        if ( (long) lemons + newLemons > Integer.MAX_VALUE || (long) sugar + newSugar > Integer.MAX_VALUE) {
            return false;
        }

        cash = cash - (int) cost;
        lemons = lemons + newLemons;
        sugar = sugar + newSugar;

        return true;
    }

    public boolean setPrice(int newPrice) {
        if ( newPrice <= 0) {
            return false;
        }

        price = newPrice;
        return true;
    }

    public boolean makePitchers(int amount) {
        if ( amount <= 0) {
            return false;
        }

        long lemonsNeeded = (long) recipe.getLemons() * amount;
        long sugarNeeded = (long) recipe.getSugar() * amount;

        if ( lemonsNeeded > lemons || sugarNeeded > sugar) {
            return false;
        }

        if ( amount > Integer.MAX_VALUE - pitchers) {
            return false;
        }

        lemons = lemons - (int) lemonsNeeded;
        sugar = sugar - (int) sugarNeeded;
        pitchers = pitchers + amount;

        return true;
    }

    public int sellLemonade(int customers) {
        if ( customers < 0) {
            return 0;
        }

        long availableCups = (long) pitchers * 8;
        int sold = customers;

        if ( sold > availableCups) {
            sold = (int) availableCups;
        }

        long earnings = (long) sold * price;

        if ( earnings > Integer.MAX_VALUE - (long) cash) {
            return 0;
        }

        cash = cash + (int) earnings;
        pitchers = 0;

        return sold;
    }
}
