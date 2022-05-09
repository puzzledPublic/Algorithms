package programmers;

import java.util.Arrays;

//양궁대회
public class ArcheryContest {
    public static void main(String[] args) {
        int[] ns = {5, 1, 9, 10};
        int[][] infos = {
                {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},    //[0,2,2,0,1,0,0,0,0,0,0]
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},    //[-1]
                {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1},    //[1,1,2,0,1,2,2,0,0,0,0]
                {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3},    //[1,1,1,1,1,1,1,1,0,0,2]
        };

        for(int i = 0; i < ns.length; i++) {
            Arrays.stream(solution(ns[i], infos[i])).forEach(r -> System.out.print(r + " "));
            System.out.println();
        }
    }

    static int max;
    static int[] ans;
    static int[] solution(int n, int[] info) {
        int[] answer = {};
        max = -1;
        ans = new int[11];
        int[] arr = new int[11];    //라이언 점수판
        test(10, n, arr, info);

        if(max == -1) {
            ans = new int[]{-1};
        }
        return answer = ans;
    }
    //n = (0~10점) 점수, k = 남은 화살 개수, arr = 라이언 점수판, info = 어피치 점수판
    static void test(int n, int k, int[] arr, int[] info) {
        if(k == 0) {    //화살을 다 쐈으면 점수 계산
            int a = 0, b = 0;   //두 명의 점수(a = 라이언, b = 어피치)
            for(int i = 0; i < info.length; i++) {  //점수 계산
                if(!(arr[i] == 0 && info[i] == 0)) {
                    if(arr[i] > info[i]) {
                        a += 10 - i;
                    }else {
                        b += 10 - i;
                    }
                }
            }

            if(a > b && max <= (a - b)) {   //라이언이 이겼고 점수차가 제일 큰 경우 점수판 저장
                max = (a - b);
                for(int i = 0; i < arr.length; i++) {
                    ans[i] = arr[i];
                }
            }
            return;
        }
        if(n == -1) {   //화살을 다 쏘지 못하고 탐색 끝난 경우 종료
            return;
        }

        for(int i = 0; i <= k; i++) {   //n 점수에 0~k발 쏘는 경우 탐색
            arr[n] = i;
            test(n - 1, k - i, arr, info);
            arr[n] = 0;
        }
    }
}
