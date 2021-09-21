package java8;

import java.util.Scanner;

//N-QUEEN
public class Jungol1889 {
	static boolean[] col, inc, dec;
	static int N;
	static int answer;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		col = new boolean[N+1];	//행 체크 배열
		inc = new boolean[N+N+1];	//상향 대각선 체크 배열
		dec = new boolean[N+N+1];	//하향 대각선 체크 배열
		
		solve(1);
		System.out.println(answer);
	}
	static void solve(int r){
		if(r > N){
			answer++;
			return;
		}
		for(int i = 1; i <= N; i++){
			if(!col[i] && !inc[r + i] && !dec[N + (r - i) + 1]){
				col[i] = inc[r + i] = dec[N + (r - i) + 1] = true;
				solve(r+1);
				col[i] = inc[r + i] = dec[N + (r - i) + 1] = false;
			}
		}
	}
}
