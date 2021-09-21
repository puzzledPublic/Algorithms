package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FarthestNode {
	public static void main(String[] args) {
		int n = 6;
		int[][] vertex = {
				{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
		};
		System.out.println(solution(n, vertex));
	}
	static class Info {
		int node, dist;
		Info(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
	}
	static int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<Integer>[] list = new List[n + 1];
        int[] chk = new int[n + 1];
        
        Arrays.fill(chk, -1);
        chk[1] = 0;
        
        for(int i = 1; i < n + 1; i++) {
        	list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edge.length; i++) {
        	list[edge[i][0]].add(edge[i][1]);
        	list[edge[i][1]].add(edge[i][0]);
        }
        
        int max = 0;
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(1, 0));
        
        while(!queue.isEmpty()) {
        	Info info = queue.poll();
        	for(Integer i : list[info.node]) {
        		if(chk[i] == -1) {
        			int dist = info.dist + 1;
        			chk[i] = dist;
        			queue.add(new Info(i, dist));
        			if(max < dist) {
        				max = dist;
        			}
        		}
        	}
        }
        
        for(int i = 1; i < chk.length; i++) {
        	if(max == chk[i]) {
        		answer++;
        	}
        }
        return answer;
    }
}
