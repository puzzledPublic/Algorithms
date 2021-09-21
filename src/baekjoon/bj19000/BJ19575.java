package baekjoon.bj19000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//Polynomial
public class BJ19575 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		long result = 0;
		long MOD = 1_000_000_007;
		for(int i = 0; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			long A = Long.parseLong(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			if(i == 0) {
				result = (A * X) % MOD;
			}
			else if(i == N) {
				result = (result + A) % MOD;
			}
			else{
				result = (result + A) % MOD;
				result = (result * X) % MOD;
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
