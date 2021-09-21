package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//걷다보니 신천역 삼 (Small)
public class BJ14650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		bw.write((N == 1 ? 0 : (int)Math.pow(3, N - 2) * 2) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
