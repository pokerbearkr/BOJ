package programmers;

import java.util.HashMap;

public class Pro138476 {
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        HashMap<Integer, Integer> tangerines = new HashMap<>();
        for (int tan : tangerine) {
            if (tangerines.containsKey(tan)) {
                tangerines.put(tan, tangerines.get(tan) + 1);
            } else {
                tangerines.put(tan,1);
            }
        }



    }
}
