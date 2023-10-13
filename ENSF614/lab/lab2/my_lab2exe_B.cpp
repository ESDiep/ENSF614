/*
 *  lab2exe_B.cpp
 *  ENSF 614 Lab 2 Exercise B
 *  Completed by Sieu Eric Diep
 */

int my_strlen(const char *s);
/*  Duplicates strlen from <cstring>, except return type is int.
 *  REQUIRES
 *     s points to the beginning of a string.
 *  PROMISES
 *     Returns the number of chars in the string, not including the
 *     terminating null.
 */

void my_strncat(char *dest, const char *source, int);
/*  Duplicates strncat from <cstring>, except return type is void.
 *  REQUIRES:
 *    dest points to the beginning of a string,
 *    source points to the beginning of a string
 *    an integer n which is the first n character of the source string 
 *  PROMISES
 *    appending the first n character of string source to dest
 */

int my_strcmp(const char* str1, const char* str2);
/* Compares two strings and return an integer
 * REQUIRES:
 *  two cstrings, i.e. two char pointers, each points to a cstring
 * PROMISES:
 *  return 0 if two string are identical
 *  return a negative value if string 1 is less than string 2
 *  return a positive value if string 1 is greater than string 2
*/

#include <iostream>
#include <cstring>
using namespace std;

int main(void)
{
    char str1[7] = "banana";
    const char str2[] = "-tacit";
    const char* str3 = "-toe";
    
    /* point 1 */
    char str5[] = "ticket";
    char my_string[100]="";
    int bytes;
    int length;
    
    /* using strlen libarary function */
    length = (int) my_strlen(my_string);
    cout << "\nLine 1: my_string length is " << length;
  
    /* using sizeof operator */
    bytes = sizeof (my_string);
    cout << "\nLine 2: my_string size is " << bytes << " bytes.";
   
    /* using strcpy libarary function */
    strcpy(my_string, str1);
    cout << "\nLine 3: my_string contains: " << my_string;
   
    length = (int) my_strlen(my_string);
    cout << "\nLine 4: my_string length is " << length << ".";
   
    my_string[0] = '\0';
    cout << "\nLine 5: my_string contains:\"" << my_string << "\"";
  
    length = (int) my_strlen(my_string);
    cout << "\nLine 6: my_string length is " <<  length << ".";
   
    bytes = sizeof (my_string);
    cout << "\nLine 7: my_string size is still " << bytes << " bytes.";
 
    /* strncat append the first 3 characters of str5 to the end of my_string */
    my_strncat(my_string, str5, 3);
    cout << "\nLine 8: my_string contains:\"" << my_string << "\"";
  
    length = (int) my_strlen(my_string);
    cout << "\nLine 9: my_string length is " << length << ".";
   
    my_strncat(my_string, str2,  4);
    cout << "\nLine 10: my_string contains:\"" << my_string << "\"";
    
    /* strncat append ONLY up ot '\0' character from str3 -- not 6 characters */
    my_strncat(my_string, str3, 6);
    cout << "\nLine 11: my_string contains:\"" << my_string << "\"";
   
    length = (int) my_strlen(my_string);
    cout << "\nLine 12; my_string has " << length << " characters.";

    cout << "\n\nUsing strcmp - C library function: ";
    
    cout << "\n\"ABCD\" is less than \"ABCDE\" ... strcmp returns: " <<
    my_strcmp("ABCD", "ABCDE");

    cout << "\n\"ABCD\" is less than \"ABND\" ... strcmp returns: " <<
    my_strcmp("ABCD", "ABND");
    
    cout << "\n\"ABCD\" is equal than \"ABCD\" ... strcmp returns: " <<
    my_strcmp("ABCD", "ABCD");
 
    cout << "\n\"ABCD\" is less than \"ABCd\" ... strcmp returns: " <<
    my_strcmp("ABCD", "ABCd");

    cout << "\n\"Orange\" is greater than \"Apple\" ... strcmp returns: " <<
    my_strcmp("Orange", "Apple") << endl;
    return 0;
}

int my_strlen(const char *s){

    int count = 0;
    while(s[count] != '\0')
        count++;

    return count;

}

void my_strncat(char *dest, const char *source, int n){
    int pos = 0, i=0;
    while(dest[pos] !='\0'){
        pos++;
    }
 

    for( i = 0; i < n; i++){
        dest[pos+i] = source[i];
    }
    dest[pos+i] = '\0';
}

int my_strcmp(const char* str1, const char* str2){


    int pos = 0, result = 0;

    do{

        result = str1[pos] - str2[pos];

        if(result !=0 )
            return result;
        else
            pos++;
    }while(str1[pos] != '\0' || str2[pos] != '\0');
   
    return result;

}

