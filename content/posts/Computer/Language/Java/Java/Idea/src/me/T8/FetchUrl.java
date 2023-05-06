package me.T8;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author liukanglai
 * @date 5/15/21 - 3:06 PM
 */
public class FetchUrl {
    public static void main(String[] args) {
        URL url = null;
        FileWriter fi = null;
        InputStreamReader urli = null;
        BufferedReader urlr = null;
        try {
            url = new URL("https://www.cup.edu.cn/jwc/jxjs/Ttrends/e3da1a3f369d4b47a0e020edbeb6f87f.htm");
            fi = new FileWriter("url.txt");
            urli = new InputStreamReader(url.openStream());
            urlr = new BufferedReader(urli);
            String read;
            while ((read = urlr.readLine()) != null) {
                fi.write(read + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                urlr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            }
            try {
                urli.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}