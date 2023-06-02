# 从 C 到 Cpp

## 好处

1. 兼容 c 语言
1. STL 库
1. string 好用
1. 运行时间差一些

## 命名空间

- 命名空间，避免函数同名
- using namespace std;

## cin/cout

- 速度要慢，可以改为 scanf，printf

## 头文件

- `<string.h> -> <cstring>`

## bool

- bool flag = true;
- 0 为 false，其他都是 true

## const

- #define MAX 150(in c)
- const int MAX = 150(in cpp)

## string

- string s = "hello";
- s1+s2
- cin >> s;(不能有空格，回车？)
- getline(cin, s);
- s.length();
- s1 = s.substr(4,2);

## 结构体

- 可以省去 typedef

## 函数

- 传值时可不用加&取地址，只要在函数形参中用 int &a 即可

## STL

1. vector

```cpp
#include<vector>
// 命名空间std
vector<int> array; // 默认为0
array.resize(10);
vector<int> array(10, 2);  // 10个空间，里面是2
array.push_back(11);
for (auto p = array.begin(); p != array.end(); p++) {
    std::cout << *p << " ";
}
```

1. set

- 集合，里面元素各不相同，而且元素会按照从小到大排序

```cpp
#include<set>
// 命名空间std
set<int> s; // 后面不可加内容
s.insert(0);
s.find(0); //返回指针
s.erase(0);
for (auto p = s.begin(); p != s.end(); p++) {
    std::cout << *p << " ";
}
```

1. map

- 键值对，从小到大排序

```cpp
#include<map>
// 命名空间std
map<string, int> m;
m["hello"] = 2;
for (auto p = s.begin(); p != s.end(); p++) {
    std::cout << p->first << " : " << p->second << endl;
}
m.size();
```

1. stack

```cpp
#include<stack>
// 命名空间std
stack<int> s;
s.push(0);
s.top();
s.pop();
s.size();
```

1. queue

```cpp
#include<queue>
// 命名空间std
queue<int> s;
s.push(0);
s.pop(); //返回指针
s.front();
s.back();
s.size();
for (auto p = s.begin(); p != s.end(); p++) {
    std::cout << *p << " ";
}
```

1. unordered_map/unordered_set

- 不排序

```cpp
#include<unordered_set>
#include<unordered_map>
// 命名空间std
unordered_set<int> s;
s.insert(0);
s.find(0); //返回指针
s.erase(0);
for (auto p = s.begin(); p != s.end(); p++) {
    std::cout << *p << " ";
}
```

## 位运算

- bitset，字符数组，但逆序

```cpp
#include<bitset>
// 命名空间std
bitset<5> b(19);
b.any();
b.none();
b.count();
b.size();
b.test();
for (auto p = s.begin(); p != s.end(); p++) {
    std::cout << *p << " ";
}
```
