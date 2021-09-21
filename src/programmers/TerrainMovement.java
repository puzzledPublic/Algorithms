package programmers;

import java.util.PriorityQueue;

//지형 이동(2019 winter coding)
public class TerrainMovement {
	public static void main(String[] args) {
		int[][] land = {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}};
		int height = 3;
		
		System.out.println(solution(land, height));
	}
	static int[][] district;
	static int N;
	static int[][] d = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
	static boolean[][] chk;
	static class Edge{
		int a, b, len;
		public Edge(int a, int b, int len) {
			this.a = a;
			this.b = b;
			this.len = len;
		}
	}
	static int[] parent;
	static PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.len - b.len);
	public static int solution(int[][] land, int height) {
        int answer = 0;
        N = land.length;
        district = new int[N][N];
        chk = new boolean[N][N];
        
        int districtCount = 0;	//나뉜 지역 개수
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		if(!chk[i][j]) {
        			dfs(i, j, districtCount++, land, height);	//맵을 돌며 지역을 나눈다.
        		}
        	}
        }
       
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {	//주위 지역이 서로 다르다면 높이 차이와 함께 우선순위 큐에 넣어준다. 
        		if(i + 1 < N && district[i][j] != district[i + 1][j]) {
        			pq.add(new Edge(district[i][j], district[i + 1][j], Math.abs(land[i][j] - land[i + 1][j])));
        		}
        		if(j + 1 < N && district[i][j] != district[i][j + 1]) {
        			pq.add(new Edge(district[i][j], district[i][j + 1], Math.abs(land[i][j] - land[i][j + 1])));        			
        		}
        	}
        }
        
        parent = new int[districtCount];
        
        for(int i = 0; i < districtCount; i++) {
        	parent[i] = i;
        }
        
        while(!pq.isEmpty()) {	//MST
        	Edge e = pq.poll();
        	if(union(e.a, e.b)) {	//두 지역이 이어지지 않았다면 union
        		answer += e.len;
        	}
        }
        return answer;
    }
	
	static void dfs(int x, int y, int z, int[][] land, int height) {
		chk[x][y] = true;
		district[x][y] = z;
		for(int i = 0; i < d.length; i++) {
			int nx = x + d[i][0], ny = y + d[i][1];
			if((0 <= nx && nx < N) && (0 <= ny && ny < N)) {
				if(!chk[nx][ny] && Math.abs(land[x][y] - land[nx][ny]) <= height) {	//높이 차이가 height 이하라면 같은 지역
					dfs(nx, ny, z, land, height);
				}
			}
		}
	}
	
	static int find(int u) {
		if(u == parent[u]) {
			return u;
		}
		return parent[u] = find(parent[u]);
	}
	
	static boolean union(int u, int v) {
		u = find(u);
		v = find(v);
		if(u == v) {
			return false;
		}
		parent[u] = v;
		return true;
	}
}
