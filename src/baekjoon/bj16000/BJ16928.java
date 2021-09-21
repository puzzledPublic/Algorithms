package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//뱀과 사다리 게임
public class BJ16928 {
	static class Pos {
		int x, t;
		Pos(int x, int t) {
			this.x = x;
			this.t = t;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] checkArr = new boolean[101];
		int[] ladderSnake = new int[101];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ladderSnake[x] = y;	//x에서 y로 이동.
		}
		
		int min = Integer.MAX_VALUE;
		
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(1, 0));
		checkArr[1] = true; 
		while(!queue.isEmpty()) {	//BFS
			Pos p = queue.poll();
			
			if(p.x == 100) {	//100번에 도착하면 끝.
				min = p.t;
				break;
			}
			
			for(int i = 1; i < 7; i++) {
				if(p.x + i <= 100 && !checkArr[p.x + i]) {
					if(ladderSnake[p.x + i] != 0) {	//사다리나 뱀이 있으면 해당 번호로 이동.
						checkArr[ladderSnake[p.x + i]] = true;
						queue.add(new Pos(ladderSnake[p.x + i], p.t + 1));
					}else {	//없으면 그냥 이동.
						queue.add(new Pos(p.x + i, p.t + 1));
					}
					checkArr[p.x + i] = true;
				}
			}
		}
		
		bw.write(min + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
