package algorithmsForPS;

import java.io.File;
import java.util.Scanner;

public class AfcChangeMoneyL {
	static int M, N;
	static int[] moneys, DT = new int[10001];
	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "\\src\\test\\AfcChangeMoneyL";
		try(Scanner input = new Scanner(new File(path))) {
			M = input.nextInt();
			N = input.nextInt();
			moneys = new int[N];
			for(int i = 0; i < N; i++) {
				moneys[i] = input.nextInt();
			};
//			System.out.println(solve(0));
//			System.out.println(solve2(0));
			System.out.println(solve3());
//			System.out.println(solve4(M));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//재귀 (time out)
	static int solve(int k) {
		if(k == M) {
			return 0;
		}
		int result = 987654321;
		for(int i = 0; i < N; i++) {
			if(k + moneys[i] <= M) {
				result = Math.min(result, solve(k + moneys[i]) + 1);
			}
		}
		return result;
	}
	//메모이제이션
	static int solve2(int k) {
		if(k == M) {
			return DT[k] = 0;
		}
		if(DT[k] == 0) {
			DT[k] = 987654321;
			for(int i = 0; i < N; i++) {
				if(k + moneys[i] <= M) {
					DT[k] = Math.min(DT[k], solve2(k + moneys[i]) + 1);
				}
			}
		}
		return DT[k];
	}
	//동적계획법 (f(n) = n원일때 사용한 최소 동전 개수)
	static int solve3() {
		for(int i = 0; i < N; i++) {
			DT[moneys[i]] = 1;
		}
		for(int i = moneys[0]; i <= M; i++) {
			if(DT[i] == 0) {
				DT[i] = 987654321;
				for(int j = 0; j < N; j++) {
					if(i - moneys[j] > 0) {
						DT[i] = Math.min(DT[i], DT[i - moneys[j]] + 1);
					}
				}
			}
		}
		return DT[M];
	}
	
	static int solve4(int k) {
		for(int i = 0; i < N; i++) {
			if(moneys[i] == k) {
				return 1;
			}
		}
		if(DT[k] == 0) {
			DT[k] = 987654321;
			for(int i = 0; i < N; i++) {
				if(k - moneys[i] > 0) {
					DT[k] = Math.min(DT[k], solve4(k - moneys[i]) + 1);
				}
			}
		}
		return DT[k];
	}
}
