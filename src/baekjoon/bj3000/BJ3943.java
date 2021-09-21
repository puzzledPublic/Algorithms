package baekjoon.bj3000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

//헤일스톤 수열
public class BJ3943 {
	static Map<Integer, Integer> heilStone = new HashMap<>();	//메모이제이션
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		heilStone.put(1, 1);
		for(int i = 2; i <= 100_000; i++) {
			solve(i);
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(heilStone.get(n) + "\n");
			bw.write(bruteForce(n) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	//그냥 하나하나 계산해도 통과 됨.
	static int bruteForce(int n) {
		int result = 1;
		while(n != 1) {
			result = Math.max(result, n);
			if(n % 2 == 0) {
				n /= 2;
			}else {
				n = n * 3 + 1;
			}
		}
		return result;
	}
	
	//메모이제이션을 통한 풀이(만일 bruteForce 방법이 오래걸린다면 이 풀이가 더 빠를것)
	static int solve(int n) {
		if(n == 1) {
			return 1;
		}
		
		if(heilStone.containsKey(n)) {
			return heilStone.get(n);
		}
		
		int result = -1;
		if(n % 2 == 0) {
			result = solve(n / 2);
		}else {
			result = solve(n * 3 + 1);
		}
		
		int max = Math.max(n, result);
		heilStone.put(n, max);
		return max;
	}
}
