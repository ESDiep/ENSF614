
#include <iostream>
#include "MyArray.h"


  // Create empty array.
  // PROMISES: size() == 0.
  MyArray::MyArray(){
    sizeM = 0;
    storageM = new EType[0];
  }
  
  // Create object by copying a built-in array.
  // REQUIRES
  //   sizeA >= 0. Elements builtin[0] ... builtin[sizeA - 1] exist.
  // PROMISES
  //   size() == sizeA.
  //   For i from 0 to sizeA-1, element i of object == builtin[i]. 
  MyArray::MyArray(const EType *builtin, int sizeA){
    if(sizeA > 0){
      sizeM = sizeA;
      storageM = new EType[sizeM];

      for(int i = 0; i < sizeA; i++){
        storageM[i] = builtin[i];
      }

    }

  }
    
  MyArray::MyArray(const MyArray& source){
    sizeM = source.size();    
    for(int i = 0; i < sizeM; i++){
      storageM[i] = source.at(i);
    }

  }

  MyArray& MyArray::operator =(const MyArray& rhs){
    if(this!= &rhs){
      delete[] storageM;
      sizeM = rhs.size();
      storageM = new EType[sizeM];
      //assert(storageM != NULL);
      for(int i = 0; i< sizeM; i++){
        storageM[i] = rhs.at(i);
      }
    }

    return *this;

   }
  
  MyArray::~MyArray(){
    delete[] storageM;    
  }

// PROMISES: Return value is number of elements stored.
  int MyArray::size() const{
    return sizeM;
  }
  
// REQUIRES: 0 <= i && i < size().
  // PROMISES: Return value is a reference to element i of array.
  EType MyArray::at(int i) const{
    if(i>=0 && i<sizeM)
      return storageM[i];
    else
      return '\0';
  }
  
  // REQUIRES: 0 <= i && i < size().
  // PROMISES: assigns new_value to the ith element of storageM
  void MyArray::set(int i, EType new_value){
    if(i>=0 && i<sizeM)
      storageM[i] = new_value;
    else
      std::cout<<"i is out of bound";
  }
   

  // REQUIRES: new_size >= 0.
  // PROMISES
  //   size() == new_size.
  //   If the operation shrinks the array or does not change the size,
  //   values of elements 0, 1, ... new_size - 1 are preserved.
  //   If the operation increases the size,
  //   values of elements 0, 1, ... one less than the old size
  //   are preserved.
  void MyArray::resize(int new_size){
    
    if(new_size > 0){

      if(sizeM > 0){
        if(new_size > sizeM ){
          EType *temp = new EType[new_size];
          temp = storageM;
          storageM = temp;
          delete[] temp;      
        }  
      }       
      
      sizeM = new_size; 
    }   
    else
      std::cout << "new size is negative";    

  }
  