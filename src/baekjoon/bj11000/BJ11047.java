package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//동전 0 (그리디)
public class BJ11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		for(int i = N - 1; i >= 0; i--) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		solve(coins, K, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(int[] coins, int k, Writer w) throws IOException {
		int count = 0;
		for(int i = 0; i < coins.length; i++) {	//최고 금액부터 최대한 동전을 쓴다.
			while(k / coins[i] != 0) {
				count += k / coins[i];
				k %= coins[i];
			}
		}
		w.write(count + "\n");
	}
}
