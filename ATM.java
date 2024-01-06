package java_project_2;
// Roll no.= 21124041   Name=Piyush Sharma
import java.util.InputMismatchException;
import java.util.Scanner;



public class ATM {
    // an array of size 5 to store account numbers of different users
    private long[] acc=new long[5];
    // an array of size 5 to store the pin of the respected account number in the acc array
    private long[] pin=new long[5];
    // a constructor which initializes all the elements in the acc array which the respective account numbers and pin of that account is stored in the respective indexed element of
    //the array pin
    // I have considered that the account number a3 and a4 are registered as current accounts and the other are registered as saving account
    //a3 and a4 are stored in 2nd and 3rd indexed element of the array acc
    ATM(long a1,long a2,long a3,long a4,long a5,long p1,long p2,long p3,long p4,long p5){
        acc[0]=a1;//saving account
        acc[1]=a2;//saving account
        acc[2]=a3;//current account
        acc[3]=a4;//current account
        acc[4]=a5;//saving account
        pin[0]=p1;//pin of a1
        pin[1]=p2;//pin of a2
        pin[2]=p3;//pin of a3
        pin[3]=p4;//pin of a4
        pin[4]=p5;//pin of a5


    }
    // creating objects of the class account and allocating memory to them ,each object for each Account
    account A1=new account();
    account A2=new account();
    account A3=new account();
    account A4=new account();
    account A5=new account();
    // creating an object temp and allocating memory to it,we will temporarily store the account number taken from the user in its instance variable until we find
    //which element of the array acc which matches with the value of temp's instance variable account_no
    account temp=new account();
    account n1;

    public void pin_details(int a){
//creating a flag and initializing it as true
        //the do while loop will iterate if the condition is true, till now the condition is false, but if an exception occurs then we change the flag to false
        // and the condition !flag becomes true thus another iteration takes place
        boolean flag =true;
        do {
            //using try and catch inside the loop for exception handling

            try {
                flag=true;
               //taking the account number's pin as input from the user and using setter of the object n1 to initialize the value of its instance variable pin_no
                System.out.print("Please enter your pin :");
                Scanner ob = new Scanner(System.in);
                n1.setPin_no(ob.nextInt());
                //if a value other than an integer is entered then  InputMismatchException will occur and the control will pass to the respective catch statement


                //using if statement  checking if the entered pin  is equal to the pin of that respective account number
                //if they are equal then the method atm_functions is called and a(i.e the index of the element of the array pin and acc )is passed as an argument
                //else "The pin entered is wrong , please enter the current pin to proceed" will be printed and pin details method will be called again and a will be passes as an argument
                int i=0;
                if(pin[a]==n1.getPin_no()){
                   atm_functions(a);
                }else{
                    System.out.println(" \nThe pin entered is wrong , please enter the current pin to proceed\n");
                    pin_details(a);
                }
            }
            //if InputMismatchException occurs then "Please do not give any alphabet or symbol as input" will be printed and the flag will change to false

            catch (InputMismatchException e){
                System.out.println("\nPlease do not give any alphabet or symbol as input");
                flag=false;
            }
        } while(!flag);
    }


