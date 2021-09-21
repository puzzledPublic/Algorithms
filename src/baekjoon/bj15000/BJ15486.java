package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//퇴사 2
public class BJ15486 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N + 1];
		int[] T = new int[N + 1]; 
		int[] P = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		//O(N)
		for(int i = 1; i <= N; i++) {
			dp[i] = Math.max(dp[i], dp[i - 1]);	//i일까지 최대 얻을 수 있는 이득
			
			if(i + T[i] - 1 <= N) {	//N일을 넘으면 이득을 얻을 수 없음
				//i + T[i] - 1일까지 얻을 수 있는 최대 이득은 ((i - 1일까지 얻을 수 있는 최대 이득) + P[i](i일부터 i + T[i] - 1일까지 일했을때 이득))들 중 최대값
				dp[i + T[i] - 1] = Math.max(dp[i + T[i] - 1], dp[i - 1] + P[i]);
			}
		}
		
		bw.write(dp[N] + "\n");
		
		//다른 풀이(O(100*N))
		//dp[i] = i일까지 일 할 때 얻을 수 있는 최대 이득
//		for(int i = 1; i <= N; i++) {
//			for(int j = (i - 52 > 0 ? i - 52 : 1); j <= i; j++) {	//T[j]가 최대 50인것을 이용. (i - 50)일 위치만 살펴보자.
//				if(T[j] + j - 1 == i) {	//j일부터 j + T[j]일까지 일 할 때 i일에 끝나는 경우
//					dp[i] = Math.max(dp[i], dp[j - 1] + P[j]);
//				}else if(T[j] + j - 1 < i) {	//i일 전에 끝나고
//					if(T[i] != 1) {	//i일에 하루짜리 일이 없는 경우
//						dp[i] = Math.max(dp[i], dp[j - 1] + P[j]);
//					}else {	//i일에 하루짜리 일이 있는 경우
//						dp[i] = Math.max(dp[i], dp[j - 1] + P[j] + P[i]);						
//					}
//				}
//			}
//		}
//		
//		bw.write(dp[N] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
