package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RunningRace {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        Arrays.stream(solution(players, callings)).forEach(System.out::println);
    }

    static String[] solution(String[] players, String[] callings) {
        String[] answer = {};

        Map<String, Integer> map = new HashMap<>(); //Map<이름, 현재순위>
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i + 1);
        }

        for(int i = 0; i < callings.length; i++) {
            int num = map.get(callings[i]); //불린 사람의 현재 순위

            String temp = players[num - 1]; //앞 사람이랑 위치 교환
            players[num - 1] = players[num - 2];
            players[num - 2] = temp;

            map.replace(callings[i], num - 1);  //두명의 위치값 갱신
            map.replace(players[num - 1], num);
        }

        answer = players;

        return answer;
    }
}
