package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Milk Pails(Bronze)
public class BJ11999 {
	static int max = 0, X, Y, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		solve(0);
		br.close();
	}
	static void solve(int sum) {
		for(int i = 0; i <= M / X; i++) {	//X로 M을 넘지않게 채울 수 있는 최대 횟수
			int t = 0;
			t += (X * i);	//X를 늘려가며 채워놓고
			max = Math.max(max, M - ((M - t) % Y));	//Y를 채울 수 있는 만큼 채워서 max값 비교
		}
		System.out.println(max);
	}
}
