package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9290 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            problem(i);
        }
    }

    private static void problem(int testCaseNumber) throws Exception {
        char[][] map = new char[3][3];
        for (int i = 0; i < 3; i++) {
            String st = br.readLine();
            for (int j = 0; j < 3; j++) {
                map[i][j] = st.charAt(j);
            }
        }
        char namgue = br.readLine().charAt(0);

        int winX = -1, winY = -1;

        for (int i = 0; i < 3; i++) {
            int namgueCount = 0;
            int emptyCount = 0;
            int emptyX = -1, emptyY = -1;
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == namgue) {
                    namgueCount++;
                } else if (map[i][j] == '-') {
                    emptyCount++;
                    emptyX = i;
                    emptyY = j;
                }
            }
            if (namgueCount == 2 && emptyCount == 1) {
                winX = emptyX;
                winY = emptyY;
                break;
            }
        }

        if (winX == -1) {
            for (int j = 0; j < 3; j++) {
                int namgueCount = 0;
                int emptyCount = 0;
                int emptyX = -1, emptyY = -1;
                for (int i = 0; i < 3; i++) {
                    if (map[i][j] == namgue) {
                        namgueCount++;
                    } else if (map[i][j] == '-') {
                        emptyCount++;
                        emptyX = i;
                        emptyY = j;
                    }
                }
                if (namgueCount == 2 && emptyCount == 1) {
                    winX = emptyX;
                    winY = emptyY;
                    break;
                }
            }
        }

        if (winX == -1) {
            int namgueCount = 0;
            int emptyCount = 0;
            int emptyX = -1, emptyY = -1;
            for (int i = 0; i < 3; i++) {
                if (map[i][i] == namgue) {
                    namgueCount++;
                } else if (map[i][i] == '-') {
                    emptyCount++;
                    emptyX = i;
                    emptyY = i;
                }
            }
            if (namgueCount == 2 && emptyCount == 1) {
                winX = emptyX;
                winY = emptyY;
            }
        }

        if (winX == -1) {
            int namgueCount = 0;
            int emptyCount = 0;
            int emptyX = -1, emptyY = -1;
            for (int i = 0; i < 3; i++) {
                if (map[i][2 - i] == namgue) {
                    namgueCount++;
                } else if (map[i][2 - i] == '-') {
                    emptyCount++;
                    emptyX = i;
                    emptyY = 2 - i;
                }
            }
            if (namgueCount == 2 && emptyCount == 1) {
                winX = emptyX;
                winY = emptyY;
            }
        }

        if (winX != -1) {
            map[winX][winY] = namgue;
        }

        System.out.println("Case " + testCaseNumber + ":");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}