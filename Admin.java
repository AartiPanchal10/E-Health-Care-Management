import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Admin {
    public static void main(String[] args) throws Exception {
        String Add;
        String ID;
        String password;
        String name;
        String Specialist = "";
        String Experience;
        String Available_Days;
        String fees;
        int Sl_No;
        String Age;
        String Gender;
        String Email;
        String Disese;
        String Dr_Name;
        String Appointment_Date;
        String Prescription;
        String next_Date;
        String feedBack;
        String namep;
        String passwordD;
        String Degree = "MBBS";
        String k;
        Scanner s = new Scanner(System.in);
        System.out.println("1.Admin                   2.Patients                   3.Doctor ");
        int n = s.nextInt();
        switch (n) {
            case 1:
                System.out.println("Please enter ID: ");
                s.nextLine();
                ID = s.nextLine();
                System.out.println("Please enter passowrd: ");
                password = s.nextLine();
                if (ID.equals("aartipanchal001@gmail.com") && password.equals("Aarti@123")) {
                    System.out.println("Login successful.");
                    System.out.println("press {1} for Add Doctor");
                    System.out.println("press {2} for Delete Doctor");
                    System.out.println("press {3} for Update Doctor Data");
                    System.out.println("press {4} for View Doctor List");
                    System.out.println("press {5} for View Patient List");

                    Add = s.nextLine();
                    if (Add.equals("1")) {
                        System.out.println("Please enter Sl_No: ");
                        Sl_No = s.nextInt();
                        s.nextLine();
                        System.out.println("Please enter the Name :");
                        name = s.nextLine();
                        System.out.println("Please enter your password: ");
                        passwordD = s.nextLine();
                        System.out.println("Please enter the Specialist: ");
                        Specialist = s.nextLine();
                        System.out.println("Please enter the Experience: ");
                        Experience = s.nextLine();
                        System.out.println("Please enter the Available_Days: ");
                        Available_Days = s.nextLine();
                        System.out.println("Please enter the fees: ");
                        fees = s.nextLine();
                        Degree = "MBBS";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        System.out.println("Driver Loaded Successfully");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dlist", "root",
                                "Aarti@12345");
                        System.out.println("Successfully");

                        PreparedStatement ps = con.prepareStatement("insert into ListDoctor values(?,?,?,?,?,?,?,?)");
                        ps.setInt(1, Sl_No);
                        ps.setString(2, name);
                        ps.setString(3, passwordD);
                        ps.setString(4, Specialist);
                        ps.setString(5, Experience);
                        ps.setString(6, Available_Days);
                        ps.setString(7, fees);
                        ps.setString(8, Degree);
                        int i = ps.executeUpdate();

                        if (i > 0) {
                            System.out.println("Success");
                        } else {
                            System.out.println("fail");
                        }
                    } else if (Add.equals("2")) {
                        try {
                            System.out.println("Please Press Sl_No to delete the Doctor: ");
                            Sl_No = s.nextInt();
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            System.out.println("Driver Loaded Successfully");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dlist", "root",
                                    "Aarti@12345");
                            PreparedStatement ps = con.prepareStatement("delete from ListDoctor where Sl_No=?");
                            ps.setInt(1, Sl_No);
                            int i = ps.executeUpdate();
                            if (i > 0) {
                                System.out.println("success");
                            } else {
                                System.out.println("Fail");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (Add.equals("3")) {
                        try {
                            System.out.println("Please Press Sl_No to update the Doctor: ");
                            Sl_No = s.nextInt();
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            System.out.println("Driver Loaded Successfully");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dlist", "root",
                                    "Aarti@12345");
                            PreparedStatement ps = con.prepareStatement(
                                    "update ListDoctor set Experience=?, Available_Days=?, Fees=? where Sl_No=?");
                            System.out.println("Update Experience");
                            s.nextLine();
                            Experience = s.nextLine();
                            ps.setString(1, Experience);
                            System.out.println("Update Available_Days");
                            Available_Days = s.nextLine();
                            ps.setString(2, Available_Days);
                            System.out.println("Update fees");
                            fees = s.nextLine();
                            ps.setString(3, fees);
                            ps.setInt(4, Sl_No);
                            int i = ps.executeUpdate();
                            if (i > 0) {
                                System.out.println("success");
                            } else {
                                System.out.println("Fail");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (Add.equals("4")) {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        // System.out.println("Driver Loaded Successfully");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dlist", "root",
                                "Aarti@12345");

                        String str = "select * from ListDoctor ";
                        PreparedStatement ps = con.prepareStatement(str);
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            name = rs.getString("name");
                            Experience = rs.getString("Experience");
                            Available_Days = rs.getString("Available_Days");
                            fees = rs.getString("Fees");
                            Specialist = rs.getString("Specialist");
                            System.out.println(
                                    name + '\n' + Specialist + '\n' + Experience + '\n' + Available_Days + '\n'
                                            + fees);
                        }
                    } else if (Add.equals("5")) {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        // System.out.println("Driver Loaded Successfully");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dlist", "root",
                                "Aarti@12345");

                        String str = "select * from ListPatient ";
                        PreparedStatement ps = con.prepareStatement(str);
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            namep = rs.getString("namep");
                            password = rs.getString("password");
                            Age = rs.getString("Age");
                            Gender = rs.getString("Gender");
                            Email = rs.getString("Email");
                            Disese = rs.getString("Disease");
                            Dr_Name = rs.getString("Dr_Name");
                            fees = rs.getString("Fees");
                            Appointment_Date = rs.getString("Appointment");
                            Prescription = rs.getString("prescription");
                            next_Date = rs.getString("next_Date");
                            feedBack = rs.getString("giveFeedback");

                            System.out.println(namep + "   " + password + "   " + Age + "   " + Gender + "   " + Email
                                    + "   " + Disese + "   " + Dr_Name + "   " + fees + "   " + Appointment_Date + "   "
                                    + Prescription + "   " + next_Date + "   " + feedBack);
                        }
                    }
                }
                break;
            case 2:

                System.out.println("Please press 1 for signup: ");
                System.out.println("Please press 2 for login: ");
                int p = s.nextInt();
                if (p == 1) {
                    System.out.println("Sl_No: ");
                    Sl_No = s.nextInt();
                    System.out.println("Enter your name: ");
                    s.nextLine();
                    namep = s.nextLine();
                    System.out.println("Create your password: ");
                    password = s.nextLine();
                    System.out.println("Enter your Age: ");
                    Age = s.nextLine();
                    System.out.println("Enter your Gender: ");
                    Gender = s.nextLine();
                    System.out.println("Enter your Email ID: ");
                    Email = s.nextLine();

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    // System.out.println("Driver Loaded Successfully");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dlist", "root",
                            "Aarti@12345");
                    System.out.println("Enter your Disese: ");
                    Disese = s.nextLine();
                    String str = "select * from ListDoctor where Specialist=?";
                    PreparedStatement ps = con.prepareStatement(str);
                    ps.setString(1, Disese);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        name = rs.getString("name");

                        Experience = rs.getString("Experience");
                        Available_Days = rs.getString("Available_Days");
                        fees = rs.getString("Fees");
                        Specialist = rs.getString("Specialist");
                        System.out.println(
                                name + "   " + Specialist + "   " + Experience + "   " + Available_Days + "   " + fees);
                    }
                    System.out.println("Enter the Doctor Name: ");
                    Dr_Name = s.nextLine();
                    System.out.println("Please pay fees: ");
                    fees = s.nextLine();
                    System.out.println("Enter Appointment Day: ");
                    Appointment_Date = s.nextLine();
                    Prescription = "null";
                    next_Date = "null";
                    feedBack = "null";
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        // System.out.println("Driver Loaded Successfully");
                        Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dlist", "root",
                                "Aarti@12345");
                        PreparedStatement ps1 = con1
                                .prepareStatement("insert into  ListPatient values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        ps1.setInt(1, Sl_No);
                        ps1.setString(2, namep);
                        ps1.setString(3, password);
                        ps1.setString(4, Age);
                        ps1.setString(5, Gender);
                        ps1.setString(6, Email);
                        ps1.setString(7, Disese);
                        ps1.setString(8, Dr_Name);
                        ps1.setString(9, fees);
                        ps1.setString(10, Appointment_Date);
                        ps1.setString(11, Prescription);
                        ps1.setString(12, next_Date);
                        ps1.setString(13, feedBack);
                        int i = ps1.executeUpdate();
                        if (i > 0) {
                            System.out.println("success");
                        } else {
                            System.out.println("Fail");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (p == 2) {

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    // System.out.println("Driver Loaded Successfully");
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dlist", "root",
                            "Aarti@12345");
                    System.out.println("Enter your ID: ");
                    s.nextLine();
                    namep = s.nextLine();

                    System.out.println("Enter your password");
                    password = s.nextLine();

                    String str9 = "select * from ListPatient where namep=? and password=?";
                    PreparedStatement ps2 = con2.prepareStatement(str9);
                    ps2.setString(1, namep);
                    ps2.setString(2, password);
                    ResultSet rs2 = ps2.executeQuery();
                    while (rs2.next()) {
                        System.out.println("Patient Data: ");
                        namep = rs2.getString("namep");
                        password = rs2.getString("password");
                        Age = rs2.getString("Age");
                        Gender = rs2.getString("Gender");
                        Email = rs2.getString("Email");
                        Disese = rs2.getString("Disease");
                        Dr_Name = rs2.getString("Dr_Name");
                        fees = rs2.getString("Fees");
                        Appointment_Date = rs2.getString("Appointment");

                        System.out.println("Patient Name: " + namep + '\n' + "Age: " + Age + '\n' + "Gender: " + Gender
                                + '\n' + "Email: "
                                + Email +'\n'+ "Disease: " + Disese +'\n'+ "Dr_Name: "  + Dr_Name+'\n' + "Fees: "
                                + fees+'\n'+"Appointment date : "+Appointment_Date);
                    }
                    System.out.println("If you want to book your next Appointment, please press Yes: ");

                    k = s.nextLine();
                    if (k.equals("Yes")) {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        // System.out.println("Driver Loaded Successfully");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dlist", "root",
                                "Aarti@12345");
                        PreparedStatement ps3 = con.prepareStatement(
                                "update ListPatient set Fees = ?,giveFeedback=? where namep=? and password=?");
                        System.out.println("Pay fees");
                        s.nextLine();
                        fees=s.nextLine();
                        System.out.println("Please give feedback");
                        feedBack = s.nextLine();
                        // feedBack = s.nextLine();
                        ps3.setString(1, fees);
                        ps3.setString(2, feedBack);
                        ps3.setString(3, namep);
                        ps3.setString(4, password);
                        int i = ps3.executeUpdate();
                        if (i > 0) {
                            System.out.println(
                                    "-----------------------------------------------Thank you------------------------------------------------------");
                        } else {
                            System.out.println("not Done");
                        }
                    } else {
                        System.out.println(
                                "-----------------------------------------------Thank you------------------------------------------------------");
                    }
                }
                break;
            case 3:
                Class.forName("com.mysql.cj.jdbc.Driver");
                // System.out.println("Driver Loaded Successfully");
                Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dlist", "root",
                        "Aarti@12345");
                System.out.println("Enter your ID: ");
                s.nextLine();
                name = s.nextLine();

                System.out.println("Enter your password");
                password = s.nextLine();
                String str9 = "select * from ListDoctor where name=? and password=?";
                PreparedStatement ps2 = con2.prepareStatement(str9);
                ps2.setString(1, name);
                ps2.setString(2, password);
                ResultSet rs2 = ps2.executeQuery();
                while (rs2.next()) {
                    s.nextLine();
                    System.out.println("       Your Data: ");
                    System.out.println();
                    name = rs2.getString("name");
                    password = rs2.getString("password");
                    Specialist = rs2.getString("Specialist");
                    Experience = rs2.getString("Experience");
                    Available_Days = rs2.getString("Available_Days");
                    fees = rs2.getString("fees");

                    System.out.println("Name: " + name + '\n' + "Password: " + password + '\n' + "Specialist: "
                            + Specialist + '\n' + "Experience: " + Experience + '\n' + "Available_Days: "
                            + Available_Days + '\n' + "Fees: " + fees);
                }
                System.out.println("If you want to check Patient List: ");
                System.out.println("Yes/No");
                k = s.nextLine();
                if (k.equals("Yes")) {
                    System.out.println("Enter your name: ");
                    String named = s.nextLine();
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    // System.out.println("Driver Loaded Successfully");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dlist", "root",
                            "Aarti@12345");
                    PreparedStatement ps3 = con.prepareStatement("select * from ListPatient where Dr_Name=? ");

                    ps3.setString(1, named);
                    ResultSet rs3 = ps3.executeQuery();
                    while (rs3.next()) {
                        System.out.println("___________________________________________________________________");
                        System.out.println("---------Patient Data---------");
                        namep = rs3.getString("namep");
                        // password = rs2.getString("password");
                        Age = rs3.getString("Age");
                        Gender = rs3.getString("Gender");
                        Email = rs3.getString("Email");
                        Disese = rs3.getString("Disease");
                        Dr_Name = rs3.getString("Dr_Name");
                        fees = rs3.getString("Fees");
                        Appointment_Date = rs3.getString("Appointment");

                        System.out.println("Patient Name: " + namep + '\n' + "Age: " + Age + '\n' + "Gender: " + Gender
                                + '\n' + "Email: "
                                + Email + '\n' + "Disease: " + Disese + '\n' + "Dr_Name: " + Dr_Name + '\n' + "Fees: "
                                + fees + '\n' + Appointment_Date);
                    }
                }
                System.out.println("If you want to check patient ");
                System.out.println("Yes/No");
                k = s.nextLine();
                if (k.equals("Yes")) {
                    System.out.println("Enter the patient name");
                    namep = s.nextLine();
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    // System.out.println("Driver Loaded Successfully");
                    Connection con4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dlist", "root",
                            "Aarti@12345");
                    PreparedStatement ps6 = con4
                            .prepareStatement(" update ListPatient set prescription = ?,next_Date=? where namep=? ");
                    System.out.println("Enter medicine ");
                    Prescription = s.nextLine();
                    System.out.println("Enter the next appointment date");
                    next_Date = s.nextLine();
                    ps6.setString(1, Prescription);
                    ps6.setString(2, next_Date);
                    ps6.setString(3, namep);
                    int i = ps6.executeUpdate();
                    if (i > 0) {
                        System.out.println(
                                "-----------------------------------------------Thank you------------------------------------------------------");
                    } else {
                        System.out.println("not Done");
                    }
                } else {
                    System.out.println(
                            "-----------------------------------------------Thank you------------------------------------------------------");
                }

        }
    }
}
