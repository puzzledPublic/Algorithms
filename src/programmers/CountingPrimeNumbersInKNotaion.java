package programmers;

import java.util.Arrays;

//k진수에서 소수 개수 구하기
public class CountingPrimeNumbersInKNotaion {
    public static void main(String[] args) {
        int[] ns = {437674, 110011, 5, 797161};    //3, 2, 0
        int[] ks = {3, 10, 2, 3};

        for (int i = 0; i < ns.length; i++) {
            System.out.println(solution(ns[i], ks[i]));
        }
    }

    static int solution(int n, int k) {
        int answer = 0;

        String tran = "";

        while(n > 0) {
            tran = (n % k) + tran;
            n /= k;
        }

        String[] splitted = tran.split("[0]+");

        for(int i = 0; i < splitted.length; i++) {
            long num = Long.parseLong(splitted[i]);

            boolean isPrime = true;
            for(long j = 2; j * j <= num; j++) {    //num이 long 타입이므로 j * j시 long이 될 수 있다. j도 long 타입이 되어야 함에 주의
                if(num % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(num >= 2 && isPrime) {
                answer++;
            }
        }

        return answer;
    }
}
