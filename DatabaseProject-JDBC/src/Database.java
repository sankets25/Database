import java.io.*;
import java.sql.*;


public class Database {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//Datbase Connection
        Class.forName("com.mysql.jdbc.Driver"); 
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Company","","");  //establishing connection with database

        try {

            ///////////////////////////////////////////sql insert command for department table insert///////////////////////////////////////////////////////
            String sql = "INSERT INTO DEPARTMENT (Dname, Dnumber, Mgr_ssn, Mgr_start_date) VALUES (?, ?, ?, ?)";
            //sql commands are precompiled and stored in prepared statement object
            PreparedStatement statement = con.prepareStatement(sql);  //prepared statement object

            Statement statement1 = con.createStatement();

            statement1.executeQuery("SET FOREIGN_KEY_CHECKS = 0");    //set the foreign key constraint off

            String csvFilePath = "C:\\Users\\Sanket\\Desktop\\DB1\\Files\\csv\\dept.csv";  //path to load data from csv file
            BufferedReader buf = new BufferedReader(new FileReader(csvFilePath));    //Reads text from a character-input stream
            String val = null;   //intialisation

            while ((val = buf.readLine()) != null) {        //checks the null condition
                String[] data = val.split(","); // This specifies the delimiter.
                String Dname = data[0];    //split the data from array index
                String Dnumber = data[1];
                String Mgr_ssn = data[2];
                String Mgr_start_date = data[3];

                statement.setString(1, Dname);
                statement.setString(2, Dnumber);
                statement.setString(3, Mgr_ssn);
                statement.setString(4, Mgr_start_date);
                statement.addBatch();
            }

            buf.close();
            statement.executeBatch();

            statement1.executeQuery("SET FOREIGN_KEY_CHECKS = 1");

            System.out.println("Insert value to department table is successully done");
    /////////////////////////////////////////////////////////sql insert command for employee table insert//////////////////////////////////////////////////////////////////////////////////////
            String sql1 = "INSERT INTO EMPLOYEE (Fname, Minit, Lname, Ssn, Bdate, Address, Sex, Salary, Super_ssn, Dno) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement3 = con.prepareStatement(sql1);

            Statement statement2 = con.createStatement();

            statement2.executeQuery("SET FOREIGN_KEY_CHECKS = 0");

            String csvFilePath1 = "C:\\Users\\Sanket\\Desktop\\DB1\\Files\\csv\\emp.csv"; //path to load data from csv file
            BufferedReader buf1 = new BufferedReader(new FileReader(csvFilePath1));
            String val1 = null;


            while ((val1 = buf1.readLine()) != null) {
                String[] data = val1.split(","); // This specifies the delimiter.
                String Fname = data[0];
                String Minit = data[1];
                String Lname = data[2];
                String Ssn = data[3];
                String Bdate = data[4];
                String Address = data[5];
                String Sex = data[6];
                String Salary = data[7];
                String Super_ssn = data[8];
                String Dno = data[9];


                statement3.setString(1, Fname);
                statement3.setString(2, Minit);
                statement3.setString(3, Lname);
                statement3.setString(4, Ssn);
                statement3.setString(5, Bdate);
                statement3.setString(6, Address);
                statement3.setString(7, Sex);
                statement3.setString(8, Salary);
                statement3.setString(9, Super_ssn);
                statement3.setString(10, Dno);
                statement3.addBatch();
            }

            buf1.close();      //close the buffer reader stream
            statement3.executeBatch();

            statement2.executeQuery("SET FOREIGN_KEY_CHECKS = 1");

            System.out.println("Insert value to Employee table is successully done Employee");

            //////////////////////////////////////sql insert command for dependent table insert/////////////////////////////////////

            String sql2 = "INSERT INTO DEPENDENT (Essn, Dependent_name, Sex, Bdate, Relationship) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement5 = con.prepareStatement(sql2);

            Statement statement6 = con.createStatement();

            statement6.executeQuery("SET FOREIGN_KEY_CHECKS = 0");

            String csvFilePath2 = "C:\\Users\\Sanket\\Desktop\\DB1\\Files\\csv\\dependent.csv";  //path to load data from csv file
            BufferedReader buf2 = new BufferedReader(new FileReader(csvFilePath2));
            String val2 = null;


            while ((val2 = buf2.readLine()) != null) {   //read the line of text
                String[] data = val2.split(","); // This specifies the delimiter.
                String Essn = data[0];
                String Dependent_name = data[1];
                String Sex = data[2];
                String Bdate = data[3];
                String Relationship = data[4];


                statement5.setString(1, Essn);
                statement5.setString(2, Dependent_name);
                statement5.setString(3, Sex);
                statement5.setString(4, Bdate);
                statement5.setString(5, Relationship);

                statement5.addBatch();
            }

            buf2.close();    //close the buffer reader stream
            statement5.executeBatch();

            statement6.executeQuery("SET FOREIGN_KEY_CHECKS = 1");

            System.out.println("Insert value to dependent table is successully done");


            ///////////////////////////////////sql insert command for dept_locations table insert/////////////////////////////

            String sql3 = "INSERT INTO DEPT_LOCATIONS (Dnumber, Dlocation) values (?,?)";

            PreparedStatement statementl = con.prepareStatement(sql3);

            Statement statementl3 = con.createStatement();

            statementl3.executeQuery("SET FOREIGN_KEY_CHECKS = 0");    //turn off the foreign key constraint

            String csvFilePath3 = "C:\\Users\\Sanket\\Desktop\\DB1\\Files\\csv\\deptlcn.csv";
            BufferedReader bufl = new BufferedReader(new FileReader(csvFilePath3));
            String lineTextl = null;


            while ((lineTextl = bufl.readLine()) != null) {
                String[] data = lineTextl.split(","); // This specifies the delimiter. split the data with the value of ","
                String Dnumber = data[0];
                String Dlocation = data[1];



                statementl.setString(1, Dnumber);
                statementl.setString(2, Dlocation);


                statementl.addBatch(); // used to Add a set of parameters to this PreparedStatement object's batch of commands
            }

            buf1.close();   //close the buffer reader stream
            statementl.executeBatch();

            statementl3.executeQuery("SET FOREIGN_KEY_CHECKS = 1");   //turn on the foreign key constraint //source:http://www.sqlines.com/mysql/set_foreign_key_checks

            System.out.println("Insert value to DEPT_LOCATIONS table is successully");



            //////////////////////////////////////sql insert command for Project table insert/////////////////////////
            String sql4 = "INSERT INTO PROJECT (Pname,Pnumber,Plocation, Dnum) values (?,?,?,?)";

            PreparedStatement statementp = con.prepareStatement(sql4);

            Statement statementp3 = con.createStatement();

            statementp3.executeQuery("SET FOREIGN_KEY_CHECKS = 0");   //turn off the foreign key constraint

            String csvFilePath4 = "C:\\Users\\Sanket\\Desktop\\DB1\\Files\\csv\\project.csv";  //path to load data from csv file
            BufferedReader bufp = new BufferedReader(new FileReader(csvFilePath4));
            String valp = null;


            while ((valp = bufp.readLine()) != null) {     //read the line of text
                String[] data = valp.split(","); // This specifies the delimiter. //split is used to split the data by the delimiter ','
                String Pname = data[0];
                String Pnumber = data[1];
                String Plocation = data[2];
                String Dnum = data[3];



                statementp.setString(1, Pname);
                statementp.setString(2, Pnumber);
                statementp.setString(3, Plocation);
                statementp.setString(4, Dnum);


                statementp.addBatch();
            }

            bufp.close();
            statementp.executeBatch();

            statementp3.executeQuery("SET FOREIGN_KEY_CHECKS = 1");  // foreign key check turn on again  /Executes the defined query , which returns a single ResultSet object.
            //statementp3.executeQuery("SET PRIMARY_KEY_CHECKS = 1");

            System.out.println("Insert value to project table is successully");



            //////////////////////////////sql insert command for Works_On table insert//////////////////////
            String sql5 = "INSERT INTO WORKS_ON (Essn,Pno,Hours) values (?,?,?)";

            PreparedStatement statementw = con.prepareStatement(sql5);

            Statement statementw3 = con.createStatement();

            statementw3.executeQuery("SET FOREIGN_KEY_CHECKS = 0");  //Executes the defined query , which returns a single ResultSet object.

            String csvFilePath5 = "C:\\Users\\Sanket\\Desktop\\DB1\\Files\\csv\\workson.csv"; //path to load data from csv file
            BufferedReader bufw = new BufferedReader(new FileReader(csvFilePath5));
            String valw = null;

            //statementw3.executeQuery("SET FOREIGN_KEY_CHECKS = 1");

            while ((valw = bufw.readLine()) != null) {
                String[] data = valw.split(","); // This specifies the delimiter.
                String Essn = data[0];
                String Pno = data[1];
                String Hours = data[2];


                statementw.setString(1, Essn);
                statementw.setString(2, Pno);
                statementw.setString(3, Hours);


                statementw.addBatch();
            }

            bufw.close();
            statementw.executeBatch();

            statementw3.executeQuery("SET FOREIGN_KEY_CHECKS = 1");    //
           // statementp3.executeQuery("SET PRIMARY_KEY_CHECKS = 1");

            System.out.println("Insert value to works_on table is successully");




            /////////////////////////////////////////////////

            con.close();      //closed the connection

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
