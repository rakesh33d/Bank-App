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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getRateOfInterest() {
        return rateOfInterest;
    }

    public static void setRateOfInterest(double rateOfInterest) {
        HDFCUser.rateOfInterest = rateOfInterest;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
