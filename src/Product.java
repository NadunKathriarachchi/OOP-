public abstract class Product {
    protected String productId;
    protected String productName;
    protected int numberOfAvailableItems;
    protected double price;
    public Product(String productId,String productName,int numberOfAvailableItems,double price){
        this.productId=productId;
        this.productName=productName;
        this.numberOfAvailableItems=numberOfAvailableItems;
        this.price=price;
    }
    public String getProductId(){
        return productId;
    }
    public String getProductName(){
        return productName;
    }
    public int getNumberOfAvailableItems(){
        return numberOfAvailableItems;
    }
    public double getPrice(){
        return price;
    }
    public void setProductId(String productId){
        this.productId=productId;
    }
    public void setProductName(String productName){
        this.productName=productName;
    }
    public void setNumberOfAvailableItems(int numberOfAvailableItems){
        this.numberOfAvailableItems=numberOfAvailableItems;
    }
    public void setPrice(int price){
        this.price=price;
    }
}
