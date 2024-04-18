#include <iostream>

int main(int argc, char *argv[]) {
  std::cout << "Enter the name of the person you want to write to:\n";
  std::string first_name;
  std::cin >> first_name;
  std::cout << "Dear " << first_name << ",\n";
  std::cout << "  How are you? I am fine. I miss you.\n";

  std::cout << "Enter the name of another person:\n";
  std::cin >> first_name;
  std::cout << "  Have you see " + first_name + " lately?\n";

  char friend_sex;
  return 0;
}
