package java8;

import java.util.PriorityQueue;

public class DijkstraAlgorithm {
	
	final static int INF = 1111;
	static int arrayGraph[][] = {
		{0,   0,   0,   0,   0, 0,   0,   0},
		{0,   0,   2, INF, INF,   5, INF, INF},
		{0,   2,   0,   3,   8,   1, INF, INF},
		{0, INF,   3,   0,   1, INF, INF,   4},
		{0, INF,   8,   1,   0,   5,   1,   5},
		{0,   5,   1, INF,   5,   0, INF, INF},
		{0, INF, INF, INF,   1, INF,   0,   1},
		{0, INF, INF,   4,   5, INF,   1,   0}
	};
	static int arrFloyd[][] = new int[8][8];
	static int distance[] = new int [8];
	static boolean visited[] = new boolean[8];
	static int[] prev = new int[8];
	public static void main(String[] args) {
		
		
		/*
		//다익스트라
		int start, end;
		start = 1;
		end = 3;
		dijkstra(start);
		
		for(int i =1; i < distance.length; i++){
			System.out.print(distance[i] +" ");
		}
		System.out.println();
			
		pathPrint(start, end);*/
		
		//플로이드
		floyd();
		for(int i = 0 ; i < arrFloyd.length; i++){
			for(int j = 0 ; j < arrFloyd[0].length; j++){
				System.out.print(arrFloyd[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void pathPrint(int start, int end){
		System.out.print(start+" ");
		path(end);
		System.out.print(end+" ");
	}
	static void path(int end){
		if(prev[end] == 0){
			return;
		} 
		path(prev[end]);
		System.out.print(prev[end] +" ");
		
	}
	//다익스트라 알고리즘 (한 시작 정점에서 모든 정점에 대한 최단거리)
	static void dijkstra(int start){
		
		//distance 초기화
		for(int i = 1 ; i < distance.length; i++){
			distance[i] = arrayGraph[start][i];
		}
		
		for(int i = 0; i < 7; i++){
			
			int s = shortestPoint();
			visited[s] = true;
			
			for(int j = 1; j < distance.length; j++){
				if(!visited[j]){
					if(distance[j] > distance[s] + arrayGraph[s][j]){
						distance[j] = distance[s] + arrayGraph[s][j];
						prev[j] = s;
					}
				}
			}
		}
	}
	//현재 distance 중 제일 작은 정점
	static int shortestPoint(){
		
		int min = INF, value = 1;
		for(int i = 1; i < distance.length; i++){
			if(!visited[i] && min > distance[i]){
				min = distance[i];
				value = i;
			}
		}
		return value;
	}
	//플로이드 알고리즘( 모든 정점에서 모든 정점까지의 최단거리)
	static void floyd(){
		for(int i = 0 ; i < arrFloyd.length; i++){
			for(int j = 0 ; j < arrFloyd[0].length; j++){
				arrFloyd[i][j] = arrayGraph[i][j];
			}
		}
		
		for(int k = 1 ; k < arrFloyd.length; k++){
			for(int i = 1 ; i < arrFloyd.length; i++){
				for(int j = 1; j < arrFloyd.length; j++){
					if(arrFloyd[i][j] > arrFloyd[i][k] + arrFloyd[k][j]){
						arrFloyd[i][j] = arrFloyd[i][k] + arrFloyd[k][j];
					}
				}
			}
		}
		
	}
}
