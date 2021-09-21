package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//암호코드
public class BJ2011 {
	static int MOD = 1000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int[] dp = new int[s.length() + 1];		//dp[i] = i번째 숫자를 놓았을때 만들 수 해석할 수 있는 경우의 수 (i >= 1)
		if(s.charAt(0) - '0' > 0) {		//0이 먼저 들어오는 경우는 0
			dp[0] = dp[1] = 1;
		}
		for(int i = 2; i < dp.length; i++) {
			int t = (s.charAt(i - 2) - '0'), t2 = (s.charAt(i - 1) - '0'), t3 = t * 10 + t2;	//(문자열 인덱스가 0부터 시작하므로) t1 = i - 2번째 숫자, t2 = i - 1번째 숫자, t3 = t1, t2를 합친 두자리 숫자
			if(0 < t && 0 < t2 && t3 < 27) {	//t1, t2가 1 이상이고 t3가 27 미만이라면 ex) 123
				dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
			}else if(0 < t && t2 == 0 && t3 < 27) {		//t1이 1 이상, t2 가 0이고 t3가 27미만이라면 ex) 109
				dp[i] = dp[i - 2];
			}else if(t2 != 0){		//여기까지 왔다면 t1 == 0 || t2 == 0 || t3 >= 27이고 t2가 0이면 해석 불가가 된다.
				dp[i] = dp[i - 1];
			}
		}
		bw.write(dp[dp.length - 1] + " ");
		bw.flush();
		bw.close();
		br.close();
	}
}
