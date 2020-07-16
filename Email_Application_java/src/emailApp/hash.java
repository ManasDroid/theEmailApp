package emailApp;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class hash {
    //Generates SHA-1 hash for input string
    public static String encrypt(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger n  = new BigInteger(1, messageDigest);
            String hashtext = n.toString(16);
            while(hashtext.length()<32)
                hashtext = '0' + hashtext;
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(encrypt("password"));
    }
}