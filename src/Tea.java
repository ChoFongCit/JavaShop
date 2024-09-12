/*
 * This class models Tea drinks
 *
 * */
public class Tea extends Drinks{
    private int type; //1 for red tea, 2 for green tea, 3 for peppermint tea
    private final String size = "small";
    private boolean decaf;
    //Constructor
    public Tea(){
        type = 1;
        decaf = false;
        this.adjustPrice();
    }
    public Tea(int type1){
        type = type1;
        decaf = false;
        this.adjustPrice();
    }
    public Tea(int type1, boolean decaf1){
        this(type1);
        decaf = decaf1;
        this.adjustPrice();
    }

    //setters

    public void setDecaf(boolean decaf) {
        this.decaf = decaf;
        this.adjustPrice();
    }
    public void setType(int type1){
        this.type = type1;
        this.adjustPrice();
    }
    //getters
    public boolean isDecaf(){
        return decaf;
    }
    public int getType(){
        return type;
    }
    //extra
    /**
     * This method adjusts the pricing of this instance
     */
    private void adjustPrice(){
        switch(type){
            case 1:
                cost=0.1;
                price=2.4;
                break;
            case 2:
                cost=0.2;
                price=2.8;
                break;
            case 3:
                cost=0.3;
                price=3.0;
                break;
        }
        if(decaf){
            cost+=0.1;
            price+=0.2;
        }
    }
    public String toString(){
        String name = "";
        switch(type){
            case 1:
                name="Irish-Tea";
                break;
            case 2:
                name="Green-Tea";
                break;
            case 3:
                name="Peppermint-Tea";
                break;
        }
        if(this.decaf){
            name = "Decaffeinated "+name;
        }
        String out = "Tea " +name + "\t"+ this.size+ "\t€" + this.price;
        return out;
    }
    public String toWriteString(){
        String out = "Tea " + type + " " + isDecaf() +"\n";
        return out;
    }
}
