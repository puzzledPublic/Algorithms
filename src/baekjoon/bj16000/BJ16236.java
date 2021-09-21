package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//아기상어
public class BJ16236 {
	static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}}, map;	//상대적 상, 하, 좌, 우 탐색 좌표 , 입력 map 배열
	static int[] shark = new int[2];	//상어 위치
	static int size = 2, feed, time;	//상어 크기, 현재 크기에서 먹은 물고기 수, 시간
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int[][] dist = new int[N][N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {	//초기 상어 위치
					map[i][j] = 0;
					shark[0] = i;
					shark[1] = j;
				}
			}
		}
		
		while(bfs(dist));	//더 이상 먹을 수 없을때까지 진행한다.
		System.out.println(time);
		br.close();
	}
	
	static boolean bfs(int[][] dist) {
		for(int i = 0; i < dist.length; i++) {		//현재 맵에서 상어크기보다 큰 물고기가 있는 칸은 -1, 그외엔 0으로 둔 배열을 만든다.
			for(int j = 0; j < dist.length; j++) {
				if(map[i][j] > size) {
					dist[i][j] = -1;
				}else {
					dist[i][j] = 0;
				}
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {	//같은 거리(최소)의 먹을 수 있는 물고기 후보들, 위, 왼쪽순으로 정렬.
			int diff = a[0] - b[0];
			if(diff == 0) {
				return a[1] - b[1];
			}
			return diff;
		});
		queue.add(shark);
		dist[shark[0]][shark[1]] = 1;
		boolean stop = false;
		while(!queue.isEmpty()) {	//bfs 시작
			int[] coord = queue.poll();
			for(int i = 0; i < d.length; i++) {
				int x = coord[0] + d[i][0], y = coord[1] + d[i][1];
				if((0 <= x && x < dist.length) && (0 <= y && y < dist.length) && dist[x][y] == 0) {
					dist[x][y] = dist[coord[0]][coord[1]] + 1;
					if((0 < map[x][y] && map[x][y] < size)) {	//만일 현재 탐색중인 칸에 물고기 크기가 상어보다 작은데.
						if(!pq.isEmpty() && pq.peek()[2] < dist[x][y] - 1) {	//최소거리가 이전에 구한것보다 크면 탐색 종료.
							stop = true;
							break;
						}else {		//최소거리가 같으면 먹을 수 있는 물고기이므로 후보에 넣는다.
							pq.add(new int[]{x, y, dist[x][y] - 1});
						}
					}
					queue.add(new int[]{x, y});
				}
			}
			if(stop) {
				break;
			}
		}
//		for(int i = 0; i < dist.length; i++) {
//			for(int j = 0; j < dist.length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("size: " + size + " feed: " + feed + " time: " + time);
		if(!pq.isEmpty()) {		//만일 먹을 수 있는 물고기가 있다면. (큐 앞에 있는것이 다음에 먹을 물고기)
			shark[0] = pq.peek()[0];	//상어위치 갱신
			shark[1] = pq.peek()[1];
			if(feed + 1 == size) {		//상어 size 만큼 먹었으면 크기 증가, feed 초기화
				feed = 0;
				size++;
			}else {						//아니라면 feed만 증가.
				feed++;
			}
			time += pq.peek()[2];		//time 증가
			map[shark[0]][shark[1]] = 0;	//원래 map에 먹은 물고기 자리를 0으로 갱신.
			return true;
		}
		return false;
	}
}
