package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//하노이 탑 이동 순서
public class BJ11729 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		bw.write(hanoi(N, 1, 2, 3) + "\n");
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
	static int hanoi(int n, int from, int temp, int to) throws IOException {
		if(n == 1) {
			sb.append(from + " " + to + "\n");
			return 1;
		}
		int count = 1;
		count += hanoi(n - 1, from, to, temp);
		sb.append(from + " " + to + "\n");
		count += hanoi(n - 1, temp, from, to);
		return count;
	}
}
