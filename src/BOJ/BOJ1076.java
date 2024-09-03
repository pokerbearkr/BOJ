package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class BOJ1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String one = bf.readLine();
        String two = bf.readLine();
        String three = bf.readLine();
        String arr[] = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        int num[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        long num1[] = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        long ans = (num[Arrays.asList(arr).indexOf(one)] * 10 + num[Arrays.asList(arr).indexOf(two)]) * num1[Arrays.asList(arr).indexOf(three)];
        System.out.println(ans);
    }
}
