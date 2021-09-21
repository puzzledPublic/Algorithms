package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//다이나믹 롤러
public class BJ17393 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] ink = new long[N];	//잉크 지수
		long[] viscosity = new long[N];	//점도 지수
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			ink[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			viscosity[i] = Long.parseLong(st.nextToken());
		}
		
		for(int i = 0; i < N - 1; i++) {
			long currInk = ink[i];	//i번째 타일의 잉크 지수
			int start = i, end = N;	//(i + 1) ~ N까지 타일의 점도 지수 구간에서 점도 지수가 currInk보다 같거나 큰 위치 중 제일 작은 위치를 구한다. (점도 지수가 오름차순이므로 이분탐색을 사용 할 수 있다.)
			while(start < end) {
				int mid = (start + end) / 2;
				if(currInk >= viscosity[mid]) {
					start = mid + 1;
				}else {
					end = mid;
				}
			}
			bw.write((start - (i + 1)) + " ");	//최대로 칠할 수 있는 칸의 개수
		}
		bw.write("0\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
