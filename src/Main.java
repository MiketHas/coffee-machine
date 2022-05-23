import java.util.Scanner;

public class Main {

    enum Choice {
        BUY, FILL, TAKE, REMAINING, EXIT;
    }

    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int cash = 550;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        getAction();
    }

    public static void getState () {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water%n", water);
        System.out.printf("%d ml of milk%n", milk);
        System.out.printf("%d g of coffee beans%n", beans);
        System.out.printf("%d disposable cups%n", cups);
        System.out.printf("$%d of money%n%n", cash);
    }

    public static void getAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");

        String userInput = input.next();
        Choice userChoice = Choice.valueOf(userInput.toUpperCase());

        switch (userChoice) {
            case BUY -> buy();
            case FILL -> fill();
            case TAKE -> {
                System.out.printf("I gave you %s%n%n", cash);
                cash = 0;
                getAction();
            }
            case REMAINING -> {
                getState();
                getAction();
            }
            case EXIT -> System.exit(0);
        }
    }

    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");

        String whichCoffee = input.next();

        switch (whichCoffee) {
            case "1" -> {
                espresso();
                System.out.println();
            }
            case "2" -> {
                latte();
                System.out.println();
            }
            case "3" -> {
                cappuccino();
                System.out.println();
            }
            case "back" -> System.out.println();
        }
        getAction();
    }

    public static void espresso() {
        int water1cupE = 250;
        int beans1cupE = 16;
        int costE = 4;

        if ((cups == 0) || (water < water1cupE) || (beans < beans1cupE)) {
            System.out.println(espressoRes(water1cupE));
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= water1cupE;
            beans -=beans1cupE;
            cash += costE;
            cups --;
        }
    }

    public static String espressoRes(int water1cupE) {

        if (cups < 1) {
            return "Sorry, not enough cups!";
        } else if (water < water1cupE) {
            return "Sorry, not enough water!";
        } else {
            return "Sorry, not enough beans!";
        }
    }

    public static void latte() {
        int water1cupL = 350;
        int milk1cupL = 75;
        int beans1cupL = 20;
        int costL = 7;

        if ((cups == 0) || (water < water1cupL) || (milk < milk1cupL) || (beans < beans1cupL)) {
            System.out.println(latteRes(water1cupL, milk1cupL));
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -=water1cupL;
            milk -= milk1cupL;
            beans -= beans1cupL;
            cash += costL;
            cups --;
        }
    }

    public static String latteRes(int water1cupL, int milk1cupL) {

        if (cups < 1) {
            return "Sorry, not enough cups!";
        } else if (water < water1cupL) {
            return "Sorry, not enough water!";
        } else if (milk < milk1cupL) {
            return "Sorry, not enough water!";
        } else {
            return "Sorry, not enough beans!";
        }
    }

    public static void cappuccino() {
        int water1cupC = 200;
        int milk1cupC = 100;
        int beans1cupC = 12;
        int costC = 6;

        if ((cups == 0) || (water < water1cupC) || (milk < milk1cupC) || (beans < beans1cupC)) {
            System.out.println(cappuccinoRes(water1cupC, milk1cupC));
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -=water1cupC;
            milk -= milk1cupC;
            beans -= beans1cupC;
            cash += costC;
            cups --;
        }
    }

    public static String cappuccinoRes(int water1cupC, int milk1cupC) {

        if (cups < 1) {
            return "Sorry, not enough cups!";
        } else if (water < water1cupC) {
            return "Sorry, not enough water!";
        } else if (milk < milk1cupC) {
            return "Sorry, not enough water!";
        } else {
            return "Sorry, not enough beans!";
        }
    }

    public static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        water += input.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += input.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beans += input.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cups += input.nextInt();
        getAction();
    }
}