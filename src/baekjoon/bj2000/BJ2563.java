package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//색종이
public class BJ2563 {
	static boolean[][] paper = new boolean[101][101];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), x, y, count = 0;
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			for(int j = y; j < y + 10; j++) {
				for(int k = x; k < x + 10; k++) {
					if(paper[j][k] != true) {
						count++;
						paper[j][k] = true;
					}
				}
			}
		}
		System.out.println(count);
	}
}
