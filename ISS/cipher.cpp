#include<iostream>
#include<string.h>
using namespace std;
void decrypt(string,int);
char alpha[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' '};

void encrypt(string ptext,int key)
{
	string ctext;
	int value;
	
	for(int i=0;i<ptext.length();i++)
	{
		
		{
		
		for(int j=0;j<sizeof(alpha);j++)
		{
	
			if(alpha[j]==ptext[i])
			{
				value=(j+key)%sizeof(alpha);
				ctext=ctext+alpha[value];
			}
		}
	}
	
	
	}
	cout<<"encryption::"<<ctext<<endl;
	decrypt(ctext,key);
}

void decrypt(string ctext,int key)
{
	string ptext;
	int value;
	for(int i=0;i<ctext.length();i++)
	{
		if(islower(ctext[i]))
		{
		for(int j=0;j<sizeof(alpha);j++)
		{
			if(alpha[j]==ctext[i])
			{
				value=j-key;
				if(value<0)
				{
					value=value+sizeof(alpha);
				}
				else
				{
					value=(j-key)%sizeof(alpha);
				}
				ptext=ptext+alpha[value];
			}
		}
	}
	
	}
	
	cout<<"decription::"<<ptext<<endl;
}
int main()
{
     string ptext;
     cout<<"enter the string for encryption and decryption::";
     getline(cin,ptext);
     int key;
     cout<<"enter the key::";
     cin>>key;
     
     encrypt(ptext,key);
}