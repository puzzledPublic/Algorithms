package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//수빈이와 수열
public class BJ10539 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long prevB = 0, currentB;
		for(int i = 1; i < N + 1; i++) {
			currentB = Long.parseLong(st.nextToken());
			bw.write(((i * currentB) - ((i - 1) * prevB)) + " ");	//문제로 부터(n*Bn = A(1~n-1)의 합 + An)의 수식을 알 수 있고 이를 풀어보면 An = n*Bn - (n-1)*B(n-1)임을 알 수 있다.
			prevB = currentB;
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
