package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//부분집합의 합
public class BJ1182 {
	static int N, S, count;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0, 0);
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		br.close();
	} 
	
	static void solve(int start, int sum) {
		if(start == N) {
			return;
		}
		int t= sum + arr[start];
		if(t == S) {
			count++;
		}
		solve(start + 1, t);	//현재 숫자를 고른 경우
		solve(start + 1, sum);	//현재 숫자를 고르지 않은 경우
	}
}
