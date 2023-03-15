import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class A42_DES_ECB {
    public static void main(String[] args) throws Exception {
        
        if (args.length != 1) {
            System.out.println("Usage: java A42_DES_ECB <filename>");
            return;
        }

        String fileName = args[0];
        FileInputStream fis = new FileInputStream(fileName);
        byte[] data = new byte[(int) fis.available()];
        fis.read(data);
        fis.close();

        byte[] keyData = { 1, 2, 3, 4, 5, 6, 7, 8 };
        SecretKey key = new SecretKeySpec(keyData, "DES");

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encryptedData = cipher.doFinal(data);

        FileOutputStream fos = new FileOutputStream(fileName + ".enc");
        fos.write(encryptedData);
        fos.close();

        System.out.println("Encryption completed. Encrypted data stored in " + fileName + ".enc");
    }
}