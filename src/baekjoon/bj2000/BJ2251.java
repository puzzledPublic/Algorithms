package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//물통
public class BJ2251 {
	static class BowlState {	//현재 물통들의 상태
		int A, B, C;
		BowlState(int A, int B, int C) {
			this.A = A;
			this.B = B;
			this.C = C;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		boolean[][] isVisitedAtState = new boolean[A + 1][B + 1];	//이미 방문한 상태인지 검사할 배열
		List<Integer> list = new ArrayList<>();		//물통 A가 비워져있을때 C에 담긴 물의 양들의 리스트
		Queue<BowlState> queue = new LinkedList<>();
		
		queue.add(new BowlState(0, 0, C));	//시작 상태
		while(!queue.isEmpty()) {
			BowlState bs = queue.poll();
			if(isVisitedAtState[bs.A][bs.B]) {	//이미 방문한 상태라면 넘어간다.
				continue;
			}
			isVisitedAtState[bs.A][bs.B] = true;	//방문 상태 체크
			if(bs.A == 0) {		//A의 물의 양이 0이라면 C의 물의 양을 리스트에 넣는다.
				list.add(C - bs.B);
			}
			//각 물통에 0 이상의 물이 있다면 나머지 물통에 부어본다.
			if(bs.A > 0) {
				if(B < bs.A + bs.B) {	//A -> B	//다 못 붓는 경우
					queue.add(new BowlState(bs.A - (B - bs.B), B, bs.C));
				}else {	//다 부을 수 있는 경우
					queue.add(new BowlState(0, bs.A + bs.B, bs.C));
				}
				if(C < bs.A + bs.C) {	//A -> C
					queue.add(new BowlState(bs.A - (C - bs.C), bs.B, C));
				}else {
					queue.add(new BowlState(0, bs.B, bs.A + bs.C));
				}
			}
			if(bs.B > 0) {
				if(A < bs.B + bs.A) {	//B -> A
					queue.add(new BowlState(A, bs.B - (A - bs.A), bs.C));
				}else {
					queue.add(new BowlState(bs.B + bs.A, 0, bs.C));
				}
				if(C < bs.B + bs.C) {	//B -> C
					queue.add(new BowlState(bs.A, bs.B - (C - bs.C), C));
				}else {
					queue.add(new BowlState(bs.A, 0, bs.B + bs.C));
				}
			}
			if(bs.C > 0) {	//C -> A
				if(A < bs.C + bs.A) {
					queue.add(new BowlState(A, bs.B, bs.C - (A - bs.A)));
				}else {
					queue.add(new BowlState(bs.A + bs.C, bs.B, 0));
				}
				if(B < bs.C + bs.B) {	//C -> B
					queue.add(new BowlState(bs.A, B, bs.C - (B - bs.B)));
				}else {
					queue.add(new BowlState(bs.A, bs.C + bs.B, 0));
				}
			}
		}
		Collections.sort(list);
		for(int i : list) {
			bw.write(i + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
