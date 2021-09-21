package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;

//로프
public class BJ2217 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		solve(arr, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int[] arr, Writer w) throws IOException {
		Arrays.sort(arr);	//로프가 버티는 중량으로 오름차순 정렬한다 
		int max = 0, t = 0;
		for(int i = 0; i < arr.length; i++) {	//arr[i] * (arr.length - i) = i번째 로프 중량을 n - i개 만큼 더한 중량
			t = arr[i] * (arr.length - i);
			if(max < t) {	//그 가능한 중량 중 최대값
				max = t;
			}
		}
		w.write(max + "\n");
	}
}
