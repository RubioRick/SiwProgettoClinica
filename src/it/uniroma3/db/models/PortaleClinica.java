package it.uniroma3.db.models;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ejb.Stateless;

@Stateless(name = "portaleClinica")
public class PortaleClinica {
	
	
	public static String toSHA1(String password) {
		byte[] convertme = password.getBytes();
	    MessageDigest md = null;
	    try {
	        md = MessageDigest.getInstance("SHA-1");
	    }
	    catch(NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    } 
	    return new String(md.digest(convertme));
	}
}
