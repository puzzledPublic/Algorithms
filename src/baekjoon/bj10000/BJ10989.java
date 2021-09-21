package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

//수 정렬하기 3 (카운팅 정렬)
public class BJ10989 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];	//최대숫자를 알아야 카운팅 정렬 가능 (문제에서 최대 10000)
		for(int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		solve(arr, bw);
		bw.close();
		br.close();
	}
	
	static void solve(int[] arr, Writer w) throws IOException {	//숫자들의 횟수를 세서 0 부터 최대 숫자까지 각 숫자 횟수만큼 출력
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i]; j++) {
				w.write(i + "\n");
			}
		}
		w.flush();
	}
}
