
import java.util.*;
public class Vigenere{
	public static void main(String[] args){
		int vtable[][]=new int[26][26];
		int ciphertext[][]=new int[1][50];
		int value=65;
		int repeatvar=25;
		int in=1;
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<26;i++){
			for(int j=0;j<26;j++){
				
				if(value>90){
					vtable[i][j]=90-repeatvar;
					repeatvar--;
				}
				else{
				vtable[i][j]=value;
				value++;
				}
			}
			repeatvar=25;
			value=65+in;
			in++;
		}
		System.out.println("Enter a message or plaintext(Only Capital letter is allowed):");
		String m=sc.next();
		System.out.println("Enter valid key(Enter only Capital Letter):");
		String k=sc.next();
		String k1="";
		if(k.length()>m.length()){
			System.out.println("Enter key size less than Plaintext");
			System.exit(1);
		}
		else{
		for(int l=0;l<m.length();l++){
			if(k1.length()<m.length()){
				k1=k1+k.charAt(l%k.length());
			}
			else{
				break;
			}
		}
		}
		System.out.println("New key is:"+k1);
		System.out.println("*****Encryption of given message is*****");
		for(int y=0;y<m.length();y++){
			int plaintextletter=m.charAt(y);
			int keytextletter=k1.charAt(y);
			outer_for_encryption:
			for(int i=0;i<26;i++){
				for(int j=0;j<26;j++){
					if((plaintextletter==vtable[i][0])&&(keytextletter==vtable[0][j])){
							System.out.print((char)vtable[i][j]);
							ciphertext[0][y]=vtable[i][j];
							break outer_for_encryption;
					}
					}
				
			}
		}
		System.out.println();
		System.out.println("*****Decryption of given ciphertext is*****");
		for(int y=0;y<m.length();y++){
			int keytextletter=k1.charAt(y);
			int ciphertextletter=ciphertext[0][y];
			outer_for_decryption:
			for(int i=0;i<26;i++){
				for(int j=0;j<26;j++){
					if((keytextletter==vtable[i][0])&&(ciphertextletter==vtable[i][j])){
						System.out.print((char)vtable[0][j]);
						break outer_for_decryption;
					}
				}
			}
		}
		
	}
}