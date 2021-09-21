package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//크리보드
public class BJ11058 {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		long[] dp = new long[101];	//dp[i] = 버튼을 i번 눌렀을 때 출력되는 A의 최대 개수
		for(int i = 1; i <= 6; i++) {
			dp[i] = i;
		}
		
		//1번 버튼: A출력
		//2번 버튼: 전체 선택
		//3번 버튼: 버퍼에 쓰기
		//4번 버튼: 버퍼를 화면에 쓰기
		//이라고 할 때 이 버튼 숫자들을 나열하는 것으로 생각할 수 있다.
		//~1, ~234, ~2344, ~23444, ~234444, ~2344444 ...로 끝나는 경우가 있다.
		//2, 3, 4버튼을 묶음으로 누르는게 최적이다.
		//마지막 버튼이 1인 경우 dp[i - 1] + 1이 된다.
		//그 외에는 4로 끝나는 경우가 있다. dp[i - 끝나는 번호들의 길이(234->3, 2344->4, 23444->5...)] * (끝에 4번 버튼이 눌린 횟수 + 1)
		//이들 중 최대 값이 dp[i]이다.
		for(int i = 7; i <= 100; i++) {
			int k = 2;
			for(int j = i - 3; j >= 3; j--) {
				dp[i] = Math.max(dp[i], dp[j] * k);
				k++;
			}
			dp[i] = Math.max(dp[i], dp[i - 1] + 1);
		}
		
		bw.write(dp[N] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
