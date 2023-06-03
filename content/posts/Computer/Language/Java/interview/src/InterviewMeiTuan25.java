import java.util.Scanner;

public class InterviewMeiTuan25 {
    class Node{
        int value = 0;
        int color = 0;
        int left = -1;
        int right =  -1;
        void setColor(int color){
            this.color = color;
        }
        void setLeft(int left){
            this.left = left;
        }
        void setRight(int right){
            this.right = right;
        }
    }
    int value(Node node){
        if(node.left == -1){
            if(node.color == 1){

            }else if(node.color == 2){

            }
        }
        if(node.left != -1){

        }
        return 1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] father = new int[n-1];
        Node[] node = new Node[n];
        for (int i = 0; i < n-1; i++) {
            father[i] = scanner.nextInt();
            if(node[father[i]-1].left == -1){
                node[father[i]-1].left = i+1;
            }else {
                node[father[i]-1].right = i+1;
            }
        }
        int[] color = new int[n];
        for (int i = 0; i < n-1; i++) {
            color[i] = scanner.nextInt();
            node[i].setColor(color[i]);
        }
        for (int i = 0; i < n; i++) {
            if(node[i].left != -1){

            }
        }
    }
}
