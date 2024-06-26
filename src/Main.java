import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number:- ");
        int options = scanner.nextInt();
        WestminsterShoppingManager obj3 = new WestminsterShoppingManager();
        while (options!=0){
            switch (options){
                case 1 :
                    obj3.addproduct();
                    break;
                case 2 :
                    obj3.delete();
                    break;
                case 3 :
                    obj3.PrintListofProduct();
                    break;
                case 4:
                    obj3.savetoFile();
                    break;
                default:
                    System.out.println("Invalid Input!! Try Again.");
            }
            System.out.println("Enter Menu Number:- ");
            options=scanner.nextInt();
        }
        System.out.println("Thank You!");
    }
}