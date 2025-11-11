package BOJ;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ17114 {
    public static void main(String[] args) throws Exception {
        int M = read();
        int N = read();
        int O = read();
        int P = read();
        int Q = read();
        int R = read();
        int S = read();
        int T = read();
        int U = read();
        int V = read();
        int W = read();

        int[][] move = new int[][]{
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1}
        };

        int raw = 0;
        int[][][][][][][][][][][] tomato = new int[M][N][O][P][Q][R][S][T][U][V][W];
        boolean[][][][][][][][][][][] visited = new boolean[M][N][O][P][Q][R][S][T][U][V][W];

        Queue<int[]> queue = new ArrayDeque<>();

        int tem;
        for (int w = 0; w < W; w++) {
            for (int v = 0; v < V; v++) {
                for (int u = 0; u < U; u++) {
                    for (int t = 0; t < T; t++) {
                        for (int s = 0; s < S; s++) {
                            for (int r = 0; r < R; r++) {
                                for (int q = 0; q < Q; q++) {
                                    for (int p = 0; p < P; p++) {
                                        for (int o = 0; o < O; o++) {
                                            for (int n = 0; n < N; n++) {
                                                for (int m = 0; m < M; m++) {
                                                    tem = read();
                                                    tomato[m][n][o][p][q][r][s][t][u][v][w] = tem;
                                                    if (tem == 1) {
                                                        queue.add(new int[]{m, n, o, p, q, r, s, t, u, v, w, 0});
                                                        visited[m][n][o][p][q][r][s][t][u][v][w] = true;
                                                    } else if (tem == 0) {
                                                        raw++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        int maxCount = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowM = now[0];
            int nowN = now[1];
            int nowO = now[2];
            int nowP = now[3];
            int nowQ = now[4];
            int nowR = now[5];
            int nowS = now[6];
            int nowT = now[7];
            int nowU = now[8];
            int nowV = now[9];
            int nowW = now[10];
            int nowCount = now[11];

            for (int i = 0; i < 22; i++) {
                int nextM = nowM + move[i][0];
                int nextN = nowN + move[i][1];
                int nextO = nowO + move[i][2];
                int nextP = nowP + move[i][3];
                int nextQ = nowQ + move[i][4];
                int nextR = nowR + move[i][5];
                int nextS = nowS + move[i][6];
                int nextT = nowT + move[i][7];
                int nextU = nowU + move[i][8];
                int nextV = nowV + move[i][9];
                int nextW = nowW + move[i][10];

                // 경계값 체크 및 방문 여부 확인
                if (nextN >= 0 && nextN < N &&
                        nextM >= 0 && nextM < M &&
                        nextO >= 0 && nextO < O &&
                        nextP >= 0 && nextP < P &&
                        nextQ >= 0 && nextQ < Q &&
                        nextR >= 0 && nextR < R &&
                        nextS >= 0 && nextS < S &&
                        nextT >= 0 && nextT < T &&
                        nextU >= 0 && nextU < U &&
                        nextV >= 0 && nextV < V &&
                        nextW >= 0 && nextW < W &&
                        !visited[nextM][nextN][nextO][nextP][nextQ][nextR][nextS][nextT][nextU][nextV][nextW] &&
                        tomato[nextM][nextN][nextO][nextP][nextQ][nextR][nextS][nextT][nextU][nextV][nextW] == 0) {

                    // 방문 처리 및 상태 변경
                    visited[nextM][nextN][nextO][nextP][nextQ][nextR][nextS][nextT][nextU][nextV][nextW] = true;
                    tomato[nextM][nextN][nextO][nextP][nextQ][nextR][nextS][nextT][nextU][nextV][nextW] = 1;
                    raw--;

                    // 큐에 추가
                    queue.add(new int[]{nextM, nextN, nextO, nextP, nextQ, nextR, nextS, nextT, nextU, nextV, nextW, nowCount + 1});
                }
            }

            maxCount = nowCount;
        }

        if (raw == 0) {
            System.out.println(maxCount);
        } else {
            System.out.println(-1);
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}