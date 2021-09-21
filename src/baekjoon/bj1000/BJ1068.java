package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//트리
public class BJ1068 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] tree = new int[N][N];	//트리를 나타내기 위한 2차원배열
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent == -1) {	//루트 노드가 없는 경우
				tree[i][i] = 2;	//2는 자기 자신 노드를 나타냄
			}else {
				tree[parent][i] = 1;	//트리 간선
				tree[i][i] = 2;
			}
		}
		int removedNode = Integer.parseInt(br.readLine());
		removeDFS(tree, removedNode);	//지우려는 노드부터 리프 노드까지 정점 및 간선을 다 지운다.
		int count = 0, sum;
		for(int i = 0; i < N; i++) {
			sum = 0;
			for(int j = 0; j < N; j++) {
				sum += tree[i][j];
			}
			if(sum == 3) {	//리프노드만 지워버린 경우 루트 노드에서 리프노드의 간선이 남아서 3이 되는 경우가 있다.
				for(int j = 0; j < N; j++) {
					if(tree[i][j] == 1) {	//
						sum = 0;
						for(int k = 0; k < N; k++) {	//리프노드가 지워졌는지 확인
							sum += tree[j][k];
						}
						if(sum == 0) {	//지워졌다면 루트노드가 리프노드가 되므로 +1
							count++;
						}
						break;
					}
				}
			}
			else if(sum == 2) {	//리프노드인 경우
				count++;
			}
		}
		System.out.println(count);
	}
	static void removeDFS(int[][] tree, int removedNode) {	//dfs로 간선 및 정점 제거
		for(int i = 0; i < tree.length; i++) {
			if(tree[removedNode][i] == 1) {
				removeDFS(tree, i);
				tree[removedNode][i] = 0;	//간선 제거
			}
		}
		tree[removedNode][removedNode] = 0;	//정점 제거
	}
}
