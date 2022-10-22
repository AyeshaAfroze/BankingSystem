/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;

/**
 *
 * @author PC FiX
 */
public class database1 {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    /**
     *
     * @author Asus
     */
    String pin;
    public Connection conn;
    public ResultSet rs;
    public Statement st;
    String d, na, n1, b, a, p, e, s1, s2, s3, s4, s5, s6, s7, s8,z1;

    public database1() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank3", "root", "");
            st = conn.createStatement();
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

    }
    public void updatebalance(String balance,String accNo) {  //this method in database class
        try {
         //   int id = 6;
            //String name = "Rina";
            String query = "UPDATE signup SET balance= '" + balance + "' Where acc='" + accNo+"' ";
            st.execute(query);

        } catch (Exception ex) {
            System.out.println("Error 4 :" + ex);
        }
    }

    
    public void inFile(String s)
            
    {
          try {

                File f = new File("E:/2.1/NewClass.account.txt");
                f.createNewFile();
                
                FileWriter fr = null;
                try {
                    fr = new FileWriter(f);
                    BufferedWriter out = new BufferedWriter(fr);
                    //out.write(s1);
                   // out.newLine();

                    out.write(s);
                    out.newLine();                 
                    
                    
                    
                    out.close();
                    System.out.println("File created successfully");

                } catch (IOException e) {
                }

            } catch (IOException ex) {
                Logger.getLogger(database1.class
                        .getName()).log(Level.SEVERE, null, ex);

            }
        
        
        
    }

    public void saveinfo(String x) {///query n save in var

        

        try {
            //String query = "select pin from signup where acc='" + acc + "' ";
            String query2 = "select name,dob,nationality,balance,ad,phn,email from signup where acc='"+x+"'";

            ResultSet r2 = st.executeQuery(query2);
            FXMLLoader loader = new FXMLLoader();
            // ProfileController j = loader.getController();
            while (r2.next()) {
                d = r2.getString("dob");
                na = r2.getString("name");
                n1 = r2.getString("nationality");

                b = r2.getString("balance");
                a = r2.getString("ad");
                

                // System.out.println(d);
                // System.out.println(n1);
                p = r2.getString("phn");
                e = r2.getString("email");
                //j.setInfo(na,d,n1,b,a,p,e);

            }

        } catch (SQLException ex) {
            Logger.getLogger(database1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void file() {
        
        FileReader fr1 = null;
        try {

            fr1 = new FileReader("E:/2.1/NewClass.account.txt");
            BufferedReader file = new BufferedReader(fr1);
            z1 = file.readLine();
            //saveinfo(s1);
            //out.write(na);
            // out.newLine();

            System.out.println(z1);

            // TODO add your handling code here:
        } catch (FileNotFoundException ex) {
            Logger.getLogger(database1.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(database1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        



//////write
        saveinfo(z1);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank3", "root", "");
            st = conn.createStatement();

            try {

                File f = new File("E:/2.1/NewClass.save.txt");
                f.createNewFile();
                FileWriter fr = null;
                try {
                    fr = new FileWriter(f);
                    BufferedWriter out = new BufferedWriter(fr);
                    //out.write(s1);
                   // out.newLine();
                    
                      out.write(z1);
                    out.newLine();

                    out.write(na);
                    out.newLine();

                    out.write(d);
                    out.newLine();

                    out.write(n1);
                    out.newLine();

                    out.write(b);
                    out.newLine();

                    out.write(a);
                    out.newLine();

                    out.write(p);
                    out.newLine();

                    out.write(e);
                    out.newLine();

                    out.close();
                    System.out.println("File created successfully");

                } catch (IOException e) {
                }

            } catch (IOException ex) {
                Logger.getLogger(database1.class
                        .getName()).log(Level.SEVERE, null, ex);

            }

        } catch (SQLException ex) {
            Logger.getLogger(database1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getacc() {////read n return
        //file();
        //String s1;
        FileReader fr = null;
        try {

            fr = new FileReader("E:/2.1/NewClass.save.txt");
            BufferedReader file = new BufferedReader(fr);
            s1 = file.readLine();
            //saveinfo(s1);
            //out.write(na);
            // out.newLine();

            System.out.println(s2);

            // TODO add your handling code here:
        } catch (FileNotFoundException ex) {
            Logger.getLogger(database1.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(database1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return s1;
    }

    public String getName() {////read n return
        //file();
        //String s1;
        FileReader fr = null;
        try {

            fr = new FileReader("E:/2.1/NewClass.save.txt");
            BufferedReader file = new BufferedReader(fr);
            s1 = file.readLine();
            s2 = file.readLine();

            //System.out.println(s2);
            // TODO add your handling code here:
        } catch (FileNotFoundException ex) {
            Logger.getLogger(database1.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(database1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return s2;
    }

    public String getDOB() {////read n return
        //file();
        //String s1;
        FileReader fr = null;
        try {

            fr = new FileReader("E:/2.1/NewClass.save.txt");
            BufferedReader file = new BufferedReader(fr);
            s1 = file.readLine();
            s2 = file.readLine();

            s3 = file.readLine();

            //System.out.println(s2);
            // TODO add your handling code here:
        } catch (FileNotFoundException ex) {
            Logger.getLogger(database1.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(database1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return s3;
    }

    public String getNat() {////read n return
        //file();
        //String s1;
        FileReader fr = null;
        try {

            fr = new FileReader("E:/2.1/NewClass.save.txt");
            BufferedReader file = new BufferedReader(fr);
            s1 = file.readLine();
            s2 = file.readLine();

            s3 = file.readLine();
            s4 = file.readLine();

            //System.out.println(s2);
            // TODO add your handling code here:
        } catch (FileNotFoundException ex) {
            Logger.getLogger(database1.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(database1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return s4;
    }

    public String getbalance() {////read n return
        //file();
        //String s1;
        FileReader fr = null;
        try {

            fr = new FileReader("E:/2.1/NewClass.save.txt");
            BufferedReader file = new BufferedReader(fr);
            s1 = file.readLine();
            s2 = file.readLine();

            s3 = file.readLine();
            s4 = file.readLine();
            s5 = file.readLine();
            //System.out.println(s2);
            // TODO add your handling code here:

        } catch (FileNotFoundException ex) {
            Logger.getLogger(database1.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(database1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return s5;
    }

    public String getAd() {////read n return
        //file();
        //String s1;
        FileReader fr = null;
        try {

            fr = new FileReader("E:/2.1/NewClass.save.txt");
            BufferedReader file = new BufferedReader(fr);
            s1 = file.readLine();
            s2 = file.readLine();

            s3 = file.readLine();
            s4 = file.readLine();
            s5 = file.readLine();
            s6 = file.readLine();
            //System.out.println(s2);
            // TODO add your handling code here:

        } catch (FileNotFoundException ex) {
            Logger.getLogger(database1.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(database1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return s6;
    }

    public String getphone() {////read n return
        //file();
        //String s1;
        FileReader fr = null;
        try {

            fr = new FileReader("E:/2.1/NewClass.save.txt");
            BufferedReader file = new BufferedReader(fr);
            s1 = file.readLine();
            s2 = file.readLine();

            s3 = file.readLine();
            s4 = file.readLine();
            s5 = file.readLine();
            s6 = file.readLine();
            s7 = file.readLine();
            //System.out.println(s2);
            // TODO add your handling code here:

        } catch (FileNotFoundException ex) {
            Logger.getLogger(database1.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(database1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return s7;
    }

    public String getMail() {////read n return
        //file();
        //String s1;
        FileReader fr = null;
        try {

            fr = new FileReader("E:/2.1/NewClass.save.txt");
            BufferedReader file = new BufferedReader(fr);
            s1 = file.readLine();
            s2 = file.readLine();

            s3 = file.readLine();
            s4 = file.readLine();
            s5 = file.readLine();
            s6 = file.readLine();
            s7 = file.readLine();
            s8 = file.readLine();
            //System.out.println(s2);
            // TODO add your handling code here:

        } catch (FileNotFoundException ex) {
            Logger.getLogger(database1.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(database1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return s8;
    }

    public void getinfo(String acc, String name, String dob, String nat, String gen, String ad, String phn, String email, String pass) {
        try {
            //String query = "select pin from signup where acc='" + acc + "' ";
            String query2 = "select name,dob,nationality,balance,ad,phn,email from signup where acc='" + acc + "' ";
            ResultSet r2 = st.executeQuery(query2);
            FXMLLoader loader = new FXMLLoader();
            ProfileController j = loader.getController();
            while (r2.next()) {
                String d = r2.getString("dob");
                String na = r2.getString("name");
                String n1 = r2.getString("nationality");

                String b = r2.getString("balance");
                String a = r2.getString("ad");

                // System.out.println(d);
                // System.out.println(n1);
                String p = r2.getString("phn");
                String e = r2.getString("email");
                j.setInfo(na, d, n1, b, a, p, e);

            }

        } catch (SQLException ex) {
            Logger.getLogger(database1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getData(String s) {///for login query n return pin
        try {
            //String query = "SELECT * FROM signup ";
            String query = "select pin from signup where acc='" + s + "' ";

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                pin = rs.getString("pin");

            }
           // saveinfo(s);

            //  rs = st.executeQuery(query);
            /*   System.out.println("Results from the query:\n ");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String section = rs.getString("section");

                System.out.println("ID: " + id + " Name: " + name + " Address: " + address + " Section: " + section);*/
            //  }
        } catch (Exception ex) {
            System.out.println("Error 2 :" + ex);
        }
        return pin;

    }
///insert in table

    public void insertData(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10) {
        try {
            String query = "insert into signup values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','," + s7 + "','" + s8 + "','" + s9 + "','" + s10 + "')"; //updating data

            st.execute(query);
        } catch (Exception ex) {
            System.out.println("Error 3 :" + ex);
        }
    }

    /*  public void updateData() {
        try {
            int id = 6;
            String name = "Rina";
            String query = "UPDATE student SET name= '" + name + "' Where id=" + id;
            st.execute(query);

        } catch (Exception ex) {
            System.out.println("Error 4 :" + ex);
        }
    }

    public void deleteData() {
        try {
            int id = 5;
            String query = "DELETE FROM student WHERE id =" + id;
            st.execute(query);
        } catch (Exception ex) {
            System.out.println("Error 5 :" + ex);
        }
    }*/
}
