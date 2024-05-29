package me.T4;

/**
 * @author liukanglai
 * @date 4/8/21 - 5:54 PM
 */


class PayStart {
    public static void main(String[] args) {
        Bus a_bus = new Bus();
        Taxi a_taxi = new Taxi();
        a_bus.收取费用();
        a_taxi.收取费用();
        a_taxi.AdjustTemp();
    }
}

interface 收费 {
    void 收取费用();
}

interface 调节温度 {
    void AdjustTemp();
}

class Bus implements 收费 {
    public void 收取费用() {
        System.out.println("公交车收取费用，？？？");
    }
}

class Taxi implements 收费 , 调节温度 {
    public void 收取费用() {
        System.out.println("出租车收取费用，？？？");
    }
    public void AdjustTemp() {
        System.out.println("出租车调节温度，？？？");
    }
}