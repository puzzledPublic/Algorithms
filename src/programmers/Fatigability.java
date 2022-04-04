package programmers;

import java.util.Arrays;

//피로도
public class Fatigability {
    public static void main(String[] args) {
        int k = 80;

        int[][] dungeons = {
                {80, 20},
                {50, 40},
                {30, 10},
        };

        System.out.println(solution(k, dungeons));
    }

    static int solution(int k, int[][] dungeons) {
        int answer = 0;

        int[] arr = new int[dungeons.length];
        for(int i = 0; i < dungeons.length; i++) {
            arr[i] = i;
        }
        //던전이 최대 8개이므로 순열(8!)로 조사한다.
        do {
            int t = k;
            int count = 0;
            for(int i = 0; i < arr.length; i++) {
                if(t >= dungeons[arr[i]][0]) {
                    t -= dungeons[arr[i]][1];
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }while(permutation(arr));

        return answer;
    }

    static boolean permutation(int[] arr) {
        int i = arr.length - 1, j = arr.length - 1;

        while(i > 0 && arr[i] < arr[i - 1]) {
            i--;
        }

        if(i == 0) {
            return false;
        }

        while(arr[j] < arr[i - 1]) {
            j--;
        }

        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        j = arr.length - 1;

        while(i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return true;
    }
}
