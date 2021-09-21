package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//타일코드
public class BJ1720 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];	//dp[i] = 2xi의 공간을 1x2, 2x1, 2x2 타일로 채워넣는 경우의 수
		
		dp[0] = dp[1] = 1;
		for(int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] * 2;
		}
		
		int[] dp2 = new int[N + 1];	//dp2[i] = 2xi의 공간을 1x2, 2x1, 2x2 타일로 대칭되도록 채워넣는 경우의 수
		dp2[0] = dp2[1] = 1;
		for(int i = 2; i <= N; i++) {
			if(i % 2 == 0) {	//짝수일 때
				dp2[i] = dp[i / 2] + dp[i / 2 - 1] * 2;	//[i / 2]가 대칭, 가운데 2x2를 남겨두고 [i / 2 - 1]이 대칭 (가운데 2x2가 1x2를 두개, 2x2를 한개 둘 수 있으므로 2배)
			}else {	//홀수일 때
				dp2[i] = dp[i / 2];	//가운데 2x1를 두고 양쪽이 대칭.
			}
		}
		//모든 경우의 수 - 대칭되는 경우의 수 = 좌우반전 되는 경우의 수
		//각 좌우반전 되는 경우 1씩 빼야하므로 2로 나눠준다. 그 후 모든 경우의 수에서 빼면 원하는 답을 얻는다.
		//모든 경우의 수 - ((모든 경우의 수 - 대칭되는 경우의 수) / 2)
		bw.write((dp[N] - ((dp[N] - dp2[N]) / 2)) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
