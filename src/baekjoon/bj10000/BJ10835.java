package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//카드게임
public class BJ10835 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N + 1][N + 1];	//dp[i][j] = 왼쪽 카드를 i개, 오른쪽 카드를 j개 사용했을 때 얻을 수 있는 최대 점수.
		int[][] card = new int[N + 1][2];	//dp[i][0] = 왼쪽 카드 번호들, dp[i][1] = 오른쪽 카드 번호들.
//		int[][] dp2 = new int[N + 1][N + 1];
		for(int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = N; j > 0; j--) {
				card[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j < N + 1; j++) {
				if(card[i][0] > card[j][1]) {
					dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i - 1][j - 1], dp[i][j - 1] + card[j][1]));
				}else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
				}
			}
		}
		
//		for(int i = N - 1; i >= 0; i--) {
//			for(int j = N - 1; j >= 0; j--) {
//				if(card[i + 1][0] > card[j + 1][1]) {
//					dp2[i][j] = Math.max(dp2[i + 1][j], Math.max(dp2[i + 1][j + 1], dp2[i][j + 1] + card[j + 1][1]));
//				}else {
//					dp2[i][j] = Math.max(dp2[i + 1][j], dp2[i + 1][j + 1]);
//				}
//			}
//		}
		
		bw.write(dp[N][N] + "\n");
//		bw.write(dp2[0][0] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
