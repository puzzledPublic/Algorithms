package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//순열사이클
public class BJ10451 {
	static int[] parent = new int[1001];	//각 노드의 부모
	static boolean[] check = new boolean[1001];	//노드를 탐색했는지 여부
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()), N;
		for(int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			for(int j = 1; j < N + 1; j++) {
				parent[j] = 0;
				check[j] = false;
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j < N + 1; j++) {	//각 노드의 부모 저장
				parent[j] = Integer.parseInt(st.nextToken());
			}
			solve(parent, check, N, bw);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	//순열이므로 사이클은 항상 존재한다.
	static void solve(int[] parent, boolean[] check, int N, Writer w) throws IOException {
		int count = 0;
		for(int i = 1; i < N + 1; i++) {
			if(check[i] == false) {
				int k = parent[i];
				while(i != k) {	//자신이 나올때까지 그래프(부모)를 타고 간다.
					check[k] = true;
					k = parent[k];
				}
				count++;
			}
		}
		w.write(count + "\n");
	}
}
