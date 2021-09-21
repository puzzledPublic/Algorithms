package baekjoon.bj19000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//약수
public class BJ19576 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		Arrays.fill(dp, 1);
		
		//가장 긴, 배수가 되는 부분수열 길이를 구한다.
		for(int i = 1; i < N; i++) {
			for(int j = i - 1; j >= 0; j--) {
				if(arr[i] % arr[j] == 0) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		int result = 1;
		for(int i = 0; i < N; i++) {
			result = Math.max(result, dp[i]);
		}
		
		bw.write((N - result) + "\n"); 
		
		bw.flush();
		bw.close();
		br.close();
	}
}
