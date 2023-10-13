//quiz1.cpp
//ENSF614 - Practice Quiz for quiz 1

#include <iostream>
using namespace std;

//function protoptype

char* reverse_strcat(char* dest, char* source);
bool up_then_down(const int* arr, int n);
bool all_diff(const char *left, const char *right);
int compareMyStrings(const char* arg1, const char* arg2);

int main(){

    char str1[] = "banana";
    cout << "str1 " << str1 <<endl;

    char str2[] = "-tacit";
    cout << "str2" << str2 << endl;

    const char* str3 = "-toe";
    char str5[] = "ticket";

    char *str6;
    str6 = reverse_strcat(str1,str2);

    //cout<< "str1 " << str1 << endl << "and str2: " << str2 << endl;
    cout<< "reversecat " << str6 << " str1 " << str1;

    const char a[] = "abc";
    const char b[] = "def";
    const char c[] = "ade";

    cout << "abc and def f " << all_diff(a,b) <<endl; 
    cout << "def and ade t  " << all_diff(b,c) <<endl;
    cout << "abc and ade t " << all_diff(a,c) << endl;

}

char* reverse_strcat(char* dest, char* source){
    int destPos = 0, srcPos = 0;

    char* result = dest;
    //finding the length of each string

    while(dest[destPos] != '\0')
        destPos++;
    
    while(source[srcPos] != '\0')
        srcPos++;

    for(int i = 0; i < srcPos; i++){
       dest[destPos+i] = source[srcPos-i-1];
       cout << destPos+i <<endl;
       cout << source[srcPos-i-1] <<endl;
       cout<< dest[destPos+i] <<endl;
    }
    dest[destPos+srcPos] = '\0';
    cout<< dest << endl;
   /* for(int i = srcPos -1; i >0; i--){
        dest[destPos] = source[srcPos];
        destPos++;
    }*/
    
    return result;
}

bool all_diff(const char *left, const char *right){
    //bool result = true;

    while(*left){
        while(*right){
            if(*left == *right)
                return false;
            right++;
        }
        left++;
    }

    return true;
}