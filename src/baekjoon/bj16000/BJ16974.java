package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//레벨 햄버거
public class BJ16974 {
	static long[] patty, burn;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		long X = Long.parseLong(st.nextToken());
		
		patty = new long[51];
		burn = new long[51];
		patty[0] = 1;
		for(int i = 1; i <= 50; i++) {	//각 레벨의 햄버거 패티 수와 빵 수를 계산한다.
			patty[i] = patty[i - 1] * 2 + 1;
			burn[i] = burn[i - 1] * 2 + 2;
		}
		
		bw.write(solve(N, X) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static long solve(int n, long x) {//N레벨의 햄버거에서 아래서부터 X개의 패티나 빵을 먹었을때 먹은 패티의 수
		if(n == 0) {
			return 1;
		}
		long len = patty[n] + burn[n];	//현재 레벨의 햄버거 길이
		long middle = len / 2 + 1;	//현재 레벨의 햄버거의 중간(P) 위치
		long result = 0;
		if(x == 1) {	//맨 처음인 경우 0
			return 0;
		}else if(1 < x && x < middle) {//1 ~ middle 사이인 경우 재귀를 통해 구한다.
			result = solve(n - 1, x - 1);
		}else if(x == middle) {	//middle인 경우 middle 위치의 패티 1개와 n - 1 레벨의 패티수를 더한것과 같다.
			result = patty[n - 1] + 1;
		}else if(middle < x && x < len) {	//middle ~ len 사이인 경우 middle 전의 패티 수와 middle ~ x까지의 재귀를 통한 패티수의 합과 같다.
			result = patty[n - 1] + 1 + solve(n - 1, x - middle);
		}else {	//맨 끝인 경우 n 레벨의 패티 수와 같다.
			result = patty[n];
		}
		return result;
	}
}
