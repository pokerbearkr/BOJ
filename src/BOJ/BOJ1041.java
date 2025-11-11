package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1041 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dice = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            System.out.println(findFiveMin(dice));
            return;
        }

        int oneMin = findMin(dice);
        int twoMin = findTwoMin(dice);
        int threeMin = findThreeMin(dice);

        long threeFaceCount = 4;
        long twoFaceCount = 4L * (N - 1) + 4L * (N - 2);
        long oneFaceCount = (N - 2L) * (N - 2L) + 4L * (N - 2L) * (N - 1);

        long result = threeFaceCount * threeMin
                + twoFaceCount * twoMin
                + oneFaceCount * oneMin;

        System.out.println(result);
    }

    private static int findMin(int[] dice) {
        int min = Integer.MAX_VALUE;
        for (int face : dice) {
            min = Math.min(min, face);
        }
        return min;
    }

    private static int findTwoMin(int[] dice) {
        int min = Integer.MAX_VALUE;
        int[][] twoFacePairs = {{0, 1}, {0, 2}, {0, 3}, {0, 4},
                {5, 1}, {5, 2}, {5, 3}, {5, 4},
                {1, 2}, {2, 4}, {3, 4}, {3, 1}};
        for (int[] pair : twoFacePairs) {
            min = Math.min(min, dice[pair[0]] + dice[pair[1]]);
        }
        return min;
    }

    private static int findThreeMin(int[] dice) {
        int min = Integer.MAX_VALUE;
        int[][] threeFaceCombos = {{0, 1, 2}, {0, 1, 3}, {0, 3, 4}, {0, 2, 4},
                {5, 1, 2}, {5, 1, 3}, {5, 3, 4}, {5, 2, 4}};
        for (int[] combo : threeFaceCombos) {
            min = Math.min(min, dice[combo[0]] + dice[combo[1]] + dice[combo[2]]);
        }
        return min;
    }

    private static int findFiveMin(int[] dice) {
        int max = 0;
        for (int face : dice) {
            max = Math.max(max, face);
        }
        return Arrays.stream(dice).sum()-max;
    }
}