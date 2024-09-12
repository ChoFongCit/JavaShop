/*This is the class for storing information regarding customer*/
public class Customer {
    //fields
    private String name;
    private String phoneNo;

    //constructors
    public Customer(String name, String no){
        this.name = name;
        phoneNo = no;
    }

    //setters
    public void setName(String name1){
        this.name=name1;
    }
    public void setPhoneNo(String phoneNo1){
        this.phoneNo = phoneNo1;
    }

    //getters
    public String getName(){
        return this.name;
    }
    public String getPhoneNo(){
        return this.phoneNo;
    }
}
