package com.dm.springbootjpapostgresql.example.stringPkg;

public class StringTest2 {

	public static void main(String[] args) {
		String	input = "<payload>fsfsdfdfddggvcvvvvvvvvvvvvv</payload>";
		int firstIndex=input.indexOf("<payload>");
		int lastIndex=input.indexOf("</payload>");
		input=input.substring(firstIndex+9, lastIndex);
		input=input.replaceAll("&lt;/", "</");
		input=input.replaceAll("tns:", "adp:");
		String output=input.replaceAll("&lt;", "\r\n<");
		output="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:adp=\"http://www.adpolice.gov.ae/\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <adp:UserIdentifierSoapHeaderIn>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <adp:UserName>DUBAIMUN</adp:UserName>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <adp:Password>DMUNADP2018//@Test</adp:Password>\r\n" + 
				"      </adp:UserIdentifierSoapHeaderIn>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <adp:getVehicleInfo>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <adp:request>\r\n" + 
				""+output;
		output=output+"    </adp:request>\r\n" + 
				"      </adp:getVehicleInfo>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";

	    System.out.println(output);

	    
	}

}
