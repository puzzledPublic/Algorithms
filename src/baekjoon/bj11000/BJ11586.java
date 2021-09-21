package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//지영 공주님의 마법 거울
public class BJ11586 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		char[][] mirror = new char[N][];
		for(int i = 0; i < N; i++) {
			mirror[i] = br.readLine().toCharArray();
		}
		int K = Integer.parseInt(br.readLine());
		switch(K) {
		case 1:
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					bw.write(mirror[i][j]);
				}
				bw.write("\n");
			}
			break;
		case 2:
			for(int i = 0; i < N; i++) {
				for(int j = N - 1; j >= 0; j--) {
					bw.write(mirror[i][j]);
				}
				bw.write("\n");
			}
			break;
		case 3:
			for(int i = N - 1; i >= 0; i--) {
				for(int j = 0; j < N; j++) {
					bw.write(mirror[i][j]);
				}
				bw.write("\n");
			}
			break;
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
