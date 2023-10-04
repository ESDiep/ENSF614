typedef double EType;

class MyArray {
public:

  // Create empty array.
  // PROMISES: size() == 0.
  MyArray(){
    sizeM = 0;
  }
  
  // Create object by copying a built-in array.
  // REQUIRES
  //   sizeA >= 0. Elements builtin[0] ... builtin[sizeA - 1] exist.
  // PROMISES
  //   size() == sizeA.
  //   For i from 0 to sizeA-1, element i of object == builtin[i]. 
  MyArray(const EType *builtin, int sizeA){

  }
  

  MyArray(const MyArray& source){

  }

  MyArray& operator =(const MyArray& rhs){
    
  }
  ~MyArray();

  int size() const;
  // PROMISES: Return value is number of elements stored.

  EType at(int i) const;
  // REQUIRES: 0 <= i && i < size().
  // PROMISES: Return value is a reference to element i of array.

  void set(int i, EType new_value);
  // REQUIRES: 0 <= i && i < size().
  // PROMISES: assigns new_value to the ith element of storageM 

  void resize(int new_size);
  // REQUIRES: new_size >= 0.
  // PROMISES
  //   size() == new_size.
  //   If the operation shrinks the array or does not change the size,
  //   values of elements 0, 1, ... new_size - 1 are preserved.
  //   If the operation increases the size,
  //   values of elements 0, 1, ... one less than the old size
  //   are preserved.

private:
  int sizeM;
  EType *storageM;
};