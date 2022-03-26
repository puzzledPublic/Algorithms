package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//로또의 최고 순위와 최저 순위
public class LottoUpperLower {
    public static void main(String[] args) {
        int[][] lottoss = {
                {44, 1, 0, 0, 31, 25},
                {0, 0, 0, 0, 0, 0},
                {45, 4, 35, 20, 3, 9},
        };
        int[][] win_nums = {
                {31, 10, 45, 1, 6, 19},
                {38, 19, 20, 40, 15, 25},
                {20, 9, 3, 45, 4, 35},
        };
        for(int i = 0; i < lottoss.length; i++) {
            Arrays.stream(solution(lottoss[i], win_nums[i])).forEach((r) -> System.out.print(r + " "));
            System.out.println();
        }
    }

    static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        Set<Integer> set = new HashSet<>();
        for (int win_num : win_nums) {
            set.add(win_num);
        }

        int zero = 0;   //지워진 숫자 갯수
        int correct = 0;    //맞은 숫자 갯수
        for (int lotto : lottos) {
            if (lotto == 0) {   //지워진 숫자
                zero++;
            } else if (set.contains(lotto)) {   //맞는 숫자인지 확인
                correct++;
            }
        }

        int upper = zero + correct; //지워진 숫자가 다 맞는 경우 - 최고 순위
        int lower = correct;    //지워진 숫자가 다 틀린 경우 - 최저 순위

        answer[0] = Math.min((7 - upper), 6);
        answer[1] = Math.min((7 - lower), 6);

        return answer;
    }
}
