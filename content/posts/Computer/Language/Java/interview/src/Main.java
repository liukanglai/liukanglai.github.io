import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(S[] args) {
        System.out.println("Hello world!");
        Stack<Integer> stack = new Stack<Integer>();

// 入栈
        stack.push(1);
        stack.push(2);
        stack.push(3);

// 出栈
        int top = stack.pop();
        System.out.println(top); // 输出 3

// 查看栈顶元素
        int peek = stack.peek();
        System.out.println(peek); // 输出 2
        Queue<String> queue = new LinkedList<String>();

// 入队
        queue.offer("apple");
        queue.offer("banana");
        queue.offer("orange");

// 出队
        String front = queue.poll();
        System.out.println(front); // 输出 apple

// 查看队首元素
        /*
        String peek = queue.peek();
        System.out.println(peek); // 输出 banana

         */
    }
}

/*
 * package com.google;
 *
 * import java.nio.charset.StandardCharsets;
 * import java.util.Locale;
 * import java.util.StringTokenizer;
 *
 * public class StringTurn {
 * public static void main(String[] args) {
 * String str = "Test";
 * String str1 = "Test1";
 * int str_length = str.length();
 * str.toLowerCase(Locale.ROOT);
 * str.toUpperCase(Locale.ROOT);
 * str.equals(str1);
 * str.compareTo(str);
 * str.equalsIgnoreCase(str);
 * int x = Integer.parseInt(str);
 * float y = Float.parseFloat(str);
 * String str2 = String.valueOf(x);
 * String str3 = String.valueOf(y);
 * byte[] z = str.getBytes(StandardCharsets.UTF_8);
 * //String(byte[], int offset, int length);
 * int g = str.charAt('e');
 * String str4 = str1.substring(2,4);
 * str4 = str.concat(str);
 * String s = "I, love, you";
 * StringTokenizer st = new StringTokenizer(s, ",");
 * while (st.hasMoreElements()){
 * String st1 = (String) st.nextToken();
 * System.out.println(str1);
 *
 * }
 *
 * }
 * }
 */
