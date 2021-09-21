package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//타일 채우기
public class BJ2133 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		bw.write(solve(N) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static long solve(int N) {
		long DP[] = new long[N + 2];	//DP[i] = 3xi 사각형을 2x1, 1x2로 채울 수 있는 경우의 수
		DP[0] = 1;	//아무것도 안채우는 경우 1
		DP[2] = 3;	//3x2의 경우 3가지뿐
		for(int i = 4; i < N + 1; i+= 2) {	//DP[i] = DP[i - 2] * 3 + (DP[i - 4] + DP[i - 6] + DP[i - 8] ... + DP[0]) * 2;
			DP[i] = DP[i - 2] * 3;			//DP[i - 2] * 3은 i - 2까지 채우는 경우의 수 그리고 3x2를 채우는 경우의 수를 곱한 값이다
			for(int j = 4; j <= i; j += 2) {	
				DP[i] += DP[i - j] * 2;		//3xi(i >= 4, i는 짝수)부터 특수하게 채우는 2가지 경우가 있다.(문제 예제 참조)
			}								//(i - 4까지 채운 경우의 수에 3x4를 채우는 특수한 경우 2) + (i - 6까지 채운 경우의 수에 3x6을 채우는 특수한 경우 2가지)... 3xi를 채우는 특수한 경우 수 2가지를 합한 값이다.
		}
		return DP[N];
	}
}
