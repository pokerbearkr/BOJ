package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ1251 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();


        List<String> arr = new ArrayList<>();
        int count=0;

        for (int i = 1; i <s.length()-1; i++) {
            String start = s.substring(0, i);
            for (int j = i+1; j <s.length() ; j++) {
                String mid = s.substring(i, j);
                String end = s.substring(j);
                arr.add(reverse(start)+reverse(mid)+reverse(end));
                count++;
            }
        }
        Collections.sort(arr);
        System.out.println(arr.get(0));

    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
