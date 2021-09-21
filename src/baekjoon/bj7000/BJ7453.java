package baekjoon.bj7000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//합이 0인 정수
public class BJ7453 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][4];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 4; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] ab = new int[N * N];
		int[] cd = new int[N * N];
		int k = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				ab[k] = arr[i][0] + arr[j][1];	//a + b의 모든 경우
				cd[k] = arr[i][2] + arr[j][3];	//c + d의 모든 경우
				k++;
			}
		}
		
		Arrays.sort(cd);	//이분탐색을 위한 cd배열 정렬
		
		long answer = 0;	//입력 숫자가 모두 0인 경우 최악의 경우 답은 4000^4가 되므로 long 타입으로 선언
		for(int i = 0; i < N * N; i++) {	//각 ab배열 원소에 대해 cd 배열에서 이분탐색.
			int num = -ab[i];	//0이되려면 해당 숫자의 음수가 있어야한다.
			int lowerBound, upperBound;
			
			int start = 0, end = N * N;	//lowerBound 구하기
			while(start < end) {
				int mid = (start + end) / 2;
				if(cd[mid] < num) {
					start = mid + 1;
				}else {
					end = mid;
				}
			}
			lowerBound = start;
			start = 0;
			end = N * N;
			while(start < end) {	//upperBound 구하기
				int mid = (start + end) / 2;
				if(cd[mid] <= num) {
					start = mid + 1;
				}else {
					end = mid;
				}
			}
			upperBound = start;
			answer += (upperBound - lowerBound);	//합하여 0이 되는 숫자 개수
		}
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
