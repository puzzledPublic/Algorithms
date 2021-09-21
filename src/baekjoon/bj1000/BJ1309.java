package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//동물원
public class BJ1309 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//DP[i][j] = i번째 위치에 각각의 상태일때  가능한 배치 수
		//상태 = (j=0 -> 아무것도 놓지 않는 상황, j=1 -> 왼쪽에만 놓는 상황, j=2 -> 오른쪽에만 놓는 상황)
		int N = Integer.parseInt(br.readLine()), mod = 9901;
		int[][] DP = new int[2][3];
		DP[0][0] = DP[0][1] = DP[0][2] = 1;
		for(int i = 1; i < N; i++) {
			DP[i % 2][0] = (DP[(i - 1) % 2][0] + DP[(i - 1) % 2][1] + DP[(i - 1) % 2][2]) % mod;
			DP[i % 2][1] = (DP[(i - 1) % 2][0] + DP[(i - 1) % 2][2]) % mod;
			DP[i % 2][2] = (DP[(i - 1) % 2][0] + DP[(i - 1) % 2][1]) % mod;
		}
		
		bw.write(((DP[(N - 1) % 2][0] + DP[(N - 1) % 2][1] + DP[(N - 1) % 2][2]) % mod) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
