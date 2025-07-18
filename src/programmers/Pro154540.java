package programmers;

import java.util.*;

public class Pro154540 {
    private static int X;
    private static int Y;

    private static final int[] nextX = {1, 0, -1, 0};
    private static final int[] nextY = {0, 1, 0, -1};
    private static char[][] newMap;
    private static boolean[][] isVisited;
    private static final List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})));
    }

    public static int[] solution(String[] map) {

        newMap = new char[map.length][map[0].length()];
        X = map.length;
        Y = map[0].length();
        isVisited = new boolean[X][Y];

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                char target = map[i].charAt(j);
                if(target == 'X') {
                    isVisited[i][j] = true;
                }
                newMap[i][j] = target;
            }
        }

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if(!isVisited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(i -> i).toArray();

    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        isVisited[i][j] = true;
        int sum=0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            sum+=Integer.parseInt(String.valueOf(newMap[x][y]));

            for (int k = 0; k < 4; k++) {
                int nX = cur[0] + nextX[k];
                int nY = cur[1] + nextY[k];
                if(nX>=0&&nX<X&&nY>=0&&nY<Y&&!isVisited[nX][nY]) {
                    queue.add(new int[]{nX, nY});
                    isVisited[nX][nY] = true;
                }
            }

        }
        answer.add(sum);
    }
}
