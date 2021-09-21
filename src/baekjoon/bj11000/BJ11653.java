package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//소인수분해
public class BJ11653 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int T = N;
		for(int i = 2; i * i <= N; i++) {
			while(T % i == 0) {
				bw.write(i + "\n");
				T /= i;
			}
		}
		if(T != 1) {
			bw.write(T + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
