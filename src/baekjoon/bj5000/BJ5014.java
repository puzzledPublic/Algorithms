package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//스타트링크
public class BJ5014 {
	static class Elevator {
		int floor;
		int tryNum;
		Elevator(int floor, int tryNum) {
			this.floor = floor;
			this.tryNum = tryNum;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int F = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken()), U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[1000001];	//층 반복 방문 체크 배열
		int result = -1;
		
		Queue<Elevator> queue = new LinkedList<>();
		queue.add(new Elevator(S, 0));
		visited[S] = true;
		while(!queue.isEmpty()) {	//BFS
			Elevator ele = queue.poll();
			if(ele.floor == G) {
				result = ele.tryNum;
				break;
			}
			if(ele.floor + U <= F && !visited[ele.floor + U]) {			//위층으로 가는 경우
				visited[ele.floor + U] = true;
				queue.add(new Elevator(ele.floor + U, ele.tryNum + 1));
			}
			if(ele.floor - D >= 1 && !visited[ele.floor - D]) {			//아래층으로 가는 경우
				visited[ele.floor - D] = true;
				queue.add(new Elevator(ele.floor - D, ele.tryNum + 1));
			}
		}
		if(result != -1) {
			bw.write(result + "\n");
		}else {
			bw.write("use the stairs\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
