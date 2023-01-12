import java.util.Objects;
import java.util.UUID;

public class HDFCUser implements BankInterface{

    private String name;
    private String accountNo;
    private double balance;
    private static double rateOfInterest;

    private String password;

    public HDFCUser(String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;

        //bank initialize
        this.rateOfInterest = 7.0;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int amount) {
        balance=balance+amount;
        return "Updated balance is : "+balance;
    }

    @Override
    public String withdrawMoney(int amount, String enteredPassword) {
        if(Objects.equals(enteredPassword,password)){
            if(amount>balance){
                return "Insufficient funds :(";
            }
            else {
                balance = balance -amount;
                return "Withdrawal of "+amount+" done";
            }
        }
        else{
            return "Wrong password !";
        }
    }

    @Override
    public double calculateInterest(int years) {
        return (balance*years*rateOfInterest)/100;
    }
}
