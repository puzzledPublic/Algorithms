package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//효율적인 해킹
//글에서 유도하는대로 그래프를 만들고 dfs했더니 시간초과가 난다.
//거꾸로 그래프를 만들어보는게 관건이었다.
public class BJ1325 {
	static List<Integer>[] graph;
	static boolean[] chk;
	static int[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		chk = new boolean[N + 1];
		list = new int[N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<Integer>(); 
		}
		//a가 b를 신뢰한다라고 할때 b -> a로 방향간선이 생기는데 여기서는 반대 방향 간선으로 생각한다.
		//그래프를 만들고 각 정점에서 dfs를 돌면서 정점을 지날때마다 그 정점의 방문횟수를 +1 증가시킨다.
		//각 정점에서 거꾸로된 그래프(a -> b)를 거슬러 올라가며 방문 정점 횟수를 1씩 증가시키면 각 정점 횟수는 원래 그래프(b -> a)에서 연결된 정점의 개수가 된다.
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
		}
		for(int i = 1; i < N + 1; i++) {
			Arrays.fill(chk, false);
			solve(i);
		}
		
		int max = 0;
		
		for(int i = 1; i < N + 1; i++) {
			if(max < list[i]) {
				max = list[i];
			}
		}
		for(int i = 1; i < N + 1; i++) {
			if(list[i] == max) {
				bw.write(i + " ");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int start) {
		chk[start] = true;
		for(int next : graph[start]) {
			if(!chk[next]) {
				list[next]++;
				solve(next);
			}
		}
	}
}


