import java.io.Serializable;

public class Clothing extends Product implements Serializable {
    protected int size;
    protected String colour;
    public Clothing(String productId,String productName,int numberOfAvailableItems,double price,int size,String colour){
        super(productId,productName,numberOfAvailableItems,price);
        this.size=size;
        this.colour=colour;
    }
    public int getSize() {
        return size;
    }
    public String getColour(){
        return colour;
    }
    public void setSize(int size){
        this.size=size;
    }
    public void setColour(String colour){
        this.colour=colour;
    }
}
