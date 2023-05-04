package me.T8;

import java.io.*;

/**
 * @author liukanglai
 * @date 5/15/21 - 11:25 AM
 */
public class Io {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        FileInputStream fi = null;
        try {
            fw = new FileWriter("/home/liukanglai/2.txt", true);
            fi = new FileInputStream("/home/liukanglai/2.txt");
            byte[] buffer = new byte[10];
            fi.read(buffer);
            fw.write("h");
            fr = new FileReader("/home/liukanglai/2.txt");
            int read = fr.read();
            //char[] read1 = new char[5];
            //fr.read(read1);
            while(read != -1) {
                System.out.println((char) read);
                read = fr.read(); // Read end will return -1, other return length.
            }

            BufferedInputStream bfi = new BufferedInputStream(fi); // 处理流，关闭时，自动关节点流
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                if(fr != null) {
                    fr.close();
                }
                if(fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
