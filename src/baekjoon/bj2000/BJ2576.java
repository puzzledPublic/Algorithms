package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//홀수
public class BJ2576 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int sum = 0, min = 101;
		for(int i = 0; i < 7; i++) {
			int t = Integer.parseInt(br.readLine());
			if(t % 2 != 0) {
				sum += t;
				if(t < min) {
					min = t;
				}
			}
		}
		if(sum > 0) {
			bw.write(sum + "\n" + min);
		}else {
			bw.write("-1\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