    // method to take account number as input from the user
    public void account_details(){

//creating a flag and initializing it as true
        //the do while loop will iterate if the condition is true, till now the condition is false, but if an exception occurs then we change the flag to false
        // and the condition !flag becomes true thus another iteration takes place
        boolean flag =true;
          do {
              //using try and catch inside the loop for exception handling
            try {
                flag=true;
                System.out.println("\n                        WELCOME TO THIS ATM PROGRAM !!                        \n");
                //taking user's account number as input and updating it to object temp's instance variable account_no using its setAccount_no() method

                System.out.print("Please enter your account number: ");
                Scanner ob = new Scanner(System.in);
                temp.setAccount_no(ob.nextInt());
             //if a value other than an integer is entered then  InputMismatchException will occur and the control will pass to the respective catch statement

             int i=0;
             //using while loop checking which element of the array acc matches with the value stored in instance variable account_no in the object temp
             //the value of that instance variable is obtained by using its getAccount_no method
                while( acc[i]!=temp.getAccount_no()) {
                    //if the element is found then the loop will break and the value of its index will be obtained , else the loop will iterate again and at a time
                    //the value of i will be greater than 4 and ArrayIndexOutOfBoundsException will take place and the control will be transferred to the respective catch statement
                 if(acc[i]==temp.getAccount_no()){
                    break;
                 }
                 i++;
                }
                //now that we know the index of the element of the array acc in which user's account number is stored
                //so now we will set the instance variable account_no of the respective object corresponding to the index using its setter and getter of the object temp
                switch (i){
                    //if index is 0 ,then we will set account_no of the object A1 using the setter of A1 and getter of the object temp
                    case 0:  A1.setAccount_no(temp.getAccount_no());
                    //A1 contains the address of the memory location of the object A1,we will assign A1 to n1 so now n1 also contains the address of that memory location
                    n1=A1;
                    //similarly we will do this for other cases
                    break;
                    case 1:  A2.setAccount_no(temp.getAccount_no());
                     n1=A2;
                    break;
                    case 2:  A3.setAccount_no(temp.getAccount_no());
                    n1=A3;
                    break;
                    case 3:  A4.setAccount_no(temp.getAccount_no());
                    n1=A4;
                    break;
                    case 4:  A5.setAccount_no(temp.getAccount_no());
                    n1=A5;
                    break;

                }
                //now depending on the account number different object will be used
                //Now we have called pin_details method and passed the index as a parameter
                pin_details(i);
            }
            //if ArrayIndexOutOfBoundsException occurs then "Sorry!,this account is not registered here. Please try again." will be printed and the flag will change to false
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("\nSorry!,this account is not registered here. Please try again.\n");
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                flag =false;
            }
            //if InputMismatchException occurs then "Please do not give any alphabet or symbol as input" will be printed and the flag will change to false

            catch (InputMismatchException e){
                System.out.println("\nPlease do not give any alphabet or symbol as input\n");
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                flag=false;
            }
        } while(!flag);

    }
    public void account_type(int n,int a8){
        //creating a flag and initializing it as true
        //the do while loop will iterate if the condition is true, till now the condition is false, but if an exception occurs then we change the flag to false
        // and the condition !flag becomes true thus another iteration takes place
        boolean flag =true;
        do {
            //using try and catch inside the loop for exception handling

          try {


              System.out.println("\nSelect your account type:- \n");
              System.out.println("Option 1: Type 1 for current account ");
              System.out.println("Option 2: Type 2 for saving account ");
              Scanner m = new Scanner(System.in);
              System.out.print("\nYour choice : ");
              //taking input from user, 1 for current account and 2 for saving account and storing input in n2
              int n2 = m.nextInt();


              if (n2 == 1) {


                      try {

                       //checking if a8 is equal to 2 or 3 as the elements of the array acc with index 2 and 3 are registered to current account
                          //if it does ,then it means that the account  is registered to current account
                          if(a8==2||a8==3) {
                              //here n is the choice for withdrawal,deposit and checking balance
                              switch (n) {
                                  case 3:
                                      //current balance will be printed
                                      n1.check_current_balance();
                                      System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                                      //Once after printing the balance ,the job is done so we will call account_details() method again for the next task to be done that will be asked by the user
                                      account_details();

                                      break;
                                  case 2:
                                      //current balance will be printed
                                      n1.check_current_balance();
                                      System.out.println("Enter the amount you want to deposit: ");
                                      System.out.print("Amount :");
                                      //amount will be taken as input from user
                                      double amount = m.nextDouble();
                                      //deposit_current_account method will be called and amount will be passed as argument,this will increment the balance by amount
                                      n1.deposit_current_account(amount);
                                      //current balance will be printed
                                      n1.check_current_balance();
                                      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                      //Once after printing the balance ,the job is done so we will call account_details() method again for the next task to be done that will be asked by the user
                                      account_details();

                                      break;
                                  case 1:
                                      //current balance will be printed
                                      n1.check_current_balance();
                                      System.out.println("Enter the amount you want to withdraw :");
                                      System.out.print("Amount :");
                                      //amount will be taken as input from user
                                      amount = m.nextDouble();
                                      //withdraw_current_account(amount) method will return true or false depending upon the value of current_balance - amount
                                      flag = n1.withdraw_current_account(amount);
                                      //if flag is true that means the amount is sufficient to withdraw from the atm(i.e current_balance - amount >=0)
                                      if (flag==true){
                                          //current balance will be printed
                                          n1.check_current_balance();
                                      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                      System.out.println("\n\n");
                                          //Once after printing the balance ,the job is done so we will call account_details() method again for the next task to be done that will be asked by the user
                                          account_details();

                                      break;}
                              }
                          }else{
                              //if a8 is neither 2 or 3 then this block will be executed
                              //it will mean that the registered account is not a current account
                              System.out.println("\nSorry , it seems your registered account is not a current account \n");
                              //flag will change to false
                             flag=false;
                          }
                      } catch (InputMismatchException b) {
                          //if any exception occurs during the time of input then this block will be executed
                          System.out.println("Please do not enter any alphabet or symbol as an input!!");
                          flag=false;
                      }

              } else if (n2 == 2) {
                  //checking if a8 is equal to 0 or 1 or 4 as the elements of the array acc with index 0,1 and 4 are registered to saving account
                  //if it does ,then it means that the account  is registered to saving account
                  try {
                      if(a8==1||a8==4||a8==0) {
                          //here n is the choice for withdrawal,deposit and checking balance

                          switch (n) {
                              case 3:
                                  //saving balance will be printed
                                  n1.check_saving_balance();
                                  System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                  System.out.println("\n\n");
                                  //Once after printing the balance ,the job is done so we will call account_details() method again for the next task to be done that will be asked by the user
                                  account_details();
                                  break;
                              case 2:
                                  //saving balance will be printed
                                  n1.check_saving_balance();
                                  System.out.println("Enter the amount you want to deposit: ");
                                  System.out.print("Amount :");
                                  //amount will be taken as input from user
                                  double amount = m.nextDouble();
                                  //deposit_saving_account method will be called and amount will be passed as argument,this will increment the balance by amount
                                  n1.deposit_saving_account(amount);
                                  //saving balance will be printed
                                  n1.check_saving_balance();
                                  System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                  System.out.println("\n\n");
                                  //Once after printing the balance ,the job is done so we will call account_details() method again for the next task to be done that will be asked by the user
                                  account_details();
                                  break;
                              case 1:
                                  //saving balance will be printed
                                  n1.check_saving_balance();
                                  System.out.println("Enter the amount you want to withdraw :");
                                  System.out.print("Amount :");
                                  amount = m.nextDouble();
                                  flag=n1.withdraw_saving_account(amount);//
                                  //if flag is true that means the amount is sufficient to withdraw from the atm(i.e saving_balance - amount >=0)
                                  if(flag==true){
                                      //saving balance will be printed
                                      n1.check_saving_balance();
                                  System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                  System.out.println("\n\n");
                                      //Once after printing the balance ,the job is done so we will call account_details() method again for the next task to be done that will be asked by the user

                                      account_details();
                                  break;}

                          }
                      }else{    //if a8 is neither 0 or 1 or 4 then this block will be executed
                          //it will mean that the registered account is not a saving account
                          System.out.println("\nSorry , it seems your registered account is not a saving account \n");
                          flag=false;//...

                      }
                  }catch (InputMismatchException a){
                      //if any exception occurs during the time of input then this block will be executed
                      System.out.println("\nPlease do not enter any alphabet or symbol as an input!!\n");
                       flag=false;
                  }
              }else{
                  //if n2 is neither 2 nor 1 then this block will be executed and InputMismatchException will be thrown
                  throw new InputMismatchException();
              }
          }catch (InputMismatchException e){
              //for the above thrown exception this catch block will be executed
              System.out.println("\nPlease give 1 or 2 as input only\n");
              flag=false;

          }
        }while (!flag);
    }
//method that allows user to choose between withdraw,deposit and viewing  account balance
    public void atm_functions(int a8){
        boolean flag=true;
        //creating a flag and initializing it as true
        //the do while loop will iterate if the condition is true, till now the condition is false, but if an exception occurs then we change the flag to false
        // and the condition !flag becomes true thus another iteration takes place
        do {
            //using try and catch inside the loop for exception handling

            try{
                flag=true;
            System.out.println("\nSelect the function you want to perform :-\n");
            System.out.println("Option 1:  Type 1 to withdraw cash");
            System.out.println("Option 2:  Type 2 to deposit cash");
            System.out.println("Option 3:  Type 3 to view account balance");
            System.out.print("\nYour choice : ");
            Scanner m = new Scanner(System.in);
            int n = m.nextInt();
            //if n is any other than 1,2 and 3 then an InputMismatchException will be thrown
            if(n!=1&&n!=2&&n!=3){
                throw new InputMismatchException();
            }
            //a method account_type will be called and n and a8(i.e the index of the element of the array pin and acc ) will be passed as arguments
            account_type(n,a8);}
            catch (InputMismatchException e){
                System.out.println("\n Please type 1 or 2 or 3 as input only\n");
                flag=false;
            }

        }while(!flag);

    }



}
