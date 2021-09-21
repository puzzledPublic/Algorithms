package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//아맞다우산
public class BJ17244 {
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
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[M][N];
		int[][] chk = new int[M][N];
		List<Coord> XList = new ArrayList<>();	//S, X, E의 위치를 담는 리스트
		XList.add(new Coord(0, 0));
		
		Coord end = null;
		for(int i = 0; i < M; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'X') {
					XList.add(new Coord(i, j));
				}else if(map[i][j] == 'S'){
					XList.set(0, new Coord(i, j));	//시작점은 위치 리스트의 맨 앞으로
				}else if(map[i][j] == 'E') {
					end = new Coord(i, j);
				}
			}
		}
		XList.add(end);	//끝점은 위치 리스트의 맨 뒤로
		
		int[][] distance = new int[XList.size()][XList.size()];	//distance[i][j] = XList[i] ~ XList[j] 까지의 최단 거리
		
		for(int i = 0; i < XList.size(); i++) {
			chkInit(chk);
			Coord start = XList.get(i);
			Queue<Coord> queue = new LinkedList<>();
			queue.add(start);
			chk[start.x][start.y] = 0;
			while(!queue.isEmpty()) {	////각 정점에서 시작하여 BFS로 다른 'S', 'X', 'E'까지의 거리를 갱신.
				Coord coord = queue.poll();
				
				if(map[coord.x][coord.y] == 'S' || map[coord.x][coord.y] == 'X' || map[coord.x][coord.y] == 'E') {
					for(int j = 0; j < XList.size(); j++) {
						if(XList.get(j).x == coord.x && XList.get(j).y == coord.y) {
							distance[i][j] = distance[j][i] = chk[coord.x][coord.y];
							break;
						}
					}
				}
				
				for(int j = 0; j < d.length; j++) {
					int nx = coord.x + d[j][0], ny = coord.y + d[j][1];
					if((0 <= nx && nx < M) && (0 <= ny && ny < N) && map[nx][ny] != '#' && chk[nx][ny] == -1) {
						chk[nx][ny] = chk[coord.x][coord.y] + 1;
						queue.add(new Coord(nx, ny));
					}
				}
			}
		}
		
		int[] arr = new int[XList.size()];	//순열 배열(맨 처음과 끝은 시작점과 끝점이므로 고정해야한다)
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		
		int min = Integer.MAX_VALUE;
		do {
			//순열에 맞게 움직인 시간을 계산한다.
			int time = 0;
			for(int i = 1; i < arr.length; i++) {
				time += distance[arr[i - 1]][arr[i]];
			}
			if(min > time) {
				min = time;
			}
		}while(arr.length > 2 && permutation(arr));
		
		bw.write(min + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	//체크 배열 초기화
	static void chkInit(int[][] chk) {
		for(int i = 0; i < chk.length; i++) {
			Arrays.fill(chk[i], -1);
		}
	}
	
	//순열생성	(arr[1]~arr[length-2]까지의 원소만 움직인다)
	static boolean permutation(int[] arr) {
		int i = arr.length - 2, j = arr.length - 2;
		
		while(i - 1 > 0 && arr[i - 1] > arr[i]) {
			i--;
		}
		
		if(i == 1) {
			return false;
		}
		
		while(arr[i - 1] > arr[j]) {
			j--;
		}
		
		int tmp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = tmp;
		
		j = arr.length - 2;
		
		while(i < j) {
			tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			i++;
			j--;
		}
		
		return true;
	}
}
