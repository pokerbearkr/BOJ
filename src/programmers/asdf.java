package programmers;

import java.util.*;

public class asdf {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        int[] numbers = {2,1,3,4,1};
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j <numbers.length ; j++) {
                set.add(numbers[i]+numbers[j]);
            }
        }
        int[] ans = set.stream().mapToInt(i->i).toArray();
        Arrays.sort(ans);


    }
}
