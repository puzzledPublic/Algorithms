package programmers;

import java.util.*;

//메뉴 리뉴얼
public class MenuRenewal {
    public static void main(String[] args) {
        String[][] orderss = {
                {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
                {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
                {"XYZ", "XWY", "WXA"},
        };
        int[][] coursess = {
                {2, 3, 4},
                {2, 3, 5},
                {2, 3, 4},
        };

        for (int i = 0; i < orderss.length; i++) {
            Arrays.stream(solution(orderss[i], coursess[i])).forEach(r -> System.out.print(r + " "));
            System.out.println();
        }
//        Arrays.stream(solution(orderss[0], coursess[0])).forEach(r -> System.out.print(r + " "));
//        System.out.println();
    }

    static String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        Map<String, Integer> map = new HashMap<>();
        int[] max = new int[course.length]; //해당 course 길이마다 최대 주문 횟수
        for (int i = 0; i < orders.length; i++) {
            char[] sorted = orders[i].toCharArray();
            Arrays.sort(sorted);    //조합을 알파벳순으로 만들기 위해 정렬
            for (int j = 0; j < course.length; j++) {
                List<String> list = new ArrayList<>();
                test(sorted, 0, course[j], "", list);   //문자들로 course[j]길이의 문자열을 만들 수 있는 조합 생성
                for (String s : list) { //만들어진 조합들로 몇개나 주문 됐는지 확인
                    int amount = 0;
                    for (int k = 0; k < orders.length; k++) {
                        int count = 0;
                        for (char c : s.toCharArray()) {
                            for (char cc : orders[k].toCharArray()) {
                                if (c == cc) {
                                    count++;
                                    break;
                                }
                            }
                        }
                        if (count == s.length()) {
                            amount++;
                        }
                    }
                    if (amount > max[j]) {  //최대 주문 횟수 갱신
                        max[j] = amount;
                    }
                    if (amount >= 2) {  //주문 2회이상 된 경우 저장
                        map.putIfAbsent(s, amount);
                    }
                }
            }
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            for (String key : map.keySet()) {
                //해당 길이의 문자열의 주문 횟수가 최대 주문 횟수 보다 큰 경우
                if (key.length() == course[i] && max[i] <= map.get(key)) {
                    list.add(key);
                }
            }
        }

        list.sort(Comparator.naturalOrder());
        answer = list.toArray(new String[0]);

        return answer;
    }

    static void test(char[] s, int i, int k, String a, List<String> comb) {
        if (k == 0) {
            comb.add(a);
            return;
        }
        if (s.length <= i) {
            return;
        }
        test(s, i + 1, k - 1, a + s[i], comb);
        test(s, i + 1, k, a, comb);
    }
}
