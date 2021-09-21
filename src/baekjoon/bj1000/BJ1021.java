package baekjoon.bj1000;

import java.util.Scanner;

//회전하는 큐
public class BJ1021 {
	static int N, P, count;
	static int[] position;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		P = input.nextInt();
		position = new int[P];
		for(int i = 0; i < P; i++) {
			position[i] = input.nextInt();
		}
		solve();
	}
	static void solve() {
		for(int i = 0; i < P; i++) {
			int m;
			if(position[i] > (N / 2 + 1)) {
				m = (N - position[i] + 1);
				move(m, 0);
			}else {
				m = (position[i] - 1);
				move(m, 1);
			}
			count += m;
			move(1, 1);
			N--;
		}
		System.out.println(count);
	}
	
	static void move(int n, int d) {
		for(int i = 0; i < position.length; i++) {
			if(d == 0) {
				position[i] = (position[i] + n) % N; 
			}else {
				position[i] = position[i] - n > 0 ? position[i] - n : position[i] - n + N;
			}
		}	
	}
}
