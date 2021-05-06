#include<iostream>
using namespace std;

class Tree {
private:
    string Name;
    string Color;
    double Price;

public:

    Tree(string name, string color, double price) {
        Name = name;
        Color = color;
        Price = price;
    }

    void getInfo() {
        cout << "Name: " << Name << endl;
        cout << "Color: " << Color << endl;
        cout << "Price: " << Price << endl;
    }
};


class Car {
public:
    string Name;
    string Color;
    double Price;

    Car(string name, string color, double price) {
        Name = name;
        Color = color;
        Price = price;
    }

    void getInfo() {
        cout << "Name: " << Name << endl;
        cout << "Color: " << Color << endl;
        cout << "Price: " << Price << endl;
    }
};

int main(void)
{
    Car myCar("Ford", "red", 50000.0);
    /*
    myCar.Name = "Ford";
    myCar.Color = "red";
    myCar.Price = 50000.0;
    */

    bool flag = false;
    string username = "liukanglai";
    if(flag == false)
        cout << "Hello" << endl;

    system("pause > 0");
}
