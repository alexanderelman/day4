package edu.acc.java1.loadnsave;

import java.io.*;
import java.security.*;
import edu.acc.java1.savenload.Employee;

public class Load {
    public static void main (String[] args) throws IOException, NoSuchAlgorithmException {
        final int FN = 0, LN = 1, UN = 2, HP = 3;
        BufferedReader br = new BufferedReader(new FileReader("staff.txt"));
        String line;
        while ((line = br.readLine()) != null ) {
            // do stuff
            String[] parts = line.split(":");
            Employee e = new Employee(parts[FN], parts[LN], parts[UN], parts[HP], false);
            System.out.println(e);
        }
        br.close();
    }
}