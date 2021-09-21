package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//무한수열
public class BJ1351 {
	static Map<Long, Long> map = new HashMap<>();	//수의 범위가 크므로 Map으로 캐시한다.
	static long N, P, Q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		
		bw.write(solve(N) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static long solve(long n) {
		if(n == 0) {	//An=1 (n=0일때)
			return 1;
		}
		if(map.containsKey(n)) {	//이미 An=solve(n)에 대한 값이 있다면 바로 리턴.
			return map.get(n);
		}
		map.put(n, solve(n / P) + solve(n / Q));	//아니라면 solve(n) = solve(n/P) + solve(n/Q)을 계산하여 캐시 해놓는다.
		return map.get(n);
	}
}
