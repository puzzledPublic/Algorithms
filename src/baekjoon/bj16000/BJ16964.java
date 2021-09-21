package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

//DFS 스페셜 저지
public class BJ16964 {
	static List<List<Integer>> tree = new ArrayList<>();
	static int[] parent;	//parent[i] = i정점의 부모 정점
	static int[] child;		//child[i] = i정점의 자식 정점 개수
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		child = new int[N + 1];
		check = new boolean[N + 1];
		for(int i = 0; i < N + 1; i++) {
			tree.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N - 1; i++) {	//트리 생성
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {	//주어진 DFS 순서
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		parent[1] = 0;	//1번 정점의 부모 정점은 0 으로 가정
		dfs(1);	//1번 정점부터 탐색.
		
		boolean result = true;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for(int i = 0; i < N; i++) {
			if(stack.peek() == parent[arr[i]]) {	//현재 정점의 부모 정점이 스택에 있다면.
				child[stack.peek()]--;	//부모 정점의 자식 정점 개수를 줄이고
				stack.push(arr[i]);	//현재 정점 push
				while(child[stack.peek()] == 0) {	//자식 정점 개수가 0인 정점들을 스택에서 pop
					stack.pop();
				}
			}else {	//부모 정점과 다르다면 DFS 순서가 잘못됨.
				result = false;
				break;
			}
		}
		
		bw.write((result ? "1\n" : "0\n"));
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int root) {
		check[root] = true;
		int count = 0;
		for(int next : tree.get(root)) {
			if(!check[next]) {
				count++;
				parent[next] = root;
				dfs(next);
			}
		}
		child[root] = count;
	}
}
