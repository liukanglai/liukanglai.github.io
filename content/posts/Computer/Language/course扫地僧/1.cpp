#include <iostream>
#include <vector>

// 命名空间，避免函数同名

int main(void) {
  int n;
  std::cin >> n;
  std::cout << "Hello Cpp!" << n++ << std::endl;  // enl 换行符
  std::vector<int> array;                         // 默认为0
  array.resize(10);
  array.push_back(11);
  for (auto p = array.begin(); p != array.end(); p++) {
    std::cout << *p << " ";
  }
  for (auto &i : array) {
    i++;
  }
  for (auto i : array) {
    std::cout << i << " ";
  }
}
