package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//나누기
public class BJ1075 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()), F = Integer.parseInt(br.readLine());
		N = (N / 100) * 100;
		for(int i = N; i < N + 100; i++) {
			if(i % F == 0) {
				if((i % 100) < 10) {
					bw.write("0");
				}
				bw.write((i % 100) + "\n");
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
