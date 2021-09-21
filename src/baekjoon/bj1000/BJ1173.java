package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//운동
public class BJ1173 {
	static class State {
		int pulse, ex, time;	//맥박, 운동시간(분), 총시간
		State(int pulse, int ex, int time) {
			this.pulse = pulse;
			this.ex = ex;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		boolean[][] check = new boolean[201][201];	//BFS를 위한 중복체크 배열
		
		Queue<State> queue = new LinkedList<>();
		
		check[m][0] = true;
		queue.add(new State(m, 0, 0));
		
		int result = -1;
		while(!queue.isEmpty()) {
			State curr = queue.poll();
			
			if(curr.ex == N) {	//운동을 N분만큼 한 경우 종료
				result = curr.time;
				break;
			}
			
			if(curr.pulse - R >= m) {	//휴식하는 경우
				if(!check[curr.pulse - R][curr.ex]) {
					check[curr.pulse - R][curr.ex] = true;
					queue.add(new State(curr.pulse - R, curr.ex, curr.time + 1));
				}
			}else {	//휴식시 맥박이 m보다 작아질 경우 m으로 유지
				if(!check[m][curr.ex]) {
					check[m][curr.ex] = true;
					queue.add(new State(m, curr.ex, curr.time + 1));
				}
			}
			
			if(curr.pulse + T <= M) {	//운동하는 경우
				if(!check[curr.pulse + T][curr.ex + 1]) {
					check[curr.pulse + T][curr.ex + 1] = true;
					queue.add(new State(curr.pulse + T, curr.ex + 1, curr.time + 1));
				}
			}
			
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
