package baekjoon.bj1000;

import java.util.Scanner;

//리모컨
public class BJ1107 {
	static int CH, B, N, Min;
	static boolean[] brokenButton = new boolean[10];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		CH = input.nextInt();
		B = input.nextInt();
		for(int i = 0; i < B; i++) {
			brokenButton[input.nextInt()] = true;
		}
		Min = CH > 100? CH - 100 : 100 - CH;
		if(B == 10) {
			System.out.println(Min);
			return;
		}
		solve(1, 0, 0);
		System.out.println(Min);
	}
	//모든 경우에 대해 돌면서(0~999999) +,-로만 가는게 더빠른지 숫자를 눌러 이동하는게 더 빠른지 비교한다
	static void solve(int n, int k, int g) {
		if(k == 7) {
			return;
		}
		if(k != 0) {
			if(CH > g) {
				if(Min > CH - g + k) {
					Min = CH - g + k;
				}
			}else if(CH < g) {
				if(Min > g - CH + k) {
					Min = g - CH + k;
				}
			}else {
				if(Min > k) {
					Min = k;
				}
			}
		}
		for(int i = 0; i < 10; i++) {
			if(!brokenButton[i]) {
				solve(i, k + 1, g * 10 + i);
			}
		}
	}
}
