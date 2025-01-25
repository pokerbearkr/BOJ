package BOJ;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15666 {
    private static int n, m;
    private static List<Integer> numbers;
    private static StringBuilder sb = new StringBuilder();
    private static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        numbers = new ArrayList<>(set);
        Collections.sort(numbers);

        result = new int[m];
        dfs(0, 0);
        System.out.println(sb);
    }

    private static void dfs(int start, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < numbers.size(); i++) {
            result[depth] = numbers.get(i);
            dfs(i, depth + 1);
        }
    }
}