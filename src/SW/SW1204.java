package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
//최빈수 구하기
public class SW1204 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            int[] arr = new int[1000];
            int cnum = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 1000; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            System.out.print("#"+cnum+" ");
            System.out.println(findMode(arr));
        }
    }
    public static int findMode(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        int mode = nums[0];
        int maxCount = 0;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int currentNum = entry.getKey();
            int currentCount = entry.getValue();

            if (currentCount > maxCount || (currentCount == maxCount && currentNum > mode)) {
                mode = currentNum;
                maxCount = currentCount;
            }
        }

        return mode;
    }
}
