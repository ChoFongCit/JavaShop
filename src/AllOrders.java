import java.io.*;
import java.util.*;
public class AllOrders {
    //fields
    private ArrayList<Order> orderArrayList;
    private ArrayList<Customer> customerArrayList;
    public AllOrders(){
        orderArrayList = new ArrayList<>();
        customerArrayList = new ArrayList<>();
    }
    /**
     * This method clears all information in the instance
     */
    public void clear(){
        this.orderArrayList.clear();
        this.customerArrayList.clear();
    }
    /**
     * This method formats information of the instance into a string for read/Write<br>
     * @oaram e containing order to be added into the list of orders
     */
    public void addOrder(Order e){
        orderArrayList.add(e);
        if(!customerArrayList.contains(e.getOrderee())){
        customerArrayList.add(e.getOrderee());
        }
    }
    public ArrayList<Customer> getCustomerArrayList(){
        return this.customerArrayList;
    }
    public ArrayList<Order> getOrderArrayList(){
        return this.orderArrayList;
    }
    public void removeOrder(int index){
        orderArrayList.remove(index);
    }
    /**
     * This method formats information of the instance into a string<br>
     * @return String containing information of the instance
     */
    public String toString(){
        String out = "All orders: \n";
        int index = 0;
        for(Order e:orderArrayList){
            out = out + index +". "+ e.getCustomerName() + "\tTotal: €"+e.calculatePrice()+"\n";
            index++;
        }
        return out;
    }
    /**
     * This method formats calculates profit of all orders<br>
     * @return double representing profit made.
     */
    public double calculateProfit(){
        double profit = 0;
        for(Order e: orderArrayList){
            profit = profit + e.calculateProfit();
        }
        return profit;
    }
}
