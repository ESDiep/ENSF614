/*
 * lab2exe_E.cpp
 * Implementation file for complex number module
 *
 * ENSF 614 Lab 2 Exercise E
 */

#include "lab2exe_E.h"
#include <iostream>

cplx cplx_add(cplx z1, cplx z2)
{
  cplx result;

  result.real = z1.real + z2.real;
  result.imag = z1.imag + z2.imag;
  return result;
}

void cplx_subtract(cplx z1, cplx z2,  cplx *difference)
{
  difference->real = z1.real - z2.real;
  difference->imag = z1.imag - z2.imag;
}

void cplx_multiply(const cplx *pz1,const cplx *pz2,cplx *product)
{  
  product->real = (pz1->real)*(pz2->real) - (pz1->imag)*(pz2->imag);
  product->imag = (pz1->real)*(pz2->imag) + (pz2->real)*(pz1->imag);

}
