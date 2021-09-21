package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//좌표 정렬하기
public class BJ11650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (a, b) -> {
			int result = Integer.compare(a[0], b[0]);	//x좌표 순으로
			if(result == 0) {	//x좌표가 같은 경우
				return Integer.compare(a[1], b[1]);	//y좌표 순으로
			}
			return result;
		}); 
		for(int i = 0; i < N; i++) {
			bw.write(arr[i][0] + " " +arr[i][1] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
