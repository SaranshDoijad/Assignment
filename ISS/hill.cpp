#include<iostream>
#include<math.h>
using namespace std;
float en[3][1], de[3][1], a[3][3], b[3][3], msg[3][1], m[3][3];
void getKeyMatrix() 
{ 
   int i, j;
   char mes[3];
   cout<<"Enter 3x3 matrix for key:-"<<endl;
   for(i = 0; i < 3; i++)
   for(j = 0; j < 3; j++) {
      cin>>a[i][j];
      m[i][j] = a[i][j];
   }
   cout<<"\nEnter a string of 3 letter: ";
   cin>>mes;
   for(i = 0; i < 3; i++)
   msg[i][0] = mes[i] - 65;
}
void encrypt() { 
   int i, j, k;
   for(i = 0; i < 3; i++)
   {
     for(j = 0; j < 1; j++)
     {
      for(k = 0; k < 3; k++)
      {
         en[i][j] = en[i][j] + a[i][k] * msg[k][j];
       }
      }
    } 
   cout<<"\nEncrypted string is: ";
   for(i = 0; i < 3; i++)
   cout<<(char)(fmod(en[i][0], 26) + 65);
}
void inversematrix() {
   cout<<"\nenter the inverse matrix:-"<<endl;
   
   for(int i=0;i<3;i++)
   {
   	for(int j=0;j<3;j++)
   	{
   		cin>>b[i][j];
	   }
   }
}
void decrypt() { //decrypt the message
   int i, j, k;
   inversematrix();
   for(i = 0; i < 3; i++)
   {
     for(j = 0; j < 1; j++)
     {
	 
      for(k = 0; k < 3; k++)
      {
        de[i][j] = de[i][j] + b[i][k] * en[k][j];
      }
    }
   }
   cout<<"\nDecrypted string is: ";
   for(i = 0; i < 3; i++)
   cout<<(char)(fmod(de[i][0], 26) + 65); 
   cout<<"\n";
}
int main() {
   getKeyMatrix();
   encrypt();
   decrypt();
}

