package com.dm.springbootjpapostgresql.example.xmlValidation;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

//import jakarta.xml.XMLConstants;
//import jakarta.xml.transform.stream.StreamSource;
//import jakarta.xml.validation.Schema;
//import jakarta.xml.validation.SchemaFactory;
//import jakarta.xml.validation.Validator;
//
//import org.xml.sax.ErrorHandler;
//import org.xml.sax.SAXException;
//import org.xml.sax.SAXParseException;

public class XMLValidation {

    public static void main(String[] args) {
    //	System.out.println("XMLValidation");
//      System.out.println("EmployeeRequest.xml validates against Employee.xsd? "+validateXMLSchema("Employee.xsd", "EmployeeRequest.xml"));
//      System.out.println("EmployeeResponse.xml validates against Employee.xsd? "+validateXMLSchema("Employee.xsd", "EmployeeResponse.xml"));
//      System.out.println("employee.xml validates against Employee.xsd? "+validateXMLSchema("Employee.xsd", "employee.xml"));
      
      }
    
/*
 * public static boolean validateXMLSchema(String xsdPath, String xmlPath){
 * 
 * try { SchemaFactory factory =
 * SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); Schema schema
 * = factory.newSchema(new File(xsdPath)); Validator validator =
 * schema.newValidator(); validator.validate(new StreamSource(new
 * File(xmlPath))); } catch (IOException | SAXException e) {
 * System.out.println("Exception: "+e.getMessage()); return false; } return
 * true; }
 * 
 * public static void validate(File xml, InputStream xsd) { try { SchemaFactory
 * factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
 * Schema schema = factory.newSchema(new StreamSource(xsd)); Validator validator
 * = schema.newValidator();
 * 
 * final List<SAXParseException> exceptions = new
 * LinkedList<SAXParseException>(); validator.setErrorHandler(new ErrorHandler()
 * {
 * 
 * @Override public void warning(SAXParseException exception) throws
 * SAXException { exceptions.add(exception); }
 * 
 * @Override public void fatalError(SAXParseException exception) throws
 * SAXException { exceptions.add(exception); }
 * 
 * @Override public void error(SAXParseException exception) throws SAXException
 * { exceptions.add(exception); } });
 * 
 * StreamSource xmlFile = new StreamSource(xml); validator.validate(xmlFile);
 * 
 * } catch (SAXException e) { e.printStackTrace(); } catch (IOException e) {
 * e.printStackTrace(); } } 
 */
}