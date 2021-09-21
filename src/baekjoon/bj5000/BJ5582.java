package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//공통 부분 문자열
public class BJ5582 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int[][] dp = new int[str1.length()][str2.length()];	//dp[i][j] = str1[i]와 str2[j]를 같은 위치에 대고 비교했을때까지의 최대 공통 부분문자열 크기
		//연속해야하므로 str1[i]와 str2[j]가 같을때 str1[i-1]과 str2[j-1]도 같아야 한다. 그러므로 그 이전까지의 연속길이를 알고 싶다면 dp[i-1][j-1]의 값을 가져오면 된다.
		int max = 0;
		for(int i = 0; i < str1.length(); i++) {
			for(int j = 0; j < str2.length(); j++) {
				if(str1.charAt(i) == str2.charAt(j)) {
					if(i - 1 >= 0 && j - 1 >= 0) {	//i or j가 0일때 ArrayIndexOutOfBoundsException 방지
						dp[i][j] = dp[i - 1][j - 1];	//dp[i][j] = if(str1[i] == str2[j]) { dp[i-1][j-1] + 1 } else 0
					}
					dp[i][j]++;
					if(max < dp[i][j]) {
						max = dp[i][j];
					}
				}
			}
		}
		
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
