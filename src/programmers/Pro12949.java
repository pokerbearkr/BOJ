package programmers;

public class Pro12949 {
    public static void main(String[] args) {
        int[][] arr1 = {{1,4},{3,2},{4,1}};
        int[][] arr2 = {{3,3},{3,3}};

        int row1 = arr1.length;
        int col1 = arr1[0].length;
        int col2 = arr2[0].length;

        int[][] answer = new int[row1][col2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        System.out.println(answer);
    }
}
