package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//삼각형의 값
//검색해서 품..
public class BJ4092 {
	static int N;
	static int max;
	static int[][] tri = new int[401][801];
	static int[][] asum = new int[401][801];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int nums = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			if(st.countTokens() == 1) {
				break;
			}
			max = Integer.MIN_VALUE;
			N = Integer.parseInt(st.nextToken());
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= (i * 2) - 1; j++) {
					tri[i][j] = Integer.parseInt(st.nextToken());
					asum[i][j] = asum[i][j - 1] + tri[i][j];	//asum[i][j] = tri[i][1] ~ tri[j]의 합.
				}
			}
			
			//(i, j)을 꼭대기로하는 삼각형의 합을 구한다.
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= (i * 2) - 1; j++) {
					solve(i, j, j, 0);
				}
			}
			
			bw.write((nums++) + ". " + max + "\n");
		}
		
//		int sum = 0;
//		for(int i = N; i >= 1; i--) {
//			sum += getAmount(N, i);
//		}
//		
//		bw.write(sum + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int x, int yLeft, int yRight, int sum) {
		if(x > N || x < 1 || yLeft < 1 || yRight > (x * 2) - 1) {
			return;
		}
		
		sum += asum[x][yRight] - asum[x][yLeft - 1];	//높이 x까지의 삼각형의 합
		max = Math.max(max, sum);
		
		if(yLeft % 2 == 1) {	//yLeft가 홀수인 경우 정삼각형 탐색.
			solve(x + 1, yLeft, yRight + 2, sum);
		}else {	//yLeft가 짝수인 경우 역삼각형 탐색.
			solve(x - 1, yLeft - 2, yRight, sum);
		}
	}
	
	//높이 N인 삼각형의 높이 k인 부분 삼각형 개수 (1 <= k <= N), 문제랑 상관없는데 그냥 한번 구해봄
	static int getAmount(int N, int k) {
		if(k < 0) return -1;
		if(k == 1) {
			return N * N;
		}else {
			if(2 * k > N) {
				return ((N - k + 1) * (N - k + 1) + (N - k + 1)) / 2;
			}else {
				return (((k * k) + k) / 2) + ((N - 2 * k + 1) * (N - k + 2));
			}
		}
	}
}
