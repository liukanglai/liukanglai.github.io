#include <algorithm>
#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;

// 暴力：一个指针记录当前字符最长，如下一个不一样，判断下下个是否一样，如果一样再来个指针记录长度，总长度相加，但要，如果后面再来了一个相同字符，长度+1
// 第二个指针遇到不同字符终止，用hash表记录字符长度。接着第一个指针+1，在次循环
class SolutionMy {
 public:
  int maxRepOpt1(string text) {
    int max = 0;
    for (int i = 0; i < text.length(); i++) {
      int k = i;  // 重要，记录前面有的
      int pos = text[i] - 'a';
      int len = 1;
      /*
      if (hash[pos] != 0 && add[pos] == 0) {
        hash[pos]++;  // 后面有字符可以换前面的
        len++;        // 前面有字符可以换后面的
        add[pos] = 1;
      }
      */
      while (i < text.length() - 1 && text[i] == text[i + 1]) {
        len++;
        i++;
      }
      int j = i + 2;
      if (i < text.length() - 2 && text[i] == text[j]) {
        len++;
        while (j < text.length() - 1 && text[j] == text[j + 1]) {
          len++;
          j++;
        }
      }
      int flag = 0;
      while (j++ < text.length()) {
        if (text[j] == text[i]) {
          len++;
          flag = 1;
          break;
        }
      }
      while (flag == 0 && --k >= 0) {
        if (text[k] == text[i]) {
          len++;
          break;
        }
      }
      hash[pos] = hash[pos] > len ? hash[pos] : len;
      max = max > hash[pos] ? max : hash[pos];
    }
    return max;
  }

 private:
  int hash[26] = {0};
};

class SolutionPlus {
 public:
  int maxRepOpt1(const std::string& text) {
    int max_len = 0;
    int hash[26] = {0};  // 使用大括号初始化器来初始化数组

    for (auto i = text.begin(); i != text.end(); i++) {
      auto k = i;
      auto pos = *i - 'a';
      auto len = 1;

      while (i + 1 != text.end() && *i == *(i + 1)) {
        len++;
        i++;
      }

      auto j = i + 2;
      if (j != text.end() && *i == *j) {
        len++;
        while (j + 1 != text.end() && *j == *(j + 1)) {
          len++;
          j++;
        }
      }

      auto flag = false;
      while (++j != text.end()) {
        if (*j == *i) {
          len++;
          flag = true;
          break;
        }
      }

      while (!flag && k-- != text.begin()) {
        if (*k == *i) {
          len++;
          break;
        }
      }

      hash[pos] = std::max(hash[pos], len);  // 使用std::max函数代替三目运算符
      max_len = std::max(max_len, hash[pos]);  // 使用std::max函数代替三目运算符
    }

    return max_len;
  }
};

// use hashtable

class SolutionHash {
 public:
  int maxRepOpt1(const std::string& text) {
    int max_len = 0;
    std::unordered_map<char, int> hash;

    for (auto i = text.begin(); i != text.end(); i++) {
      auto k = i;
      auto len = 1;

      while (i + 1 != text.end() && *i == *(i + 1)) {
        len++;
        i++;
      }

      auto j = i + 2;
      if (j != text.end() && *i == *j) {
        len++;
        while (j + 1 != text.end() && *j == *(j + 1)) {
          len++;
          j++;
        }
      }

      auto flag = false;
      while (++j != text.end()) {
        if (*j == *i) {
          len++;
          flag = true;
          break;
        }
      }

      while (!flag && k-- != text.begin()) {
        if (*k == *i) {
          len++;
          break;
        }
      }

      hash[*i] = std::max(hash[*i], len);
      max_len = std::max(max_len, hash[*i]);
    }

    return max_len;
  }
};

int main() {
  SolutionHash s;
  std::string text = "ababa";
  std::cout << s.maxRepOpt1(text) << std::endl;
  return 0;
}
