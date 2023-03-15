import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class A42_DES_ECB_decrypt {
    public static void main(String[] args) throws Exception {
        
        if (args.length != 1) {
            System.out.println("Usage: java A42_DES_ECB_Decrypt <filename>");
            return;
        }

        String fileName = args[0];
        FileInputStream fis = new FileInputStream(fileName);
        byte[] encryptedData = new byte[(int) fis.available()];
        fis.read(encryptedData);
        fis.close();

        byte[] keyData = { 1, 2, 3, 4, 5, 6, 7, 8 };
        SecretKey key = new SecretKeySpec(keyData, "DES");

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decryptedData = cipher.doFinal(encryptedData);

        FileOutputStream fos = new FileOutputStream(fileName.replace(".enc", ""));
        fos.write(decryptedData);
        fos.close();

        System.out.println("Decryption completed. Decrypted data stored in " + fileName.replace(".enc", ""));
    }
}