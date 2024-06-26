import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class WestminsterShoppingManager implements ShoppingManager{
    Electronics [] electronics = new Electronics[50];
    Clothing [] clothing = new Clothing[50];
    int Max_pro = 0;
    public static int q;
    public static int r;
    public WestminsterShoppingManager(){
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("ProItems.txt")))
        {
            electronics = (Electronics[]) inputStream.readObject();
            clothing = (Clothing[]) inputStream.readObject();
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Didn't save in file exist.");
        }
        for (int k=0;k<electronics.length;k++){
            if (electronics[k] != null){
                Max_pro++;
                q++;
            }
        }
        for (int g=0;g<clothing.length;g++){
            if (clothing[g] != null){
                Max_pro++;
                r++;
            }
        }
    }
    @Override
    public void addproduct() {
        System.out.println(Max_pro + q + r);
        Scanner sca1 = new Scanner(System.in);
        System.out.println("What Product do you want to add?");
        System.out.println("If you want to add Electronic Product Enter number 1 ");
        System.out.println("If you want to add Clothing Product Enter number 2 ");
        System.out.println("Enter Product type number: ");
        int producttype = sca1.nextInt();

        if (producttype == 1) {
            for (; q < electronics.length; q++) {

                if (Max_pro <= 50) {
                    Scanner sca = new Scanner(System.in);

                    System.out.println("Enter product ID:- ");
                    String productid = sca.next();
                    boolean isalradyhas = false;
                    for (int p = 0; p < electronics.length; p++) {
                        if (electronics[p] != null && electronics[p].getProductId().equalsIgnoreCase(productid)) {
                            isalradyhas = true;
                            System.out.println("This Product Id is already at the array.");
                        }
                    }
                    if (isalradyhas) {
                        continue;
                    }

                    System.out.println("Enter product Name:- ");
                    String productname = sca.next();

                    System.out.println("Enter Available Products:- ");
                    int availablepro = sca.nextInt();

                    System.out.println("Enter Product Price:- ");
                    int price = sca.nextInt();

                    System.out.println("Enter Product brand:- ");
                    String probrand = sca.next();

                    System.out.println("Enter Product warranty:- ");
                    int warranty = sca.nextInt();

                    Electronics obj = new Electronics(productid, productname, availablepro, price, probrand, warranty);
                    obj.setProductId(productid);
                    obj.setProductName(productname);
                    obj.setNumberOfAvailableItems(availablepro);
                    obj.setPrice(price);
                    obj.setBrand(probrand);
                    obj.setWarranty(warranty);

                    electronics[q] = obj;
                    Max_pro += 1;

                    System.out.println("You Add Product Successfully");
                    if (electronics.length == Max_pro) {
                        System.out.println("All ready there is no space to add items.");
                        break;
                    }

                    System.out.println("You want to add other Product 'YES or NO'");
                    String decision = sca.next();
                    if (decision.equalsIgnoreCase("no")) {
                        break;
                    }
                } else {
                    System.out.println("Already full");
                }
            }
            for (Electronics E : electronics) {
                if (E != null) {
                    System.out.println("ProductID: " + E.getProductId());
                    System.out.println("ProductName: " + E.getProductName());
                    System.out.println("ProductItems: " + E.getNumberOfAvailableItems());
                    System.out.println("Product Price: " + E.getPrice());
                    System.out.println("Product Brand: " + E.getBrand());
                    System.out.println("Product Warranty: " + E.getWarranty());
                    System.out.println("----------------");
                }
            }
        }else if (producttype == 2) {
            for (; r < clothing.length; r++) {

                if (Max_pro < 50) {

                    Scanner sca = new Scanner(System.in);

                    System.out.println("Enter the product ID:- ");
                    String productid = sca.next();
                    boolean isalradyhas1 = false;
                    for (int d = 0; d < clothing.length; d++) {
                        if (clothing[d] != null && clothing[d].getProductId().equalsIgnoreCase(productid)) {
                            isalradyhas1 = true;
                            System.out.println("this Product Id is already at the array.");
                        }
                    }
                    if (isalradyhas1) {
                        continue;
                    }
                    System.out.println("Enter the product Name:- ");
                    String productname = sca.next();

                    System.out.println("Enter the Available Products:- ");
                    int availablepro = sca.nextInt();

                    System.out.println("Enter the Product Price:- ");
                    int price = sca.nextInt();

                    System.out.println("Enter the Product Size:- ");
                    int prosize = sca.nextInt();

                    System.out.println("Enter the Product Color:- ");
                    String color = sca.next();

                    Clothing obj1 = new Clothing(productid, productname, availablepro, price, prosize, color);
                    obj1.setProductId(productid);
                    obj1.setProductName(productname);
                    obj1.setNumberOfAvailableItems(availablepro);
                    obj1.setPrice(price);
                    obj1.setSize(prosize);
                    obj1.setColour(color);

                    clothing[r] = obj1;
                    Max_pro += 1;
                    System.out.println("You Add the Product Successfully");
                    if (clothing.length == Max_pro) {
                        System.out.println("All ready there is no space to add items.");
                        break;
                    }

                    System.out.println("You want to add other Product 'YES or NO'");
                    String decision = sca.next();
                    if (decision.equalsIgnoreCase("no")) {
                        break;
                    }
                } else {
                    System.out.println("Already full");
                }
            }
            for (Clothing C : clothing) {
                if (C != null) {
                    System.out.println("ProductID: " + C.getProductId());
                    System.out.println("ProductName: " + C.getProductName());
                    System.out.println("ProductItems: " + C.getNumberOfAvailableItems());
                    System.out.println("Product Price: " + C.getPrice());
                    System.out.println("Product Size: " + C.getSize());
                    System.out.println("Product Color: " + C.getColour());
                    System.out.println("----------------");
                }
            }
        }
    }
    @Override
    public void delete() {

        Scanner sca = new Scanner(System.in);
        System.out.println("Enter Product ID:- ");
        String productid1 = sca.next();


        Electronics productdelete = null;
        Clothing productdelete1 = null;

        boolean electronictype = true;
        boolean clothingtype = true;

        if (electronictype) {
            for (int p = 0; p < electronics.length; p++) {
                if (electronics[p] != null && electronics[p].getProductId().equalsIgnoreCase(productid1)) {
                    productdelete = electronics[p];
                    electronics[p] = null;
                    Max_pro -= 1;
                    electronictype = false;
                    if (!electronictype) {
                        System.out.println(productid1 + "Product ID has delete in cart.");
                        break;
                    }
                }
            }
            if (!electronictype) {
                System.out.println("The Delete Product Details.");
                System.out.println("Product ID: " + productdelete.getProductId());
                System.out.println("ProductName: " + productdelete.getProductName());
                System.out.println("ProductItems: " + productdelete.getNumberOfAvailableItems());
                System.out.println("Product Price: " + productdelete.getPrice());
                System.out.println("Product Brand: " + productdelete.getBrand());
                System.out.println("Product Warranty: " + productdelete.getWarranty());
            }
        }
        if (clothingtype) {
            for (int a = 0; a < clothing.length; a++) {
                if (clothing[a] != null && clothing[a].getProductId().equalsIgnoreCase(productid1)) {
                    productdelete1 = clothing[a];
                    clothing[a] = null;
                    Max_pro -= 1;
                    clothingtype = false;
                    if (!clothingtype) {
                        System.out.println(productid1 + "Product ID has delete in cart.");
                        break;
                    } else {
                        System.out.println("There is no Product ID!! " + productid1);
                    }
                }
            }
            if (!clothingtype) {
                System.out.println("The Delete Product Details.");
                System.out.println("Product ID:- " + productdelete1.getProductId());
                System.out.println("ProductName: " + productdelete1.getProductName());
                System.out.println("ProductItems: " + productdelete1.getNumberOfAvailableItems());
                System.out.println("Product Price: " + productdelete1.getPrice());
                System.out.println("Product Size: " + productdelete1.getSize());
                System.out.println("Product Color: " + productdelete1.getColour());
            }
        }
        if (electronictype && clothingtype) {
            System.out.println("There is no Product ID!! " + productid1);
        }
    }
    @Override
    public void PrintListofProduct() {

        ArrayList<Product> productList = new ArrayList<>();

        for (int a = 0; a < electronics.length; a++) {
            if (electronics[a] != null) {
                productList.add(electronics[a]);
            }
        }
        for (int p = 0; p < clothing.length; p++) {
            if (clothing[p] != null) {
                productList.add(clothing[p]);
            }
        }
        Collections.sort(productList, Comparator.comparing(Product::getProductId));

        for (Product products : productList) {
            if (products instanceof Electronics) {
                System.out.println("Electronic Product: ");
                System.out.println("Product ID: " + products.getProductId());
                System.out.println("Product name: " + products.getProductName());
                System.out.println("Number of Items: " + products.getNumberOfAvailableItems());
                System.out.println("Product Price: " + products.getPrice());
                System.out.println("Product Brand: " + ((Electronics) products).getBrand());
                System.out.println("Product Warranty: " + ((Electronics) products).getWarranty());

            } else if (products instanceof Clothing) {

                System.out.println("Electronic Product: ");
                System.out.println("Product ID: " + products.getProductId());
                System.out.println("Product name: " + products.getProductName());
                System.out.println("Number of Items: " + products.getNumberOfAvailableItems());
                System.out.println("Product Price: " + products.getPrice());
                System.out.println("Product Size: " + ((Clothing) products).getSize());
                System.out.println("Product Color: " + ((Clothing) products).getColour());
            }
        }
    }
    @Override
    public void savetoFile() {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("ProItems.txt"))){
            outputStream.writeObject(electronics);
            outputStream.writeObject(clothing);
            outputStream.close();
            System.out.println("Save to file.");
        }catch (IOException e){
            System.out.println(e);
        }
    }
}

