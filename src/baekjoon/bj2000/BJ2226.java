package baekjoon.bj2000;

import java.io.*;
import java.math.BigInteger;

//이진수
public class BJ2226 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[1001];
        //1 -> 01 -> 1001 -> 01101001
        //수열의 생성되는 규칙을 보면 이전의 수에서 현재 수를 만들때, 현재의 수 = [이전의 수 비트반전 + 이전의 수]가 된다.
        //수를 합쳤을때 연속된 0의 구간 개수를 알아야 하므로 이전의 수의 맨 앞자리가 1인지 0인지 알아야 한다.
        //앞자리는 계속해서 비트반전이 되므로 맨 앞자리 수는 짝수번째일때 0, 홀수번째일때 1이 되는걸 알 수 있다.
        dp[1] = BigInteger.ZERO;
        for(int i = 2; i < 1001; i++) {
            if(i % 2 == 0) {
                dp[i] = dp[i - 1].multiply(BigInteger.TWO).add(BigInteger.ONE);
            }else {
                dp[i] = dp[i - 1].multiply(BigInteger.TWO).subtract(BigInteger.ONE);
            }
        }

        bw.write(dp[N] + "\n");

        bw.close();
        br.close();
    }
}
