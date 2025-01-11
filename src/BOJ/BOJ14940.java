package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int startX=0;
        int startY=0;
        int[] moveX = new int[]{1, 0, -1, 0};
        int[] moveY = new int[]{0, 1, 0, -1};


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tem = Integer.parseInt(st.nextToken());
                if (tem == 2) {
                    startX = i;
                    startY = j;
                } else if (tem == 0) {
                    visited[i][j] = true;
                }
                map[i][j] = tem;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX,startY,0});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowCount = now[2];
            if(nowX<0 || nowX>=n || nowY<0 || nowY>=m) continue;
            if(map[nowX][nowY] == 0) continue;
            if(visited[nowX][nowY]) continue;
            visited[nowX][nowY] = true;

            map[nowX][nowY] = nowCount;
            for (int i = 0; i < 4; i++) {
                queue.add(new int[]{nowX + moveX[i], nowY + moveY[i], nowCount+1});
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    if (!visited[i][j]) {
                        map[i][j] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
