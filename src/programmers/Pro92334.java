package programmers;

import java.util.*;

public class Pro92334 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        int[] result = solution(id_list, report, k);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> reportCount = new HashMap<>();
        Map<String, Integer> mailCount = new HashMap<>();

        for (String id : id_list) {
            reportMap.put(id, new HashSet<>());
            reportCount.put(id, 0);
            mailCount.put(id, 0);
        }

        for (String rep : report) {
            String[] parts = rep.split(" ");
            String reporter = parts[0];
            String reported = parts[1];

            if (!reportMap.get(reporter).contains(reported)) {
                reportMap.get(reporter).add(reported);
                reportCount.put(reported, reportCount.get(reported) + 1);
            }
        }

        Set<String> bannedUsers = new HashSet<>();
        for (String id : id_list) {
            if (reportCount.get(id) >= k) {
                bannedUsers.add(id);
            }
        }

        for (String reporter : id_list) {
            for (String reportedUser : reportMap.get(reporter)) {
                if (bannedUsers.contains(reportedUser)) {
                    mailCount.put(reporter, mailCount.get(reporter) + 1);
                }
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mailCount.get(id_list[i]);
        }

        return answer;
    }
}
