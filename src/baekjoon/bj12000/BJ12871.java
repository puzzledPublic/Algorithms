package baekjoon.bj12000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//무한 문자열
public class BJ12871 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String S = br.readLine();
		String T = br.readLine();
		while(S.length() <= 255) S += S;
		while(T.length() <= 255) T += T;
		bw.write((S.substring(0, 255).equals(T.substring(0, 255)) ? "1" : "0") + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
