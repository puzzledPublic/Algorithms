package baekjoon.bj2000;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//색종이 올려 놓기
public class BJ2643 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = Math.max(a, b); //너비와 높이 중 더 긴 것을 앞에 고정시킨다.
            arr[i][1] = Math.min(a, b);
        }
        //앞의 수로 내림차순 정렬 후 뒷 수로 내림차순 정렬
        Arrays.sort(arr, (a, b) -> b[0] - a[0] == 0 ? b[1] - a[1] : b[0] - a[0]);

        //앞의 수로 정렬했으므로 n번째 수는 n+a 수보다 당연히 크다.
        //그렇다면 뒤의 수로 색종이를 올릴 수 있는지 확인해야 한다.
        //LDS(Longest Decreasing Subsequence)로 최대 길이(겹칠 수 있는 최대 색종이 개수)를 알아낼 수 있다.
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        for(int i = 1; i < N; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(arr[i][1] <= arr[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = 1;
        for(int i = 0; i < dp.length; i++) {
            result = Math.max(result, dp[i]);
        }

        bw.write(result + "\n");

        bw.close();
        br.close();
    }
}
