package com.dm.springbootjpapostgresql.service.FileOps;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import org.springframework.beans.factory.annotation.Value;

public class FileWriteService {
    @Value("${file.outputLocation}")
    private String outputLocation;	

	public void testFileWrite() {
        File f0 = new File(outputLocation+File.separator+"file.txt");
        

        try {
                if (f0.createNewFile()) {  
                    System.out.println("File " + f0.getName() + " is created successfully.");  
                } else {  
                                System.out.println("File is already exist in the directory.");  
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }  
        
        System.out.println("--------------");
        
        
        // Creating file object  
        //File f1 = new File("D:FileOperationExample.txt");  
        File f1 = new File(outputLocation+File.separator+"1234567890Payload.xml");
        if (f1.exists()) {  
            // Getting file name  
            System.out.println("The name of the file is: " + f1.getName());  
   
            // Getting path of the file   
            System.out.println("The absolute path of the file is: " + f1.getAbsolutePath());     
   
            // Checking whether the file is writable or not  
            System.out.println("Is file writeable?: " + f1.canWrite());    
   
            // Checking whether the file is readable or not  
            System.out.println("Is file readable " + f1.canRead());    
   
            // Getting the length of the file in bytes  
            System.out.println("The size of the file in bytes is: " + f1.length());    
        } else {  
            System.out.println("The file does not exist.");  
        }    
        
        System.out.println("--------------");

        
        try {  
            FileWriter fwrite = new FileWriter(outputLocation+File.separator+"FileOperationExample.txt");  
            // writing the content into the FileOperationExample.txt file  
            fwrite.write("A named location used to store related information is referred to as a File.");   
       
            // Closing the stream  
            fwrite.close();   
            System.out.println("Content is successfully wrote to the file.");  
        } catch (IOException e) {  
            System.out.println("Unexpected error occurred");  
            e.printStackTrace();  
            }      
        
        System.out.println("--------------");



        File f3 = new File(outputLocation+File.separator+"file.txt");   
        if (f3.delete()) {   
          System.out.println(f3.getName()+ " file is deleted successfully.");  
        } else {  
          System.out.println("Unexpected error found in deletion of the file.");  
        }   
        System.out.println("--------------");

	}

	public void testFileWrite2() throws IOException {

		System.out.println("---------Writer-------------");
		Writer w = new FileWriter(outputLocation+File.separator+"output.txt");
		w.write("prabhu sample");
		w.close();
		System.out.println("-----------------------");
		
		System.out.println("---------FileWriter-------------");
		FileWriter fw = new FileWriter(outputLocation+File.separator+"output2.txt");
		fw.write("prabhu sample 222222222");
		fw.close();
		System.out.println("-----------------------");
		
		File f = new File(outputLocation+File.separator+"output22.txt");
		FileWriter fw2 = new FileWriter(f);
		fw2.write("prabhu sample 222222222");
		fw2.close();
		System.out.println("-----------------------");
		
		System.out.println("---------BufferedWriter-------------");
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputLocation+File.separator+"output3.txt"));
		bw.write("bw test");
		bw.close();
		System.out.println("-----------BufferedWriter append------------");
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(outputLocation+File.separator+"output3.txt",true));//if true is not added its overwrite
		bw2.append("bw test 222222222");
		bw2.append("bw test 233332423434534523");
		bw2.close();
		System.out.println("-----------------------");	
		
		System.out.println("---------PrintWriter File-------------");
		PrintWriter pw = new PrintWriter(outputLocation+File.separator+"output4.txt");
		pw.write("test PrintWriter");
		pw.close();
		System.out.println("-----------------------");	

		System.out.println("---------PrintWriter console-------------");
		PrintWriter pw2 = new PrintWriter(System.out);
		pw2.write("test PrintWriter");
		pw2.print("3534253");
		pw2.println("1111111111111135342534343");
		pw2.printf("Product name is %s and its price is %d $", "iPhone", 1000);
		pw2.flush();
		pw2.close();
		System.out.println("-----------------------");	
		
		System.out.println("---------FileOutputStream-------------");
		FileOutputStream fos = new FileOutputStream(new File(outputLocation+File.separator+"output5.txt"));
		fos.write(65);
		String s = "test string";
		byte[] ba = s.getBytes();
		fos.write(ba);
		fos.close();
		System.out.println("-----------------------");	
		

	}

	public void testFileWrite3() {
		String	CorrelationId = "1234567890";
		String	payload = "<?xml version='1.0' encoding='utf-8'?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Body><ProcessPVAcquisitionResponse xmlns=\"http://online.pc.icm.epay.bct.com/\"><RegisterPaymentVoucherResponse>\r\n" + 
				"  <GenericResponse>\r\n" + 
				"    <ReplyTimeStamp>09/08/2020 11:21:38</ReplyTimeStamp>\r\n" + 
				"    <ResponseCode>000</ResponseCode>\r\n" + 
				"    <ResponseDesc_EN>Approved</ResponseDesc_EN>\r\n" + 
				"    <ResponseDesc_AR>تمت الموافقة</ResponseDesc_AR>\r\n" + 
				"    <GenericRequestHeader>\r\n" + 
				"      <MsgId>2020125968556004036</MsgId>\r\n" + 
				"      <TerminalID/>\r\n" + 
				"      <MessageType>ACQ</MessageType>\r\n" + 
				"      <CommitType>M</CommitType>\r\n" + 
				"      <ReqTimeStamp>09/08/2020 11:21:37</ReqTimeStamp>\r\n" + 
				"      <Reserved1/>\r\n" + 
				"      <Reserved2/>\r\n" + 
				"      <Reserved3/>\r\n" + 
				"      <Reserved4/>\r\n" + 
				"      <Reserved5/>\r\n" + 
				"      <Reserved6/>\r\n" + 
				"      <Reserved7/>\r\n" + 
				"      <Reserved8/>\r\n" + 
				"      <Reserved9/>\r\n" + 
				"      <Reserved10/>\r\n" + 
				"      <Reserved11/>\r\n" + 
				"      <Reserved12/>\r\n" + 
				"      <Reserved13/>\r\n" + 
				"      <Reserved14/>\r\n" + 
				"      <Reserved15/>\r\n" + 
				"    </GenericRequestHeader>\r\n" + 
				"    <ErrorResponses/>\r\n" + 
				"  </GenericResponse>\r\n" + 
				"  <VoucherResponseDetails>\r\n" + 
				"    <VoucherResponse>\r\n" + 
				"      <SourceSystemAppRefNo>PR-3356-13093000</SourceSystemAppRefNo>\r\n" + 
				"      <SourceSysVoucherNo>EREF0000981</SourceSysVoucherNo>\r\n" + 
				"      <EPayVoucherRefNo>RSCCSA202000624926</EPayVoucherRefNo>\r\n" + 
				"    </VoucherResponse>\r\n" + 
				"  </VoucherResponseDetails>\r\n" + 
				"</RegisterPaymentVoucherResponse></ProcessPVAcquisitionResponse></soapenv:Body></soapenv:Envelope>";
		String completed="";
		
		//String	fileLocation = "packages/DMAcquisition/config/"+CorrelationId+"Payload.xml";
		String	fileLocation = outputLocation+File.separator+CorrelationId+"Payload.xml";
		
		
		File file = new File(fileLocation);
		boolean result;   
		try    
		{  
		result = file.createNewFile();  //creates a new file  
		if(result)      // test if successfully created a new file  
		{  
		System.out.println("file created "+file.getCanonicalPath()); //returns the path string 
	    
		//InputStream input = new FileInputStream(fileLocation);
		//Properties prop = new Properties();
		
		//prop.load(input);
	    FileOutputStream out = new FileOutputStream(fileLocation);
	    byte[] b= payload.getBytes();       //converts string into bytes  
	
	    out.write(b);   
	    out.close();            //close the file  
	//writes bytes into file  
	
	   // prop.setProperty("Payload", payload);
	
	    //prop.save(out, null);
	    out.close();
	    completed="true";
		}  
		else  
		{  
		System.out.println("File already exist at location: "+file.getCanonicalPath());  
		completed="File already exist at location: "+file.getCanonicalPath();
		}  
		}   
		catch (IOException e)   
		{  
		e.printStackTrace();    //prints exception if any  
		} 

	}

}
