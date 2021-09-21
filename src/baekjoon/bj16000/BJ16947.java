package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//서울 지하철 2호선
public class BJ16947 {
	static List<List<Integer>> graph = new ArrayList<>();
	static int[] chk;
	static int[] chk2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		chk = new int[N + 1];
		chk2 = new int[N + 1];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		dfs(1, -1);
		
		for(int i = 1; i <= N; i++) {
			if(chk[i] == 2) {	//사이클을 이루는 정점에서
				for(int next : graph.get(i)) {
					if(chk[next] != 2 && chk2[next] == 0) {	//이어지는 정점이 일반 정점인 경우 거리를 잰다.
						findLen(next, 1);
					}
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			bw.write(chk2[i] + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void findLen(int curr, int len) {
		chk2[curr] = len;
		for(int next : graph.get(curr)) {
			if(chk[next] != 2 && chk2[next] == 0) {
				findLen(next, len + 1);
			}
		}
	}
	
	static int turn;	//사이클 시작점.
	static int mark = 2;	//사이클을 이루는 정점들을 표시
	static int dfs(int curr, int prev) {	//dfs 돌며 사이클 만들기.
		chk[curr] = 1;
		
		int re = 1;
		for(int next : graph.get(curr)) {
			if(chk[next] == 0) {	//방문하지 않은 곳이면
				int c = dfs(next, curr);
				if(c == 2 && chk[curr] != 2) {	//사이클을 이루는 정점인 경우 마크
					chk[curr] = mark;
					re = 2;
				}
				if(turn == curr) {	//시작점으로 돌아오면 사이클 종료.
					mark = 1;
				}
			}else if(chk[next] == chk[curr] && prev != next) {	//이미 방문한 곳이면(사이클), 바로 이전 정점이 아님을 주의
				chk[next] = chk[curr] = 2;
				turn = next;
				re = 2;
			}
		}
		return re;
	}
}
