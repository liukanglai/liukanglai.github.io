import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
public class Test20221 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map1 = new HashMap<>(); // 记录每一段的map
        for (int i = 0; i < str.length(); i++) {
            String tem = str.substring(i, i+1);
            if(map.containsKey(tem)){
                map.put(tem,map.get(tem)+1);
            }
            else{
                map.put(tem, 1);
            }
        }
        int flag = 0, length = 0;
        for (int i = 0; i < str.length(); i++) {
            String tem = str.substring(i, i+1);
            map.put(tem, map.get(tem)-1);
            map1.put(tem, map.get(tem));
            length++;
            if(map.get(tem) == 0){
                flag = 0;
                Iterator<Map.Entry<String, Integer>> it = map1.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, Integer> entry = it.next();
                    //System.out.println(entry.getKey() + " = " + entry.getValue());
                    if(entry.getValue() != 0){
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0){
                    System.out.print(length+" ");
                    map1.clear();
                    length = 0;
                }
            }
        }
    }
}
