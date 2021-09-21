package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//사수빈탕
public class BJ14585 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		boolean[][] arr = new boolean[301][301];
		int[][] dp = new int[301][301];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true; 
		}
		
		if(arr[0][0]) {		//(0, 0)(시작점)에 사탕이 있는 경우
			dp[0][0] = M;
		}
		//dp[i][j] = (i, j)까지 도착했을때 먹을 수 있는 최대 사탕 개수	 (x, y가 증가하는 방향으로만 움직일 수 있다.)
		for(int i = 1; i < 301; i++) {	//dp[0][i], dp[i][0]의 값을 먼저 계산한다.
			if(arr[i][0]) {
				dp[i][0] = dp[i - 1][0] + ((M - i) > 0 ? M - i : 0);	//i > M인 경우 음수가 되는 것을 방지
			}else {
				dp[i][0] = dp[i - 1][0];
			}
			if(arr[0][i]) {
				dp[0][i] = dp[0][i - 1] + ((M - i) > 0 ? M - i : 0);
			}else {
				dp[0][i] = dp[i - 1][0];
			}
		}
		//dp[i][j] = (arr[i][j]에 사탕바구니가 존재하는 경우) Max(dp[i - 1][j], dp[i][j - 1]) + 처음 사탕바구니에 담긴 사탕 개수 - (i, j)까지 도달하는데 걸리는 시간
		//           (사탕 바구니가 존재하지 않는 경우) Max(dp[i - 1][j], dp[i][j - 1])
		for(int i = 1; i < 301; i++) {
			for(int j = 1; j < 301; j++) {
				if(arr[i][j]) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + ((M - (i + j)) > 0 ? (M - (i + j)) : 0);	//(i + j) > M인 경우 음수가 되는 것을 방지
				}else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		bw.write(dp[300][300] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
