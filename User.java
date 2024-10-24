import java.util.Scanner;
public class User {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your Designation: ");
        System.out.println("Press 1 for Admin");
        System.out.println("Press 2 for Doctor");
        System.out.println("Press 3 for Patient");
        System.out.println("Please enter 1, 2 or 3: ");
        int option = s.nextInt();
        String ID;
        String RID;
        String password;
        switch (option){
            case 1:
            System.out.println("Please enter your User ID");
            ID=s.next();
            while (ID!="Admin003@MG") {
            if(ID.equals("Admin003@MG"))
            {
                System.out.println("Please enter password: ");
                password=s.next();
                if(password.equals("admin@123"))
                {
                System.out.println("login Successful.");
                break;
                }
            else
            {
                System.out.println("Invalid password");
                
            }
            }
            else if (ID!="Admin003@MG")
            {
                System.out.println("Please enter correct User ID");
                RID=s.next();
                ID=RID;
            }
            }
            break;
            case 2:
            System.out.println("Please enter your User ID");
            ID=s.next();
            while (ID!="Doctor003@MG") {
            if(ID.equals("Doctor003@MG"))
            {
                System.out.println("Please enter password: ");
                password=s.next();
                if(password.equals("doctor@123"))
                {
                System.out.println("login Successful.");
                break;
                }
            else
            {
                System.out.println("Invalid password");
                
            }
            }
            else if (ID!="Doctor003@MG")
            {
                System.out.println("Please enter correct User ID");
                RID=s.next();
                ID=RID;
            }
            }
            break;
            case 3:
            System.out.println("Please enter your User ID");
            ID=s.next();
            while (ID!="Patient003@MG") {
            if(ID.equals("Patient003@MG"))
            {
                System.out.println("Please enter password: ");
                password=s.next();
                if(password.equals("patient@123"))
                {
                System.out.println("login Successful.");
                break;
                }
            else
            {
                System.out.println("Invalid password");
                
            }
            }
            else if (ID!="Patient003@MG")
            {
                System.out.println("Please enter correct User ID");
                RID=s.next();
                ID=RID;
            }
            }
            break;
            }
            }
    }


