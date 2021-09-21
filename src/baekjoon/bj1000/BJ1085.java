package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//직사각형에서 탈출
public class BJ1085 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());
		solve(x, y, w, h);
	}
	static void solve(int x, int y, int w, int h) {
		int a = x, b = w - x, c = y, d = h - y;
		System.out.println(Math.min(a, Math.min(b, Math.min(c, d))));
	}
}
