package programmers;

public class Pro172928 {
    private static int nowX = 0, nowY = 0;

    public static void main(String[] args) {
        String[] park = {"SOO", "OOO", "OOO"};
        String[] routes = {"E 2", "S 2", "W 1"};

        int[][] map = new int[park.length][park[0].length()];

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'O') {
                    map[i][j] = 1;
                } else if (park[i].charAt(j) == 'S') {
                    map[i][j] = 1;
                    nowX = i;
                    nowY = j;
                } else if (park[i].charAt(j) == 'X') {
                    map[i][j] = 0;
                }
            }
        }

        for (String route : routes) {
            move(map, route);
        }

        System.out.println(nowX + " " + nowY);
    }

    private static void move(int[][] map, String route) {
        String[] parts = route.split(" ");
        char direction = parts[0].charAt(0);
        int distance = Integer.parseInt(parts[1]);

        int newX = nowX, newY = nowY;

        for (int i = 0; i < distance; i++) {
            int nextX = newX, nextY = newY;

            if (direction == 'E') nextY++;
            if (direction == 'W') nextY--;
            if (direction == 'S') nextX++;
            if (direction == 'N') nextX--;

            if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[0].length || map[nextX][nextY] == 0) {
                return;
            }

            newX = nextX;
            newY = nextY;
        }

        nowX = newX;
        nowY = newY;
    }
}
