package CrackingtheCodingInterview;

public class Book0108 {
    public static void setZeroes(int[][] matrix) {
        int col = -1, row = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    if(row == -1){
                        row = i; col = j;
                        // break; 问题
                    }
                    else {
                        matrix[row][j] = 0;
                        matrix[i][col] = 0;
                    }
                }
            }
        }
        if(row == -1){
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][col] == 0 && i != row){
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if(matrix[row][i] == 0 && i != col){
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix  = {{1,1,0},{1,0,1},{1,1,1}};
        setZeroes(matrix);
    }
}
