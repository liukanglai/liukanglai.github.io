public class S {
        public static void main(String[] args)  {
            String a = "java2";
            final String b = "java";
            String d = "java";
            String c = b + 2;
            String e = d + 2;
            System.out.println((a == c));
            System.out.println((a == e));
                Long tail = 2000L;
                Long distance = 1999L;
                Long story = 1000L;
                if ((tail > distance) ^ ((story * 2) == tail))
                    System.out.print("1");
                if ((distance + 1 != tail) ^ ((story * 2) == distance))
                    System.out.print("2");
        }
}
