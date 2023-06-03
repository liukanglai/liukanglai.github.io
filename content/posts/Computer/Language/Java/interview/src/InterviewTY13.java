import java.util.*;
// 5213 41345
// 6213 245

public class InterviewTY13 {
    static HashMap<Integer, Integer> hashMap;
    static LinkedList<Integer> linkedList = new LinkedList<Integer>();
    static LinkedList<Integer> linkedList1 = new LinkedList<Integer>();

    public static int needMin(int n, int[] a) {
        int min = 0;
        for (int i = 0; i < n; i++) {
            min += a[i];
        }
        return min;
    }

    public static void color(int w, int n, int[] a) {
        int type = n;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                type--;
            }
        }
        if (type == 0) {
            for (int i = w; i > 0; i--) {
                if (hashMap.containsKey(i)) {

                } else {
                    hashMap.put(i, -1);
                }
            }
            return;
        }
        int min = needMin(n, a)+type-1;
        int[] b = Arrays.copyOf(a, n); // copy !!!
        if (w - 1 >= min) {
            // 不涂
            if (hashMap.containsKey(w)) {
                if (hashMap.get(w) != -1) {
                    hashMap.put(w, -2);
                }
            } else {
                hashMap.put(w, -1);
            }
            color(w - 1, n, b);
        }
        //涂
        for (int i = n - type; a[i] > 0; a[i]--, w--) {
            if (hashMap.containsKey(w)) {
                if (hashMap.get(w) != i) {
                    hashMap.put(w, -2);
                }
            } else {
                hashMap.put(w, i);
            }
        }
        if (hashMap.containsKey(w)) {
            if (hashMap.get(w) != -1) {
                hashMap.put(w, -2);
            }
        } else {
            hashMap.put(w, -1);
        }
        color(w - 1, n, a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        hashMap = new HashMap<Integer, Integer>(n);
        /*
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }

         */
        color(w, n, a);

        int count = 0;
        Iterator<Map.Entry<Integer, Integer>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            //System.out.println(entry.getKey() + " = " + entry.getValue());
            if (entry.getValue() != -2 && entry.getValue() != -1) {
                count++;
                linkedList.add(entry.getKey());
            }
        }
        System.out.println(count);
        for (int i = 0; i < linkedList.size(); i++) {
            //System.out.print(w+1-linkedList.get(i));
            linkedList1.add(w+1-linkedList.get(i));
        }
        // 对LinkedList进行排序
        Collections.sort(linkedList1);

        // 输出排序后的LinkedList
        for (Integer number : linkedList1) {
            System.out.print(number);
            System.out.print(" ");
        }
    }
}