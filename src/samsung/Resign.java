package samsung;

import java.util.Scanner;
//퇴사 (백준 14501)
public class Resign {
	static int N;
	static int[] T, P;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		T = new int[N];
		P = new int[N];
		for(int i = 0; i < N; i++) {
			T[i] = input.nextInt();
			P[i] = input.nextInt();
		}
		
		System.out.println(solve(0, N));
	}
	
	static int solve(int k, int day) {	//k번째날 까지 상담을 잡았을때 최대 보수
		if(k == N) {
			return 0;
		}
		int result = 0;
		if(N - k >= T[k] && day >= T[k]) {
			result = solve(k + T[k], day - T[k]) + P[k];	//그날 상담 잡는 경우 (잡았다면 k + T[k]만큼 상담을 못하므로 뛰어넘는다)
		}
		result = Math.max(result, solve(k + 1, day - 1));	//그날 상담을 잡지 않는 경우 (못잡으면 그날은 아예 무시하므로 day - 1)
		
		return result;
	}
}
