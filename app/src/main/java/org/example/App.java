
package org.example;
import java.util.Scanner;
import java.util.Random;
import java.math.BigDecimal;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        LemonadeStand stand = new LemonadeStand();

        int day = 1;
        boolean playing = true;

        System.out.println("Welcome to My Lemonade Stand!");

        while ( playing ) {
            boolean preparing = true;

            System.out.println();
            System.out.println("Day " + day + ": Preparation Phase");

            while ( preparing ) {
                System.out.println();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Lemons : " + stand.getLemons());
                System.out.println("Sugar (Cups) : " + stand.getSugar());
                System.out.println("Water (Cups) : Unlimited");
                System.out.println("Current Pitchers : " + stand.getPitchers());
                System.out.println("Cash : $" + String.format("%.2f", stand.getCash() / 100.0));

                System.out.println();
                System.out.println("1. Purchase Ingredients");
                System.out.println("2. Tweak the Recipe");
                System.out.println("3. Set the Price");
                System.out.println("4. Make Pitchers of Lemonade");
                System.out.println("5. Move Onto the Selling Phase");
                System.out.println("6. Exit Game");
                System.out.println("What would you like to do?");

                int choice = readNumber(scanner);

                if ( choice == 1) {
                    System.out.println("Lemons are $1 each");
                    System.out.println("Sugar is $0.50 per cup");

                    System.out.println("How many lemons do you want to buy?");
                    int lemons = readNumber(scanner);

                    System.out.println("How many cups of sugar do you want to buy?");
                    int sugar = readNumber(scanner);

                    boolean purchased = stand.buyIngredients(lemons , sugar);

                    if ( purchased ) {
                        System.out.println("Great! Transaction complete!");
                    }
                    else {
                        System.out.println("Invalid amount or not enough money!");
                    }
                }
                else if ( choice == 2) {
                    System.out.println("How many lemons do you want per pitcher?");
                    int lemons = readNumber(scanner);

                    System.out.println("How many cups of sugar do you want per pitcher?");
                    int sugar = readNumber(scanner);

                    System.out.println("How many cups of water do you want per pitcher?");
                    int water = readNumber(scanner);

                    boolean changed = stand.getRecipe().setRecipe(lemons , sugar , water);

                    if ( changed ) {
                        System.out.println("Great! Your recipe is set!");
                    }
                    else {
                        System.out.println("Invalid recipe! Please try again.");
                    }
                }
                else if ( choice == 3) {
                    System.out.println("How much will you sell one cup of lemonade for?");
                    System.out.println("Enter the price in dollars:");

                    int price = readPrice(scanner);
                    boolean changed = stand.setPrice(price);

                    if ( changed ) {
                        String formatted = String.format("%.2f", stand.getPrice() / 100.0);
                        System.out.println("Awesome! Each cup of lemonade is $" + formatted);
                    }
                    else {
                        System.out.println("Invalid price!");
                    }
                }
                else if ( choice == 4) {
                    System.out.println("How many pitchers of lemonade do you want to make?");
                    int amount = readNumber(scanner);

                    boolean made = stand.makePitchers(amount);

                    if ( made ) {
                        System.out.println("Fantastic! You made " + amount + " pitchers of lemonade!");
                    }
                    else {
                        System.out.println("Not enough ingredients or invalid amount!");
                    }
                }
                else if ( choice == 5) {
                    preparing = false;
                }
                else if ( choice == 6) {
                    preparing = false;
                    playing = false;
                }
                else {
                    System.out.println("Invalid choice! Please try again.");
                }
            }

            if ( playing ) {
                System.out.println();
                System.out.println("Day " + day + ": Selling Phase");
                System.out.println("The customers are coming!");

                int customers = random.nextInt(500) + 1;
                int availableCups = stand.getPitchers() * 8;
                int sold = stand.sellLemonade(customers);
                int leftover = availableCups - sold;

                System.out.println(customers + " customers visited your stand today!");
                System.out.println("You sold " + sold + " cups of lemonade.");

                String earnings = String.format("%.2f", (long) sold * stand.getPrice() / 100.0);
                System.out.println("You earned $" + earnings);

                System.out.println("Unsold lemonade : " + leftover + " cups");
                System.out.println("The leftover lemonade was thrown away!");

                String cash = String.format("%.2f", stand.getCash() / 100.0);
                System.out.println("Current Cash : $" + cash);

                System.out.println();
                System.out.println("Let's get some sleep and try again tomorrow!");

                day = day + 1;
            }
        }

        System.out.println();
        System.out.println("Thank you for playing My Lemonade Stand!");

        scanner.close();

    }

    public static int readNumber(Scanner scanner) {
        while ( true ) {
            String input = scanner.nextLine();

            try {
                int number = Integer.parseInt(input);
                return number;
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a whole number.");
            }
        }
    }

    public static int readPrice(Scanner scanner) {
        while ( true ) {
            String input = scanner.nextLine().trim();

            try {
                BigDecimal amount = new BigDecimal(input);
                int cents = amount.movePointRight(2).intValueExact();

                if ( cents > 0) {
                    return cents;
                }
                else {
                    System.out.println("Please enter a positive price.");
                }
            }
            catch (NumberFormatException | ArithmeticException e) {
                System.out.println("Invalid price! Enter dollars with at most 2 decimal places.");
            }
        }
    }
}
