package baekjoon.bj12000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//숨바꼭질 2
public class BJ12851 {
	static class State {
		int pos, time;
		public State(int pos, int time) {
			this.pos = pos;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		int[] visited = new int[100001];	//visited[i] = i위치에 도착한 최소 시간
		Arrays.fill(visited, Integer.MAX_VALUE);
		int minimumTime = Integer.MAX_VALUE, count = 0;
		Queue<State> queue = new LinkedList<>();
		queue.add(new State(N, 0));
		
		while(!queue.isEmpty()) {
			State state = queue.poll();
			if(state.pos == K) {	//K위치에 도착한 경우
				if(minimumTime > state.time) {	//minimumTime 갱신
					minimumTime = state.time;
					count++;
				}else if(minimumTime == state.time) {	//현재 도착시간과 같으면 경우의수 +1
					count++;
				}
			}
			
			if(state.time >= minimumTime) {	//현재 위치까지 온 시간(state.time)이 minimumTime보다 크다면 더 탐색할 필요 없음.
				continue;
			}
			//state.time에 + 1해줘야하는데 안해줘도 결과는 같음(+1 해주면 처리시간(ms)이 조금 더 나와서..)
			if(state.pos * 2 <= 100000 && visited[state.pos * 2] >= state.time) {	//현재 위치까지의 온 시간이 i위치까지의 최소시간과 같거나 작다면 더 탐색해본다.
				visited[state.pos * 2] = state.time;
				queue.add(new State(state.pos * 2, state.time + 1));
			}
			if(state.pos + 1 <= 100000 && visited[state.pos + 1] >= state.time) {
				visited[state.pos + 1] = state.time;
				queue.add(new State(state.pos + 1, state.time + 1));
			}
			if(state.pos - 1 >= 0 && visited[state.pos - 1] >= state.time) {
				visited[state.pos - 1] = state.time;
				queue.add(new State(state.pos - 1, state.time + 1));
			}
		}
		
		bw.write(minimumTime + "\n" + count + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
