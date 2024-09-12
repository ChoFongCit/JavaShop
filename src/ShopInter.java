import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public interface ShopInter {
    AllOrders root = new AllOrders();

    public void newOrder();

    public void displayCustomers();
    public void addToOrder(Order tempOrder);

    public void profitReport();
    public Drinks newDrink();
    public Coffee newCoffee();
    public Tea newTea();
    public void showOrders();
    public void writeToFile();
    private String writeString(){
        String write ="";
        for(Order e: root.getOrderArrayList()){
            write = write + e.getOrderee().getName() +"\n" + e.getOrderee().getPhoneNo() + "\n";
            write = write + e.toWriteString();
        }
        return write;
    }
    public void ReadFile();
}

