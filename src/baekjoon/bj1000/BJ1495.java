package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//기타리스트
public class BJ1495 {
	static int N, S, M, max = -1;
	static int[] arr;
	static int[][] DP;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		DP = new int[N + 1][M + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0, S);
		for(int i = M; i >= 0; i--) {
			if(DP[N][i] > 0) {	//n번째 곡을 연주할때 도달할 수 있는 가장 큰 볼륨
				max = i;
				break;
			}
		}
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	//n번째 곡을 연주할때 next 볼륨에 도달 가능한가?
	static int solve(int n, int next) {
		if(DP[n][next] != 0) {	//0인 경우는 아직 탐색 안된 영역
			return DP[n][next];
		}
		if(n == N) {	//도달한 경우 1로 설정
			return DP[n][next] = 1;
		}
		if(next - arr[n] >= 0) {
			DP[n][next] = solve(n + 1, next - arr[n]);
		}
		if(next + arr[n] <= M) {
			DP[n][next] = solve(n + 1, next + arr[n]);
		}
		//도달하지 못한다면 -1로 설정
		return -1;
	}
}
