package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//3의 배수
public class BJ16561 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		for(int i = 3; i < N; i += 3) {
			for(int j = 3; j < N; j += 3) {
				if(N - (i + j) >= 3 && (N - (i + j)) % 3 == 0) {
					count++;
				}
			}
		}
		
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
