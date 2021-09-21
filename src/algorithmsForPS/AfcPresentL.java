package algorithmsForPS;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

//선물 L
public class AfcPresentL {
	static int N, sum;
	static int[] presents;
	static boolean[][][] DP;	//DP[n][a][b] = n번째 선물을 받고 길순이가 a 부피, 길삼이가 b 부피일때 조건을 만족하는지 여부
	//길동이의 부피는 sum이 선물들의 총합이라 하면 sum = 길동부피(c) + 길순부피(a) + 길삼부피(b)가 되고 셋 중 두명의 부피만 알면 나머지 한명의 부피를 알 수 있다.
	//그래서 DP배열에서 2명의 부피만 저장하여 메모리를 줄일 수 있다.
	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "\\src\\test\\AfcPresentL";
		
		try(Scanner input = new Scanner(new File(path))) {
			while(input.hasNext()) {
				N = input.nextInt();
				presents = new int[N + 1];
				sum = 0;
				for(int i = 1; i < N + 1; i++) {
					presents[i] = input.nextInt();
					sum += presents[i];
				}
				//12 12 9
				//10 2 1
				//6 6 5
				solve2();
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void solve() {
		DP = new boolean[21][2001][2001];
		DP[0][0][0] = true;
		//DP[i][a][b] = 
		//i-1번째 선물까지 받은상태서 
		//1. a(길순)에 present[i] 부피가 추가되는 경우, 
		//2. b(길동)에 present[i] 부피가 추가되는 경우
		//3. 길동이 받아 부피 추가할 필요 없는 경우 
		//이들중 하나라도 참이면 가능성 있는 상태가 된다.
		for(int i = 1; i <= N; i++) {
			for(int a = 0; a <= 2000; a++) {
				for(int b = 0; b <= 2000; b++) {
					DP[i][a][b] = (DP[i - 1][a][b] || 
							(a - presents[i] >= 0 ? DP[i - 1][a - presents[i]][b] : false) || 
							(b - presents[i] >= 0 ? DP[i - 1][a][b - presents[i]] : false));
				}
			}
		}
		int A = 0, B = 0, C = 0, ans = 987654321;
		for(int a = 0; a <= 2000; a++) {
			for(int b = 0; b <= 2000; b++) {
				if(DP[N][a][b]) {
					if(sum - (a + b) >= a && a >= b && sum - (a + b) - b <= ans) {	//길동 >= 길순 >= 길삼을 만족하며 min(길동 - 길삼)인 경우를 찾는다.
						ans = sum - (a + b) - b;
						A = sum - (a + b);
						B = a;
						C = b;
					}
				}
			}
		}
		System.out.println(A + " " + B + " " + C);
	}
	
	//메모리와 속도가 더 나은 버전.
	static void solve2() {
		//부피는 길동 >= 길순 >= 길삼이 되어야 하므로
		//2000 / 3 = 666.666... ~= 667이다.
		//이러면 길순, 길삼의 부피는 667을 넘어서는 경우는 없다.
		//또한 i번째 선물을 받을때 그 이전의 상태. 즉 i-1번째 선물을 받았을때만 계산에 필요하므로 2개의 저장공간만 있다면 충분하다.
		DP = new boolean[2][668][668];
		DP[0][0][0] = true;
		
		for(int i = 1; i <= N; i++) {
			for(int a = 0; a <= 667; a++) {
				for(int b = 0; b <= 667; b++) {
					DP[i % 2][a][b] = (DP[1 - (i % 2)][a][b] ||
							(a - presents[i] >= 0 ? DP[1 - (i % 2)][a - presents[i]][b] : false) ||
							(b - presents[i] >= 0 ? DP[1 - (i % 2)][a][b - presents[i]] : false));
							
				}
			}
		}
		int A = 0, B = 0, C = 0, ans = 987654321;
		for(int a = 0; a <= 667; a++) {
			for(int b = 0; b <= 667; b++) {
				if(DP[N % 2][a][b]) {
					if(sum - (a + b) >= a && a >= b && sum - (a + b) - b <= ans) {
						ans = sum - (a + b) - b;
						A = sum - (a + b);
						B = a;
						C = b;
					}
				}
			}
		}
		System.out.println(A + " " + B + " " + C);
	}
}
