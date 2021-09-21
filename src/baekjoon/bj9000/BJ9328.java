package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//열쇠
public class BJ9328 {
	static class Coord {
		int x, y;
		Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			boolean[] keys = new boolean[26];	//열쇠 보유 여부
			Queue<Coord> queue = new LinkedList<>();	//BFS를 위한 큐
			List<List<Coord>> door = new ArrayList<>();	//해당 키의 문 방문 여부.
			for(int i = 0; i < 26; i++) {
				door.add(new ArrayList<>());
			}
			
			int docuCount = 0;
			
			char[][] ground = new char[H][W];
			for(int i = 0; i < H; i++) {
				String line = br.readLine();
				for(int j = 0; j < W; j++) {
					ground[i][j] = line.charAt(j);
					//가장자리이면서 탐색할 수 있는 자리라면.
					if(((i == 0 || j == 0) || (i == H - 1 || j == W - 1)) && ground[i][j] != '*' && ground[i][j] != '-') {
						docuCount += nextBehave(i, j, queue, ground, keys, door);
					}
				}
			}
			
			String keyList = br.readLine();	//처음에 보유한 열쇠 목록.
			if(!"0".equals(keyList)) {
				for(int i = 0; i < keyList.length(); i++) {	//각 열쇠 보유 표시를 하고 해당 열쇠로 열 수 있는 문이 있다면 queue에 넣는다.
					int index = keyList.charAt(i) - 'a';
					keys[index] = true;
					List<Coord> alphaDoor = door.get(index);
					if(alphaDoor.size() != 0) {
						for(Coord c : alphaDoor) {
							queue.add(c);
						}
						alphaDoor.clear();
					}
				}
			}
			
			while(!queue.isEmpty()) {	//BFS 시작.
				Coord c = queue.poll();
				
				for(int i = 0; i < d.length; i++) {	//4방향에 대해 탐색.
					int nx = c.x + d[i][0], ny = c.y + d[i][1];
					if((0 <= nx && nx < H) && (0 <= ny && ny < W) && ground[nx][ny] != '*' && ground[nx][ny] != '-') {
						docuCount += nextBehave(nx, ny, queue, ground, keys, door);
					}
				}
			}
			
			bw.write(docuCount + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int nextBehave(int nx, int ny, Queue<Coord> queue, char[][] ground, boolean[] keys, List<List<Coord>> door) {
		int result = 0;
		if('A' <= ground[nx][ny] && ground[nx][ny] <= 'Z') {	//'A' ~ 'Z'인 문 인경우.
			if(keys[ground[nx][ny] - 'A']) {	//해당 문의 열쇠를 보유하고 있다면 바로 탐색.
				queue.add(new Coord(nx, ny));
				ground[nx][ny] = '-';
			}else {	//열쇠가 없으면 나중에 열쇠를 찾았을 경우 탐색 하도록 저장한다.
				door.get(ground[nx][ny] - 'A').add(new Coord(nx, ny));
			}
		}else if('a' <= ground[nx][ny] && ground[nx][ny] <= 'z') {	//'a' ~ 'z'인 열쇠인 경우.
			if(door.get(ground[nx][ny] - 'a').size() > 0) {	//해당 열쇠로 열 수 있는 문이 있다면.
				for(Coord cc : door.get(ground[nx][ny] - 'a')) {	//모두 탐색할 수 있도록 queue에 넣는다.
					queue.add(cc);
					ground[cc.x][cc.y] = '-'; 
				}
				door.get(ground[nx][ny] - 'a').clear();	//저장한 문 목록을 제거
			}
			keys[ground[nx][ny] - 'a'] = true;	//열쇠 보유 표시.
			queue.add(new Coord(nx, ny));	//계속해서 탐색.
			ground[nx][ny] = '-';
		}else {	//그 외 ('$' 또는 '.')
			if(ground[nx][ny] == '$') {	//'$'라면 문서이므로 획득.
				result = 1;
			}
			queue.add(new Coord(nx, ny));	//계속해서 탐색.
			ground[nx][ny] = '-';
		}
		return result;
	}
}
