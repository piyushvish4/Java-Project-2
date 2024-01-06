package java_project_2;
// Roll no.= 21124041   Name=Piyush Sharma
public class runfile {
    public static void main(String[] args) {
        //making an object of class ATM and passing account numbers and theirs pins in constructor
ATM a=new ATM(123456789,234567891,345678912,456789123,567891234,1234,2345,3456,4567,5678);
//account no. 1= 123456789 , pin=1234
//account no. 2= 234567891 , pin=2345
//account no. 3= 345678912 , pin=3456
//account no. 4= 456789123 , pin=4567
//account no. 5= 567891234 , pin=5678

        //calling the method account_details()
a.account_details();




    }
}
