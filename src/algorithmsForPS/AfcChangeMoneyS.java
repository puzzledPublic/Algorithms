package algorithmsForPS;

import java.util.Scanner;
//거스름 돈(S)
public class AfcChangeMoneyS {
	static int M, N;
	static int coin[];
	static int answer = 987654321; 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		M = input.nextInt();
		N = input.nextInt();
		coin = new int[N];
		for(int i = 0; i < N; i++) {
			coin[i] = input.nextInt();
		}
		
		/*solve(0,0);
		System.out.println(answer);*/
		
		solve2(0,0,0);
		System.out.println(answer);
		
	}
	//time fail
	static void solve(int currentSum, int depth) {
		if(currentSum > M) {
			return;
		}
		if(currentSum == M) {
			if(depth < answer) {
				answer = depth;
			}
			return;
		}
		for(int i = 0; i < N; i++) {
			solve(currentSum + coin[i], depth + 1);
		}
	}
	
	static void solve2(int currentSum, int k, int cnt) {
		if(k == N || currentSum > M) {
			if(currentSum == M) {
				if(answer > cnt) {
					answer = cnt;
				}
			}
			return;
		}
		if(currentSum == M) {
			if(answer > cnt) {
				answer = cnt;
			}
			return;
		}
		for(int i = 0; currentSum + coin[k] * i <= M; i++) {
			solve2(currentSum + coin[k] * i, k + 1, cnt + i);
		}
	}
}
