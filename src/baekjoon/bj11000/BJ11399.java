package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.StringTokenizer;

//ATM (그리디)
public class BJ11399 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		solve(arr, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int[] arr, Writer w) throws IOException {
		Arrays.sort(arr);	//시간을 적게쓰는 사람을 먼저 세워야 모든 인원의 인출 시간이 최소가 된다.
		int sum = arr[0];
		for(int i = 1; i < arr.length; i++) {
			sum += (arr[i] += arr[i - 1]);
		}
		w.write(sum + "\n");
	}
}
