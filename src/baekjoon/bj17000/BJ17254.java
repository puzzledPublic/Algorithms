package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//키보드 이벤트
public class BJ17254 {
	static class Key {
		int n, t;
		char ch;
		Key(int n, int t, char ch) {
			this.n = n;
			this.t = t;
			this.ch = ch;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Key[] inputs = new Key[M];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			inputs[i] = new Key(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
		}
		
		Arrays.sort(inputs, (a, b) -> {
			return a.t == b.t ? a.n - b.n : a.t - b.t;
		});
		
		for(int i = 0; i < M; i++) {
			bw.write(inputs[i].ch);
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
