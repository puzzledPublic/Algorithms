package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//배달
public class Delivery {
	public static void main(String[] args) {
		int[] N = {5, 6};
		int[] K = {3, 4};
		int[][][] road = {
				{
					{1,2,1}, {2,3,3}, {5,2,2}, {1,4,2}, {5,3,1}, {5,4,2}
				},
				{
					{1,2,1}, {1,3,2}, {2,3,2}, {3,4,3}, {3,5,2}, {3,5,3}, {5,6,1}
				}
		};
		
		for(int i = 0; i < N.length; i++) {
			System.out.println(solution2(N[i], road[i], K[i]));
		}
	}
	static class Node {
		int index, weight;
		Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}
	}
	static int solution(int N, int[][] road, int K) {	//다익스트라 최단경로
        int answer = 0;
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);	//높은 숫자로 초기화
        List<Node>[] nodes = new ArrayList[N + 1];	//그래프 제작
        for(int i = 1; i < nodes.length; i++) {
        	nodes[i] = new ArrayList<>();
        }
        for(int i = 0; i < road.length; i++) {
        	nodes[road[i][0]].add(new Node(road[i][1], road[i][2]));
        	nodes[road[i][1]].add(new Node(road[i][0], road[i][2]));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        dist[1] = 0; //시작 정점의 최단 경로는 0
        pq.add(new Node(1, 0));
       
        while(!pq.isEmpty()) {
        	Node c = pq.poll();
        	
        	if(c.weight > dist[c.index]) {	//현재 정점까지의 비용이 이미 구한 비용보다 크다면 무시한다.
        		continue;
        	}
        	
        	for(Node n : nodes[c.index]) {	//현재 정점과 연결된 정점들을 탐색하며
        		if(dist[c.index] + n.weight < dist[n.index]) {	//(현재 정점까지 온 비용 + 다음 정점까지 가는 비용) < 이미 구한 다음 정점까지의 비용이라면 
        			dist[n.index] = dist[c.index] + n.weight;	//다음 정점까지의 비용을 갱신
        			pq.add(new Node(n.index, dist[c.index] + n.weight));	//다음 정점을 큐에 추가.
        		}
        	}
        }
        
        for(int i = 1; i < dist.length; i++) {	//1에서 모든 정점까지의 경로 중
        	if(dist[i] <= K) {	//K보다 작게 걸리는 노드라면 배달 가능
        		answer++;
        	}
        }
        
        return answer;
    }
	
	static int solution2(int N, int[][] road, int K) {	//플로이드 와샬 최단경로
		int answer = 0;
		
		int[][] map = new int[N + 1][N + 1];
		
		for(int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], 987654321);	//도달 못함(큰 수)으로 초기화 (더했을때 오버플로우 안날정도의 수로)
			map[i][i] = 0;	//자기자신은 비용이 0
		}
		
		for(int i = 0; i < road.length; i++) {	//그래프 제작
			if(map[road[i][0]][road[i][1]] > road[i][2]) {	//a <-> b인 경로가 여러개 존재하면 가장 비용이 낮은 경로로 설정
				map[road[i][0]][road[i][1]] = road[i][2];
				map[road[i][1]][road[i][0]] = road[i][2];
			}
		}
		
		for(int k = 1; k < N + 1; k++) {
			for(int i = 1; i < N + 1; i++) {
				for(int j = 1; j < N + 1; j++) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		for(int i = 1; i < N + 1; i++) {
			if(map[1][i] <= K) {
				answer++;
			}
		}
		
		return answer;
	}
}
