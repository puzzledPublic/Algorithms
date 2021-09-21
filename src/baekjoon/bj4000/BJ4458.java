package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//첫 글자를 대문자로
public class BJ4458 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			bw.write(Character.toUpperCase(line.charAt(0)) + line.substring(1) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
