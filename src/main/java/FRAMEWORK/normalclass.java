package FRAMEWORK;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import io.github.bonigarcia.wdm.WebDriverManager;

public class normalclass {

	public static void main(String[] args) throws FilloException, IOException {
//		// TODO Auto-generated method stub
//
//		Fillo fillo = new Fillo();
//		Connection conn = fillo.getConnection(System.getProperty("user.dir") + "\\Ishine.xlsx");
//		String selectQuery = "SELECT * FROM Sheet2";
//		Recordset r = conn.executeQuery(selectQuery);
//
////		List<Object> al = new ArrayList<Object>();
////
////		while (r.next()) {
////			List<String> columns = r.getFieldNames();
////			for (String column : columns) {
////				al.add(r.getField(column));
////			}
////		}
////
////		for (Object o : al) {
////			System.out.println(o);
////		}
//		
//		List<Object> rowsList = new ArrayList<>();
//
//		while (r.next()) {
//		    List<String> columns = r.getFieldNames();
//		    List<Object> rowValues = new ArrayList<>();
//		    for (String column : columns) {
//		        rowValues.add(r.getField(column));
//		    }
//		    rowsList.add(rowValues);	    
//		}
//		
//		
//		
////		for (List<Object> row : rowsList) {
////		    for (Object value : row) {
////		        System.out.print(value + "\t");
////		    }
////		    System.out.println();
////		}
//		
//		
//		int size=rowsList.size();
//		
//		for(int i=0;i<size;i++)
//		{
//			 List<Object> row = (List<Object>) rowsList.get(i);
//		
//		
////		for (List<Object> row :  rowsList) {
//		    // Create a StringBuilder to build the string representation of the row
//		    StringBuilder rowString = new StringBuilder();
//
//		    for( int j=1;j<row.size();j++)
//			 {
//		        // Convert each column value to string and append it to the rowString
//		        rowString.append(row.get(j).toString()).append(", "); // You can use any delimiter you prefer (e.g., ", ", "\t", "|", etc.)
//		    }
//
//		    // Remove the last delimiter (comma and space) from the end of the rowString
//		    if (rowString.length() > 0) {
//		        rowString.setLength(rowString.length() - 2);
//		    }
//		    
//		    String[] columnValues = rowString.toString().split(", ");
//
//		    // Process each column value individually
//		    for (String columnValue : columnValues) {
//		        // Store each column value in another variable or perform any other processing
//		        // For example, you can add them to a list or use them directly in your code
//		        System.out.println("Column Value: " + columnValue);
//		    }
//
//		    // Now, the rowString contains the string representation of the current row
////		    System.out.println(rowString.toString());
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
////		int size=rowsList.size();
////		
////		for(int i=0;i<size;i++)
////		{
////			 List<Object> row = (List<Object>) rowsList.get(i);
////			 for(Object value : row)
////			 {
////				 System.out.print(value+"\t");
////			 }
////			 System.out.println();
////		}
////		
//		
//
//		
////		for (Object o : rowsList) {
////			System.out.println(o);
////		}

//		Fillo fillo = new Fillo();
//        Connection conn = fillo.getConnection(System.getProperty("user.dir") + "\\ISHINE.xlsx");
//        String moduleName = "ISHINE"; // Replace this with the desired module name
//        String query = "SELECT * FROM Sheet1 WHERE RUNSTATUS='Y' and MODULE='" + moduleName + "'";
//        
//        List<Object> rowsList = new ArrayList<>();
//
//        
//        if ("ISHINE".equalsIgnoreCase(moduleName)) {
//            Recordset recordset = conn.executeQuery(query);
//            // Process the recordset or perform other operations with the data
//            
//        	
//    		while (recordset.next()) {
//    			List<String> columns = recordset.getFieldNames();
//    			List<Object> rowValues = new ArrayList<>();
//    			for (String column : columns) {
//    				rowValues.add(recordset.getField(column));
//    			}
//    			rowsList.add(rowValues);
//    		}
//    		
//    		for(Object val :rowsList)
//    			System.out.println(val);
//            
//            recordset.close();
//        } else {
//            System.out.println("Module name is not 'ISHINE'. Stopping execution.");
//        }
//
//        conn.close();

		String filePath = "C:\\Users\\biswa\\eclipse-workspace\\BiswajitFramework\\DataSheet\\ICICIPruAmcSip_PostLogin.xlsx";

		System.out.println(filePath);

		File file = new File(filePath);
		try {

			if (file.isFile()) {
				System.out.println("  File is present");

			} else {
				System.out.println("  File is not present");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("An error occurred: " + e.getMessage());
		}

	}

}
