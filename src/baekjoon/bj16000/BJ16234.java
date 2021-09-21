package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//인구 이동
public class BJ16234 {
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int sum, L, R;
	static List<int[]> list = new ArrayList<>();	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[][] chk = new boolean[N][N];
		int count = 0, result = 0;
		while(true) {
			for(int i = 0; i < chk.length; i++) {
				Arrays.fill(chk[i], false);
			}
			count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!chk[i][j]) {	//아직 탐색을 안한 나라면 탐색
						count++;
						sum = 0;		//연합들의 총 인구수
						list.clear();	//연합한 나라들의 위치
						dfs(map, chk, i, j);
						for(int[] k : list) {	//연합한 나라들의 인구수를 평균화
							map[k[0]][k[1]] = sum / list.size();
						}
					}
				}
			}
			
			if(count == N * N) {	//더 이상 국경을 열 수가 없다면 종료
				break;
			}
			result++;
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int[][] map, boolean[][] chk, int sx, int sy) {
		chk[sx][sy] = true;
		sum += map[sx][sy];		//현재 나라의 인구수를 더한다
		for(int i = 0; i < d.length; i++) {
			int x = sx + d[i][0], y = sy + d[i][1];
			if((0 <= x && x < map.length) && (0 <= y && y < map.length) && !chk[x][y]) {	//아직 탐색안한 상,하,좌,우로 인접한 나라에 대해
				int diff = map[sx][sy] - map[x][y] > 0 ? map[sx][sy] - map[x][y] : map[x][y] - map[sx][sy];
				if(L <= diff && diff <= R) {	//인구수 차이가 기준에 부합하면 연합 결성
					dfs(map, chk, x, y);
				}
			}
		}
		list.add(new int[]{sx, sy});	//연합하는 나라들의 목록을 만든다.
	}
}
