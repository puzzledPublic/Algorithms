package baekjoon.bj13000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//침투
public class BJ13565 {
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static boolean flag = false;	//inner side까지 도달 여부
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
		char[][] map = new char[M][];
		for(int i = 0; i < M; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < N; i++) {
			if(flag) {	//이미 inner side까지 도달 가능하면 끝낸다.
				break;
			}
			if(map[0][i] == '0') {	//outer side에서 dfs 시작.
				dfs(map, 0, i);
			}
		}
		
		if(flag) {
			bw.write("YES\n");
		}else{
			bw.write("NO\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(char[][] map, int x, int y) {
		if(flag) {
			return;
		}
		for(int i = 0; i < d.length; i++) {		//상 하 좌 우 방향에 대해 dfs
			int xx = x + d[i][0], yy = y + d[i][1];
			if((0 <= xx && xx < map.length) && (0 <= yy && yy < map[0].length) && map[xx][yy] == '0') {	//범위 및 이동 가능한지 검사
				if(xx == map.length - 1) {		//inner side에 도착하면 바로 끝낸다.
					flag = true;
					return;
				}
				map[xx][yy] = '1';
				dfs(map, xx, yy);
			}
		}
	}
}
