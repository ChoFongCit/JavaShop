import java.util.*;
/**
 * This class contains information of individual orders for drinks and customer<br>

 *
 */
public class Order {
    //fields
    private ArrayList<Drinks> orderList = new ArrayList<>();
    private Customer orderee;
    private final Date orderTime = new Date();
    public Order(String name, String phoneNo){
        orderee = new Customer(name, phoneNo);
    }
    public Order(Customer orderee){
        this.orderee = orderee;
    }
    //getters
    public Date getOrderTime(){
        return orderTime;
    }
    /**
     * This method returns customer name of this order<br>

     * @return String containing name of customer
     */
    public String getCustomerName(){
        return orderee.getName();
    }
    public Customer getOrderee(){
        return this.orderee;
    }


    //extra
    /**
     * This method adds a drink to the ArrayList containing the list of drinks ordered<br>

     * @param newDrink the instance of the drink to be ordered
     */
    public void addDrink(Drinks newDrink){
        orderList.add(newDrink);
    }
    /**
     * This method calculates the total price of the order<br>
     * @return double containing total price
     */
    public double calculatePrice(){
        double total= 0;
        for(Drinks e: orderList){
            total+= e.getPrice();
        }
        return total;
    }
    /**
     * This method calculates the total profit made from this order<br>
     * @return double containing total profit
     */
    public double calculateProfit(){
        double total= 0;
        for(Drinks e: orderList){
            total+= e.getProfit();
        }
        return total;
    }
    /**
     * This method formats information of the instance into a string<br>
     * @return String containing information of the instance
     */
    public String toString(){
        String out = String.format("Name: %s\t %s\n",orderee.getName(),orderee.getPhoneNo());
        String orders = "";
        int index = 0;
        for(Drinks e: orderList){
           orders = orders + index+ ". "+e.toString()+"\n";
           index++;
        }
        out = out + orders + "Total Price: €"+ this.calculatePrice();
        return out;
    }
    /**
     * This method formats information of the instance into a string for read/Write<br>
     * @return String containing information of the instance
     */
    public String toWriteString(){

        int lines = this.orderList.size();
        String write = lines + "\n";
        for(Drinks e : this.orderList){
            write = write + e.toWriteString();
        }
        return write;
    }
}
