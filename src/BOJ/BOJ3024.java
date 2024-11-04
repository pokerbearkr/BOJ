package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3024 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        char[][] board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        boolean found = false;
        char ans = '-';

        // 가로 체크 (연속된 3개의 문자 확인)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - 3; j++) {  // 3개의 연속된 칸을 확인하기 때문에 N-3까지
                if (board[i][j] == board[i][j + 1] && board[i][j + 1] == board[i][j + 2] && board[i][j] != '.') {
                    found = true;
                    ans = board[i][j];
                    break;
                }
            }
            if (found) break;
        }

        // 세로 체크 (연속된 3개의 문자 확인)
        if (!found) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N - 3; j++) {
                    if (board[j][i] == board[j + 1][i] && board[j + 1][i] == board[j + 2][i] && board[j][i] != '.') {
                        found = true;
                        ans = board[j][i];
                        break;
                    }
                }
                if (found) break;
            }
        }

        // 좌상에서 우하로 내려가는 대각선 체크 (연속된 3개의 문자 확인)
        if (!found) {
            for (int i = 0; i <= N - 3; i++) {
                for (int j = 0; j <= N - 3; j++) {
                    if (board[i][j] == board[i + 1][j + 1] && board[i + 1][j + 1] == board[i + 2][j + 2] && board[i][j] != '.') {
                        found = true;
                        ans = board[i][j];
                        break;
                    }
                }
                if (found) break;
            }
        }

        // 우상에서 좌하로 내려가는 대각선 체크 (연속된 3개의 문자 확인)
        if (!found) {
            for (int i = 0; i <= N - 3; i++) {
                for (int j = 2; j < N; j++) {
                    if (board[i][j] == board[i + 1][j - 1] && board[i + 1][j - 1] == board[i + 2][j - 2] && board[i][j] != '.') {
                        found = true;
                        ans = board[i][j];
                        break;
                    }
                }
                if (found) break;
            }
        }

        // 결과 출력
        if (found && ans != '.') {
            System.out.println(ans);
        } else {
            System.out.println("ongoing");
        }
    }
}