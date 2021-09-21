package algorithmsForPS;

import java.io.File;
import java.util.Scanner;

public class AfcRoadToResearchL {
	static int n, m, sol = 987654321, counter;
	static int[] chk = new int[101], greedy_chk = new int[1001];
	static int[][] G = new int[1001][1001];
	
	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "\\src\\test\\AfcRoadToResearch";
		try(Scanner input = new Scanner(new File(path))) {
			n = input.nextInt();
			m = input.nextInt();
			int s, e, w;
			for(int i = 0; i < m; i++) {
				s = input.nextInt();
				e = input.nextInt();
				w = input.nextInt();
				G[s][e] = G[e][s] = w;
			}
			
			greedy_ans(1); //단순 그리디로 탐색배제, 효율 향상
			solve(1, 0);
			System.out.println(sol);
			System.out.println(counter);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	//단순 탐욕법으로 첫번째 해를 미리 구해 놓음
	static void greedy_ans(int V) {
		int W = 0, t = 0;
		greedy_chk[V] = 1;
		while(V != n) {
			int min = 987654321;
			for(int i = 1; i <= n; i++) {
				if((greedy_chk[i] == 0) && (G[V][i] != 0) && (G[V][i] < min)) {
					greedy_chk[i] = 1;
					min = G[V][i];
					t = i;
				}
			}
			sol += G[V][t];
			V = t;
		}
	}
	
	static void solve(int V, int W) {
		if(W > sol) {
			return;
		}
		counter++;
		if(V == n) {
			if(W < sol) {
				sol = W;
			}
			return;
		}
		for(int i = 1; i <= n; i++) {
			if(chk[i] == 0 && G[V][i] != 0) {
				chk[i] = 1;
				solve(i, W + G[V][i]);
				chk[i] = 0;
			}
		}
	}
}
