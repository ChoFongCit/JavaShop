/**
 * Abstract class that models the two major drinks sold<br>

 *
 */
public abstract class Drinks {
    //private fields
    protected String size;    //only 2 sizes, large || small
    protected double price = 2;
    protected double cost;

    //Constructors
    public Drinks(){
        this.price = 2;
        this.size = "small";
        this.cost=0;
    }
    public Drinks(String size1){
        this.price =2;
        this.size = size1;
        this.cost=0;
    }


    //setters
    public void setPrice(double priceIn){
        this.price = priceIn;
    }
    public void setSize(String size1){
        this.size = size1;
    }
    public void setCost(double cost1){
        if(cost1>price){
            this.cost = price;
        }
        else {
            this.cost = cost1;
        }
    }

    //getters
    public double getPrice(){
        return this.price;
    }
    public double getCost(){
        return this.cost;
    }
    public String getSize(){
        return this.size;
    }

    /**
     * This method calculates the profit made from the instance of the drink<br>

     * @return Double representing profit
     */
    public double getProfit(){
        return (price-cost);
    }


    public abstract String toWriteString();
}
