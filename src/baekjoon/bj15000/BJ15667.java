package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2018 연세대학교 프로그래밍 경진대회
public class BJ15667 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		//k^2 + k + 1 = N; 이고 근의 공식을 사용하면 k = (-1 + sqrt(4 * N - 3)) / 2가 된다.
		int K = (int)((Math.sqrt((double)(4 * N - 3)) - 1) / 2);
		
		bw.write(K + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
