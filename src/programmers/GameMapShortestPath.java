package programmers;

import java.util.LinkedList;
import java.util.Queue;

//게임 맵 최단거리
public class GameMapShortestPath {
	public static void main(String[] args) {
		int[][][] maps = {
				{
					{1,0,1,1,1},
					{1,0,1,0,1},
					{1,0,1,1,1},
					{1,1,1,0,1},
					{0,0,0,0,1}
				}, 
				{
					{1,0,1,1,1},
					{1,0,1,0,1},
					{1,0,1,1,1},
					{1,1,1,0,0},
					{0,0,0,0,1}
				}
		};
		for(int i = 0; i < maps.length; i++) {
			System.out.println(solution(maps[i]));
		}
	}
	
	static int solution(int[][] maps) {
		int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		int answer = -1;
		Queue<int[]> queue = new LinkedList<>();
		maps[0][0] = 2;
		queue.add(new int[]{0, 0, 1});
		
		while(!queue.isEmpty()) {
			int[] coord = queue.poll();
			if(coord[0] == maps.length - 1 && coord[1] == maps[0].length - 1) {
				answer = coord[2];
				break;
			}
			for(int i = 0; i < d.length; i++) {
				int x = coord[0] + d[i][0], y = coord[1] + d[i][1];
				if((0 <= x && x < maps.length) && (0 <= y && y < maps[0].length) && maps[x][y] == 1) {
					maps[x][y] = 2;
					queue.add(new int[]{x, y, coord[2] + 1});
				}
			}
		}
		
		return answer;
	}
}
