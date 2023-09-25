package programmers;

import java.util.HashMap;
import java.util.Map;

//할인 행사
public class OnSale {
    public static void main(String[] args) {
        String[][] wants = {
                {"banana", "apple", "rice", "pork", "pot"},
                {"apple"},
                {"banana", "pot"},
        };
        int[][] numbers = {
                {3, 2, 2, 2, 1},
                {10},
                {3, 1}
        };
        String[][] discounts = {
                {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"},
                {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"},
                {"banana", "pot", "pot", "pot", "pot", "pot", "pot", "pot", "banana", "banana", "pot", "pot", "pot", "pot", "pot", "pot", "pot", "banana"}
        };

        /*
        * result
        * 3
        * 0
        * 2 -> 실패 수정 필요
        */
        for(int i = 0; i < wants.length; i++) {
            System.out.println(solution(wants[i], numbers[i], discounts[i]));
        }
    }

    static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < 10; i++) {
            if(map.containsKey(discount[i])) {
                map.replace(discount[i], map.get(discount[i]) + 1);
            }else {
                map.put(discount[i], 1);
            }
        }

        int start = 0;
        int end = 10;

        while(end <= discount.length) {
            boolean check = false;
            for(int i = 0; i < number.length; i++) {
                if(!(map.containsKey(want[i]) && map.get(want[i]) >= number[i])) {
                    check = true;
                    break;
                }
            }
            if(!check) {
                answer++;
            }

            if(end < discount.length) {
                map.replace(discount[start], map.get(discount[start]) - 1);
                if(map.containsKey(discount[end])) {
                    map.replace(discount[end], map.get(discount[end]) + 1);
                }else {
                    map.put(discount[end], 1);
                }
            }
            start++;
            end++;
        }

        return answer;
    }
}
