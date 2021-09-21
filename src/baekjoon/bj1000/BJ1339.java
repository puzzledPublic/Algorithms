package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//단어수학
public class BJ1339 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] alpha = new int[26];
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			int ten = (int)Math.pow(10, line.length() - 1);
			for(int j = 0; j < line.length(); j++) {
				alpha[line.charAt(j) - 65] += ten;
				ten /= 10;
			}
		}
		Arrays.sort(alpha);
		
		int result = 0;
		for(int i = 9; i >= 0; i--) {
			result += (alpha[16 + i] * i);
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
