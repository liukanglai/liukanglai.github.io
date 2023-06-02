// main.cpp
#include "Complex.h"

#include <iostream>

int main(int argc, char *argv[]) {
  Complex<int> c1(10, 20);
  Complex<int> c2(30, 40);

  Complex c3 = c1 + c2;
  std::cout << c3 << std::endl;
  return 0;
}
