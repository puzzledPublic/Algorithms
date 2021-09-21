package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//노솔브 방지문제야!!
public class BJ15917 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int Q = Integer.parseInt(br.readLine());
		for(int i = 0; i < Q; i++) {
			int a = Integer.parseInt(br.readLine());
			bw.write(((a & -a) == a ? "1\n" : "0\n"));	//숫자 a가 2의 제곱으로 나타낼 수 있는가 여부 (a & -a == a)
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
