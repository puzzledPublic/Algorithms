package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//양팔저울
public class BJ2629 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] bead = new int[N];
		int[] dp = new int[30001];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			bead[i] = Integer.parseInt(st.nextToken());
		}
		
		//x + a + b = c + d + e일 때 x = c + d + e - a - b가 되는 것처럼 저울도 마찬가지.
		//그러므로 첫번째 구슬부터 N번째 구슬까지 각 구슬을 골라서 더하거나, 빼거나. 아니면 고르지 않거나 이 3가지 선택지가 있다. 
		//뺄셈으로 마이너스가 될 수 있다. 문제에서 추의 개수는 30개, 각 무게는 500g이므로 15000g을 더하여 마이너스로인한 런타임 에러를 피한다.
		int count = 1;
		dp[15000] = count;
		for(int i = 0; i < N; i++) {
			count++;
			for(int j = 0; j < 30001; j++) {
				if(0 <= j - bead[i] && j + bead[i] <= 30000 && 0 < dp[j] && dp[j] < count) {
					if(dp[j + bead[i]] == 0) {	//더하거나
						dp[j + bead[i]] = count;
					}
					if(dp[j - bead[i]] == 0) {	//빼거나
						dp[j - bead[i]] = count;
					}
					//고르지 않은 경우는 이미 dp[j]이므로 생략
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			int Q = Integer.parseInt(st.nextToken());
			//Q <= 40000g 이지만 입력 조건 때문에 최대 15000g까지만 측정 가능하다.
			bw.write((Q <= 15000 && dp[Q + 15000] != 0 ? "Y" : "N") + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
