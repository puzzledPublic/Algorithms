package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//파일 합치기
public class BJ11066 {
	static int[][] DP;	//DP[i][j] = i번째 파일부터 j번째 파일까지 합쳤을때 드는 가장 적은 비용
	static int[] pSum;	//연속 부분합
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			DP = new int[n + 1][n + 1];
			pSum = new int[n + 1];
			for(int j = 0; j < n + 1; j++) {
				for(int k = 0; k < n + 1; k++) {
					DP[j][k] = 987654321;
				}
			}
			for(int j = 1; j < n + 1; j++) {
				DP[j][j] = Integer.parseInt(st.nextToken());
				pSum[j] = pSum[j - 1] + DP[j][j];
			}
			bw.write(solve(1, n) + "\n");
		}
		
		for(int i = 0; i < T; i++) {
			bw.write(solve2(Integer.parseInt(br.readLine()), br.readLine()) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	//메모이제이션
	static int solve(int left, int right){
		if(left == right) {	//자기자신을 합칠 수 없으므로 0
			return 0;
		}
		if(DP[left][right] != 987654321) {	//Memoization
			return DP[left][right];
		}
		if(right - left == 1) {	//인접한 파일인 경우 서로의 합이 합치는 비용
			return pSum[right] - pSum[left - 1];
		}
		for(int i = left; i < right; i++) {	//파일을 합치는 모든 경우를 돌아본다.
			//left ~ i의 비용과 i + 1 ~ right까지의 비용의 합들 중 최소값
			DP[left][right] = Math.min(DP[left][right], solve(left, i) + solve(i + 1, right) + (pSum[right] - pSum[left - 1]));
		}
		return DP[left][right];
	}
	
	//동적계획법 O(n^3) (Knuth's Optimization으로 O(N^2)가 가능하다 한다.)
	static int solve2(int n, String s) {
		StringTokenizer st = new StringTokenizer(s);
		int[][] DP2 = new int[n + 1][n + 1];	//i번째 파일부터 j번째 파일까지 합치는데 드는 최소 비용
		int[] pSum = new int[n + 1];	//연속 부분합
		
		for(int i = 0; i < n + 1; i++) {
			for(int j = 0; j < n + 1; j++) {
				DP2[i][j] = 987654321;
			}
		}
		
		for(int i = 1; i < n + 1; i++) {
			pSum[i] = pSum[i - 1] + Integer.parseInt(st.nextToken());	//부분합 구하기
			DP2[i][i] = 0;	//자기자신을 합치는것은 불가능이므로 드는 비용은 0
		}
		
		//DP[i][j] = i ~ j까지의 부분합 + Min(DP[i][k] + DP[k + 1][j])
		//배열을 채우는 순서가 대각선 방향임을 주의.
		for(int k = 1; k < n; k++) {	//두 파일간 떨어져있는 거리
			for(int i = 1; i < n - k + 1; i++) {	//왼쪽 파일의 위치, 오른쪽 파일 위치는 i + k가 된다.
				for(int j = i; j < i + k ; j++) {	//두 구간을 나누는 중간 파일 위치
					DP2[i][i + k] = Math.min(DP2[i][i + k], DP2[i][j] + DP2[j + 1][i + k] + pSum[i + k] - pSum[i - 1]);
				}
			}
		}
		return DP2[1][n];	//1 ~ n까지 파일을 합치는데 드는 최소 비용
	}
}
