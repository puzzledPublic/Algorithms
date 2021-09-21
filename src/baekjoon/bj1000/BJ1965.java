package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//상자넣기
public class BJ1965 {
	static int N;
	static int[] arr, dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
//		int result = 0;
//		for(int i = 0; i < N; i++) {
//			result = Math.max(result, solve(i));
//		}
//		bw.write(result + "\n");
		
		bw.write(solve3() + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	//LIS 메모이제이션(하향식) O(n^2)
	static int solve(int start) {
		if(start == N) {
			return 1;
		}
		if(dp[start] != 0) {
			return dp[start];
		}
		dp[start] = 1;
		for(int i = start + 1; i < N; i++) {
			if(arr[start] < arr[i]) {
				dp[start] = Math.max(dp[start], solve(i) + 1);
			}
		}
		return dp[start];
	}
	
	//동적계획법(상향식) O(n^2)
	static int solve2() {
		int max = 0;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < i; j++){
				if(arr[i] > arr[j] && dp[i] < dp[j]+1){
					dp[i]++;
				}
			}
			if(dp[i] > max) max = dp[i];
		}
		
		return max+1;
	}
	
	//O(nlogn)
	static int solve3() {
		int index = 0;
		dp[0] = arr[0];
		for(int i = 1; i < N; i++) {
			if(dp[index] < arr[i]) {
				dp[++index] = arr[i];
			}else {
				int k = lowerBound(index, arr[i]);
				dp[k] = arr[i];
			}
		}
		return index + 1;
	}
	
	static int lowerBound(int index, int n) {	//dp 배열에서 n보다 크면서 가장 작은 수의 인덱스를 리턴
		int start = 0;
		while(start < index) {
			int mid = (start + index) / 2;
			if(dp[mid] >= n) {
				index = mid;
			}else {
				start = mid + 1;
			}
		}
		return index;
	}
}
