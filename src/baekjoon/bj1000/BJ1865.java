package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

//웜홀
public class BJ1865 {
	static class Node {
		int vertex, weight;
		Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()), N, M, W;
		StringTokenizer st;
		List<List<Node>> list;
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			list = new ArrayList<>(N + 1);
			for(int j = 0; j < N + 1; j++) {
				list.add(new LinkedList<>());
			}
			for(int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine(), " "); 
				int from, to, weight;
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				weight = Integer.parseInt(st.nextToken());
				list.get(from).add(new Node(to, weight));
				list.get(to).add(new Node(from, weight));
			}
			for(int j = 0; j < W; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				list.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()), -Integer.parseInt(st.nextToken())));
			}
			if(solve(list, N)) {
				bw.write("YES\n");
			}else {
				bw.write("NO\n");
			}
			list.clear();
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean solve(List<List<Node>> list, int n) {	//벨만-포드 최단거리
		int[] upper = new int[n + 1];
		for(int i = 0; i < n + 1; i++) {
			upper[i] = 987654321;	//upper[i] = Integer.MAX_VALUE로 할 경우 아래 upper[j] + cost에서 오버플로우 발생 가능성!!
		}
		upper[1] = 0;
		boolean updated = false;
		for(int i = 1; i < n + 1; i++) {	//n - 1번이 아닌 n번까지 돌면서 음수 사이클이 존재하는지 확인
			updated = false;
			for(int j = 1; j < n + 1; j++) {
				for(Node node : list.get(j)) {
					int cost = node.weight;
					int there = node.vertex;
					if(upper[there] > upper[j] + cost) {
						upper[there] = upper[j] + cost;
						updated = true;
					}
				}
			}
			if(!updated) {	//완화(relax)가 안되면 음수 사이클은 없고 최단거리가 모두 구해졌으므로 바로 종료
				break;
			}
		}
		if(updated) {	//음수 사이클이 있다면 시작점에 도착했을때 과거로 갈 수 있다!
			return true;
		}
		return false;
	}
}
