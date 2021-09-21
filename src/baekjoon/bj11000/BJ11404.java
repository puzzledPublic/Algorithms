package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//플로이드
public class BJ11404 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
		int[][] cities = new int[N + 1][N + 1];
		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j < N + 1; j++) {
				cities[i][j] = 987654321;
			}
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
			if(cities[a][b] > 0 && cities[a][b] < c) {
				continue;
			}else {
				cities[a][b] = c;
			}
		}
		solve(cities, N, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(int[][] cities, int n, Writer w) throws IOException {	//플로이드 와샬 최단거리 arr[i][j][k] = Min(arr[i][j][k-1], arr[i][k][k-1] + arr[k][j][k-1])
		for(int k = 1; k < n + 1; k++) {
			for(int i = 1; i < n + 1; i++) {
				for(int j = 1; j < n + 1; j++) {
					if(i != j) {
						cities[i][j] = Math.min(cities[i][j], cities[i][k] + cities[k][j]);
					}
				}
			}
		}
		for(int i = 1; i < n + 1; i++) {
			for(int j = 1; j < n + 1; j++) {
				if(cities[i][j] == 987654321) {
					w.write("0 ");
				}else {
					w.write(cities[i][j] + " ");
				}
			}
			w.write("\n");
		}
	}
}
