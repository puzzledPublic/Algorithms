package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//삼각 그래프
public class BJ4883 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int k = 1, n;
		int[][] dp = new int[100001][3];	//dp[i][j] = i행 j열까지 가는데 드는 최소 비용
		StringTokenizer st;
		while((n = Integer.parseInt(br.readLine())) != 0) {
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < 3; j++) {
					dp[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dp[0][0] = 987654321;	//맨 우상단 정점은 가운데 정점에서 갈 수가 없으므로 INF.
			dp[0][2] += dp[0][1];	//맨 좌상단 정점은 가운데 정점에서 갈 수 있다.
			for(int i = 1; i < n; i++) {	//첫째 줄을 제외한 행들
				dp[i][0] += Math.min(dp[i - 1][0], dp[i - 1][1]);	//좌측 정점은 dp[i-1][0], dp[i-1][1]에서 올 수 있다.
				dp[i][1] += Math.min(dp[i][0], Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])));	//가운데 정점은 dp[i][0], dp[i-1][0 ~ 2]에서 올 수 있다.
				dp[i][2] += Math.min(dp[i][1], Math.min(dp[i - 1][1], dp[i - 1][2]));	//우측 정점은 dp[i][1], dp[i-1][1], dp[i-1][2]에서 올 수 있다.
			}
			bw.write(k + ". " + dp[n - 1][1] + "\n");	//마지막 행 가운데 정점까지 가는데 드는 최소 비용 출력
			k++;
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
