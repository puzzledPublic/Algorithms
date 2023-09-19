package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//귤 고르기
public class TangerinePick {
    public static void main(String[] args) {
        int[] ks = {6, 4, 2};
        int[][] tangerines = {
                {1, 3, 2, 5, 4, 5, 2, 3},
                {1, 3, 2, 5, 4, 5, 2, 3},
                {1, 1, 1, 1, 2, 2, 2, 3}
        };

        for(int i = 0; i < ks.length; i++) {
            System.out.println(solution(ks[i], tangerines[i]));
        }
    }

    static int solution(int k, int[] tangerine) {
        int answer = 0;

        int remove = tangerine.length - k;  //제거해야 할 귤 개수

        Map<Integer, Integer> map = new HashMap<>();    //Map<숫자, 배열 내 숫자갯수>
        for(int i = 0; i < tangerine.length; i++) {
            if(map.containsKey(tangerine[i])) {
                map.replace(tangerine[i], map.get(tangerine[i]) + 1);
            }else {
                map.put(tangerine[i], 1);
            }
        }

        int[] arr = new int[map.size()];    //귤들의 갯수를 담은 배열
        int idx = 0;
        for(int num : map.keySet()) {
            arr[idx++] = map.get(num);
        }

        Arrays.sort(arr);   //제일 적은 수의 귤부터 제거하기 위해 정렬

        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(sum + arr[i] > remove) {
                answer = arr.length - i;
                break;
            }
            sum += arr[i];
        }

        return answer;
    }
}
