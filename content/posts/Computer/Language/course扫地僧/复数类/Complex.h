// Complex.h
#ifndef COMPLEX_H_
#define COMPLEX_H_

#include <iostream>

#pragma once

using std::ostream;

template <typename T>
class Complex {
  template <typename U>
  friend ostream &operator<<(ostream &out, const Complex<U> &c3);

 public:
  explicit Complex(T c1 = 0, T c2 = 0);

  Complex operator+(const Complex &cc);

 private:
  T c1;
  T c2;
};

template <typename T>
Complex<T>::Complex(T c1, T c2) {
  this->c1 = c1;
  this->c2 = c2;
}
template <typename T>
Complex<T> Complex<T>::operator+(const Complex<T> &cc) {
  Complex tmp(c1 + cc.c1, c2 + cc.c2);
  return tmp;
}

template <typename U>
ostream &operator<<(ostream &out, const Complex<U> &c3) {
  out << "c1:" << c3.c1 << " c2:" << c3.c2 << std::endl;
  return out;
}

#endif  // COMPLEX_H_
