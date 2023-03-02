import java.util.Arrays;
import java.util.Scanner;

public class RailFence {
    private static String encrypt(String plainText, int key){
        int len = plainText.length();
        char[][] matrix = new char[key][len];
        for(int i = 0; i < key; i++){
            Arrays.fill(matrix[i], '*');
        }
        int k = 0;
        int i = 0;
        boolean goDown = true;
        while(k < len){
            for(int j = 0; j < len; j++ ){
                matrix[i][j] = plainText.charAt(k++);
                if(goDown) i++;
                if(!goDown) i--;
                if(i == key - 1) goDown = false;
                if(i == 0) goDown = true;
            }    
        }
        StringBuilder cipherText = new StringBuilder();
        for(i = 0; i < key; i++) {
            for(int j = 0; j < len; j++){
                char ch = matrix[i][j];
                if(ch != '*') cipherText.append(ch);
            }
        }
        return cipherText.toString();
    }

    private static String decrypt(String cipherText, int key){
        int len = cipherText.length();
        char[][] matrix = new char[key][len];
        for(int i = 0; i < key; i++){
            Arrays.fill(matrix[i], '*');
        }
        int k = 0;
        int i = 0;
        boolean goDown = true;
        while(k < len){
            for(int j = 0; j < len; j++ ){
                matrix[i][j] = '_'; 
                k++;
                if(goDown) i++;
                if(!goDown) i--;
                if(i == key - 1) goDown = false;
                if(i == 0) goDown = true;
            }    
        }
        k = 0;
        for(i = 0; i < key; i++){
            for(int j = 0; j < len; j++){
                if(matrix[i][j] == '_') matrix[i][j] = cipherText.charAt(k++); 
            }
        }

        StringBuilder plainText = new StringBuilder();

        for(i = 0; i < len; i++){
            for(int j = 0; j < key; j++){
                if(matrix[j][i] != '*') plainText.append(matrix[j][i]);
            }
        }
        
        return plainText.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the plain text: ");
        String plainText = sc.nextLine();

        System.out.print("Enter the key: ");
        int key = sc.nextInt();
                
        String cipherText = encrypt(plainText, key);
        System.out.println("Encrypted String: " + cipherText);
        String dec = decrypt(cipherText, key);
        System.out.println("Decrypted String: " + dec);
    }    
}
