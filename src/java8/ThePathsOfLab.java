package java8;

import java.util.Scanner;

//그래프에서 전체탐색법으로 탐색한 모든 경로중 가장 작은 비용을 출력( O(n!) )
public class ThePathsOfLab {
	static int max=Integer.MAX_VALUE;
	static int[] V = new int[100];
	static int[][] G = new int[100][100]; 
	public static void main(String[] args) {
		//N 정점 수, M 간선 수
		int N,M;
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		//간선 갯수만큼
		for(int i = 0 ; i < M; i++){
			//정점 두개와 가중치를 입력 받아 인접행렬에 저장
			int t1 = input.nextInt(), t2 = input.nextInt();
			G[t1][t2] = G[t2][t1] = input.nextInt();
		}
		//깊이우선탐색 시작
		dfs(1,0,N);
		//최소값 출력
		System.out.println(max);
		input.close();
	}
	
	private static void dfs(int f, int com, int N){
		//마지막 위치에 도달하면
		if(f==N){
			//지금까지의 비용이 다른 경로 비용보다 작다면
			if(com<max){
				max = com;
			}
			return;
		}
		//모든 정점을 탐색 
		for(int i = 1; i < N+1;i++){
			//연결된 정점이고 방문한 적이 없다면
			if(G[f][i]>0 && V[f]==0){
				//방문표시
				V[f] = 1;
				//연결된 정점으로 넘어감
				dfs(i,com+G[f][i],N);
				//백트래킹하며 방문을 초기화
				V[f] = 0;
			}
		}
	}
	
}
