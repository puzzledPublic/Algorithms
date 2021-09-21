package baekjoon.bj12000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//뮤탈리스크
public class BJ12869 {
	static int[][][] order = {
			{{9}},	//N = 1일때 순열
			{{9, 3}, {3, 9}},	//N = 2일때 순열
			{{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}}	//N = 3일때 순열
	};
	static int[][][] dp;
	static int N;
	static int[] Count = {1, 2, 6};
	static int[] tmp = {0, 0, 0};
	static int[] hp = {0, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			hp[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[61][61][61];
		for(int i = 0; i < 61; i++) {
			for(int j = 0; j < 61; j++) {
				for(int k = 0; k < 61; k++) {
					dp[i][j][k] = Integer.MAX_VALUE;	//최대로 초기화
				}
			}
		}
		bw.write(solve(hp[0], hp[1], hp[2]) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int a, int b, int c) {	//각 scv 체력이 a, b, c일때 모두 부술 수 있는 최소 공격 횟수
		if(a <= 0 && b <= 0 && c <= 0) {
			return dp[0][0][0] = 0;
		}
		
		if(dp[a][b][c] != Integer.MAX_VALUE) {
			return dp[a][b][c];
		}
		
		for(int i = 0; i < Count[N - 1]; i++) {	//N!의 순열을 돌며
			for(int j = 0; j < N; j++) {
				tmp[j] = order[N - 1][i][j];
			}
			int na = a - tmp[0] > 0 ? a - tmp[0] : 0;	//각 값을 뺀다.(데미지를 준다.) 0 이하면 0으로 고정
			int nb = b - tmp[1] > 0 ? b - tmp[1] : 0;
			int nc = c - tmp[2] > 0 ? c - tmp[2] : 0;
			dp[a][b][c] = Math.min(dp[a][b][c], solve(na, nb, nc) + 1);
		}
		
		return dp[a][b][c];
	}
}
