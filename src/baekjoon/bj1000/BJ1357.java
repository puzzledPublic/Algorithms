package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//뒤집힌 덧셈
public class BJ1357 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		StringBuilder X = new StringBuilder(st.nextToken());
		StringBuilder Y = new StringBuilder(st.nextToken());
		StringBuilder Z = new StringBuilder(Integer.toString((Integer.parseInt(X.reverse().toString()) + Integer.parseInt(Y.reverse().toString()))));
		
		bw.write(Integer.parseInt(Z.reverse().toString()) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
