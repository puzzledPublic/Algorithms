package programmers;

import java.util.Arrays;

//두 큐 합 같게 만들기
public class MakingQueueSumEqual {
    public static void main(String[] args) {
        int[][] queue1s = {
                {3, 2, 7, 2},   //2
                {1, 2, 1, 2},   //7
                {1, 1},         //-1
                {1, 2},         //3
                {1, 2, 1},      //6
                {1, 2, 1, 2},   //9
                {1, 2, 1, 1, 1},    //12
                {1, 2, 1, 2, 1, 2},  //15
                {11}    //-1
        };
        int[][] queue2s = {
                {4, 6, 5, 1},
                {1, 10, 1, 2},
                {1, 5},
                {4, 1},
                {1, 6, 1},
                {1, 1, 10, 2},
                {1, 2, 1, 12, 2},
                {1, 2, 1, 2, 16, 1},
                {9, 1, 3}
        };

        for (int i = 0; i < queue1s.length; i++) {
            System.out.println(solution(queue1s[i], queue2s[i]));
        }
    }

    static public int solution(int[] queue1, int[] queue2) {
        int answer = -1;

        long q1sum = 0, q2sum = 0;
        for (int i = 0; i < queue1.length; i++) {
            q1sum += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            q2sum += queue2[i];
        }

        int[] queue = new int[queue1.length + queue2.length];
        for (int i = 0; i < queue1.length; i++) {
            queue[i] = queue1[i];
        }

        for (int i = queue1.length; i < queue1.length + queue2.length; i++) {
            queue[i] = queue2[i - queue1.length];
        }

        int q1point = 0, q2point = queue1.length;
        long q1 = q1sum, q2 = q2sum;
        int count = 0;
        while (count < queue.length * 2) {
            if (q1 == q2) {
                answer = count;
                break;
            } else if (q1 < q2) {
                q1 += queue[q2point];
                q2 -= queue[q2point];
                q2point = q2point + 1 == queue.length ? 0 : q2point + 1;
            } else if (q1 > q2) {
                q2 += queue[q1point];
                q1 -= queue[q1point];
                q1point = q1point + 1 == queue.length ? 0 : q1point + 1;
            }
            count++;
        }

        return answer;
    }
}
