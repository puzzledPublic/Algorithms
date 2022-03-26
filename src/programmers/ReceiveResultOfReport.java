package programmers;

import java.io.IOException;
import java.util.*;

//신고 결과 받기
public class ReceiveResultOfReport {
    public static void main(String[] args) {
        String[][] id_lists = {
                {"muzi", "frodo", "apeach", "neo"},
                {"con", "ryan"},
        };
        String[][] reports = {
                {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
                {"ryan con", "ryan con", "ryan con", "ryan con"},
        };

        int[] ks = {2, 3};

        for(int i = 0; i < id_lists.length; i++) {
            Arrays.stream(solution(id_lists[i], reports[i], ks[i])).forEach((r) -> System.out.print(r + " "));
            System.out.println();
        }
    }

    static int[] solution2(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Set<String>> map = new HashMap<>(); //Map<신고당한 id, 신고한 id들>
        Map<String, int[]> result = new HashMap<>();    //Map<id, [id index, 알림횟수]>

        for(int i = 0; i < id_list.length; i++) {
            result.put(id_list[i], new int[]{i, 0});
        }

        for(String rep : report) {
            String[] splitted = rep.split(" ");
            String reportId = splitted[0];
            String reportedId = splitted[1];
            if(!map.containsKey(reportedId)) {
                map.put(reportedId, new HashSet<>());
            }
            map.get(reportedId).add(reportId);
        }

        for(String reportedId: map.keySet()) {
            if(map.get(reportedId).size() >= k) {
                for(String id : map.get(reportedId)) {
                    result.get(id)[1]++;
                }
            }
        }

        for(String id : result.keySet()) {
            answer[result.get(id)[0]] = result.get(id)[1];
        }

        return answer;
    }

    static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Set<String>> map = new HashMap<>(); //Map<신고한 id, 신고당한 id들>
        Map<String, Integer> reportCounter = new HashMap<>();   //Map<신고당한 id, 신고당한 횟수>
        Map<String, int[]> result = new HashMap<>();    //Map<id, [id index, 알림 횟수]

        for(int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], new HashSet<>());
            result.put(id_list[i], new int[]{i, 0});
        }

        for(String rep : report) {
            String[] splitted = rep.split(" ");
            String reportId = splitted[0];
            String reportedId = splitted[1];
            map.get(reportId).add(reportedId);
        }

        for(String id : map.keySet()) {
            for(String reportedId: map.get(id)) {
                if (reportCounter.containsKey(reportedId)) {
                    reportCounter.put(reportedId, reportCounter.get(reportedId) + 1);
                } else {
                    reportCounter.put(reportedId, 1);
                }
            }
        }

        for(String rcKey : reportCounter.keySet()) {
            if(reportCounter.get(rcKey) >= k) {
                for (String idKey : map.keySet()) {
                    if (map.get(idKey).contains(rcKey)) {
                        result.get(idKey)[1]++;
                    }
                }
            }
        }

        for(String rKey : result.keySet()) {
            answer[result.get(rKey)[0]] = result.get(rKey)[1];
        }

        return answer;
    }
}
