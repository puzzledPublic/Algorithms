package algorithmsForPS;

import java.util.Scanner;

//격자 길
public class AfcLatticeRoad {
	static int H, W;
	static int answer;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		H = input.nextInt();
		W = input.nextInt();
		
		solve(0, 0);
		System.out.println(answer);
	}
	
	static void solve(int x, int y) {
		if(x > H || y > W) {
			return;
		}
		if(x == H && y == W) {
			answer++;
			return;
		}
		
		solve(x + 1, y);	//아래
		if((double)H/W <= (double)x/(y+1)) {	//기울기로 판정
			solve(x, y + 1);    //오른쪽
		}
	}
}
