import java.util.*;

class cipher
{
    public static void main(String[] args)
    {
        String str = "abcdefghijklmnopqrstuvwxyz";

        Scanner sc = new Scanner(System.in);

        System.out.println("enter the string");
        String a = sc.nextLine();

         System.out.println("enter the key");
        int k = sc.nextInt();

        int res[] = new int[a.length()];

        System.out.println("E");

        for(int i=0 ; i<a.length();i++)
        {
            res[i] = str.indexOf(a.charAt(i));
            res[i] = (res[i] + k) % 26 ;
        }

        for(int j=0; j<a.length();j++)
        {
            System.out.print(str.charAt(res[j]));
        }
        System.out.println("");
        System.out.println("D");

        for(int i=0 ; i<a.length();i++)
        {
           //res[i] = str.indexOf(a.charAt(i));
            res[i] = (Math.abs((res[i] -k)% 26)) ;
           // res[i] = (res[i] - k) % 26 ;
            
         }
        
        for(int j=0; j<a.length();j++)
        {
            System.out.print(str.charAt(res[j]));
        }
}
}