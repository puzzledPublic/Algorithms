package samsung;

import java.util.Arrays;
import java.util.Scanner;

//톱니바퀴 (백준 14891)
public class ToothedWheel {
	static char[][] toothedWheels = new char[4][8];
	static boolean[] checked = new boolean[4]; //양옆으로 재귀하므로 중복접근 방지하기 위한 체크 배열
	static int num;
	static int[][] nad;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < 4; i++) {
			toothedWheels[i] = input.next().toCharArray();	
		}
		num = input.nextInt();
		nad = new int[num][2];
		for(int i = 0; i < num; i++) {
			nad[i][0] = input.nextInt();
			nad[i][1] = input.nextInt();
		}
		//톱니바퀴 회전
		int t;
		for(int i = 0; i < num; i++) {
			t = nad[i][0] - 1;
			checked[t] = true;
			solve(t, nad[i][1]);
			Arrays.fill(checked, false);
		}
		//출력계산
		int result = 0, c = 1;
		for(int i = 0; i < 4; i++) {
			if(toothedWheels[i][0] == '1') {
				result += c;
			}
			c *= 2;
		}
		System.out.println(result);
	}
	
	static void solve(int n, int d) {
		//회전하는 톱니바퀴 기준으로 양옆으로 재귀
		if(n - 1 >= 0 && toothedWheels[n - 1][2] != toothedWheels[n][6] && checked[n - 1] == false) {
			checked[n - 1] = true;
			solve(n - 1, -d);
		}
		if(n + 1 <= 3 && toothedWheels[n][2] != toothedWheels[n + 1][6] && checked[n + 1] == false) {
			checked[n + 1] = true;
			solve(n + 1, -d);
		}
		rotate(n, d);
	}
	
	static void rotate(int n, int d) {
		if(d == -1) {	//반시계 방향
			char temp = toothedWheels[n][0];
			for(int i = 1; i < 8; i++) {
				toothedWheels[n][i - 1] = toothedWheels[n][i];
			}
			toothedWheels[n][7] = temp;
		} else {	//시계 방향
			char temp = toothedWheels[n][7];
			for(int i = 6; i >= 0; i--) {
				toothedWheels[n][i + 1] = toothedWheels[n][i];
			}
			toothedWheels[n][0] = temp;
		}
	}
}
