package edu.acc.java1.hashes;

import javax.swing.JOptionPane;
import java.security.*;
import java.util.Base64;

// Completed 10/18/2018
// Version 2.0
public class Main {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String input = JOptionPane.showInputDialog(null, "Enter some text:");
		if (input == null) return;
		
		final String format = "%02X";
		StringBuilder sb = new StringBuilder(512);
		
		//Base64.Encoder e = Base64.getEncoder();
		//byte[] inputAsBytes = input.getBytes();
		//byte[] = e.encode(inputAsBytes);
		String encoded = Base64.getEncoder().encodeToString(input.getBytes());
		sb.append("In Base64: ").append(encoded);
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] hash = md.digest(input.getBytes());
		sb.append("\n\nMD5 Hash: ");
		for (byte b : hash)
			sb.append(String.format(format, b));
		
		md = MessageDigest.getInstance("SHA-256");
		hash = md.digest(input.getBytes());
		sb.append("\n\nSHA-256 Hash: ");
		for (byte b : hash)
			sb.append(String.format(format, b));
		
		JOptionPane.showMessageDialog(null, sb);
	}

}

















