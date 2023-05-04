#include <string.h>

int stack[10000] = {0};
int length = 0;

void push(int i) { stack[length++] = i; }

void pop() { stack[--length] = 0; }

int get() {
  if (length == 0) {
    return -1;
  }
  return stack[length - 1];
}

int isValid(char* s) {
  for (int i = 0; i < strlen(s); i++) {
    switch (s[i]) {
      case '(':
        push(1);
        break;
      case '[':
        push(2);
        break;
      case '{':
        push(3);
        break;
      case ')':
        if (get() == 1) {
          pop();
        } else {
          return 0;
        }
        break;
      case ']':
        if (get() == 2) {
          pop();
        } else {
          return 0;
        }
        break;
      case '}':
        if (get() == 3) {
          pop();
        } else {
          return 0;
        }
        break;
      default:
        break;
    }
  }
  if (length == 0) {
    return 1;
  }
  return 0;
}

int main() { isValid("{[]}"); }

char pairs(char a) {
  if (a == '}') return '{';
  if (a == ']') return '[';
  if (a == ')') return '(';
  return 0;
}

bool s_isValid(char* s) {
  int n = strlen(s);
  if (n % 2 == 1) {
    return false;
  }
  int stk[n + 1], top = 0;
  for (int i = 0; i < n; i++) {
    char ch = pairs(s[i]);
    if (ch) {
      if (top == 0 || stk[top - 1] != ch) {
        return false;
      }
      top--;
    } else {
      stk[top++] = s[i];
    }
  }
  return top == 0;
}
