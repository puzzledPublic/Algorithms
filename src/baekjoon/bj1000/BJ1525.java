package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

//퍼즐
public class BJ1525 {
	static class PuzzleBoard{
		int step;	//시도 횟수
		long state;	//현재 퍼즐 상태
		PuzzleBoard(long state, int step) {
			this.state = state;
			this.step = step;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//change[i][j] = i번째칸이 0일때 i번째칸과 교환될 수 있는 j번째 칸들
		int[][] change = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4, 6}, {1, 3, 5, 7}, {2, 4, 8}, {3, 7}, {4, 6, 8}, {5, 7}};
		long start = 0, end = 0;
		for(int i = 0; i < 3; i++) {	//시작 상태 계산
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 3; j++) {
				long t = Long.parseLong(st.nextToken());
				t <<= (i * 3 + j) * 4;
				start |= t;
			}
		}
		for(int i = 1; i < 9; i++) {	//정렬된 상태 계산
			long t = i;
			t <<= (i - 1) * 4;
			end |= t;
		}
		
		long result = -1;	//출력할 결과 값
		Set<Long> set = new HashSet<>();	//중복 방문 방지를 위한 HashSet
		Queue<PuzzleBoard> queue = new LinkedList<>();	//BFS를 위한 Queue
		queue.add(new PuzzleBoard(start, 0));
		
		while(!queue.isEmpty()) {
			PuzzleBoard current = queue.poll();
			if(current.state == end) {	//원하는 상태에 도달하면
				result = current.step;	//시도 횟수를 저장하고 종료
				break;
			}
			//현재 상태에서 0이 어디 위치에 있는지 확인 (숫자당 4bit로 계산한다.)
			long check = 15;
			int index = 0;
			for(int i = 0; i < 9; i++) {
				if((current.state & (check << (i * 4))) == 0) {
					index = i;
					break;
				}
			}
	
			for(int i = 0; i < change[index].length; i++) {	//0의 위치와 교환할 수 있는 위치들과의 교환한 상태를 만든다.
				long next = current.state;	//현재 상태 복사.
				long mask = 15;		//4bit(1111)로 된 마스크
				mask <<= change[index][i] * 4;	//교환될 위치로 마스크 이동
				mask = next & mask;		//교환될 위치의 4bit 획득
				next &= ~mask;	//현재 상태에서 4bit 획득한 위치를 0으로 만든다.
				int diff = index - change[index][i];	//획득한 4bit를 넣을 0의 위치로 이동
				if(diff > 0) {
					mask <<= diff * 4;
				}else {
					mask >>= -diff * 4;
				}
				next |= mask;	//4bit를 넣는다.
				if(!set.contains(next)) {	//방문한 상태가 아니라면 큐에 넣어 탐색을 이어나간다.
					queue.add(new PuzzleBoard(next, current.step + 1));
					set.add(next);
				}
			}
		}
		
		bw.write(result + "\n");	//결과 출력
		bw.flush();
		bw.close();
		br.close();
	}
}
