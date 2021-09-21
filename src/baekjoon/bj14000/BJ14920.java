package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//3n+1 수열
public class BJ14920 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int C = Integer.parseInt(br.readLine());
		
		int n = 1;
		while(C != 1) {
			if(C % 2 == 0) {
				C /= 2;
			}else {
				C = 3 * C + 1;
			}
			n++;
		}
		bw.write(n + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
}
