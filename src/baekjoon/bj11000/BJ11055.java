package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//가장 큰 증가 부분 순열
public class BJ11055 {
	static int[] arr;
	static int[] DP;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		DP = new int[N];	//i번째 숫자부터 증가수열을 이룰때 가장 큰 증가하는 수열의 합
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			DP[i] = arr[i];
		}
		
//		int result = 0;
//		for(int i = 0; i < N; i++) {	//solve(i)는 i번째 숫자부터 시작하는 증가수열을 구하므로 모든 경우를 탐색하려면 0 ~ N까지 모두 살펴봐야한다. ex) 9 8 9 8 9
//			result = Math.max(result, solve(i));
//		}
//		bw.write(result + "\n");
		
		bw.write(solve2(N) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int start) {
		if(start == arr.length) {	//끝에 도달하면 0
			return 0;
		}
		if(DP[start] != arr[start]) {
			return DP[start];
		}
		for(int i = start + 1; i < arr.length; i++) { //(start+1) ~ 끝까지 돌며 현재 숫자보다 크면 증가수열을 이루고 이를 재귀 탐색한다.
			if(arr[start] < arr[i]) {
				DP[start] = Math.max(DP[start], solve(i) + arr[start]);
			}
		}
		return DP[start];
	}
	
	static int solve2(int N) {
		int[] DP = new int[N];	//i번째 숫자까지 증가수열을 이룰때 가장 큰 증가하는 수열의 합
		for(int i = 0; i < N; i++) {
			DP[i] = arr[i];
		}
		for(int i = 0; i < N; i++) {	//i번째 숫자
			for(int j = 0; j < i; j++) {	//i번째 이전 숫자
				if(arr[j] < arr[i]) {	//현재(i)숫자 보다 이전(j)숫자가 작을 경우 증가 수열을 이룬다.
					DP[i] = Math.max(DP[i], DP[j] + arr[i]);
				}
			}
		}
		int result = 0;
		for(int i = 0; i < N; i++) {	//각 i번째 숫자로 끝나는 가장 큰 증가 수열의 합 중 가장 큰것을 고른다.
			if(result < DP[i]) {
				result = DP[i];
			}
		}
		return result;
	}
}
