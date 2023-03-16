//In ECB mode of DES we need to provide the input text in the multiple of 8 bytes so if the text is not the multiple of 8 it will get trunckate

import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import javax.crypto.Cipher;  
import javax.crypto.CipherInputStream;  
import javax.crypto.CipherOutputStream;  
import javax.crypto.KeyGenerator;  
import javax.crypto.SecretKey;  

public class DES_ECB 
{
  
private static Cipher encrypt; 
  
private static Cipher decrypt;   

public static void main(String[] args)   
{  

//path of the file that we want to encrypt  
String textFile = "C:/Users/Latitude 5480/Desktop/ISS/demo.txt";  

//path of the encrypted file that we get as output  
String encryptedData = "C:/Users/Latitude 5480/Desktop/ISS/encrypteddata.txt";  
//path of the decrypted file that we get as output  

String decryptedData = "C:/Users/Latitude 5480/Desktop/ISS/decrypteddata.txt";  
try   
{  

SecretKey scrtkey = KeyGenerator.getInstance("DES").generateKey(); //generating keys by using the KeyGenerator class  
 
//setting encryption mode 
encrypt = Cipher.getInstance("DES/ECB/NoPadding");  
encrypt.init(Cipher.ENCRYPT_MODE, scrtkey);  //to initialize cipher with key

//setting decryption mode  
decrypt = Cipher.getInstance("DES/ECB/NoPadding");  
decrypt.init(Cipher.DECRYPT_MODE, scrtkey);  //to initialize cipher with key

//calling encrypt() method to encrypt the file  
encryption(new FileInputStream(textFile), new FileOutputStream(encryptedData));  

//calling decrypt() method to decrypt the file  
decryption(new FileInputStream(encryptedData), new FileOutputStream(decryptedData));  

System.out.println("The encryption and decryption of files have been performed successfully!!");  
}   
 
catch (Exception e)   
{  
e.printStackTrace();  
}  
}  

//method for encryption  
private static void encryption(InputStream input, OutputStream output)  
throws IOException   
{  
output = new CipherOutputStream(output, encrypt);  

//calling the writeBytes() method to write the encrypted bytes to the file   
writeBytes(input, output);  
}   

//method for decryption  
private static void decryption(InputStream input, OutputStream output)  
throws IOException   
{  
input = new CipherInputStream(input, decrypt);  

//calling the writeBytes() method to write the decrypted bytes to the file    
writeBytes(input, output);  
}  

//method for writting bytes to the files   
private static void writeBytes(InputStream input, OutputStream output)  
throws IOException   
{  
byte[] writeBuffer = new byte[512];  
int readBytes = 0;  
while ((readBytes = input.read(writeBuffer)) >= 0)   //to check the content present in the file
{  
output.write(writeBuffer, 0, readBytes);  
}  
//closing the output stream  
output.close();  
//closing the input stream  
input.close();  
}    
}
