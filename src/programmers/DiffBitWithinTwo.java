package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//2개 이하로 다른 비트
public class DiffBitWithinTwo {
    public static void main(String[] args) {
        long[] numbers = {2, 7, 15}; //3, 11

//        Arrays.stream(solution(numbers)).forEach(r -> System.out.print(r + " "));

        System.out.println();

        Arrays.stream(solution2(numbers)).forEach(r -> System.out.print(r + " "));
    }

    static long[] solution2(long[] numbers) {
        long[] answer = {};

        List<Long> results = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            num += 1;   //일단 1을 더한다.
            int shift = Long.numberOfTrailingZeros(num) - 1;    //이진수에서 뒤에서 연속된 0의 개수를 구한다
            while(shift > 0) {  //0을 하나만 남기고 나머지는 1로 마스킹
                num = num | (1L << (shift - 1));
                shift--;
            }
            results.add(num);
        }

        return answer = results.stream().mapToLong(a -> a).toArray();
    }

    //비트를 1개, 2개 바꾸는 모든 경우의 수로 최저값 탐색.
    static long[] solution(long[] numbers) {
        long[] answer = {};

        List<Long> results = new ArrayList<>();

        for(int i = 0; i < numbers.length; i++) {
            long n = numbers[i];
            long[] arr = new long[63];
            int idx = 0;
            while (n > 0) {
                long r = n % 2L;
                arr[idx] = r;
                idx++;
                n /= 2;
            }

            long min = Long.MAX_VALUE;

            for(int t = 0; t < 63; t++) {
                arr[t] = arr[t] == 0 ? 1 : 0;
                long sn = 0;
                long mm = 1;
                for(int k = 0; k < 63; k++) {
                    sn += mm * arr[k];
                    mm *= 2;
                }
                arr[t] = arr[t] == 0 ? 1 : 0;
                if(sn > numbers[i] && sn < min) {
                    min = sn;
                }
            }

            for(int t = 0; t < 63; t++) {
                for(int t2 = t + 1; t2 < 63; t2++) {
                    arr[t] = arr[t] == 0 ? 1 : 0;
                    arr[t2] = arr[t2] == 0 ? 1 : 0;
                    long sn = 0;
                    long mm = 1;
                    for(int k = 0; k < 63; k++) {
                        sn += mm * arr[k];
                        mm *= 2;
                    }
                    arr[t] = arr[t] == 0 ? 1 : 0;
                    arr[t2] = arr[t2] == 0 ? 1 : 0;
                    if(sn > numbers[i] && sn < min) {
                        min = sn;
                    }
                }
            }
;           results.add(min);
        }

        return answer = results.stream().mapToLong(a -> a).toArray();
    }
}
