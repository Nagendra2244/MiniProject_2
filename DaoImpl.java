package com.Nagendra.ArogyaHospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.*;
import java.util.function.Supplier;

public class DaoImpl implements DaoInterface {

	Connection con;
	Scanner sc=new Scanner(System.in);
	 Patient p;
DaoImpl(){
		 try {
	         //1. loading Driver class 
	         Class.forName("com.mysql.cj.jdbc.Driver");
	        // 2. Establish the connection
	         this.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/arogyahospital","root","");
	         
	         Statement st=con.createStatement();
	 
	         ResultSet rs=st.executeQuery("SELECT * FROM patient");
	         
	         ResultSetMetaData rsmd=rs.getMetaData();
	 
	         int colscount=rsmd.getColumnCount();
	 
	        for(int i=1;i<=colscount;i++)
	        {
	        System.out.print(rsmd.getColumnName(i)+"\t      ");
	        }
	        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	         
	         while(rs.next())
	         {
	             for(int i=1;i<=colscount;i++)
	             {
	             System.out.print(rs.getString(i)+"\t      ");
	             }
	              System.out.println();
	         }
	        }
	        catch(Exception e) {
	        	// TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
public void patientRegistartion(Patient p) {
	// TODO Auto-generated method stub
	try {
        PreparedStatement pstmt = con.prepareStatement("INSERT INTO patient (name, gender, aadharNumber, contactNumber, city, address, dateOfAdmission, guardianName, guardianAddress, guardianContactNumber, age, recovered) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        pstmt.setString(1, p.getName());
        pstmt.setString(2, p.getGender());
        pstmt.setString(3, p.getAadharNumber());
        pstmt.setString(4, p.getContactNumber());
        pstmt.setString(5, p.getCity());
        pstmt.setString(6, p.getAddress());
        pstmt.setString(7, p.getDateOfAdmission());
        pstmt.setString(8, p.getGuardianName());
        pstmt.setString(9, p.getGuardianAddress());
        pstmt.setString(10, p.getGuardianContactNumber());
        pstmt.setInt(11, p.getAge());
        pstmt.setString(12, p.getRecovered());

        int i = pstmt.executeUpdate();
        if (i != 0) {
            System.out.println("Data saved successfully.");
        } else {
            System.out.println("Data is not saved successfully.");
        }
       
    } catch (SQLException e) {
        System.out.println("Error in patient registration: " + e.getMessage()); 
    }
}
public void showAllPatients() {
	// TODO Auto-generated method stub
	try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM patient");
        while(rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Gender: " + rs.getString("gender"));
            System.out.println("Aadhar Number: " + rs.getString("aadharNumber"));
            System.out.println("Contact Number: " + rs.getString("contactNumber"));
            System.out.println("City: " + rs.getString("city"));
            System.out.println("Address: " + rs.getString("address"));
            System.out.println("Date of Admission: " + rs.getString("dateOfAdmission"));
            System.out.println("Guardian Name: " + rs.getString("guardianName"));
            System.out.println("Guardian Address: " + rs.getString("guardianAddress"));
            System.out.println("Guardian Contact Number: " + rs.getString("guardianContactNumber"));
            System.out.println("Age: " + rs.getInt("age"));
            System.out.println("Recovered: " + rs.getString("recovered"));
            System.out.println();
        }
        
    } catch(Exception e) {
		   System.out.println(e);	
		   }
}
public void SearchPatientById(int id) {
	// TODO Auto-generated method stub
	try {
		 Statement stmt = con.createStatement();
     PreparedStatement pstmt = con.prepareStatement("SELECT * FROM patient WHERE id = ?");
     pstmt.setInt(1, id);
     ResultSet rs = pstmt.executeQuery();
     if (rs.next()) {
         System.out.println("ID: " + rs.getInt("id"));
         System.out.println("Name: " + rs.getString("name"));
         System.out.println("Gender: " + rs.getString("gender"));
         System.out.println("Aadhar Number: " + rs.getString("aadharNumber"));
         System.out.println("Contact Number: " + rs.getString("contactNumber"));
         System.out.println("City: " + rs.getString("city"));
         System.out.println("Address: " + rs.getString("address"));
         System.out.println("Date of Admission: " + rs.getString("dateOfAdmission"));
         System.out.println("Guardian Name: " + rs.getString("guardianName"));
         System.out.println("Guardian Address: " + rs.getString("guardianAddress"));
         System.out.println("Guardian Contact Number: " + rs.getString("guardianContactNumber"));
         System.out.println("Age: " + rs.getInt("age"));
         System.out.println("Recovered: " + rs.getString("recovered"));
         System.out.println();
     } else {
         System.out.println("No patient found with ID " +id);
     }
 } catch(Exception e) {
		   System.out.println(e);	
		   }
}
public void SearchPatientByage(int age) {
	// TODO Auto-generated method stub
	try {
        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM patient WHERE age = ?");
        pstmt.setInt(1, age);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Gender: " + rs.getString("gender"));
            System.out.println("Aadhar Number: " + rs.getString("aadharNumber"));
            System.out.println("Contact Number: " + rs.getString("contactNumber"));
            System.out.println("City: " + rs.getString("city"));
            System.out.println("Address: " + rs.getString("address"));
            System.out.println("Date of Admission: " + rs.getString("dateOfAdmission"));
            System.out.println("Guardian Name: " + rs.getString("guardianName"));
            System.out.println("Guardian Address: " + rs.getString("guardianAddress"));
            System.out.println("Guardian Contact Number: " + rs.getString("guardianContactNumber"));
            System.out.println("Age: " + rs.getInt("age"));
            System.out.println("Recovered: " + rs.getString("recovered"));
            System.out.println();
        }
        
    } catch (Exception e) {
        System.out.println(e);
    }
}
public void SearchPatientBycity(String city) {
	// TODO Auto-generated method stub
	try {
        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM patient WHERE city = ?");
        pstmt.setString(1, city);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Gender: " + rs.getString("gender"));
            System.out.println("Aadhar Number: " + rs.getString("aadharNumber"));
            System.out.println("Contact Number: " + rs.getString("contactNumber"));
            System.out.println("City: " + rs.getString("city"));
            System.out.println("Address: " + rs.getString("address"));
            System.out.println("Date of Admission: " + rs.getString("dateOfAdmission"));
            System.out.println("Guardian Name: " + rs.getString("guardianName"));
            System.out.println("Guardian Address: " + rs.getString("guardianAddress"));
            System.out.println("Guardian Contact Number: " + rs.getString("guardianContactNumber"));
            System.out.println("Age: " + rs.getInt("age"));
            System.out.println("Recovered: " + rs.getString("recovered"));
            System.out.println();
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}
public void deletePatientById(int id) {
	// TODO Auto-generated method stub
	try {
        // Load Driver class
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Get a connection to the database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arogyahospital","root","");
        
        // Prepare a statement to delete the patient record by ID
        PreparedStatement pstmt = con.prepareStatement("DELETE FROM patients WHERE id = ?");
        pstmt.setInt(1, id);
        
        // Execute the delete statement
        int i = pstmt.executeUpdate();
        if (i == 1) {
            System.out.println("Record Deleted Successfully");                   
        } else {
            System.out.println("ERROR OCCURRED WHILE Deleting");
        }  
        
    } catch(Exception e) {
        System.out.println(e);    
    }
}
public void markPatientRecovery(String recovered) {
	// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
    try {
        int id;
        System.out.println("Enter patient ID:");
        id = sc.nextInt();
        System.out.println("Mark the status:");
        recovered = sc.next();

        // Load the driver class
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arogyahospital", "root", "");

        // Create a prepared statement
        PreparedStatement pstmt = con.prepareStatement("UPDATE patient SET recovered=? WHERE id=?");
        pstmt.setString(1, recovered);
        pstmt.setInt(2, id);

        // Execute the update statement
        int i = pstmt.executeUpdate();
        if (i == 1) {
            System.out.println("Record Updated Successfully");
        } else {
            System.out.println("ERROR OCCURRED WHILE Updating");
        }

        
    } catch (Exception e) {
        System.out.println(e);
    }
}
public void addSupplier(com.Nagendra.ArogyaHospital.Supplier supplier) {
	// TODO Auto-generated method stub
	 try {
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arogyahospital", "root", "");
	        PreparedStatement pstmt = con.prepareStatement("INSERT INTO medicinesupplier (SupplierID, SupplierName, SupplyDate) VALUES (?, ?, ?)");
	  
	        // set the parameter values in the prepared statement
	        pstmt.setInt(1, (supplier).getSupplierID());
	        pstmt.setString(2,supplier.getSuplierName());
	        pstmt.setString(3,(String) supplier.getSupplyDate());
	              int i=1;  pstmt.executeUpdate();

	        if (i!=0) {
	            System.out.println("Supplier record added successfully!");
	        } else {
	            System.out.println("Error occurred while adding supplier");
	        }
	    } catch(Exception e) {
	        System.out.println(e);    
	    }
}
public void showallSuppliers() {
	// TODO Auto-generated method stub
	try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM medicinesupplier");
        while(rs.next()) {
            System.out.println("SupplierID: " + rs.getInt("SupplierID"));
            System.out.println("SupplierName: " + rs.getString("SupplierName"));
            System.out.println("SupplyDate: " + rs.getString("SupplyDate"));
 }
        
    } catch(Exception e) {
		   System.out.println(e);	
		   }
}
public void addMedicineRecords(Patient p, MedicineRecords record) {
	// TODO Auto-generated method stub
	try {
        // Load the driver class
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Establish the connection
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/arogyahospital", "root", "");
        
        // Insert the medicine record into the medicine_records table
        PreparedStatement pstmt = con.prepareStatement("INSERT INTO medicinerecords (id, medicine_id, supplier_id, medicine_name, unit_price, quantity, manufacture_date, expiry_date, total_price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        pstmt.setInt(1,p.getId());
        pstmt.setInt(2, record.getMedicineID());
        pstmt.setString(3, record.getSupplierID());
        pstmt.setString(4, record.getMedicineName());
        pstmt.setDouble(5, record.getUnitPrice());
        pstmt.setInt(6, record.getQuantity());
        pstmt.setDate(7, java.sql.Date.valueOf(record.getManufactureDate()));
        pstmt.setDate(8, java.sql.Date.valueOf(record.getExpiryDate()));
        pstmt.setDouble(9, record.getTotalPrice());
        int i = pstmt.executeUpdate();
        
        if (i == 1) {
            System.out.println("Medicine record added successfully!");
        } else {
            System.out.println("ERROR OCCURRED WHILE Adding");
        }  
        
    } catch(Exception e) {
        System.out.println(e);    
    }
}
public void showallMedicineRecordDetails() {
	// TODO Auto-generated method stub
	try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arogyahospital", "root", "");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM medicinerecords");
        
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Medicine ID: " + rs.getInt("medicine_id"));
            System.out.println("Supplier ID: " + rs.getString("supplier_id"));
            System.out.println("Medicine Name: " + rs.getString("medicine_name"));
            System.out.println("Unit Price: " + rs.getDouble("unit_price"));
            System.out.println("Quantity: " + rs.getInt("quantity"));
            System.out.println("Manufacture Date: " + rs.getDate("manufacture_date"));
            System.out.println("Expiry Date: " + rs.getDate("expiry_date"));
            System.out.println("Total Price: " + rs.getDouble("total_price"));
            System.out.println();
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}
public void exit() {
	// TODO Auto-generated method stub
	try {
		System.exit(0);
	
		con.close();
	    } catch (Exception e) {
	        // handle exception
	    	System.out.println(e);
	    }
}

}