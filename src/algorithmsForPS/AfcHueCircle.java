package algorithmsForPS;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

//색 상환
public class AfcHueCircle {
	static int N, K, ans;
	static int Mod = 1000000003;
	static int[][] DT = new int[1001][1001];
	static int[][][] DBT = new int[1001][1001][2];
	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "\\src\\test\\AfcHueCircle";
		try(Scanner input = new Scanner(new File(path))) {
			N = input.nextInt();
			K = input.nextInt();
			
//			System.out.println(solve(N, K));
			
//			System.out.println(solve2(N, K));
			
//			System.out.println(solve3(N, K));
			
//			solve4(1, 0, true);	//첫번째(인덱스 = 0)를 고르지 않은 경우 다음으로 넘어간다. 이때 마지막 (인덱스 = n)은 고를 수 있다.(true)
//			solve4(2, 1, false);//첫번째를 고른 경우 다음 것은 못 고르므로 다다음으로 넘어간다. 이때 마지막은 고를 수 없다.(false)
//			System.out.println(ans);
			
			for(int i = 0; i < DBT.length; i++) {
				for(int j = 0; j < DBT[0].length; j++) {
					Arrays.fill(DBT[i][j], -1);
				}
			}
			System.out.println((solve5(1, 0, 1) + solve5(2, 1, 0)) % Mod);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//재귀
	//f(n, k) = f(n - 2, k - 1) + f(n - 1, k)
	//f(n - 2, k - 1) = 첫번째, 두번째 색 중 이미 하나를 고른 경우
	//f(n - 1, k) = 첫번째, 두번째 색 둘 다 고르지 않은 경우
	static int solve(int n, int k) {
		if(k > n / 2) {
			return 0;
		} else if(k == 1) {
			return n;
		} else {
			return (solve(n - 2, k - 1) + solve(n - 1, k)) % Mod;
		}
	}
	//메모이제이션 (하향식)
	static int solve2(int n, int k) {
		if(k > n / 2) {
			DT[n][k] = 0;
		} else if(k == 1) {
			DT[n][k] = n;
		} else {
			if(DT[n][k] == 0) {
				DT[n][k] = (solve2(n - 2, k - 1) + solve2(n - 1, k)) % Mod;
			}
		}
		return DT[n][k];
	}
	//동적계획법 (상향식)
	static int solve3(int n, int k) {
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j <= n / 2; j++) {
				if(j == 1) {
					DT[i][j] = i;
				} else {
					DT[i][j] = (DT[i - 2][j - 1] + DT[i - 1][j]) % Mod;
				}
			}
		}
		return DT[n][k];
	}
	//다이나미컬 백트래킹
	static void solve4(int a, int b, boolean can) {
		if(a >= N || b == K) {
			if(b == K && (a <= N || can)) {
				ans++;
				ans %= Mod;
			}
			return;
		}
		solve4(a + 1, b, can); //첫번째를 고르지 않은 경우
		solve4(a + 2, b + 1, can);	//첫번째를 고른 경우
	}
	//다이나미컬 백트래킹 + 메모이제이션
	static int solve5(int a, int b, int can) {
		if(a >= N || b == K) {
			if(b == K && (a <= N || can == 1)) {
				return 1;
			}
			return 0;
		} else if(DBT[a][b][can] == -1) {
			DBT[a][b][can] = (solve5(a + 1, b, can) + solve5(a + 2, b + 1, can)) % Mod;
		}
		return DBT[a][b][can];
	}
}
