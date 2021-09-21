package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//사전
public class BJ1256 {
	static long[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	//a 개수
		int M = Integer.parseInt(st.nextToken());	//z 개수
		int K = Integer.parseInt(st.nextToken());
		
		dp = new long[M + 1][N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			dp[0][i] = 1;
		}
		for(int i = 1; i < M + 1; i++) {
			dp[i][0] = 1;
		}
		for(int i = 1; i < M + 1; i++) {	//dp[i][j] = i개의 'z'와 j개의 'a'를 사용했을때 만들 수 있는 문자열 개수 ( (i + j)! / i! * j! )
			for(int j = 1; j < N + 1; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				if(dp[i][j] >= 2000000000) {	//숫자가 커질 수 있는데 K가 10억까지므로 최대 20억을 갖도록 제한한다.
					dp[i][j] = 2000000000;
				}
			}
		}

		if(dp[M][N] < K) {	//원하는 K번째보다 문자열 개수가 더 적다면 불가능
			bw.write("-1\n");
		}else {	//dp 테이블을 가지고 역추적한다.
			//문자열을 사전순으로 나열했을때 dp[i][j]에서 a로 시작하는 문자열 개수는 dp[i][j - 1]개, z로 시작하는 문자열 개수는 dp[i - 1][j]개이다.
			StringBuilder sb = new StringBuilder();
			int i = M, j = N;
			while(true) {
				if(i == 0) {	//z를 다 쓴 경우 나머지는 a 문자들
					while(j > 0) {
						sb.append('a');
						j--;
					}
					break;
				}
				if(j == 0) {	//a를 다 쓴 경우 나머지는 z 문자들
					while(i > 0) {
						sb.append('z');
						i--;
					}
					break;
				}
				
				long comp = dp[i][j - 1];
				if(K <= comp) {	//K가 a로 시작하는 문자열 개수보다 같거나 작으면 a 추가
					j -= 1;
					sb.append('a');
				}else {			//K가 a로 시작하는 문자열 개수보다 크다면 z 추가
					if(j - 1 >= 0) {	//K는 상대적이어야 하므로 K의 위치를 바꿔준다.
						K -= dp[i][j - 1];
					}
					i -= 1;
					sb.append('z');
				}
			}
			bw.write(sb + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
