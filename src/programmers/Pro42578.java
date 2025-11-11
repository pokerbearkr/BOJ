package programmers;

import java.util.HashMap;
import java.util.Map;

public class Pro42578 {
    public static void main(String[] args) {

        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        Map<String, Integer> counter = new HashMap<>();

        for (String[] clothe : clothes) {
            counter.put(clothe[1], counter.getOrDefault(clothe[1], 0) + 1);
        }

        int answer = 1;
        for (int count : counter.values()) {
            answer *= (count + 1);
        }


        System.out.println(answer-1);


    }
}
