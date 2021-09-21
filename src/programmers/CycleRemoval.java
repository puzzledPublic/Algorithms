package programmers;

import java.util.ArrayList;
import java.util.List;

//사이클 제거	//타인 코드 참조.. keyword - DFS스패닝트리
public class CycleRemoval {
	public static void main(String[] args) {
		int[] n = { 4, 8, 5, 3, 4, 5, 5, 6, 6, 6};
		int[][][] edges = {
				{ {1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4} },	//5
				{ {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 1}, {2, 7}, {3, 6} },	//0
				{ { 1, 2 }, { 3, 2 }, { 4, 3 }, { 5, 2 }, { 1, 5 }, { 5, 4 } },	//7
				{ { 2, 1 }, { 3, 2 }, { 1, 3 } },	//6
				{ { 1, 2 }, { 3, 2 }, { 2, 4 }, { 4, 3 } },	//9
				{ { 2, 1 }, { 3, 2 }, { 2, 4 }, { 2, 5 }, { 5, 4 } },	//11
				{ { 1, 2 }, { 1, 3 }, { 4, 2 }, { 1, 4 }, { 5, 3 }, { 1, 5 } }, //1
				{ { 1, 2, }, { 2, 6 }, { 6, 3 }, { 2, 3 }, { 3, 4 }, { 5, 4 }, { 5, 6 }, { 1, 6 } },	//6
				{ { 2, 3 }, { 2, 6 }, { 6, 1 }, { 5, 6 }, { 3, 5 }, { 4, 3 }, { 4, 5 }, { 2, 1 } },	//0
				{ {1, 2}, {2, 3}, {1, 3}, {2, 4}, {3, 4}, {4, 5} },	//5
		};
		
		for(int i = 0; i < n.length; i++) {
			System.out.println(solution(n[i], edges[i]));
		}
		
	}
	
	static List<List<Integer>> adj;
	static List<List<Integer>> child;
	static int[] check;
	static int[] pe;	//parent_edge i를 서브스패닝트리 루트로 하는 부모 백엣지 개수
	static int[] we;	//weak_edge i를 서브스패닝트리 루트로 하는 조금이라도 포함된 백엣지 개수 (조상으로 올라가는 백엣지) 
	static int[] se;	//strong_edge i를 서브스패닝트리 루트로 하는 완전한 백엣지 개수 (백엣지는 서브스패닝트리 내부에만 존재)
	static int solution(int n, int[][] edges) {
        int answer = 0;    
        
        adj = new ArrayList<>();
        child = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) {
        	adj.add(new ArrayList<>());
        	child.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++) {
        	adj.get(edges[i][0]).add(edges[i][1]);
        	adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        check = new int[n + 1];
        pe = new int[n + 1];
        we = new int[n + 1];
        se = new int[n + 1];
        
        check[1] = 1;
        dfs(1, 0);
        
        for(int i = 1; i < n + 1; i++) {
        	int flag = 0;
        	for(int j = 0; j < child.get(i).size(); j++) {
        		int v = child.get(i).get(j);
        		if(se[v] > 0 || we[v] - pe[v] > 1) {
        			flag = 1;
        			break;
        		}
        	}
        	
        	if(flag > 0 || edges.length - (n - 1) - we[i] != 0) {
        		continue;
        	}
        	answer += i;
        }
        
        return answer;
    }
	
	static void dfs(int u, int pa) {
		for(int w : adj.get(u)) {
			if(pa != w) {	//부모노드가 아니고
				if(check[w] == 0) {	//아직 방문 안한 노드인 경우
					check[w] = check[u] + 1;	//방문 체크
					child.get(u).add(w);	//현재 노드의 자식 노드
					int tmp = se[u];
					dfs(w, u);
					pe[w] = se[u] - tmp;
					se[u] += se[w];
					we[u] += we[w];
				}else if(check[u] > check[w]) {	//현재 노드보다 일찍 방문한 노드라면 (u가 자손, w가 조상)
					we[u]++;
					se[w]++;
				}
			}
		}
	}
}
