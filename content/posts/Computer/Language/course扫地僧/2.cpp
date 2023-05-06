#include <iostream>

class A {
 public:
  int b;
};
class B {
 public:
  int b;
};

class C : public A, public B {};

int main(int argc, char *argv[]) {
  C c1;
  c1.A::b = 1;
  std::cout << c1.A::b << std::endl;
  return 0;
}
