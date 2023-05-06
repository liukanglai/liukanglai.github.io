package me.T3;

import java.util.Arrays;
import java.util.Scanner;
class Student {
    String name;
    int ID, age;
    public void getInfo(int ID, String name, int age) {
        this.name = name;
        this.ID = ID;
        this.age = age;
    }
    int flag = 0; // judge for sort
}
public class RecordStu {

    public static void main(String[] args) {
        int sum;
        Scanner sc = new Scanner(System.in);
        sum = sc.nextInt();
        Student[] students = new Student[sum];
        for(int i = 0; i < sum; i++) {
            students[i] = new Student();
            int ID = sc.nextInt();
            String name = sc.next();
            int age = sc.nextInt();
            students[i].getInfo(ID, name, age);
        }
        //SortByName(students, sum);
        //SortByAge(students, sum);
        System.out.println(students[0].name);
        sc.close();

    }
    public static void SortByName(Student[] students, int sum) {
        String MinName = students[0].name;
        int NumMin = 0;
        for(int j = 0; j < sum; j++) {
            for (int i = 1; i < sum; i++) {
                if (students[i].flag == 0 && students[i].name.compareTo(MinName) < 0) {
                    MinName = students[i].name;
                    NumMin = i;
                }
            }
            System.out.printf("%3d ",students[NumMin].ID);
            System.out.printf("%6d ", MinName);
            System.out.printf("%3d\n", students[NumMin].age);
            students[NumMin].flag = 1;
        }
        for (int i = 0; i < sum; i++) {
            students[i].flag = 0;
        }
    }
    public static void SortByAge(Student[] students, int sum) {
        int[] TemAge = new int[sum];
        for (int i = 0; i < sum; i++) {
            TemAge[i] = students[i].age;
        }
        Arrays.sort(TemAge);
        for (int i = 0; i < sum; i++) {
            for (int j = 0; j < sum; j++) {
                if(TemAge[i] == students[j].age) {
                    Student[] SameAge = new Student[sum];
                    int NumSameAge = 1;
                    SameAge[0] = students[j];
                    for (int k = j+1; k < sum; k++) {
                        if (TemAge[i] == students[k].age) {
                            SameAge[NumSameAge++] = students[k];
                        }
                    }
                    SortByName(SameAge, NumSameAge);
                    break;
                }
            }
        }
    }
}