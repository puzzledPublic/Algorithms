package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//새끼치기
public class BJ17291 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] totalAmount = new int[N + 1];
		int[] evenYear = new int[N + 1];
		int[] oddYear = new int[N + 1];
		totalAmount[1] = oddYear[1] = 1;
		
		for(int i = 2; i <= N; i++) {
			totalAmount[i] = totalAmount[i - 1] * 2;
			if(i - 3 >= 0) {
				totalAmount[i] -= oddYear[i - 3];
			}
			if(i - 4 >= 0) {
				totalAmount[i] -= evenYear[i - 4];
			}
			if(i % 2 == 0) {
				evenYear[i] = totalAmount[i - 1];
			}else {
				oddYear[i] = totalAmount[i - 1];
			}
		}
		
		bw.write(totalAmount[N] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
