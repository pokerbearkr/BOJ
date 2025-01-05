import java.util.ArrayList;
import java.util.List;

public class Test {
    public static int findSecondBPosition(int N, int K) {
        List<int[]> positions = new ArrayList<>();

        // B가 들어갈 두 위치를 조합으로 생성하여 리스트에 추가
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                positions.add(new int[]{i, j});
            }
        }

        // K번째 조합에서 두 번째 B의 위치를 찾습니다
        int[] selectedPosition = positions.get(K - 1);

        // 두 번째 B의 위치 (1부터 시작하도록 반환)
        return selectedPosition[1] + 1;
    }

    public static void main(String[] args) {
        int N = 5; // 예시 입력: 문자열 길이
        int K = 1; // 예시 입력: K번째 문자열
        System.out.println("두 번째 B의 위치: " + findSecondBPosition(N, K));
    }
}