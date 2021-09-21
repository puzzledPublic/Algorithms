package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//BFS 스페셜 저지
public class BJ16940 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		List<List<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[] chk = new boolean[N + 1];
		int[] parent = new int[N + 1];	//i정점의 부모 정점.
		int[] child = new int[N + 1];	//i정점의 자식 정점 개수.
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		chk[1] = true;
		while(!queue.isEmpty()) {	//BFS
			int curr = queue.poll();
			
			for(int next : graph.get(curr)) {
				if(!chk[next]) {
					chk[next] = true;
					parent[next] = curr;
					child[curr]++;
					queue.add(next);
				}
			}
		}
		
		queue.clear();
		boolean result = true;
		if(arr[0] != 1) {	//주어진 방문순서가 1번 정점부터 시작하는지 검사.
			result = false;
		}else {
			int index = 1;
			queue.add(arr[0]);
			while(!queue.isEmpty()) {
				int v = queue.poll();
				
				for(int i = 0; i < child[v]; i++) {	//정점의 자식 정점 개수만큼 방문순서에 나타나야 한다.
					if(v != parent[arr[index]]) {	//주어진 방문순서에 나타난 정점의 부모 정점과 다르다면 fail
						result = false;
						break;
					}
					queue.add(arr[index]);	//queue에 현재 정점 저장.
					index++;
				}
				if(!result) {
					break;
				}
			}
		}
		
		bw.write((result ? 1 : 0) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
