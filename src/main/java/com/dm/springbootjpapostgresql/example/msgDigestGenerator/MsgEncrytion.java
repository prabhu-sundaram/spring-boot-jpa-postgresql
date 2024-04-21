package com.dm.springbootjpapostgresql.example.msgDigestGenerator;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MsgEncrytion
{
  static final char[] HEX_TABLE = new char[] { '0', '1', '2', '3', '4', '5', 
      '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

  
  private static String hashAllFields(Map fields, String SECURE_SECRET) {
    List<Comparable> fieldNames = new ArrayList(fields.keySet());
    Collections.sort(fieldNames);
    
    StringBuffer buf = new StringBuffer();

    
    Iterator<Comparable> itr = fieldNames.iterator();
    
    while (itr.hasNext()) {
      String fieldName = (String)itr.next();
      String fieldValue = (String)fields.get(fieldName);
      if (fieldValue != null && fieldValue.length() > 0) {
        buf.append(fieldValue);
      }
    } 


    
    buf.append(SECURE_SECRET);
    
    MessageDigest md5 = null;
    byte[] ba = (byte[])null;
    try {
      md5 = MessageDigest.getInstance("MD5");
      ba = md5.digest(buf.toString().getBytes("UTF-8"));
    } catch (Exception e) {
      e.printStackTrace();
    } 
    
    return hex(ba);
  }
 
  static String hex(byte[] input) {
    StringBuffer sb = new StringBuffer(input.length * 2);


    
    for (int i = 0; i < input.length; i++) {
      sb.append(HEX_TABLE[input[i] >> 4 & 0xF]);
      sb.append(HEX_TABLE[input[i] & 0xF]);
    } 
    return sb.toString();
  }

  public boolean checksum(HashMap hm, String SECURE_SECRET) {
    String hashedValue = (String)hm.get("ENCRYPTEDMSG");
    hm.remove("ENCRYPTEDMSG");
    
    String convertedString = hashAllFields(hm, SECURE_SECRET);
    
    if (hashedValue.equals(convertedString)) {
      return true;
    }
    return false;
  }
 
  public static String md5Response(HashMap hm, String SECURE_SECRET) {
    String convertedString = hashAllFields(hm, SECURE_SECRET);
    return convertedString;
  }
  
  public static String preparedDegParameter(HashMap hm) {
    String encryptedMsg = "";
    
    try {
      String SECURE_SECRET = "O4UGgzQ5GkMefyb01oQ1299565704666";
      encryptedMsg = md5Response(hm, SECURE_SECRET);   
    }
    catch (Exception e) {
      
      e.printStackTrace();
    } 
    return encryptedMsg;
  }
  
  public void testDegParameterPreparation() {
    HashMap<Object, Object> hm = new HashMap<Object, Object>();
    hm.put("AMOUNT", Double.toString(10.25D));
    hm.put("SPTRN", "TestMsg002");
    
    preparedDegParameter(hm);
  }
}
