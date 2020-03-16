package Program;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

    public static String encryptThisString(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String args[]) throws NoSuchAlgorithmException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("SHA1 hash values: ");
        System.out.print("Enter first value : ");
        String s1 = sc.next();
        System.out.print("Enter Second value : ");
        String s2 = sc.next();
        System.out.println(s1 + " - " + encryptThisString(s1));
        System.out.println(s2 + " - " + encryptThisString(s2));
    }
}
