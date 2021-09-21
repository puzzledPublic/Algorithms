package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

//맞춰봐
public class BJ1248 {
	static int N;
	static int[] numbers, pSum;
	static boolean didPrint;
	static char[][] hints;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		String hintLine = br.readLine();
		
		numbers = new int[N];
		pSum = new int[N + 1];	//번호들의 부분합. (pSum[i], i=1부터 채운다. pSum[i] - pSum[j] = j ~ i번째 숫자들의 합)
		hints = new char[N][N];
		int k = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = i; j < N; j++) {
				hints[i][j] = hintLine.charAt(k++);
			}
		}
		
		solve(0, bw);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int n, Writer w) throws IOException {	//숫자를 하나씩 고른다.
		if(didPrint) {	//이미 출력했으면 바로 리턴
			return;
		}
		
		if(n == N) {	//조건을 만족하는 N개 숫자를 모두 골랐으면
			didPrint = true;	//출력 했다고 체크
			for(int i = 0; i < N; i++) {	//숫자들 출력
				w.write(numbers[i] + " ");
			}
			return;
		}
		
		boolean isOk;	//숫자 조건이 맞는지 체크 변수
		switch(hints[n][n]) {	//N번째 숫자가 '0', '+', '-' 중에 하나임을 알 수 있다.
		case '0':	//'0'인 경우 (숫자는 0)
			isOk = true;
			//j ~ n까지의 합이 주어진 조건들에 맞는지 확인.
			for(int j = 0; j < n; j++) {
				int psum = pSum[n] - pSum[j];
				if(!(hints[j][n] == '0' && psum == 0) && !(hints[j][n] == '+' && psum > 0) && !(hints[j][n] == '-' && psum < 0)) {
					isOk = false;
					break;
				}
			}
			if(isOk) {
				numbers[n] = 0;
				pSum[n + 1] = pSum[n];
				solve(n + 1, w);
			}
			break;
		case '+':	//'+'인 경우 (1 ~ 11의 숫자들 중 하나)
			for(int i = 1; i < 11; i++) {
				isOk = true;
				for(int j = 0; j < n; j++) {
					int psum = i + pSum[n] - pSum[j];
					if(!(hints[j][n] == '0' && psum == 0) && !(hints[j][n] == '+' && psum > 0) && !(hints[j][n] == '-' && psum < 0)) {
						isOk = false;
						break;
					}
				}
				if(isOk) {
					numbers[n] = i;
					pSum[n + 1] = i + pSum[n];
					solve(n + 1, w);
				}
			}
			break;
		case '-':	//'-'인 경우 (-1 ~ -11의 숫자들 중 하나)
			for(int i = -1; i > -11; i--) {
				isOk = true;
				for(int j = 0; j < n; j++) {
					int psum = i + pSum[n] - pSum[j];
					if(!(hints[j][n] == '0' && psum == 0) && !(hints[j][n] == '+' && psum > 0) && !(hints[j][n] == '-' && psum < 0)) {
						isOk = false;
						break;
					}
				}
				if(isOk) {
					numbers[n] = i;
					pSum[n + 1] = i + pSum[n];
					solve(n + 1, w);
				}
			}
			break;
		}
	}
}
