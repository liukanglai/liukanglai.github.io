package CrackingtheCodingInterview;

public class Book0107 {
    public static void rotate(int[][] matrix) {
        int[][] copyMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                copyMatrix[i][j] = matrix[matrix.length - 1 - j][i];
            }
        }
        //matrix = copyMatrix.clone();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = copyMatrix[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
    }
}
