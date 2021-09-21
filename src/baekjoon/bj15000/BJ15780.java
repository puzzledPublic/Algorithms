package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//멀티탭 충분하니
public class BJ15780 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), sum = 0, t;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < K; i++) {
			t = Integer.parseInt(st.nextToken());
			sum += (t % 2 == 0 ? t / 2 : t / 2 + 1);
		}
		if(N <= sum) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		br.close();
	}
}
