package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//트리의 부모 찾기
public class BJ11725 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()), a, b;
		boolean[] check = new boolean[N + 1];	//방문 체크 배열
		int[] parent = new int[N + 1];	//각 노드번호의 부모 번호를 저장하기 위한 배열
		List<List<Integer>> list = new ArrayList<>();
		for(int i = 0; i < N + 1; i++) {
			list.add(new LinkedList<Integer>());
		}
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		solve(list, check, parent, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(List<List<Integer>> list, boolean[] check, int[] parent, Writer w) throws IOException {
		Queue<Integer> queue = new LinkedList<>();
		check[1] = true;
		queue.add(1);	//1이 시작 루트
		while(!queue.isEmpty()) {	//bfs
			int p = queue.poll();
			for(int n : list.get(p)) {
				if(!check[n]) {
					check[n] = true;
					queue.add(n);
					parent[n] = p;
				}
			}
		}
		for(int i = 2; i < parent.length; i++) {
			w.write(parent[i] + "\n");
		}
	}
}
