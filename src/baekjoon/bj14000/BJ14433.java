package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//한조 대기 중
public class BJ14433 {
	static int[] S, T;
	static boolean[] visited;
	static List<List<Integer>> adj = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K1 = Integer.parseInt(st.nextToken());
		int K2 = Integer.parseInt(st.nextToken());
		
		//S집합 -> T집합으로 가는 이분그래프에서 최대 매칭 수를 구하기. (이분매칭)
		S = new int[N + 1];
		T = new int[M + 1];
		adj = new ArrayList<>();
		for(int i = 0; i < N + 1; i++) {
			adj.add(new ArrayList<>());
		}
		visited = new boolean[N + 1];
		
		//첫번째 팀 이분매칭
		for(int i = 0; i < K1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj.get(a).add(b);
		}
		
		Arrays.fill(S, -1);
		Arrays.fill(T, -1);
		
		int k1Match = 0;
		for(int i = 1; i < N + 1; i++) {
			if(S[i] == -1) {
				Arrays.fill(visited, false);
				if(dfs(i)) {
					k1Match++;
				}
			}
		}
		
		//두번째팀 이분매칭.
		adj = new ArrayList<>();
		for(int i = 0; i < N + 1; i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i = 0; i < K2; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj.get(a).add(b);
		}
		
		Arrays.fill(S, -1);
		Arrays.fill(T, -1);
		
		int k2Match = 0;
		for(int i = 1; i < N + 1; i++) {
			if(S[i] == -1) {
				Arrays.fill(visited, false);
				if(dfs(i)) {
					k2Match++;
				}
			}
		}
		
		//두번째 팀이 첫번쨰 팀(욱제팀) 보다 더 많은 매칭 수를 가지면 승급.
		bw.write((k1Match < k2Match ? "네 다음 힐딱이\n" : "그만 알아보자\n"));
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean dfs(int curr) {
		visited[curr] = true;
		for(int next : adj.get(curr)) {
			//이미 매칭된 정점이 아니거나, 이미 매칭된 정점이 다른 정점과 매칭될 수 있으면.
			if(T[next] == -1 || (!visited[T[next]] && dfs(T[next]))) {
				S[curr] = next;
				T[next] = curr;
				return true;
			}
		}
		return false;
	}
}
