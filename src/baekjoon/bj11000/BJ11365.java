package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//!밀비 급일
public class BJ11365 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb;
		while(!(sb = new StringBuilder(br.readLine())).toString().equals("END")) {
			bw.write(sb.reverse().toString() + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
