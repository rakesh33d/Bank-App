import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter your name,password,balance to create a account");
        //create user

        String name=sc.nextLine();
        String password=sc.nextLine();
        double balance=sc.nextDouble();
        SBIUser user = new SBIUser(name,balance,password);

        //add money
        System.out.println("enter amount you want to add ");
        int amt=sc.nextInt();
String message= user.addMoney(amt);
        System.out.println(message);

        //withdraw money
        System.out.println("enter amount you want to withdraw :");
        int money=sc.nextInt();
        System.out.println("enter your password ");
        String pass =sc.next();
        System.out.println(user.withdrawMoney(money,pass));

        //calculate rate of interest
        System.out.println("Enter no of years for which you want to cal interest : ");
         int years=sc.nextInt();
        double interest = user.calculateInterest(years);
        System.out.println("Interest for "+ years+" years is "+interest);
    }
}