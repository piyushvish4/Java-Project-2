package java_project_2;
// Roll no.= 21124041   Name=Piyush Sharma
public class account {
    //instance variable to store account number taken from the user
    private long account_no;
    //instance variable to store pin number taken from the user
    private long pin_no;
    //instance variable to store balance for saving account
    private double saving_balance;
    //instance variable to store balance for current account
    private double current_balance;
    //method that updates value of instance variable account_no(a setter)
    public void setAccount_no(long account_no){
        this.account_no=account_no;
    }
    //method that returns the value of the instance variable account_no(a getter)
    public long getAccount_no(){
        return account_no;
    }
    //method that updates the value of the instance variable pin_no(a setter)
    public void setPin_no(long pin_no){
        this.pin_no=pin_no;
    }
    //method that returns the value of the instance variable pin_no(a getter)
    public long getPin_no(){
        return pin_no;
    }
    //method to withdraw money from a bank account(it decrements the balance in a bank account)
    //it takes the amount to be withdrawn as a parameter and returns true or false
    public boolean withdraw_saving_account(double amount){
        //if the balance after the withdrawal of money is greater than or equal to zero
        //then it updates the value of saving_balance as saving_balance - amount and returns true

        if(saving_balance-amount>=0) {
            saving_balance -= amount;
            return true;
        }
        //else if the balance after the withdrawal is less than zero than it prints "Your balance is not enough to withdraw this amount"
        //and returns false
        else{
            System.out.println("\nYour balance is not enough to withdraw this amount\n");
            return false;
        }
    }

    //method to deposit money in bank account(it increments the balance in bank account)
    //it takes the amount to be deposited as a parameter and increments the balance by that amount
    public void deposit_saving_account(double amount){
        saving_balance+=amount;
    }

    //method to withdraw money from a bank account(it decrements the balance in a bank account)
    //it takes the amount to be withdrawn as a parameter and returns true or false
    public boolean withdraw_current_account(double amount){
        //if the balance after the withdrawal of money is greater than or equal to zero
        //then it updates the value of current_balance as current_balance - amount and returns true

            if (current_balance - amount >= 0) {
                current_balance -= amount;
                return true;
            }
            //else if the balance after the withdrawal is less than zero than it prints "Your balance is not enough to withdraw this amount"
            //and returns false
            else {
                System.out.println("\nYour balance is not enough to withdraw this amount \n");
               return false;
            }
    }

    //method to deposit money in bank account(it increments the balance in bank account)
    //it takes the amount to be deposited as a parameter and increments the balance by that amount
    public void deposit_current_account(double amount){
        current_balance+=amount;
    }
    //this method prints the balance in the current account
    public void check_current_balance(){
        System.out.println("Your current balance : "+current_balance);
    }
    //this method prints the balance in the saving account

    public void check_saving_balance(){
        System.out.println("Your current balance : "+saving_balance);

    }
}
