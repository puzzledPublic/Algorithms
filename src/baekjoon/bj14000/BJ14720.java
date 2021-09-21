package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//우유 축제 (그리디하게 풀 수도 있음)
public class BJ14720 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		int[] dp = new int[N];	//i번째 우유가게에서 arr[i] 종류의 우유를 팔때 먹을 수 있는 최대 우유 개수
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] == 0) {	//딸기 우유를 먹을 수 있는곳 (시작점)
				dp[i] = 1;
			}
		}
		int max = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i - 1; j >= 0; j--) {
				if(arr[j] == (arr[i] + 2) % 3 && dp[j] > 0) {	//i번째 우유 종류 전에 먹어야하는 우유 종류를 파는 우유가게 중 먹을 수 있는 최대 우유 개수
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		bw.write(greedySolve(arr) + "\n");
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int greedySolve(int[] arr) {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(count % 3 == arr[i]) {
				count++;
			}
		}
		return count;
	}
}