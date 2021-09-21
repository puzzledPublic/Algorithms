package java8;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	static int cache[] = new int[100];
	static int cache2[][] = new int[100][100];
	
	static int s[] = { 1,2,3};
	static int s2[] = { 10, 20, 30 };

	public static void main(String args[]) {
		Arrays.fill(cache, -1);
		for (int i = 0; i < cache2.length; i++) {
			Arrays.fill(cache2[i], -1);
		}/*
		 * int maxLength = 0; for (int begin = 0; begin < s.length; begin++) {
		 * maxLength = Math.max(maxLength, lis(begin)); }
		 * System.out.println(maxLength);
		 */
		int maxLength = 0;
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s2.length; j++) {
				maxLength = Math.max(maxLength, jlis(i, j));
			}
		}
		System.out.println(maxLength);
	}

	
	static int lis(int start) {
		if (cache[start] != -1) {
			return cache[start];
		}

		int ret = 1;

		for (int next = start + 1; next < s.length; next++) {
			if (s[start] < s[next]) {
				ret = Math.max(ret, lis(next) + 1);
			}
		}
		return ret;
	}

	
	static int jlis(int indexA, int indexB) {
		if (cache2[indexA][indexB] != -1) {
			return cache2[indexA][indexB];
		}
		
		int ret = 2;

		int a = s[indexA];
		int b = s2[indexB];
		int minElement = Math.min(a, b);
		if (s[indexA] != s2[indexB]) {
			for (int next = indexA + 1; next < s.length; next++) {
				if (minElement < s[next]) {
					ret = Math.max(ret, jlis(next, indexB) + 1);
				}
			}
			for (int next = indexB + 1; next < s2.length; next++) {
				if (minElement < s2[next]) {
					ret = Math.max(ret, jlis(indexA, next) + 1);
				}
			}
		}
		return ret;

	}
	static int lis2() {
		int max = 0;
		
		for(int i = 0; i < s.length; i++){
			for(int j = 0; j < i; j++){
				if(s[i] > s[j] && cache[i] < cache[j]+1){
					cache[i]++;
				}
			}
			if(cache[i] > max) max = cache[i];
		}
		
		return max+1;
	}
	static int lis3() {	//nlogn방법
		int N = 10, index = 0;
		int[] arr = new int[N];
		int[] dp = new int[N];
		dp[0] = arr[0];
		
		for(int j = 1; j < N; j++) {
			if(dp[index] < arr[j]) {	//증가 수열에서 마지막 숫자가 현재 배열 숫자보다 작은 경우 증가 수열에 잇는다.
				dp[++index] = arr[j];
			}else {
				int k = lowerBound(dp, index, arr[j]);
				dp[k] = arr[j];
			}
		}
		return index;
	}
	//현재까지 만든 증가 수열에서 n보다 크면서 가장 작은 수의 위치를 반환
	static int lowerBound(int[] dp, int end, int n) {
		int start = 0;
		while(start < end) {
			int mid = (start + end) / 2;
			if(dp[mid] >= n) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		return end;
	}
}
