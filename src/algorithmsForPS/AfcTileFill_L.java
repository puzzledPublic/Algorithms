package algorithmsForPS;

import java.io.File;
import java.util.Scanner;

//타일 채우기 L
public class AfcTileFill_L {
	static int N, M;
	static int[] DT = new int[10000];
	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "\\src\\test\\AfcTileFill_L";
		try(Scanner input = new Scanner(new File(path))) {
			N = input.nextInt();
			M = input.nextInt();
//			System.out.println(solve(N));
//			System.out.println(solve2(N));
//			System.out.println(solve3(N));
			System.out.println(solve4(N));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	//재귀
	static int solve(int n) {
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 3;
		}
		return (solve(n - 1) + 2 * solve(n - 2)) % M;
	}
	//메모이제이션
	static int solve2(int n) {
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 3;
		}
		if(DT[n] == 0) {
			DT[n] = (solve2(n - 1) + 2 * solve2(n - 2)) % M;
		}
		return DT[n];
	}
	//동적계획법
	static int solve3(int n) {
		DT[1] = 1;
		DT[2] = 3;
		for(int i = 3; i < n + 1; i++) {
			DT[i] = (DT[i - 1] + 2 * DT[i - 2]) % M;
		}
		return DT[n];
	}
	// N / 2 로 분할하여 메모이제이션
	static int solve4(int n) {
		if(n <= 1) {
			return DT[n] = 1;
		} else {
			if(DT[n] == 0) {
				if(n % 2 == 0) {
					DT[n] = (solve4(n / 2) * solve4(n / 2) + 2 * solve4(n / 2 - 1) * solve4(n / 2 - 1)) % M;
				}else {
					DT[n] = (solve4(n / 2 + 1) * solve4(n / 2) + 2 * solve4(n / 2 - 1) * solve4(n / 2)) % M;
				}
			}
		}
		return DT[n];
	}
}
