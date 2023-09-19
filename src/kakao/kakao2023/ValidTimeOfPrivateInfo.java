package kakao.kakao2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//개인정보 수집 유효기간
public class ValidTimeOfPrivateInfo {
    public static void main(String[] args) {
        String[] todays = {"2022.05.19", "2020.01.01"};
        String[][] termss = {
                {"A 6", "B 12", "C 3"},
                {"Z 3", "D 5"}
        };
        String[][] privaciess = {
                {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"},
                {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}
        };

        for(int i = 0; i < todays.length; i++) {
            Arrays.stream(solution(todays[i], termss[i], privaciess[i])).forEach(k -> System.out.print(k + " "));
            System.out.println();
        }
    }

    static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();
        String[] curr = today.split("\\.");
        int currY = Integer.parseInt(curr[0]);
        int currM = Integer.parseInt(curr[1]);
        int currD = Integer.parseInt(curr[2]);
        int currTime = currY * 12 * 28 + currM * 28 + currD;    //한달에 28일로 고정이므로 계산하기 쉽게 년.월.일을 일로 바꾼다

        for(int i = 0; i < privacies.length; i++) {
            String[] splittedP = privacies[i].split(" ");
            String[] past = splittedP[0].split("\\.");
            int pastY = Integer.parseInt(past[0]);
            int pastM = Integer.parseInt(past[1]);
            int pastD = Integer.parseInt(past[2]);
            int pastTime = pastY * 12 * 28 + pastM * 28 + pastD;
            String term = splittedP[1];

            for(int j = 0; j < terms.length; j++) {
                String[] splittedT = terms[j].split(" ");
                String termName = splittedT[0];
                int duration = Integer.parseInt(splittedT[1]) * 28;

                if(term.equals(termName) && pastTime + duration <= currTime) {
                    result.add(i + 1);
                }
            }
        }

        answer = result.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
