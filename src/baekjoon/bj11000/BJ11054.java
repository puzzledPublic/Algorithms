package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//가장 긴 바이토닉 수열
public class BJ11054 {
	static int[] dpToRight;
	static int[] dpToLeft;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		dpToRight = new int[N];	//오른쪽방향으로 진행할때(0->N) i까지의 최대 증가수열 길이
		dpToLeft = new int[N];	//왼쪽방향으로 진행할때(N->0) i까지의 최대 증가수열 길이
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dpToRight[i] = dpToLeft[i] = 1;	//기본 1의 길이를 가지므로 1로 초기화
		}
		for(int i = 0; i < N; i++) {	//dp[i] = i까지의 최대 증가수열 길이 => (j = 0 ~ i-1) 구간에서 arr[j] < arr[i]이고 dp[i] < dp[j] + 1인경우 dp[i] = dp[j] + 1이다.
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && dpToRight[i] < dpToRight[j] + 1) {
					dpToRight[i] = dpToRight[j] + 1;
				}
				if(arr[N - j - 1] < arr[N - i - 1] && dpToLeft[N - i - 1] < dpToLeft[N - j - 1] + 1) {
					dpToLeft[N - i - 1] = dpToLeft[N - j - 1] + 1;
				}
			}
		}
		//여기서 구하는것은 바이토닉 수열이므로 arr[i]를 기준으로 오른쪽에서 증가해오는 수열, 왼쪽에서 증가해오는 수열이 있을때의 합을 구한다. 그리고 arr[i]가 중복되므로 1을 제외한 수가 답이다.
		int max = 0;
		for(int i = 0; i < dpToRight.length; i++) {
			if(max < dpToLeft[i] + dpToRight[i]) {
				max = dpToLeft[i] + dpToRight[i];
			}
		}
		bw.write((max - 1) + "\n");
		bw.flush();
		bw.close();
	}
}
/*public class BJ11054 {	//통과. but 시간 오래걸림.
	static int[] dp;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		dp = new int[N];
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for(int i = 0; i < N; i++) {
			Arrays.fill(dp, -1);
			int left = solveLeft(i);
			dp[i] = -1;
			int right = solveRight(i);
			max = Math.max(max, left + right);
		}
		bw.write((max - 1) + "\n");
		bw.flush();
		bw.close();
	}
	static int solveLeft(int start) {
		if(dp[start] != -1) {
			return dp[start];
		}
		int result = 1;
		for(int i = start - 1; i >= 0; i--) {
			if(arr[start] > arr[i]) {
				result = Math.max(result, solveLeft(i) + 1);
			}
		}
		return dp[start] = result;
	}
	static int solveRight(int start) {
		if(dp[start] != -1) {
			return dp[start];
		}
		int result = 1;
		for(int i = start + 1; i < arr.length; i++) {
			if(arr[start] > arr[i]) {
				result = Math.max(result, solveRight(i) + 1);
			}
		}
		return dp[start] = result;
	}
}*/
