package algorithmsForPS;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class AfcMaximumSumL {
	static int N;
	static int[] S;
	static int[] DT = new int[1000];
	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "\\src\\test\\AfcMaximumSumL";
		
		try(Scanner input = new Scanner(new File(path))) {
			//입력
			N = input.nextInt();
			S = new int[N];
			for(int i = 0; i < N; i++) {
				S[i] = input.nextInt();
			}
			//처리
//			int result = -987654321;
//			for(int i = 0; i < N; i++) {
//				result = Math.max(solve(i), result);
//			}
//			System.out.println(result);
			
			Arrays.fill(DT, -987654321);
			int result = -987654321;
			for(int i = 0; i < N; i++) {
				result = Math.max(solve2(i), result);
			}
			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//재귀
	static int solve(int n) {	//solve(n) = n번째 요소를 마지막으로 하는 최대 부분합
		if(n == 0) {
			return S[0];
		}
		return Math.max(solve(n - 1) + S[n], S[n]);	//연속하는 부분합이므로 (n-1번째 요소까지의 최대 부분합 + 자기 자신)과 자기 자신 중 최대값이 solve(n)이 된다.
	}
	
	//메모이제이션
	static int solve2(int n) {
		if(n == 0) {
			return DT[n] = 0;
		}
		if(DT[n] == -987654321) {
			DT[n] = Math.max(solve2(n - 1) + S[n], S[n]);
		}
		return DT[n];
	}
}
