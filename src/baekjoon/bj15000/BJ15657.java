package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.StringTokenizer;

//N과 M (8)
public class BJ15657 {
	static int N, M;
	static int[] numbers;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		result = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);	//증가하는 수열이여야하므로 정렬한다.
		solve(0, 0, bw);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int start, int m, Writer w) throws IOException {
		if(m == M) {	//M개를 선택했으면
			for(int i = 0; i < M; i++) {	//출력
				w.write(result[i] + " ");
			}
			w.write("\n");
			return;
		}
		//중복가능하므로 i = start부터 시작.
		for(int i = start; i < N; i++) {
			result[m] = numbers[i];
			solve(i, m + 1, w);
		}
	}
}
