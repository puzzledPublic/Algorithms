package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//가장 큰 감소 부분 수열
public class BJ17216 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[N];
		int[] sum = new int[N];	//i번째 수열까지 감소 수열을 이룰때 가장 큰 합.
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = arr[i];	//최소 자기 자신은 감소 수열이다.
		}
		int result = sum[0];
		for(int i = 0; i < N; i++) {
			int max = sum[i];
			for(int j = i - 1; j >= 0; j--) {
				if(arr[i] < arr[j]) {
					if(max < sum[j] + sum[i]) {
						max = sum[j] + sum[i];
					}
				}
			}
			sum[i] = max;
			if(result < sum[i]) {
				result = sum[i];
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
