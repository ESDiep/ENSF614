/*
 * Main program file.
 *
 * ENSF 614 Lab 2 Exercise E
 */

#include <iostream>
#include <stdlib.h>
using namespace std;
#include "lab2exe_E.h"

double read_double_only(void);
/*
 *  Read a double, then skip to the end of a line of input.
 *
 *  REQUIRES
 *     User has been prompted to enter a double.
 *  PROMISES
 *     If user enters bad input, exit is called with an arg of 1.
 *     Otherwise:
 *        Characters following the int are discarded up to
 *        end-of-line or end-of-file, whichever is first.
 *        Return value is the double that was read.
 */

int main(void)
{
  cplx w, z;            /* entered by user */
  cplx sum;            /* sum of w and z */
  cplx *pdif, *prod, *pw, *pz;
  cplx diff,product;
  cout << "This programs needs values for complex numbers w and z.\n";

  cout << "  Please enter the real part of w     : ";
  w.real = read_double_only();
    
  cout << "  Please enter the imaginary part of w: ";
  w.imag = read_double_only();
  
  cout << "  Please enter the real part of z     : ";
  z.real = read_double_only();
  cout << "  Please enter the imaginary part of z: ";
  z.imag = read_double_only();

  cout << "\nw is (" << w.real << ") + j(" << w.imag << ")\n";
  cout << "z is (" << z.real << ") + j(" << z.imag << ")\n";

  sum = cplx_add(w, z);

  cout << "\nsum is (" << sum.real << ") + j(" << sum.imag << "}\n";

  pdif = &diff;
  cplx_subtract(w,z,pdif);
  cout << "\nDifference is (" << pdif->real << ") + j(" << pdif->imag << ")\n";
  
  pw = &w;
  pz = &z;
  prod = &product;
  cplx_multiply(pw,pz,prod);
  cout << "\nProduct is (" << prod->real << ") + j(" << prod->imag << ")\n";
  

  return 0;
}


double read_double_only(void)
{
  double value_read;
  int char_code;
 
  if (!(cin >> value_read)) {
    cout << "Error trying to read in a double.  Program terminated.\n";
    exit(1);
  }
 
  return value_read;
}
