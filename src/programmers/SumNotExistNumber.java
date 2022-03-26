package programmers;

import java.util.Arrays;

//없는 숫자 더하기
public class SumNotExistNumber {
    public static void main(String[] args) {
        int[][] numberss = {
                {1, 2, 3, 4, 6, 7, 8, 0},   //14
                {5, 8, 4, 0, 6, 7, 9},      //6
        };

        for (int[] numbers : numberss) {
            System.out.println(solution(numbers));
        }
    }

    static int solution(int[] numbers) {
        int answer = 0;

        int[] arr = new int[10];
        for(int i : numbers) {
            arr[i] = 1;
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                answer += i;
            }
        }

        return answer;
    }

    static int solution2(int[] numbers) {
        int answer = 45 - Arrays.stream(numbers).sum();
        return answer;
    }
}
