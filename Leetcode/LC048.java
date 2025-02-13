package Leetcode;

public class LC048 {
	public void rotate(int[][] matrix) {
        int length = matrix.length;
        for(int i=0; i<length; i++){
            for(int j=i; j<length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int k=0; k<length; k++){
            int x = 0;
            int y = length-1;
            while(x < y){
                int temp = matrix[k][x];
                matrix[k][x] = matrix[k][y];
                matrix[k][y] = temp;
                x++;
                y--;
            }
        }
    }
}
