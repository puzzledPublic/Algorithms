package algorithmsForPS;

import java.util.Scanner;

//공주 구하기(s)
public class AfcSaveThePrincess {
	static int N, M = 1000;
	//p = 점프대가 있는 시작 섬에서 떨어진 위치, d = 점프 거리, g = 공주를 엎고 건널 수 있는지 여부(못건너면 0, 건너면 1)
	static int[] p = new int[500], d = new int[500], g = new int[500];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		for(int i = 0; i < N; i++) {
			p[i] = input.nextInt();
			d[i] = input.nextInt();
			g[i] = input.nextInt();
		}
		System.out.println(solve(0, 0, 1));
	}
	//A가 건널 수 있는 조건
	static boolean ca(int a, int k) {
		return p[k] <= p[a] + d[a];
	}
	//B가 건널 수 있는 조건
	static boolean cb(int b, int k) {
		return (p[k] <= p[b] + d[k]) && g[k] == 1;
	}
	static int solve(int a, int b, int k) {
		int c = 0;
		if(k == N - 1) {
			if(ca(a,k) && cb(b, k)) {
				c = 1;
			}
			else {
				c = 0;
			}
		}
		else {
			if(ca(a, k)) {
				c += solve(k, b, k + 1) % M;
			}
			if(cb(b, k)) {
				c += solve(a, k, k + 1) % M;
			}
			c += solve(a, b, k + 1) % M;
		}
		return c;
	}
	
}

