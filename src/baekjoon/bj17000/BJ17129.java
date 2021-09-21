package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//윌리암슨수액빨이딱따구리가 정보섬에 올라온 이유
public class BJ17129 {
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] island = new int[N][M];
		int startX = 0, startY = 0;
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				island[i][j] = str.charAt(j) - '0';
				if(island[i][j] >= 2) {	//2이상은 부호를 바꿔준다.
					if(island[i][j] == 2) {	//시작점 2의 위치 저장.
						startX = i;
						startY = j;
					}
					island[i][j] = -island[i][j];
				}
			}
		}		
		
		int distance = -1;	//최소거리

		//BFS
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {startX, startY, 0});	//시작점
		island[startX][startY] = 1;	//숫자를 1로 해준다. 이것은 방문표시 역할을 한다.
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			if(island[current[0]][current[1]] < -2) {	//해당위치가 -3,-4,-5라면 도착.
				distance = current[2];	//최소거리이다.
				break;
			}
			
			for(int i = 0; i < d.length; i++) {	//상하좌우로 탐색
				int nx = current[0] + d[i][0], ny = current[1] + d[i][1];
				if((0 <= nx && nx < N) && (0 <= ny && ny < M) && island[nx][ny] <= 0) {	//0 이하라면 갈 수 있는곳이다.
					queue.add(new int[] {nx, ny, current[2] + 1});	//다음 좌표 큐에 삽입
					if(island[nx][ny] < -2) {	//만일 다음 좌표가 -3, -4, -5중 하나라면 거리 갱신을 하지말고 바로 종료.(나중에 큐에서 뽑을때 확인할 수 있도록 갱신하지 않는다)
						break;
					}
					island[nx][ny] = 1;	//방문 표시
				}
			}
		}
		
		bw.write((distance == -1 ? "NIE" : "TAK\n" + distance) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
