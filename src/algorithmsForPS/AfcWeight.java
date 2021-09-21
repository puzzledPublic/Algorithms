package algorithmsForPS;

import java.util.Scanner;

//저울 추
public class AfcWeight {
	static int W, end;
	static int weight[] = {1, 3, 9, 27, 81, 243, 729};
	static int chk[] = new int[7];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		W = input.nextInt();
		solve(W, 0);
	}
	
	static void solve(int n, int sum) {
		if(end == 1) {
			return;
		}
		if(sum == n) {	//균형이 맞으면
			for(int c = 2; c > 0; c--) {
				for(int i = 0; i < 7; i++) {
					if(chk[i] == c) {
						System.out.print(weight[i]+ " ");
					}
				}
				if(c == 2) {
					System.out.print("0 ");
				}
			}
			end = 1;	//종료
		}
		for(int i = 0; i < 7; i++) {
			if(chk[i] == 0) {
				chk[i] = 1;	//오른쪽에 두는 경우
				solve(n, sum + weight[i]);	
				chk[i] = 2;	//왼쪽에 두는 경우
				solve(n + weight[i], sum);
				chk[i] = 0;	//두지 않는 경우
			}
		}
	}
}
