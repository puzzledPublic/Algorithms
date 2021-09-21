package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//알파벳 찾기
public class BJ10809 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] alpha = new int[26];
		String s = br.readLine();
		for(int i = 0; i < alpha.length; i++) {
			alpha[i] = -1;
		}
		int index = 0;
		for(int i = 0; i < s.length(); i++) {
			index = s.charAt(i) - 97;
			if(alpha[index] == -1) {
				alpha[index] = i;
			}
		}
		for(int i = 0; i < alpha.length; i++) {
			bw.write(alpha[i] + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
