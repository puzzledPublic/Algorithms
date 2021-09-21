package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//평행 우주
public class BJ17451 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long[] arr = new long[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		long speed = 0;
		
		//뒤에서부터 최소 속력을 계산한다.
		//speed = arr[i]보다 크면서 arr[i]의 배수
		for(int i = N - 1; i >= 0; i--) {
			if(arr[i] >= speed) {
				speed = arr[i];
			}else {
				speed = arr[i] * (speed % arr[i] == 0 ? (speed / arr[i]) : (speed / arr[i]) + 1);
			}
		}
		
		bw.write(speed + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
