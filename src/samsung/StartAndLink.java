package samsung;

import java.util.Scanner;

//스타트와 링크 (백준 14889)
public class StartAndLink {
	static int N, result = 987654321;
	static int[][] S;
	static int[] st, lt;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		S = new int[N][N];
		st = new int[N/2];	//start팀
		lt = new int[N/2];	//link팀
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				S[i][j] = input.nextInt();
			}
		}
		solve(0, 0, 0);
		System.out.println(result);
	}
	static void solve(int cp, int s, int l) {
		if(cp == N) {
			int sr = 0, lr = 0;
			for(int i = 0; i < (N / 2) - 1; i++) {
				for(int j = i + 1; j < N / 2; j++) {
					sr += (S[st[i]][st[j]] + S[st[j]][st[i]]);
					lr += (S[lt[i]][lt[j]] + S[lt[j]][lt[i]]);
				}
			}
			int temp = Math.abs(sr - lr);
			if(result > temp) {
				result = temp;
			}
			return;
		}
		if(s < N / 2) {
			st[s] = cp;
			solve(cp + 1, s + 1, l);
			st[s] = 0;
		}
		if(l < N / 2) {
			lt[l] = cp;
			solve(cp + 1, s, l + 1);
			lt[l] = 0;
		}
	}
}
