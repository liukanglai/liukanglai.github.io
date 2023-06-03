//the push turn is fixed,judge whether the pop sequence is valid  ps: push 1...n, pop 7 6 2 ...

#include<iostream>
#include<stack>
#include<stdlib.h>
using namespace std;

stack<int> s;
void Npush(int n,int *a)
{
    for(int i = 1;i < n+1;i++){
        if(*(a+i)){
            s.push(i);
            *(a+i) = 0;
        }
    }
    s.pop();
}

int main(void)
{
    int n;
    cin >> n;
    int a[n+1];
    int p[n+1];
    for(int i = 0;i < n+1;i++){
        a[i] = 1;
        cin >> p[i];
    } 
    s.push(1);
    a[1] = 0;
    for(int i = 1;i < n+1;i++){
        if(s.top() <= p[i]){
            Npush(p[i],a);
        }
        else{
            cout << "Invalid!";
            exit(0);
        }
    }
    cout <<"Valid";
    return 0;
}

