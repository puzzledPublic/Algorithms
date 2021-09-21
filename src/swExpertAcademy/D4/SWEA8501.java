package swExpertAcademy.D4;

import java.util.Scanner;

//은비의 동전 뒤집기
public class SWEA8501 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		
		long[] facto = new long[1001];
		long[] dp = new long[1001];
		long MOD = 1_000_000_007;
		
		
		facto[0] = 1;
		for(int i = 1; i <= 1000; i++) {
			facto[i] = (facto[i - 1] * i) % MOD;
		}
		dp[1] = 0;
		for(int i = 2; i <= 1000; i++) {
			dp[i] = (((dp[i - 1] * i) % MOD) + ((i / 2) * facto[i - 1]) % MOD) % MOD;	//?????
		}
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = input.nextInt();
			System.out.println("#" + test_case + " " + dp[N]);
		}
	}
}

//어떤 동전 숫자를 기준으로 숫자보다 작은 동전들이 왼쪽에 홀수개 존재하면 현재 동전은 앞면이다
//public class SWEA8501 {
//	public static void main(String[] args) {
//		
//		Scanner input = new Scanner(System.in);
//		int T = input.nextInt();
//		
//		long[][] combi = new long[1001][1001];
//		long[] facto = new long[1001];
//		long mod = 1_000_000_007;
//		combi[0][0] = 1;
//		for(int i = 1; i <= 1000; i++) {
//			for(int j = 0; j <= i; j++) {
//				if(i == j || j == 0) {
//					combi[i][j] = 1;
//				}else if(j == 1) {
//					combi[i][j] = i;
//				}else {
//					combi[i][j] = (combi[i - 1][j - 1] + combi[i - 1][j]) % mod;
//				}
//			}
//		}
//		
//		facto[0] = 1;
//		for(int i = 1; i <= 1000; i++) {
//			facto[i] = (facto[i - 1] * i) % mod;
//		}
//		
//		for(int test_case = 1; test_case <= T; test_case++) {
//			int N = input.nextInt();
//			
//			int fn, fr, bn, br;
//			
//			long result = 0;
//			for(int g = 2; g <= N; g++) {
//				fn = g - 1;
//				bn = N - g;
//				
//				for(int i = 1; i <= fn; i += 2) {
//					long sub = 0;
//					for(int j = 0; j <= bn; j++) {
//						sub = (sub + ((((combi[bn][j] * facto[i + j]) % mod) * facto[fn - i + bn - j]) % mod)) % mod;
//						System.out.print("(" + fn + "C" + i + ") (" + bn + "C" + j + ") " + (i + j) + "! " + (fn - i + bn - j) + "! ");
//						System.out.println((((((combi[fn][i] * combi[bn][j]) % mod) * facto[i + j]) % mod) * facto[fn - i + bn - j]) % mod);
//					} 
//					result = (result + (sub * combi[fn][i]) % mod) % mod;
//				}
//			}
//			
//			System.out.println("#" + test_case + " " + result);
//		}
//	}
//}
