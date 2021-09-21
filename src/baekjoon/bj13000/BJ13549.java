package baekjoon.bj13000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//숨바꼭질 3
public class BJ13549 {
	static class State {
		int pos;
		int time;
		State(int pos, int time) {
			this.pos = pos;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] chk = new int[100_001];
		Arrays.fill(chk, Integer.MAX_VALUE);
		
		PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.time - b.time);	//시간순으로 정렬.
		pq.add(new State(N, 0));
		chk[N] = 0;	//처음 위치 체크.
		//input = 4, 6인 경우 (4 -> 5 -> 6) 2초, (4 -> 3 -> 6) 1초가 나올 수 있는데
		//일반적인 bfs를 하면(원하는곳 도착시 바로 종료) 4 -> 5 -> 6으로 가서 바로 종료될 수 있다.
		//그러므로 도착하면 바로 종료가 아니라 chk배열에 시간을 넣어 더 적은 시간이 걸리는 경우를 갱신해야 한다.
		while(!pq.isEmpty()) {
			State s = pq.poll();
			
			if(s.pos * 2 < 100_001 && chk[s.pos * 2] > s.time) {
				chk[s.pos * 2] = s.time;
				pq.add(new State(s.pos * 2, s.time));
			}
			
			if(s.pos + 1 < 100_001 && chk[s.pos + 1] > s.time + 1) {
				chk[s.pos + 1] = s.time + 1;
				pq.add(new State(s.pos + 1, s.time + 1));
			}
			
			if(s.pos - 1 >= 0 && chk[s.pos - 1] > s.time + 1) {
				chk[s.pos - 1] = s.time + 1;
				pq.add(new State(s.pos - 1, s.time + 1));
			}
		}
		
		bw.write(chk[K] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
