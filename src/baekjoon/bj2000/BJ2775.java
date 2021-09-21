package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//부녀회장이 될테야
public class BJ2775 {
	static int[][] arr = new int[15][15];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		fill();
		
		int T = Integer.parseInt(br.readLine()), k, n;
		for(int i = 0; i < T; i++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			bw.write(arr[k][n - 1] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void fill() {
		for(int i = 0; i < 15; i++) {
			arr[0][i] = i + 1;
			arr[i][0] = 1;
		}
		for(int i = 1; i < 15; i++) {
			for(int j = 1; j < 15; j++) {
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
			}
		}
	}
}
