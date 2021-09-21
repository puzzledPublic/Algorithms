package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//비밀번호 만들기(LCS)
public class BJ17218 {
	static String str1, str2;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		str1 = br.readLine();
		str2 = br.readLine();
		int str1Len = str1.length();
		int str2Len = str2.length();
		dp = new int[str1Len+ 1][str2Len + 1];
		
		//LCS를 구하는 dp 배열을 채운다.
		for(int i = 1; i <= str1Len; i++) {
			for(int j = 1; j <= str2Len; j++) {
				if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		
		bw.write(backtrack(str1Len, str2Len));
		
		bw.flush();
		bw.close();
		br.close();
	}
	//dp배열을 백트래킹하며 문자열을 만든다.
	static String backtrack(int i, int j) {
		if(i == 0 || j == 0) {	//끝까지 탐색하면 빈문자열 리턴
			return "";
		}
		else if(str1.charAt(i - 1) == str2.charAt(j - 1)) {	//각각의 위치가 같은 문자라면 해당 문자 추가.
			return backtrack(i - 1, j - 1) + str1.charAt(i - 1);
		}else {
			if(dp[i][j - 1] > dp[i - 1][j]) {	//더 큰 쪽으로 움직여서 숫자가 변하는 모서리 부분으로 옮긴다.
				return backtrack(i, j - 1);
			}else {
				return backtrack(i - 1, j);
			}
		}
	}
}
