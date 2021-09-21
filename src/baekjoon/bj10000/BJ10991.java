package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//별 찍기 - 16
public class BJ10991 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - i - 1; j++) {
				bw.write(" ");
			}
			for(int j = 0; j < i; j++) {
				bw.write("* ");
			}
			bw.write("*\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
