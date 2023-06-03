package com.google;

/**
 * @author liukanglai
 * @date 4/4/21 - 9:48 AM
 */
public class Overload {

    public static void main(String[] args) {
        int id = 1;
        Student student0 = new Student();
        student0.putThings(id);
        Person person0 = new Person();

    }
}
class Person {
    int id, age;
    private int m = 0;

    /*
    protected final void putThings(int id) {
        System.out.println(id);
    }

     */
    public void putThings(int id) {
        System.out.println();
    }
}
class  Student extends Person {
    /*
    private void putThings(int id, int age) {
        System.out.println();
        System.out.println(age);
    }

     */
    /*
    protected  void putThings(int id) {
        System.out.println();
    }
    */
}
