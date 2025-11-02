package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ2754 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        Map<String, Double> dictionary = new HashMap<>();
        dictionary.put("A+", 4.3);
        dictionary.put("A0", 4.0);
        dictionary.put("A-", 3.7);
        dictionary.put("B+", 3.3);
        dictionary.put("B0", 3.0);
        dictionary.put("B-", 2.7);
        dictionary.put("C+", 2.3);
        dictionary.put("C0", 2.0);
        dictionary.put("C-", 1.7);
        dictionary.put("D+", 1.3);
        dictionary.put("D0", 1.0);
        dictionary.put("D-", 0.7);
        dictionary.put("F", 0.0);

        System.out.println(dictionary.get(target));
        }
    }
