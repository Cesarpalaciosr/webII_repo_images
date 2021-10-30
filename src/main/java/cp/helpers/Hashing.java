package cp.helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {
	
public static String hashPass(String pass) {
	
		PropertiesReader prop = new PropertiesReader();
		
		
		try {
			MessageDigest hash = MessageDigest.getInstance("MD5");
			hash.update(pass.getBytes());
			byte[] b =  hash.digest();
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<b.length;i++) {
				sb.append(Integer.toString((b[i] & 0xff)+0x100, 16).substring(1));
			}
			
			sb.append(prop.getValue("secret"));	
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
