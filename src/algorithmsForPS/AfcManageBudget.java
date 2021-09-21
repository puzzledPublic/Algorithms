package algorithmsForPS;

import java.util.Scanner;
//예산 관리
public class AfcManageBudget {
	static int budget, N;
	static int cost[];
	static int res;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		budget = input.nextInt();
		N = input.nextInt();
		cost = new int[N];
		for(int i = 0 ; i < N; i++) {
			cost[i] = input.nextInt();
		}
		System.out.println(solve(0, 0));
		
		solve2(1, 0);
		
		System.out.println(res);
	}
	
	static int solve(int currentCost, int currentActivity) {
		
		if(currentActivity == N) {
			if(currentCost <= budget) {
				return currentCost;
			}
			return 0;
		}
		//현재 활동을 선택한 경우, 선택하지 않은 경우로 나뉜다.
		return Math.max(solve(currentCost + cost[currentActivity], currentActivity + 1), solve(currentCost, currentActivity + 1));
		
	}
	
	static void solve2(int i, int sum) {
		if(i == N) {
			if(sum <= budget && sum > res) {
				res = sum;
			}
			return;
		}
		solve2(i + 1, sum + cost[i]);
		solve2(i + 1, sum);
	}
}
