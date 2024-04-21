package com.dm.springbootjpapostgresql.example.msgDigestGenerator;

public class MsgDigestGeneratorClient {

	/*
	 * public static void main(String[] args) { MsgDigestGenerator MsgDigest = new
	 * MsgDigestGenerator(); System.out.println(MsgDigest.generateMsgDigest("ENBD",
	 * "20170000001", "123456789012")); }
	 */
	
	public static void main(String[] args) throws Exception {
		String a[]={"ONL", "2020090100043", "123456789012"};

		MsgDigestGenerator.main(a);

	}

}
