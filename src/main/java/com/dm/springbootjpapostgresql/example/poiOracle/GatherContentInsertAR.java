package com.dm.springbootjpapostgresql.example.poiOracle;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class GatherContentInsertAR {
	
	public static void main(String[] args) {
        String jdbcURL = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String username = "spring";
        String password = "spring123";
 
        String excelFilePath = "DM Arabic Services - May 10-sar.xlsx";
 
        //int batchSize = 20;
 
        Connection connection = null;
 
        try {
            long start = System.currentTimeMillis();
             
            FileInputStream inputStream = new FileInputStream(excelFilePath);
 
            Workbook workbook = new XSSFWorkbook(inputStream);
            
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();
 
            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);
  
            String sql = "INSERT INTO um_service_card_temp_ar (service_name,old_transaction_id,new_transaction_id,sector,department,"
            		+ "section_name,main_service,targeted_customer_category,service_classification,service_type,internal_partners,"
            		+ "external_partners,related_internal_services,ref_laws_and_legislations,service_description,customer_classification,"
            		+ "required_documents,service_channels_centre,service_fees,payment_method_and_options,service_process_and_steps,"
            		+ "service_process_time,terms_and_conditions,faqs,related_ext_services_bundles,tag) VALUES "
            		+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);    
            //int count = 0;
             
            rowIterator.next(); // skip the header row
             
            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                
                Cell cell0 = nextRow.getCell(0);
                String serviceName = "";
                if(cell0!=null)
                	serviceName = cell0.getStringCellValue();
                statement.setString(1, serviceName);
                
                Cell cell1 = nextRow.getCell(1);
                String oldTransactionId = "";
                if(cell1!=null)
                	oldTransactionId = cell1.getStringCellValue();
                statement.setString(2, oldTransactionId);
                
                Cell cell2 = nextRow.getCell(2);
                String newTransactionId = "";
                if(cell2!=null)
                	newTransactionId = cell2.getStringCellValue();
                statement.setString(3, newTransactionId);
                
                Cell cell3 = nextRow.getCell(3);
                String sector = "";
                if(cell3!=null)
                	sector = cell3.getStringCellValue();
                statement.setString(4, sector);
                
                Cell cell4 = nextRow.getCell(4);
                String department = "";
                if(cell4!=null)
                	department = cell4.getStringCellValue();
                statement.setString(5, department);
                
                Cell cell5 = nextRow.getCell(5);
                String sectionName = "";
                if(cell5 != null)
                	sectionName = cell5.getStringCellValue();
                statement.setString(6, sectionName);
                
                Cell cell6 = nextRow.getCell(6);
                String mainService = "";
                if(cell6 != null)
                	mainService = cell6.getStringCellValue();
                statement.setString(7, mainService);
                
                Cell cell7 = nextRow.getCell(7);
                String targetedCustomerCategory = "";
                if(cell7 != null)
                	targetedCustomerCategory = cell7.getStringCellValue();
                statement.setString(8, targetedCustomerCategory);
                
                Cell cell8 = nextRow.getCell(8);
                String serviceClassification = "";
                if(cell8!=null)
                	serviceClassification = cell8.getStringCellValue();
                statement.setString(9, serviceClassification);
                
                Cell cell9 = nextRow.getCell(9);
                String serviceType = "";
                if(cell9!=null)
                	serviceType = cell9.getStringCellValue();
                statement.setString(10, serviceType);
                
                Cell cell10 = nextRow.getCell(10);
                String internalPartners = "";
                if(cell10!=null)
                	internalPartners = cell10.getStringCellValue();
                statement.setString(11, internalPartners);
                
                Cell cell11 = nextRow.getCell(11);
                String externalPartners = "";
                if(cell11!=null)
                	externalPartners = cell11.getStringCellValue();
                statement.setString(12, externalPartners);
                
                Cell cell12 = nextRow.getCell(12);
                String relatedInternalServices = "";
                if(cell12!=null)
                	relatedInternalServices = cell12.getStringCellValue();
                statement.setString(13, relatedInternalServices);
                
                Cell cell13 = nextRow.getCell(13);
                String refLawsAndLegislations = "";
                if(cell13!=null)
                	refLawsAndLegislations = cell13.getStringCellValue();
                statement.setString(14, refLawsAndLegislations);
                
                Cell cell14 = nextRow.getCell(14);
                String serviceDescription = "";
                if(cell14!=null)
                	serviceDescription = cell14.getStringCellValue();
                statement.setString(15, serviceDescription);
                
                Cell cell15 = nextRow.getCell(15);
                String customerClassification = "";
                if(cell15!=null)
                	customerClassification = cell15.getStringCellValue();
                statement.setString(16, customerClassification);
                
                Cell cell16 = nextRow.getCell(16);
                String requiredDocuments = "";
                if(cell16!=null)
                	requiredDocuments = cell16.getStringCellValue();
                statement.setString(17, requiredDocuments);
                
                Cell cell17 = nextRow.getCell(17);
                String serviceChannelsCentre = "";
                if(cell17!=null)
                	serviceChannelsCentre = cell17.getStringCellValue();
                statement.setString(18, serviceChannelsCentre);
                
                Cell cell18 = nextRow.getCell(18);
                String serviceFees = "";
                if(cell18!=null)
                	serviceFees = cell18.getStringCellValue();
                statement.setString(19, serviceFees);
                
                Cell cell19 = nextRow.getCell(19);
                String paymentMethodAndOptions = "";
                if(cell19!=null)
                	paymentMethodAndOptions = cell19.getStringCellValue();
                statement.setString(20, paymentMethodAndOptions);
                
                Cell cell20 = nextRow.getCell(20);
                String serviceProcessAndSteps = "";
                if(cell20!=null)
                	serviceProcessAndSteps = cell20.getStringCellValue();
                statement.setString(21, serviceProcessAndSteps);
                
                Cell cell21 = nextRow.getCell(21);
                String serviceProcessTime = "";
                if(cell21!=null)
                	serviceProcessTime = cell21.getStringCellValue();
                statement.setString(22, serviceProcessTime);
                
                Cell cell22 = nextRow.getCell(22);
                String termAndConditions = "";
                if(cell22!=null)
                	termAndConditions = cell22.getStringCellValue();
                statement.setString(23, termAndConditions);
                
                Cell cell23 = nextRow.getCell(23);
                String faqs = "";
                if(cell23!=null)
                	faqs = cell23.getStringCellValue();
                statement.setString(24, faqs);
                
                Cell cell24 = nextRow.getCell(24);
                String relatedExtServicesBundles = "";
                if(cell24!=null)
                	relatedExtServicesBundles = cell24.getStringCellValue();
                statement.setString(25, relatedExtServicesBundles);
                
                Cell cell25 = nextRow.getCell(25);
                String tag = "";
                if(cell25!=null)
                	tag = cell25.getStringCellValue();
                statement.setString(26, tag);

                
                statement.addBatch();
                 
                /*if (count % batchSize == 0) {
                    statement.executeBatch();
                }*/              
 
            }
 
            workbook.close();

            statement.executeBatch();
  
            connection.commit();
            connection.close();
             
            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));
             
        } catch (IOException ex1) {
            System.out.println("Error reading file");
            ex1.printStackTrace();
        } catch (SQLException ex2) {
            System.out.println("Database error");
            ex2.printStackTrace();
        }
 
    }

}
