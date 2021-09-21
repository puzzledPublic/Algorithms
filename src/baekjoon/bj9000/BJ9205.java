package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//맥주 마시면서 걸어가기
public class BJ9205 {
	static boolean isHappy;
	static boolean[] chk;	//정점 탐색 여부 배열
	static List<List<Integer>> graph;	//그래프
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine()) + 2;
			int[][] coord = new int[N][2];
			isHappy = false;
			chk = new boolean[N];
			graph= new ArrayList<>();
			for(int j = 0; j < N; j++) {	//각 정점의 좌표(coord[0] 시작점, coord[N-1] 도착점)
				graph.add(new ArrayList<>());
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				coord[j][0] = Integer.parseInt(st.nextToken());
				coord[j][1] = Integer.parseInt(st.nextToken());
			}
			for(int j = 0; j < N; j++) {	//그래프 만들기
				for(int k = j + 1; k < N; k++) {
					//한 정점에서 다른 정점에 도달 가능하면 간선 생성 (맥주가 20병, 한병당 50m이니 정점간 거리는 1000m 내여야한다.)
					if(Math.abs(coord[j][0] - coord[k][0]) + Math.abs(coord[j][1] - coord[k][1]) <= 1000) {
						graph.get(j).add(k);
						graph.get(k).add(j);
					}
				}
			}
			solve(0);
			if(isHappy) {
				bw.write("happy\n");
			}else {
				bw.write("sad\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(int n) {	//dfs
		if(isHappy) {
			return;
		}
		if(n == chk.length - 1) {	//도착점까지 도달 가능하면 happy
			isHappy = true;
			return;
		}
		chk[n] = true;
		for(int i : graph.get(n)) {
			if(!chk[i]) {
				solve(i);
			}
		}
	}
}
