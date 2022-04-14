package programmers;

import java.util.Arrays;

//쿼드압축 후 개수 세기
public class CountingAfterQuadCompression {
    public static void main(String[] args) {
        int[][][] arrs = {
                {
                        {1, 1, 0, 0},
                        {1, 0, 0, 0},
                        {1, 0, 0, 1},
                        {1, 1, 1, 1}},
                {
                        {1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 1, 1, 1, 1},
                        {0, 1, 0, 0, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 1, 0, 0, 1},
                        {0, 0, 0, 0, 1, 1, 1, 1},
                },
        };

        for(int[][] arr : arrs) {
            Arrays.stream(solution(arr)).forEach(r -> System.out.print(r + " "));
            System.out.println();
        }
    }

    static int[] solution(int[][] arr) {
        int[] answer = {};

        results[0] = results[1] = 0;

        test(0, 0, arr.length, arr);

        return answer = results;
    }

    static int[] results = new int[2];

    static void test(int x, int y, int s, int[][] arr) {
        boolean same = true;
        int num = arr[x][y];
        check:
        for (int i = x; i < x + s; i++) {   //해당 영역의 숫자가 모두 같은지 check
            for (int j = y; j < y + s; j++) {
                if (num != arr[i][j]) {
                    same = false;
                    break check;
                }
            }
        }
        if(same) {  //모두 같다면 0 또는 1 개수 추가.
            results[num]++;
            return;
        }

        int p = s / 2;
        test(x, y, p, arr); //좌상단
        test(x + p, y, p, arr); //좌하단
        test(x, y + p, p, arr); //우상단
        test(x + p, y + p, p, arr); //우하단
    }
}
