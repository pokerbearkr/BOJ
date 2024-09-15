package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String[] input = bf.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // 과일 종류와 그 수를 카운트하기 위한 맵
        Map<Integer, Integer> countMap = new HashMap<>();

        // 과일 종류 세기
        for (int fruit : arr) {
            countMap.put(fruit, countMap.getOrDefault(fruit, 0) + 1);
        }

        // 과일 종류가 하나만 있는 경우
        if (countMap.size() == 1) {
            System.out.println(N);
            return;
        }

        // 최대 길이 찾기
        int maxFruit = 0;
        int left = 0;
        countMap.clear();

        for (int right = 0; right < N; right++) {
            countMap.put(arr[right], countMap.getOrDefault(arr[right], 0) + 1);

            // 두 가지 과일 종류로 제한
            while (countMap.size() > 2) {
                countMap.put(arr[left], countMap.get(arr[left]) - 1);
                if (countMap.get(arr[left]) == 0) {
                    countMap.remove(arr[left]);
                }
                left++;
            }

            if (countMap.size() == 2) {
                maxFruit = Math.max(maxFruit, right - left + 1);
            }
        }

        System.out.println(maxFruit);
    }
}