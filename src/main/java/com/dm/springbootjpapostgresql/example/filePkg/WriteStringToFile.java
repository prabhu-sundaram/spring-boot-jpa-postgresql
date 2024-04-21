package com.dm.springbootjpapostgresql.example.filePkg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteStringToFile {

	public static void main(String[] args) {
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
		String	fileLocation = "src/main/resources/example/"+CorrelationId+"Payload.xml";
		
		
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
