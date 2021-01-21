
package myexercise.encodedecode;

import org.apache.commons.codec.binary.Base64;

//the Base64 has to import from Apache  so now its showing error. 
// Once I installed Apache i can import the correct package of appache common binary base64.
public class EncodingDecodingPwd {

	public static void main(String[] args) {
		String  password= "fortest20";
	
	byte[] encodedPwd= Base64.encodeBase64(password.getBytes());
			
	System.out.println("Encoded Password: "+new String(encodedPwd));
	
	byte[] decodedPwd= Base64.decodeBase64(encodedPwd);
	System.out.println("Decoded Password:"+ new String(decodedPwd));
	
	
	}

}
