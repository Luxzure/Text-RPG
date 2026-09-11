import java.util.HashMap;
import java.util.Scanner;

public class textrpg {
    public static void addItem(HashMap<String, Integer> inventory, String item, int quantity){
        inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
    }
    public static void removeItem(HashMap<String, Integer> inventory, String item, int quantity){
        if(inventory.containsKey(item)){
            int currentQty = inventory.get(item);
            if(currentQty <= quantity){
                inventory.remove(item);
            } else{
            inventory.put(item, currentQty - quantity);
            }
        }
    }
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        //PLAYER
        double money = 1000.00;
        HashMap<String, Integer> inventory = new HashMap<>();
        boolean mainRunning = true;

        while(mainRunning){
            System.out.println("What do you want to do? (1. Player, 2. Map)");
            System.out.print("Enter your choice here: ");
            String choice1 = scanner.nextLine().trim();
            if(choice1.equals("1")){
                while(true){
                System.out.println("================================");
                System.out.println("Please choose your next action: ");
                System.out.println("[I] Inventory");
                System.out.println("[M] Money");
                System.out.println("[B] Back");
                System.out.println("================================");
                System.out.print("Enter your choice here ([I], [M], or [B]): ");
                String input = scanner.nextLine().trim();
                if (input.length() == 0){
                    System.out.println("Invalid input! Please try again.");
                    continue;
                }
                char choice = input.toUpperCase().charAt(0);
                //INVENTORY
                if(choice == 'I'){
                    while(true){     
                    System.out.println("Inventory:");
                    if(inventory.isEmpty()){
                        System.out.println("Your inventory is empty.");
                    } else{
                        for(String item : inventory.keySet()){
                            System.out.println(item + " x" + inventory.get(item));
                        }
                    }
                    System.out.println("================================");
                    System.out.println("[B] Back");
                    System.out.print("Enter your choice: ");
                    String invInput = scanner.nextLine().trim();
                    if(invInput.length() == 0){
                        System.out.println("Invalid input! Please try again.");
                        continue;
                    }
                    if(invInput.toUpperCase().charAt(0) == 'B'){
                        break;
                    } else{
                        System.out.println("Invalid choice! Please try again.");
                        }
                    }
                //MONEY
                } else if(choice == 'M'){
                    while(true){
                    System.out.println("================================");
                    System.out.println("Wallet: $" + money);
                    System.out.println("================================");
                    System.out.println("[B] Back");
                    System.out.print("Enter your choice: ");
                    String moneyInput = scanner.nextLine().trim();
                    if(moneyInput.length() == 0){
                        System.out.println("Invalid input! Please try again.");
                        continue;
                    }
                    if(moneyInput.toUpperCase().charAt(0) == 'B'){
                        break;
                        } else{
                            System.out.println("Invalid input! Please try again.");
                        }
                    }
                } else if(choice == 'B'){
                    break;
                } else{
                    System.out.println("Invalid choice! Please try again.");
                   }
                }
            } else if (choice1.equals("2")){
          
        //MAP
        char hardware = 'A';
        boolean inMapMenu = true;
              
        while(inMapMenu){
        System.out.print("Where do you wanna go? (A. Hardware, B. Bank, C. Grocery, D. Office, E. Back): ");
        String hardwareInput = scanner.nextLine().trim();
        if(hardwareInput.length() == 0){
            System.out.println("Invalid input! Please try again.");
            continue;
        }
        hardware = hardwareInput.trim().toUpperCase().charAt(0);

        if(hardware == 'A'){
            //HARDWARE MENU
            while(true){
            System.out.println("===================================");
            System.out.println("Welcome! What would you like to do?");
            System.out.println("1. Buy");
            System.out.println("2. Sell");
            System.out.println("3. Exit");
            System.out.println("===================================");
            System.out.print("Enter your choice (1, 2, or 3): ");
            String choice2 = scanner.nextLine().trim();

            if(choice2.equals("1")){
                //HARDWARE BUY
                while(true){
                System.out.println("================================");
                System.out.println("1. Duct Tape ($8.00)");
                System.out.println("2. Hammer ($50.00");
                System.out.println("3. Pliers ($30.00)");
                System.out.println("4. Saw($25.00)");
                System.out.println("5. Lubricant ($20.00)");
                System.out.println("[B] Back");
                System.out.println("================================");
                System.out.print("Enter your choice (1, 2, 3, 4, 5, or B): ");
                String hardwareBuy = scanner.nextLine().trim();
                if(hardwareBuy.length() == 0){
                        System.out.println("Invalid input! Please try again.");
                        continue;
                } 
                if(hardwareBuy.equalsIgnoreCase("B")){
                    break;
                }
                   if(hardwareBuy.equals("1")){
                        if(money >= 8.00){
                         addItem(inventory, "Duct Tape", 1);
                        money -= 8.00;
                        System.out.println("================================");
                        System.out.println("You bought a Duct Tape!");
                        System.out.println("Wallet: " + "$" +  money);
                        System.out.println("================================");
                        } else{
                            System.out.println("Insufficient Balance!");
                        }
                    } else if(hardwareBuy.equals("2")){
                       if(money >= 50.00){
                        addItem(inventory, "Hammer", 1);
                        money -= 50.00;
                        System.out.println("================================");
                        System.out.println("You bought a Hammer!");
                        System.out.println("Wallet: " + "$" + money);
                        System.out.println("================================");
                        } else{
                            System.out.println("Insufficient Balance!");
                        }
                    } else if(hardwareBuy.equals("3")){
                         if(money >= 30.00){
                        addItem(inventory, "Pliers", 1);
                        money -= 30.00;
                        System.out.println("================================");
                        System.out.println("You bought a Pliers!");
                        System.out.println("Wallet: " + "$" + money);
                        System.out.println("================================");
                        } else{
                            System.out.println("Insufficient Balance!");
                        }
                    } else if(hardwareBuy.equals("4")){
                         if(money >= 25.00){
                        addItem(inventory, "Saw", 1);
                        money -= 25.00;
                        System.out.println("================================");
                        System.out.println("You bought a Saw!");
                        System.out.println("Wallet: " + "$" + money);
                        System.out.println("================================");
                        } else{
                            System.out.println("Insufficient Balance!");
                        }
                    } else if(hardwareBuy.equals("5")){
                         if(money >= 20.00){
                        addItem(inventory, "Lubricant", 1);
                        money -= 20.00;
                        System.out.println("================================");
                        System.out.println("You bought a Lubricant!");
                        System.out.println("Wallet: " + "$" + money);
                        System.out.println("================================");
                        } else{
                            System.out.println("Insufficient Balance!");
                        }
                    } else{
                        System.out.println("Invalid input! Please try again.");
                    }
                }
            } else if(choice2.equals("2")){
                //HARDWARE SELL
                if(inventory.isEmpty()){
                    System.out.println("Your inventory is empty. Nothing to sell.");
                    continue;
                }
                System.out.println("================================");
                System.out.println("Inventory: ");
                for(String item : inventory.keySet()){
                    System.out.println(item + " x" + inventory.get(item));
                }
                System.out.println("================================");
                System.out.println("What do you wanna sell?");
                System.out.print("Enter your choice (Item name): ");
                String sellItem = scanner.nextLine().trim();
                if(inventory.containsKey(sellItem)){
                    int qty = inventory.get(sellItem);
                    if(qty > 0){
                        removeItem(inventory, sellItem, 1);
                        switch (sellItem){
                            case "Duct Tape":
                                money += 4.00;
                                break;
                            case "Hammer":
                                money += 25.00;
                                break;
                            case "Pliers":
                                money += 15.00;
                                break;
                            case "Saw":
                                money += 12.50;
                                break;
                            case "Lubricant":
                                money += 10.00;
                                break;
                            default:
                                money += 1.00;
                                break;
                        }
                        System.out.println("Sold one " + sellItem);
                        System.out.println("Wallet: $" + money);
                    } else{
                        System.out.println("You don't have any " + sellItem);
                    }
                } else {
                    System.out.println("Item not found in inventory.");
                }
            } else if(choice2.equals("3")){
                break;
            } else{
                System.out.println("Invalid Input! Please enter 1, 2, or 3.");
            }
        } 
    } else{
            System.out.println("Invalid Input! Please try again.");
        }
    }
            } else{
                System.out.println("Invalid Input! Please try again.");
            }
         }
    scanner.close();
    }
}
