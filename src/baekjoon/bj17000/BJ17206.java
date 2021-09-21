package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//준석이의 수학 숙제
public class BJ17206 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int[] cache = new int[80001];
		
		for(int i = 3; i < 80001; i++) {
			cache[i] = cache[i - 1];
			if(i % 3 == 0 || i % 7 == 0) {
				cache[i] += i;
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < T; i++) {
			bw.write(cache[Integer.parseInt(st.nextToken())] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
