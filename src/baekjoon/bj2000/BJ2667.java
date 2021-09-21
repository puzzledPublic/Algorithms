package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

//단지번호붙이기
public class BJ2667 {
	static int[][] map;
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		String s;
		for(int i = 0; i < N; i++) {
			s = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - 48;
			}
		}
		solve(map, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int[][] map, Writer w) throws IOException {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < map.length; i++) {	//모든 맵 탐색
			for(int j = 0; j < map[0].length; j++) {
				if(map[i][j] == 1) {	//만약 탐색 안된 단지라면 dfs 시작
					list.add(dfs(map, i, j));
				}
			}
		}
		list.sort((a, b) -> a - b);	//오름차순 정렬
		w.write(list.size() + "\n");
		for(int i : list) {
			w.write(i + "\n");
		}
	}
	
	static int dfs(int[][] map, int x, int y) {
		int xx, yy, result = 0;
		map[x][y] = 2;
		for(int i = 0; i < 4; i++) {
			xx = x + d[i][0];
			yy = y + d[i][1];
			if(0 <= xx && xx < map.length && 0 <= yy && yy < map[0].length) {
				if(map[xx][yy] == 1) {		
					result += dfs(map, xx, yy);
				}
			}
		}
		return result == 0 ? 1 : result + 1;	//단지 내 집 갯수
	}
}
