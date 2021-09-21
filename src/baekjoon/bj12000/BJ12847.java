package baekjoon.bj12000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//꿀 아르바이트
public class BJ12847 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		bw.write(solve(arr, M) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static long solve(int[] arr, int M) {
		long t = 0, max = 0;
		int start = 0, end = M;
		
		for(int i = start; i < end; i++) {	//첫날부터 M일까지 근무했을때 이익
			t += arr[i];
		}
		max = t;
		for(int i = end; i < arr.length; i++) {	//a일부터 a + M일까지 근무했을때 이익
			t += (arr[i] - arr[start++]);
			if(max < t) {	//최대 이익 계산
				max = t;
			}
		}
		return max;
	}
}
