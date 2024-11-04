package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 회문1
public class SW1215 {
    static BufferedReader bf;

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 10; i++) {
            System.out.print("#" + i + " ");
            System.out.println(test());
        }
    }

    public static int test() throws IOException {
        int length = Integer.parseInt(bf.readLine());
        int ans = 0;
        char[][] arr = new char[8][8];

        for (int i = 0; i < 8; i++) {
            String tem = bf.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = tem.charAt(j);
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <= 8 - length; j++) {
                if (isPalindrome(arr, i, j, length, true)) {
                    ans++;
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <= 8 - length; j++) {
                if (isPalindrome(arr, j, i, length, false)) {
                    ans++;
                }
            }
        }

        return ans;
    }
    public static boolean isPalindrome(char[][] arr, int x, int y, int length, boolean isRow) {
        for (int k = 0; k < length / 2; k++) {
            if (isRow) {
                if (arr[x][y + k] != arr[x][y + length - 1 - k]) {
                    return false;
                }
            } else {
                if (arr[x + k][y] != arr[x + length - 1 - k][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}