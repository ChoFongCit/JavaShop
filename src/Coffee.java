/*
* This class models Coffee drinks
*
* */
public class Coffee extends Drinks{
    //fields
    private int type; //1 for americano, 2 for latte, 3 for cappuccino
    private boolean lactoseFree;

    //Constructor
    public Coffee(){
        super();
        type = 1;
        lactoseFree = true;
        this.adjustPrice();
    }

    public Coffee(int type1, String size1){
        super(size1);
        type = type1;
        if(type!=1){
            this.cost = 0.75;
            this.price = 3.5;
            lactoseFree = false;
        }
        else{
            this.cost = 0.5;
            this.price = 3;
            lactoseFree = true;
        }
        size = size1;
        this.adjustPrice();
    }
    public Coffee(int type1, String size1, boolean Lfree){
        this(type1, size1);
        lactoseFree = Lfree;
        if(this.type!=1 && lactoseFree){
            cost+=0.2;
            price +=0.3;
        }
    }

    //setters
    public void setType(int type1){
        this.type = type1;
        this.adjustPrice();
    }
    public void setLactoseFree(boolean lactoseFree1){
        this.lactoseFree = lactoseFree1;
        this.adjustPrice();
    }

    //extra
    /**
     * This method adjusts the price of this instance of drink<br>
     *
     */
    private void adjustPrice(){
        if(this.type == 1){
            cost = 0.5;
            price = 3;
        }
        else{
            cost = 0.75;
            price = 3.5;
        }
        if(this.size.equalsIgnoreCase("large")){
            cost+=0.1;
            price+=0.2;
        }
        if(this.lactoseFree && this.type !=1){
            cost+=0.1;
            price+=0.2;
        }
    }

    /**
     * This method formats information of the instance into a string for display<br>

     * @return String containing information of the instance
     */
    public String toString(){
        String name = "";
        switch(type){
            case 1:
                name="Americano";
                break;
            case 2:
                name="Latte";
                break;
            case 3:
                name="Cappuccino";
                break;
        }
        if(this.isLactoseFree() && type!=1){
            name = "Lactose-free "+name;
        }
        String out = "Coffee "+name + "\t"+ this.size+ "\t€" + this.price;
        return out;
    }
    /**
     * This method formats information of the instance into a string to be used in Read/Write<br>
     * @return Read/Write String containing information of the instance
     */
    public String toWriteString(){
        String out ="coffee "+ type+" "+ isLactoseFree() + " " + size + "\n";
        return out;
    }
    //getters
    public int getType(){
        return type;
    }
    public boolean isLactoseFree(){
        return lactoseFree;
    }

}
