package com.dm.springbootjpapostgresql.example.msgDigestGenerator;
import java.util.HashMap;

public class MsgDigestGenerator
{
  public static void main(String[] args) throws Exception {
    HashMap<Object, Object> msgCheck = new HashMap<Object, Object>();
    String sourceSysChannel = "";
    String msgId = "";
    String secretCode = "";
    if (args.length != 3) {
      System.exit(-1);
    } else {
      sourceSysChannel = args[0];
      msgId = args[1];
      secretCode = args[2];
    } 
    
    String msgDigestStr = "";

    String msgConcat = msgId.concat(sourceSysChannel.concat(secretCode));
    msgCheck.put("dCheck", msgConcat);
    msgDigestStr = MsgEncrytion.preparedDegParameter(msgCheck);
    System.out.println("msgDigestStr " + msgDigestStr);
  }
}
