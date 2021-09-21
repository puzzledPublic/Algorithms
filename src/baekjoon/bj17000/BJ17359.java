package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//전구 길만 걷자
public class BJ17359 {
	static int N, min = Integer.MAX_VALUE;
	static String[] bulbs;	//전구묶음 문자열
	static int[] changes;	//각 전구묶음에서 변하는 횟수
	static boolean[] visited;	//dfs를 위한 방문 체크 배열
	static int[] order;	//방문 순서
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		bulbs = new String[N];
		visited = new boolean[N];
		changes = new int[N];
		order = new int[N];
		for(int i = 0; i < N; i++) {
			bulbs[i] = br.readLine();
			for(int j = 1; j < bulbs[i].length(); j++) {
				if(bulbs[i].charAt(j) != bulbs[i].charAt(j - 1)) {	//한 전구묶음에서 변하는 횟수 계산
					changes[i]++;
				}
			}
		}
		solve(0, 0);
		
		bw.write(min + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
	static void solve(int limit, int count) {	//전구묶음을 순서대로 배열하며 변하는 횟수를 계산한다.
		if(min <= count) {	//이미 계산한 min값 보다 크면 바로 리턴
			return;
		}
		
		if(limit == N) {	//모두 배열했으면 변하는 횟수 갱신
			if(min > count) {
				min = count;
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				order[limit] = i;
				int nextCount = count;
				if(limit > 0) {	//순서를 하나씩 추가할 때마다 마지막 전구묶음의 마지막 전구와 추가하는 전구묶음의 처음 전구가 서로 다르다면 변하는 횟수 1증가
					if(bulbs[order[limit]].charAt(0) != bulbs[order[limit - 1]].charAt(bulbs[order[limit - 1]].length() - 1)) {
						nextCount++;
					}
				}
				solve(limit + 1, nextCount + changes[i]);
				visited[i] = false;
			}
		}
	}
}
