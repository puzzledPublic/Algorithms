package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//이동하기
public class BJ11048 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[][] maze = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//maze[i][j] = i,j위치까지 왔을때 얻을 수 있는 사탕의 최대 갯수
		//i,j 위치에 도달하려면 [i-1,j], [i][j-1], [i-1][j-1]의 위치에서 출발하는 경우가 있으므로
		//maze[i][j] = Max(maze[i-1][j], maze[i][j-1], maze[i-1][j-1]) + maze[i][j]가 된다.
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				int max = 0;
				if(i - 1 >= 0) {
					max = Math.max(max, maze[i - 1][j]);
				}
				if(j - 1 >= 0) {
					max = Math.max(max, maze[i][j - 1]);
				}
				if(i - 1 >= 0 && j - 1 >= 0) {
					max = Math.max(max, maze[i - 1][j - 1]);
				}
				maze[i][j] += max;
			}
		}
		bw.write(maze[N - 1][M - 1] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
