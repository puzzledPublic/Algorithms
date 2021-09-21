package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//주사위 게임
public class BJ2476 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
			int prize = 0;
			if(a == b && b == c) {
				prize = 10000 + a * 1000;
			}else if(a == b) {
				prize = 1000 + a * 100;
			}else if(b == c) {
				prize = 1000 + b * 100;
			}else if(a == c) {
				prize = 1000 + c * 100;
			}else {
				if(a > b) {
					b = a;
				}
				if(b > c) {
					c = b;
				}
				prize = c * 100;
			}
			if(max < prize) {
				max = prize;
			}
		}
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
