package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//나머지와 몫이 같은 수
public class BJ1834 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long N = Long.parseLong(br.readLine());
		long result = 0;
		for(long i = 1; i < N; i++) {
			result += (N * i + i);
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
