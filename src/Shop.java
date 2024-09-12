import java.util.Scanner;
import java.io.*;
public class Shop implements ShopInter{
    private AllOrders root = new AllOrders();

    public Shop(){

    }

    public void newOrder(){
        Scanner scan = new Scanner(System.in);
        System.out.println("New customer? 0/1");
        Order tempOrder;

        switch(Integer.parseInt(scan.nextLine())){
            case 0:
                System.out.println("Choose from:");
                displayCustomers();
                int choice;
                try{
                    choice = Integer.parseInt(scan.nextLine());
                }catch(Exception e){
                    return;
                }
                if(choice >= root.getCustomerArrayList().size()){
                    System.out.println("No customer at that index");
                    return;
                }
                tempOrder =  new Order(root.getCustomerArrayList().get(choice));
                addToOrder(tempOrder);
                root.addOrder(tempOrder);
                break;
            case 1:
                String name ="";
                String number="";
                System.out.println("Enter Customer name:");
                     name = scan.nextLine();
                System.out.println("Enter Customer phoneNo");
                     number = scan.nextLine();
                tempOrder = new Order(name, number);
                addToOrder(tempOrder);
                root.addOrder(tempOrder);
                break;
        }
    }

    public void displayCustomers(){
        int index = 0;
        System.out.println("List of regulars: ");
        for(Customer e:root.getCustomerArrayList()){
            System.out.println(index + ". "+e.getName() + "\t" +e.getPhoneNo());
            index++;
        }
    }
    public void addToOrder(Order tempOrder){
        Scanner input3 = new Scanner(System.in);
        int choice = 1;
       do{
           {
               tempOrder.addDrink(newDrink());
               System.out.println("Continue add Drinks? 1/0");
               if(!input3.hasNextLine()){
                   System.out.println("Something wrong");
               }
               choice = Integer.parseInt(input3.nextLine());
           }
       }
       while(choice == 1);

       }

    public void profitReport(){
        System.out.println("Profit: "+ root.calculateProfit());
    }
    public Drinks newDrink(){
        Drinks tempDrink;
        Scanner input = new Scanner(System.in);
        System.out.println("Coffee or Tea? 0/1");
        if(Integer.parseInt(input.nextLine()) == 0){
            tempDrink = newCoffee();
        }
        else{
            tempDrink = newTea();
        }
        return tempDrink;
    }
    public Coffee newCoffee(){
        Scanner input2 = new Scanner(System.in);
        System.out.println("Type of coffee:\n" +
                "1. Americano\n" +
                "2. Latte\n" +
                "3. Cappuccino");
        int type = Integer.parseInt(input2.nextLine());
        String size="";
        System.out.println("Large/Small? 0/1");
        switch(Integer.parseInt(input2.nextLine())){
            case 0:
                size = "large";
                break;
            case 1:
                size = "small";
                break;
        }
        boolean lFree = false;
        if(type != 1){
            System.out.println("Lactose-Free? 0/1");
            switch(Integer.parseInt(input2.nextLine())){
                case 0:
                    lFree = false;
                    break;
                case 1:
                    lFree = true;
                    break;
            }
        }
        return (new Coffee(type, size, lFree));
    }
    public Tea newTea(){
        Scanner input2 = new Scanner(System.in);
        System.out.println("Type of Tea:\n" +
                "1. Red-Tea\n" +
                "2. Green Tea\n" +
                "3. Peppermint Tea");
        int type = Integer.parseInt(input2.nextLine());
        boolean lFree = false;
        System.out.println("Decaffeinated? 0/1");
        switch(Integer.parseInt(input2.nextLine())){
            case 0:
                lFree = false;
                break;
            case 1:
                lFree = true;
                break;
        }
        return (new Tea(type, lFree));
    }
    public void showOrders(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose an index to view more details about: ");
        System.out.println(root.toString());
        int index;
        try{
         index = Integer.parseInt(scan.nextLine());}
        catch(Exception e){
            return;
        }
        System.out.println("Order details");
        if(index >= root.getOrderArrayList().size()){
            return;
        }
        System.out.println(root.getOrderArrayList().get(index).toString());
    }

    public void writeToFile(){
        try{
            File orders = new File("order.txt");
            if(orders.createNewFile()){
                System.out.println("File created: "+ orders.getName());
            }
            else{
                System.out.println("File exists");
            }
            FileWriter writeOrders = new FileWriter(orders);
            writeOrders.write(this.writeString());
            writeOrders.close();
        }catch(Exception e)
        {
        System.out.println(e);
        }
    }
    private String writeString(){
        String write ="";
        for(Order e: root.getOrderArrayList()){
            write = write + e.getOrderee().getName() +"\n" + e.getOrderee().getPhoneNo() + "\n";
            write = write + e.toWriteString();
        }
        return write;
    }
    public void ReadFile(){
        try
        {
            root.clear();
          File orders = new File("order.txt");
          Scanner scan = new Scanner(orders);
          while(scan.hasNextLine()){
            String name = scan.nextLine();
            String number = scan.nextLine();
            Order tempOrder = new Order(name, number);
            int loop = Integer.parseInt(scan.nextLine());
              for(int i = 0 ; i < loop; i++){
                  String[] strArr = scan.nextLine().split(" ");
                  if(strArr[0].equalsIgnoreCase("coffee")){
                      Coffee tempCoffee = new Coffee(Integer.parseInt(strArr[1]),strArr[3],Boolean.parseBoolean(strArr[2]));
                      tempOrder.addDrink(tempCoffee);
                  }
                  else{
                      Tea tempTea = new Tea(Integer.parseInt(strArr[1]),Boolean.parseBoolean(strArr[2]));
                      tempOrder.addDrink(tempTea);
                  }
              }
              root.addOrder(tempOrder);
          }
        }catch(Exception e){
            System.out.println(e);
            return;
        }
        System.out.println("Successful read");
    }
}
