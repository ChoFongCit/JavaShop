import java.util.*;

public class myMain {
    static Shop shop = new Shop();
    public static void main(String[] args){

        welcomeMsg();
        choices1();
    }


    public static void welcomeMsg(){
        System.out.println("Hello! Welcome to your coffee shop!");
    }

    public static void choices1(){
        Scanner scan = new Scanner(System.in);
        boolean open = true;
        while(open) {
            System.out.println("What to do?\n" +
                    "0. Make new Order\n" +
                    "1. View All Order(s)\n" +
                    "2. Profit Report\n" +
                    "3. Write to Disk\n" +
                    "4. Read Disk\n" +
                    "5. Quit");
            int userChoice;
            try {
                userChoice = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue; // Restart the loop
            }
            switch (userChoice) {
                case 0:
                    shop.newOrder();
                    break;
                case 1:
                    shop.showOrders();
                    break;
                case 2:
                    shop.profitReport();
                    break;
                case 3:
                    shop.writeToFile();
                    break;
                case 4:
                    shop.ReadFile();
                    break;
                case 5:
                    open = false;
                    break;
            }
        }
        scan.close();
    }

//    public static void newOrder(){
//        Scanner scan = new Scanner(System.in);
//        System.out.println("New customer? 0/1");
//        Order tempOrder;
//        switch(scan.nextInt()){
//            case 0:
//                System.out.println("Choose from:");
//                displayCustomers();
//                int choice = scan.nextInt();
//                 tempOrder =  new Order(root.getCustomerArrayList().get(choice));
//                 addToOrder(tempOrder);
//                 root.addOrder(tempOrder);
//                break;
//            case 1:
//                System.out.println("Enter Customer name:");
//                String name = scan.nextLine();
//                System.out.println("Enter Customer phoneNo");
//                String number = scan.nextLine();
//                 tempOrder = new Order(name, number);
//                addToOrder(tempOrder);
//                root.addOrder(tempOrder);
//                break;
//        }
//        scan.close();
//    }
//
//    public static void displayCustomers(){
//        int index = 0;
//        System.out.println("List of regulars: ");
//        for(Customer e:root.getCustomerArrayList()){
//            System.out.println(index + ". "+e.getName() + "\t" +e.getPhoneNo());
//            index++;
//        }
//    }
//    public static void addToOrder(Order tempOrder){
//        Scanner input3 = new Scanner(System.in);
//        int choice;
//        do{
//            tempOrder.addDrink(newDrink());
//            System.out.println("Continue add Drinks? 1/0");
//            choice = input3.nextInt();
//        }
//        while(choice == 1);
//        input3.close();
//    }
//    public static Drinks newDrink(){
//        Drinks tempDrink;
//        Scanner input = new Scanner(System.in);
//        System.out.println("Coffee or Tea? 0/1");
//        if(input.nextInt() == 0){
//            tempDrink = newCoffee();
//        }
//        else{
//            tempDrink = newTea();
//        }
//        input.close();
//        return tempDrink;
//    }
//    public static Coffee newCoffee(){
//        Scanner input2 = new Scanner(System.in);
//        System.out.println("Type of coffee:\n" +
//                "1. Americano\n" +
//                "2. Latte\n" +
//                "3. Cappuccino");
//        int type = input2.nextInt();
//        String size="";
//        System.out.println("Large/Small? 0/1");
//        switch(input2.nextInt()){
//            case 0:
//                size = "large";
//                break;
//            case 1:
//                size = "small";
//                break;
//        }
//        boolean lFree = false;
//        if(type != 1){
//            System.out.println("Lactose-Free? 0/1");
//            switch(input2.nextInt()){
//                case 0:
//                    lFree = false;
//                    break;
//                case 1:
//                    lFree = true;
//                    break;
//            }
//        }
//        input2.close();
//        return (new Coffee(type, size, lFree));
//    }
//    public static Tea newTea(){
//        Scanner input2 = new Scanner(System.in);
//        System.out.println("Type of Tea:\n" +
//                "1. Red-Tea\n" +
//                "2. Green Tea\n" +
//                "3. Peppermint Tea");
//        int type = input2.nextInt();
//        boolean lFree = false;
//            System.out.println("Decaffeinated? 0/1");
//            switch(input2.nextInt()){
//                case 0:
//                    lFree = false;
//                    break;
//                case 1:
//                    lFree = true;
//                    break;
//            }
//            input2.close();
//        return (new Tea(type, lFree));
//    }
//    public static void showOrders(){
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Choose an index to view more details about: ");
//        System.out.println(root.toString());
//        int index = scan.nextInt();
//        System.out.println("Order details");
//        System.out.println(root.getOrderArrayList().get(index).toString());
//    }

}
