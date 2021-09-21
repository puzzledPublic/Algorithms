package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//방의 개수
public class TheNumberOfRooms {
	public static void main(String[] args) {
		int[][] arrows = {
				{2, 7, 2, 5, 0},	//3	//대각선 교차하는 경우..
				{1, 1, 4, 4, 6, 6, 1, 7, 3},	//1
				{6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0},	//3
				{2, 4, 6, 0, 4, 2, 0, 6},	//1
		};
		for(int i = 0; i < arrows.length; i++) {
			System.out.println(solution(arrows[i]));
		}
	}
	static class Coord {
		int x, y;
		Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Coord other = (Coord) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
	static int[][] d = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	static int solution(int[] arrows) {
		//오일러의 다면체 정리 (v - e + f = 2)를 사용, 2차원에서는 v - e + f = 1이다.
		//여기서 f(면의 갯수)를 구하는 문제이므로 v(꼭지점의 갯수)와 e(모서리, 변의 갯수)를 구하면 된다.
        int answer = 0;
        Map<Coord, Set<Coord>> map = new HashMap<>();
        map.put(new Coord(0, 0), new HashSet<>());
        int x = 0, y = 0;	//현재 좌표
        int v = 1, e = 0;	//꼭지점 수, 변의 수
        for(int i = 0; i < arrows.length; i++) {
        	int nx = x + d[arrows[i]][0], ny = y + d[arrows[i]][1];	//다음 좌표
        	Coord tmp = new Coord(nx, ny);
        	
        	if(!map.containsKey(tmp)) {	//방문한 정점이 아니면 정점과 간선을 만든다.
        		Coord origin = new Coord(x, y);
        		map.get(origin).add(tmp);
        		map.put(tmp, new HashSet<>());
        		map.get(tmp).add(origin);
        		v++;
        		e++;
        		if(arrows[i] % 2 != 0) {	//길이 1인 대각선이 교차하는 경우 꼭지점 1, 변 2개가 추가된다. (입력 1번 참고)
            		int a = (arrows[i] - 1) % 8, b = (arrows[i] + 1) % 8;
            		Coord bt1 = new Coord(x + d[a][0], y + d[a][1]), bt2 = new Coord(x + d[b][0], y + d[b][1]);
            		if(map.containsKey(bt1) && map.get(bt1).contains(bt2)) {
            			v++;
            			e += 2;
            		}
            	}
        	}else {	//이미 방문한 정점이고
        		Coord origin = new Coord(x, y);
        		if(!map.get(tmp).contains(origin)) {	//간선이 존재하지않으면 간선을 만든다.
        			map.get(tmp).add(origin);
        			map.get(origin).add(tmp);
        			e++;
        			if(arrows[i] % 2 != 0) {
                		int a = (arrows[i] - 1) % 8, b = (arrows[i] + 1) % 8;
                		Coord bt1 = new Coord(x + d[a][0], y + d[a][1]), bt2 = new Coord(x + d[b][0], y + d[b][1]);
                		if(map.containsKey(bt1) && map.get(bt1).contains(bt2)) {
                			v++;
                			e += 2;
                		}
                	}
        		}
        	}
        	
        	x = nx;
        	y = ny;
        }
        answer = 1 - v + e;
        return answer;
    }
}
