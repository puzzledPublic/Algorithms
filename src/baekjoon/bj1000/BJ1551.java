package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//수열의 변화
public class BJ1551 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), ",");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < K; i++) {	//K번 수행
			for(int j = 1; j < N - i; j++) {	//한번씩 수행할때마다 수열의 숫자가 하나씩 줄어들기에 점차 감소
				arr[j - 1] = arr[j] - arr[j - 1];
			}
		}
		
		//N-K개만큼만 출력하면 된다.
		for(int i = 0; i < N - K - 1; i++) {
			bw.write(arr[i] + ",");
		}
		bw.write(arr[N - K - 1] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
