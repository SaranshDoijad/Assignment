#include <iostream>
#include <string.h>
#include <cstring>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

using namespace std;

int main(){
	char path[200];
	cout << "Enter the path: ";
	cin >> path;
	
	char *token = strtok(path, "/");
   	int i = 0;
   	string pathArr[100]; 
   	while (token != NULL) {
        	pathArr[i++] = token; 
        	token = strtok(NULL, "/");
   	}	

	int size = i;

	string newPath = "";
	

	string pathString = "/"; 	
	
	for(i = 0; i < size; i++){
		if(pathString != newPath){
			int fd = open(pathString.c_str(), O_RDONLY);
			if(fd == 0) break;
			struct stat info;
			fstat(fd, &info);
			cout << (int)info.st_ino << "          " << pathString << endl;
			pathString += pathArr[i] + "/";
			close(fd);
		}
	}
	
}
