package programmers;

import java.util.Arrays;

public class Pro87390 {
    public static void main(String[] args) {
        int n = 4;
        long left = 7;
        long right = 14;

        int[][] arr = new int[n][n];
        int[] ans = new int[n*n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Math.min(i+1,j+1);
                ans[count++] = arr[i][j];
            }
        }
        int[] answer = new int[(int) (right-left)];
        count=0;
        for (int i =(int)left; i <(int)right ; i++) {
            answer[count++] = ans[i];
        }



    }
}
