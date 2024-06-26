import java.io.Serializable;

public class Electronics extends Product implements Serializable {
    protected String brand;
    protected int warranty;
    public Electronics(String productId,String productName,int numberOfAvailableItems,double price,String brand,int warranty){
        super(productId,productName,numberOfAvailableItems,price);
        this.brand=brand;
        this.warranty=warranty;
    }
    public String getBrand(){
        return brand;
    }
    public int getWarranty(){
        return warranty;
    }
    public void setBrand(String brand){
        this.brand=brand;
    }
    public void setWarranty(int warranty){
        this.warranty=warranty;
    }
}
