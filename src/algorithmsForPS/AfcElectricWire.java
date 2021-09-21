package algorithmsForPS;

import java.util.Arrays;
import java.util.Scanner;

//전깃줄 (초)
public class AfcElectricWire {
	static int N;
	static int wires[], wired[];
	static int cache[];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		wires = new int[N + 1];
		wired = new int[N + 1];
		cache = new int[N + 2];
		Arrays.fill(cache, -1);
		int index = 0;
		for(int i = 1; i < N + 1; i++) {
			wires[i] = input.nextInt();
			wired[i] = input.nextInt();
		}
		
		for(int i = 1 ; i < N; i++) {
			for(int j = i + 1; j < N + 1; j++) {
				if(wires[i] > wires[j]) {
					int temp = wires[i];
					wires[i] = wires[j];
					wires[j] = temp;
					temp = wired[i];
					wired[i] = wired[j];
					wired[j] = temp;
				}
			}
		}
		
		//solve
		int maxLen = 0;
		for(int i = 1; i < N + 1; i++) {
			maxLen = Math.max(maxLen, solve(i));
		}
		System.out.println(N - maxLen);
		
		//solve2
		int t = 0;
		for(int i = 1; i < N + 1; i++) {
			t = Math.max(t, solve(i));
		}
		System.out.println(N - t);
	}
	//LIS 알고리즘(N^2)
	static int solve(int start) {
		
		if(cache[start] != -1) {
			return cache[start];
		}
		cache[start] = 1;
		for(int i = start + 1; i < N + 1; i++) {
			if(wired[start] < wired[i]) {
				cache[start] = Math.max(cache[start], solve(i) + 1);
			}
		}
		return cache[start];
	}
	static int solve2(int start) {
		int count = 1;
		for(int i = start - 1; i >= 1; i--) {
			if(wired[start] > wired[i]) {
				count = Math.max(count, solve(i) + 1);
			}
		}
		return count;
	}
}
