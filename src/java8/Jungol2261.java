package java8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//경로 찾기 (BFS)
public class Jungol2261 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		int N, K, start, end;
		int[][] graph;
		String[] bits;
		N = input.nextInt();
		K = input.nextInt();
		
		bits = new String[N];
		graph = new int[N][N];
		for(int i = 0 ; i < N; i++){
			bits[i] = input.next();
		}
		start = input.nextInt();
		end = input.nextInt();
		
		int count = 0;
		for(int i = 0 ; i < N - 1 ; i++){
			for(int j = i + 1; j < N; j++){
				for(int h = 0; h < K; h++){
					if(bits[i].charAt(h) != bits[j].charAt(h)){
						count++;
					}
					if(count > 1){
						break;
					}
				}
				if(count == 1){
					graph[i][j] = graph[j][i] = 1;
				}
				count = 0;
			}
		}
		
		//int[] distance = new int[N];	//현재 탐색하는 위치까지의 최단거리를 저장하는 배열
		int[] parent = new int[N];	//현재 탐색하는 위치(i)의 바로 전 경로를 저장하는 배열
		for(int i = 0 ; i < parent.length; i++){
			parent[i] = -1;
		}
		//distance[start - 1] = 0;
		parent[start - 1] = start - 1;
		
		queue.add(start - 1);
		
		int index;
		while(!queue.isEmpty()){
			index = queue.poll();
			if(index == end - 1){
				break;
			}
			for(int i = 0 ; i < graph.length; i++){
				if(graph[index][i] == 1){
					graph[index][i] = graph[i][index] = 2;
					//distance[i] = distance[index] + 1;
					parent[i] = index;
					queue.add(i);
				}
			}
		}
		index = end - 1;
		if(parent[index] == -1){
			System.out.println("-1");
		}
		else{
			stack.push(index);
			while(parent[index] != index){
				stack.push(parent[index]);
				index = parent[index];
			}
			
			while(!stack.isEmpty()){
				System.out.print((stack.pop()+1)+" ");
			}
		}
	}
}
