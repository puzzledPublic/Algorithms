package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//극장좌석
public class BJ2302 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//dp[i] = vip석 없이 i명을 조건에맞게 나열할 수 있는 경우의 수 (조건 = i는 i, i-1, i+1좌석에만 앉을 수 있다)
		
		//1. i를 i자리에 앉힌다면 dp[i - 1]까지의 경우의 수와 같다.
		//2. i를 i-1번째 자리에 앉힌다면 i-1은 무조건 i자리에 앉아야하고 이때 경우의 수는 dp[i - 2]와 같다.
		//그러므로 dp[i] = dp[i - 1] + dp[i - 2];
		
		//vip석이 있는 경우 해당 vip좌석을 기준으로 칸막이가 생긴다고 생각할 수 있고 (vip좌석은 다른좌석에 앉을 수 없으므로)
		//그 사이사이에 있는 좌석들 갯수만큼의 나열 가능한 수들을 모두 곱하면 답이 된다.
		int[] dp = new int[41];
		dp[0] = dp[1] = 1;
		for(int i = 2; i < 41; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine()); 
		
		int mul = 1, before = 0;	//이전 vip석 인덱스
		for(int i = 0; i < M; i++) {
			int seat = Integer.parseInt(br.readLine());
			mul *= dp[seat - before - 1];	//seat - before - 1 = 사이에 있는 좌석 수
			before = seat;
		}
		
		bw.write((mul * dp[N - before]) + "\n");	//마지막의 좌석들의 경우의 수를 곱한 후 출력

		bw.flush();
		bw.close();
		br.close();
	}
}
