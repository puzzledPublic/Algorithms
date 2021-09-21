package algorithmsForPS;

import java.util.Scanner;

public class AfcBiColoring {
	static int visited[] = new int[200];;
	static int visited2[] = new int[200];
	static int graph[][];
	static int n, m;
	static boolean flag = true;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		n = input.nextInt();
		m = input.nextInt();
		graph = new int[n][n];
		int a, b;
		for(int i = 0 ; i < m ; i++) {
			a = input.nextInt();
			b = input.nextInt();
			graph[a][b] = graph[b][a] = 1;
		}
		
		//dfs
		visited[0] = 1;
		dfs(0);
		if(flag) {
			System.out.println("OK");
		}
		else {
			System.out.println("IMPOSSIBLE");
		}
		
		//dfs2
		dfs2(0,1);
		for(int i = 0 ; i < n ; i++) {
			if(visited2[i] == 0) {
				System.out.println("IMPOSSIBLE");
				return;
			}
		}
		System.out.println("OK");
	}
	
	static void dfs(int start) {
		
		for(int i = 0; i < n; i++) {
			if(graph[start][i] == 1 && visited[i] == visited[start]) {
				flag = false;
				return;
			}
		}
		for(int i = 0; i < n; i++) {
			if(graph[start][i] == 1 && visited[i] == 0) {
				if(visited[start] == 1) {
					visited[i] = 2;
				}
				else {
					visited[i] = 1;
				}
				dfs(i);
			}
		}
	}
	
	static void dfs2(int start, int color) {
		visited2[start] = color;
		int can = 1;
		for(int i = 0 ; i < n ; i++) {
			if(graph[start][i] == 1 && visited2[i] == color) {
				can = 0;
			}
		}
		if(can == 0 ) {
			visited2[start] = color;
			return;
		}
		for(int i = 0 ; i < n ; i++) {
			if(visited2[i] == 0 && graph[start][i] == 1) {
				dfs2(i, 1);
				dfs2(i, 2);
			}
		}
	}
}
