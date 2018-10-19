package edu.acc.java1.savenload;
/*
	Write a packaged program Saver to record the usernames and passwords
	of the three employees of Widgets, Inc.
		Alice Alpha's username is aa@widgets.inc and her password is 'rascal'
		Bob Beta's username is (guess) and his password is 'badger'
		Gene Gamma's username is (guess) and his password is 'scoundrel'
	Save the user's passwords as MD5 hashes along with their user names
	in a file called staff.txt.
*/
import java.security.*;
import java.io.*;

public class Saver {
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		Employee aa = new Employee("Alice","Alpha","aa@widgets.inc", "rascal", true);
		Employee bb = new Employee("Bob","Bob","bb@widgets.inc","badger", true);
		Employee gg = new Employee("Gene","Gamma","gg@widgets.inc","scoundrel", true);
		Employee[] staff = new Employee[]{aa, bb, gg};
		
		PrintWriter pw = new PrintWriter(new FileWriter("staff.txt"));
		for (Employee e : staff)
			pw.printf("%s:%s:%s:%s\n", e.getFirstName(), e.getLastName(),
				e.getUsername(), e.getPassword());
		pw.close();
	}
}

