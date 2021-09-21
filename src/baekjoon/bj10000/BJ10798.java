package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

//세로읽기
public class BJ10798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[][] arr = new char[5][15];
		for(int i = 0; i < 5; i++) {
			String s = br.readLine();
			for(int j = 0; j < s.length(); j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		solve(arr, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(char[][] arr, Writer w) throws IOException {
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 5; j++) {
				if(arr[j][i] != '\0') {
					w.write(arr[j][i]);
				}
			}
		}
		w.write("\n");
	}
}
