package me.T4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liukanglai
 * @date 4/7/21 - 3:51 PM
 */
public class PayAble1 {
    public static void main(String[] args) {
        MobilePhone myPhone = new MobilePhone();
        Scanner sc = new Scanner(System.in);
        myPhone.call_duration = sc.nextDouble();
        myPhone.unit_price = sc.nextDouble();
        myPhone.fee = myPhone.pay();
        System.out.print("Fee=");
        System.out.println(myPhone.fee);
    }
}

class Phone {
    int code;
    double call_duration, unit_price, phone_bill;
    double fee;
    public double pay() {
        return call_duration * unit_price;
    }
}

class MobilePhone extends Phone implements PayAble {
    double call_duration, unit_price, phone_bill;
    double fee;

    public double pay() {
        return call_duration * unit_price;
    }

}