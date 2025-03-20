package programmers;

import java.util.HashSet;

public class Pro131701 {
    public static void main(String[] args) {
        int[] elements = new int[]{7, 9, 1, 1, 4};
        int n = elements.length;
        int[] elements1 = new int[n * 2];

        for (int i = 0; i < n; i++) {
            elements1[i] = elements[i];
            elements1[i + n] = elements[i];
        }

        HashSet<Integer> set = new HashSet<>();

        for (int length = 1; length <= n; length++) {
            for (int start = 0; start < n; start++) {
                int sum = 0;
                for (int k = 0; k < length; k++) {
                    sum += elements1[start + k];
                }
                set.add(sum);
            }
        }

        System.out.println(set.size());
    }
}
