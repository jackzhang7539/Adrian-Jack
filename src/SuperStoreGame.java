import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

abstract class Item { //https://www.phind.com/search/cm7m60xd700003b6u7joygyhu
    String name;
    double price;
    int stock;
    String category;

    public Item(String name, double price, int stock, String category) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public abstract void displayDetails();
}

class Transportation extends Item {
    public Transportation(String name, double price, int stock) {
        super(name, price, stock, "Transportation");
    }

    @Override
    public void displayDetails() {
        System.out.println(name + " - $" + price + " (Stock: " + stock + ")");
    }
}

class Shelter extends Item {
    public Shelter(String name, double price, int stock) {
        super(name, price, stock, "Shelter");
    }

    @Override
    public void displayDetails() {
        System.out.println(name + " - $" + price + " (Stock: " + stock + ")");
    }
}

class Food extends Item {
    public Food(String name, double price, int stock) {
        super(name, price, stock, "Food");
    }

    @Override
    public void displayDetails() {
        System.out.println(name + " - $" + price + " (Stock: " + stock + ")");
    }
}

class Person extends Item {
    public Person(String name, double price, int stock) {
        super(name, price, stock, "Person");
    }

    @Override
    public void displayDetails() {
        System.out.println(name + " - $" + price + " (Stock: " + stock + ")");
    }
}

class Device extends Item {
    public Device(String name, double price, int stock) {
        super(name, price, stock, "Device");
    }

    @Override
    public void displayDetails() {
        System.out.println(name + " - $" + price + " (Stock: " + stock + ")");
    }
}

class Accessories extends Item {
    public Accessories(String name, double price, int stock) {
        super(name, price, stock, "Accessories");
    }

    @Override
    public void displayDetails() {
        System.out.println(name + " - $" + price + " (Stock: " + stock + ")");
    }
}

class Store {
    List<Item> items;

    public Store() {
        items = new ArrayList<>();
        items.add(new Transportation("Airbus A380", 500000000, 5));
        items.add(new Shelter("Mansion", 30000000, 10));
        items.add(new Food("Caviar", 10000, 100000));
        items.add(new Transportation("Rolls Royce Boatail", 30000000, 5));
        items.add(new Shelter("Condo", 2000000, 10));
        items.add(new Food("Takis", 1, Integer.MAX_VALUE));
        items.add(new Transportation("Streets of Monaco Superyacht", 1000000000, 1));
        items.add(new Person("Aiden Zhang", 20000000, 1));
        items.add(new Food("Chinatown Bakery Pastry from old Grandma", 0, 10000));
        items.add(new Device("Chromebook", 200, 20000000));
        items.add(new Device("Mac Air M3", 2000, 5000000));
        items.add(new Device("Rose-Gold Iphone 6 w/Pink Diamond", 50000000, 50));
        items.add(new Accessories("1 License Plate", 15000000, 1));
        items.add(new Accessories("Hope Diamond", 250000000, 1));
        items.add(new Accessories("Wenegade Waider", 20, 1));
    }

    public void displayItems() {
        for (Item item : items) {
            item.displayDetails();
        }
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public void updatePrices() {
        Random rand = new Random();
        for (Item item : items) {
            int change = rand.nextInt(1, 3);
            item.price *= change;
        }
    }
}

class Transaction {
    String itemName;
    double price;
    int turn;

    public Transaction(String itemName, double price, int turn) {
        this.itemName = itemName;
        this.price = price;
        this.turn = turn;
    }

    @Override
    public String toString() {
        return "Turn " + turn + ": Purchased " + itemName + " for $" + price;
    }
}

class Player {
    double money;
    List<Item> inventory;
    List<Transaction> transactions;
    int turn;

    public Player(double initialMoney) {
        this.money = initialMoney;
        this.inventory = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.turn = 1;
    }

    public void buyItem(Item item, Store store) {
        if (item.stock > 0 && money >= item.price) {
            money -= item.price;
            inventory.add(item);
            transactions.add(new Transaction(item.name, item.price, turn));
            item.stock--;
            System.out.println("Purchased " + item.name + " for $" + item.price);
        } else {
            System.out.println("Cannot purchase " + item.name);
        }
    }

    public void displayStatus() {
        System.out.println("Money left: $" + money);
        System.out.println("Inventory:");
        for (Item item : inventory) {
            item.displayDetails();
        }
    }

    public boolean hasWon() {
        return turn == 30;
    }
}

public class SuperStoreGame {
        public static void main(String[] args) {
            System.out.println("You successfully yoinked Elon Musk's biggest, baddest rocket and sold it on the black market for 25 billion dollars. Receiving 25 Billion dollars would definitely catch the attention of the government. Now you must buy stupidly expensive products to launder the money in order to not be caught by the government. You can make one trade everyday for a month and then at the end of the month, you can sell everything you laundered for money. If you buy too many expensive things you will catch the attention of the government. Good luck and launder money. ");
            //System.out.println("Buying some items has special effects. Watch your suspicion meter! If you buy too many expensive things the government will catch on!");
            Store store = new Store();
            Player player = new Player(25000000000.0); //25b cuz lots of 0s
            Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Turn " + player.turn + " ---"); // \n is used to add a new lone below
            System.out.println("1. Buy Item");
            System.out.println("2. View Status");
            System.out.println("3. End Game");
            System.out.println("--------------");
            //System.out.println("Sus bar: " + sus);
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item number to buy: ");
                    store.displayItems();
                    int itemIndex = scanner.nextInt();
                    player.buyItem(store.getItem(itemIndex), store);
                    player.turn++;
                    break;
                case 2:
                    player.displayStatus();
                    break;
                case 3:
                    System.out.println("You forfeited. Game over!");
                    player.turn++;
                    return;
                default:
                    System.out.println("Invalid choice.");
            }

            if (player.hasWon()) {
                System.out.println("Congratulations! You made it past 30 days yyayayayayayayyayayaaa!");
                break;
            }

            store.updatePrices();
        }

        scanner.close();
    }
}