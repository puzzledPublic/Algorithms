package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//점프
public class BJ1890 {
	static long[][] dp;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		dp = new long[N][N];
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(N, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	//dp[i][j] = i,j까지 도착할 수 있는 경우의 수 (아래, 오른쪽으로만 이동하고, 점프 수에 따라 달라진다)
	static void solve(int n, Writer w) throws IOException {
		dp[0][0] = 1;	//첫번째 발판은 무조건 딛으므로 1
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int k = j - 1;
				while(k >= 0) {	//위에서 오는 경우
					if(j == k + arr[i][k]) {	//점프해서 올 수 있으면 경우의 수 추가
						dp[i][j] += dp[i][k];
					}
					k--;
				}
				k = i - 1;
				while(k >= 0) {	//왼쪽에서 오는 경우
					if(i == k + arr[k][j]) {	//점프해서 올 수 있으면 경우의 수 추가
						dp[i][j] += dp[k][j];
					}
					k--;
				}
			}
		}
		w.write(dp[n - 1][n - 1] + "\n");
	}
}
