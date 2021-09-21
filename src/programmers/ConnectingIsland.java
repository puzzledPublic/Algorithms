package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//섬 연결하기	(크루스칼)
public class ConnectingIsland {
	public static void main(String[] args) {
		int n = 4;
		int[][] costs = {
				{0, 1, 1},
				{0, 2, 2},
				{1, 2, 5},
				{1, 3 ,1},
				{2, 3, 8},
		};
		System.out.println(solution(n, costs));
	}
	static class ConnectedInfo {
		int a, b, weight;
		ConnectedInfo(int a, int b, int weight) {
			this.a = a;
			this.b = b;
			this.weight = weight;
		}
	}
	static int parent[];
	static int rank[];
	static int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n + 1];
        rank = new int[n + 1];
        for(int i = 1; i < parent.length; i++) {
        	parent[i] = i;
        	rank[i] = 1;
        }
        
        List<ConnectedInfo> list = new ArrayList<>();
        for(int i = 0; i < costs.length; i++) {
        	list.add(new ConnectedInfo(costs[i][0], costs[i][1], costs[i][2]));
        }
        Collections.sort(list, (a, b) -> a.weight - b.weight);
        for(ConnectedInfo ci : list) {
        	if(find(ci.a) != find(ci.b)) {
        		answer += ci.weight;
        		union(ci.a, ci.b);
        	}
        }
        return answer;
    }
	static int find(int u) {
		if(parent[u] == u) {
			return u;
		}
		return parent[u] = find(parent[u]);
	}
	static void union(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(u == v) {
			return;
		}
		
		if(rank[u] > rank[v]) {
			int temp = u;
			u = v;
			v = temp;
		}
		
		parent[u] = v;
		
		if(rank[u] == rank[v]) {
			rank[v]++;
		}
	}
}
