package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//타일링
public class BJ1793 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] dp = new String[251];
		solve(dp);
		while(true) {
			String s = br.readLine();
			if(s == null) {
				break;
			}			
			bw.write(dp[Integer.parseInt(s)] + "\n");

		}
		bw.flush();
		bw.close();
		br.close();
	}
	//2x1, 2x2타일로 2xn 타일링
	//dp[i] = 2 * dp[i - 2] + dp[i - 1] = dp[i - 2] + dp[i - 2] + dp[i - 1]
	static void solve(String[] dp) {
		dp[0] = dp[1] = "1";
		for(int i = 2; i < 251; i++) {
			dp[i] = sum(sum(dp[i - 2], dp[i - 2]), dp[i - 1]);
		}
	}
	//숫자 문자열 덧셈
	static String sum(String s1, String s2) {
		int up = 0, temp;	//up = 올림 수, temp = 더한 수
		int s1P = s1.length() - 1,s2P = s2.length() - 1;	//문자열1, 2 포인터
		StringBuilder sb = new StringBuilder();
		
		while(s1P >= 0 && s2P >= 0) {
			temp = (s1.charAt(s1P--) - '0') + (s2.charAt(s2P--) - '0');	//두 수를 더한다
			temp += up;	//올림 수도 더한다.
			if(temp >= 10) {	//10이 넘어가면 올림 수 존재
				up = 1;
			}else {
				up = 0;
			}
			sb.append(temp % 10);
		}
		
		while(s1P >= 0) {
			temp = (s1.charAt(s1P--) - '0') + up;
			if(temp >= 10) {
				up = 1;
			}else {
				up = 0;
			}
			sb.append(temp % 10);
		}
		while(s2P >= 0) {
			temp = (s2.charAt(s2P--) - '0') + up;
			if(temp >= 10) {
				up = 1;
			}else {
				up = 0;
			}
			sb.append(temp % 10);
		}
		if(up == 1) {
			sb.append(1);
		}
		return sb.reverse().toString();
	}
}
