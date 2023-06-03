package me.T3;

import java.util.Arrays;
import java.util.Scanner;

public class RecordStu1 {
    public static class Student {
        String name;
        int id, age;
        Student(Scanner sc) {
            id = sc.nextInt();
            name = sc.next();
            age = sc.nextInt();
        }
        int flag = 0; // judge for sort
    }
    public static void main(String[] args) {
        int sum;
        Scanner sc = new Scanner(System.in);
        sum = sc.nextInt();
        Student[] students = new Student[sum];
        for (int i = 0; i < sum; i++) {
            students[i] = new Student(sc);
        }

        SortByName(students, sum);
        System.out.println();
        for (int i = 0; i < sum; i++) {
            students[i].flag = 0;
        }
        SortByAge(students, sum);
        sc.close();
    }
    public static void SortByName(Student[] students, int sum) {
        String MinName = students[0].name;
        int NumMin = 0;
        for(int j = 0; j < sum; j++) {
            for (int i = 0; i < sum; i++) {
                if (students[i].flag == 0) {
                    MinName = students[i].name;
                    NumMin = i;
                    break;
                }
            }
            for (int i = 0; i < sum; i++) {
                if (students[i].flag == 0 && students[i].name.compareTo(MinName) < 0) {
                    MinName = students[i].name;
                    NumMin = i;
                }
            }
            System.out.printf("%3d",students[NumMin].id);
            System.out.printf("%6s", MinName);
            System.out.printf("%3d\n", students[NumMin].age);
            students[NumMin].flag = 1;
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
                if(students[j].flag == 0 && TemAge[i] == students[j].age) {
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