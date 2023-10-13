 //  ENSF 614 fall 2023 Lab 4 - Exercise B
#include <iostream>
#include <fstream>
#include <sstream>
#include <stdlib.h>

const int size1 = 6;
using namespace std;
struct City {
    double x, y;
    char name[30];
};

void write_binary_file(City cities[], int size, char* filename);
/* PROMISES: attaches an ofstream object to a binary file named "filename" and
 * writes the content of the array cities into the file.
 */

void print_from_binary(char* filename);
/* PROMISES: uses ifstream library object to open the binary file named
 * "filename", reads the content of the file which are objects of struct City
 * (one record at a time), and displays them on the screen. It also saves the records
 * into a text-file that its name must be the filename argument, but with the extension
 * of .txt
 */


int main() {
    char bin_filename[] = "cities.bin";
    
    City cities[size1] = {{100, 50, "Calgary"},
        {100, 150, "Edmonton"},
        {50, 50, "Vancouver"},
        {200, 50, "Regina"},
        {500, 50, "Toronto"},
        {200, 50, "Montreal"}};
    
    write_binary_file(cities, size1, bin_filename);
    cout << "\nThe content of the binary file is:" << endl;
    print_from_binary(bin_filename);
    return 0;
}

void write_binary_file(City cities[], int size, char* filename){
    ofstream stream(filename, ios::out | ios::binary);
    if(stream.fail()){
        cerr << "failed to open file: " << filename << endl;
        exit(1);
    }
    
    for(int i =0; i < size; i++)
        stream.write((char*)&cities[i], sizeof(City));
    stream.close();
}

void print_from_binary(char* filename) {
    char temp = '0';
    char* output_file = &temp;
    int i = 0;
    const char* suffix = ".txt";
    for( i  = 0; filename[i] != '.'; i++){
        cout << i;
        output_file[i] = filename[i];
        cout << output_file[i] << endl;
    }
    cout<< i;
    while(*suffix){
        output_file[i] = *suffix;
        cout << output_file[i] << endl;
        suffix++;
        i++;
        cout << i << endl;
    }
    
    output_file[i] = '\0';
    cout<< output_file <<endl;
     while(*output_file){
        cout<<output_file;
        output_file++;
     }
    
   /* ifstream in_stream(filename, ios::in | ios::binary);
    //ofstream out_stream(output_file, ios::out, ios::app);
    if(in_stream.fail()){
        cerr << "failed to open file: " << filename << endl;
        exit(1);
    }


    

    //while(!in_stream.eof()){
        //in_stream >> a;
        //cout << a;
    //}

    //out_stream.close();
    in_stream.close();
*/
}




