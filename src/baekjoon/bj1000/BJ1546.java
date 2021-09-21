package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//평균
public class BJ1546 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		if(a == 0) {
			System.out.println(0);
			return;
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int m = 0, sum = 0, t;
		while(st.hasMoreTokens()) {
			t = Integer.parseInt(st.nextToken());
			if(t > m) {
				m = t;
			}
			sum += t;
		}
		System.out.printf("%.2f",(sum / (double)m) * 100.0 / a);
	}
}
