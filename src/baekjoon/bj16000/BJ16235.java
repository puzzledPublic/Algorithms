package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

//나무 재테크
public class BJ16235 {
	
	static class Land {
		int nutrient;	//땅의 양분
		Deque<Integer> trees;	//땅에 자라는 나무들
		public Land() {
			this.nutrient = 5;	//초기 양분 5
			this.trees = new LinkedList<>();
		}
	}
	static int[][] d = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int alive = 0;
		int[][] A = new int[N][N];	//해마다 각 영역에 줄 양분
		Land[][] lands = new Land[N][N];	//땅
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				lands[i][j] = new Land();
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			lands[x - 1][y - 1].trees.add(age);
		}
		//초기 해당 영역에 존재하는 나무들을 나이순으로 오름차순 정렬
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				Collections.sort((List<Integer>)lands[i][j].trees);
			}
		}
		
		for(int i = 0; i < K; i++) {	//K년 동안
			for(int j = 0; j < N; j++) {	//해당 영역에 (봄, 여름)
				for(int k = 0; k < N; k++) {
					int until = 0;	//양분을 먹은 나무 수
					int index = 0, size = lands[j][k].trees.size();
					while(index < size) {
						if(lands[j][k].nutrient >= lands[j][k].trees.peekFirst()) {		//양분을 줄 수 있으면
							lands[j][k].nutrient -= lands[j][k].trees.peekFirst();		//양분 흡수 후 나이 + 1
							lands[j][k].trees.addLast(lands[j][k].trees.pollFirst() + 1);
							until++;
						}else {
							break;
						}
						index++;
					}
					while(!lands[j][k].trees.isEmpty() && lands[j][k].trees.size() > until) {	//양분을 먹지 못해 죽은 나무들에 대해
						lands[j][k].nutrient += lands[j][k].trees.pollFirst() / 2;	//양분 축적
					}
				}
			}
			for(int j = 0; j < N; j++) {	//해당 영역에 (가을, 겨울)
				for(int k = 0; k < N; k++) {
					for(Integer g : lands[j][k].trees) {	//나무들이
						if(g % 5 == 0) {	//나이가 5의 배수면
							for(int u = 0; u < d.length; u++) {		//인접한 8곳에 번식
								int x = j + d[u][0], y = k + d[u][1];
								if((0 <= x && x < N) && (0 <= y && y < N)) {
									lands[x][y].trees.addFirst(1);
								}
							}
						}
					}
					lands[j][k].nutrient += A[j][k];	//겨울에 양분을 준다.
				}
			}
		}
		for(int i = 0; i < N; i++) {	//K년이 지난 후 살아있는 나무 수
			for(int j = 0; j < N; j++) {
					alive += lands[i][j].trees.size();
			}
		}
	
		bw.write(alive + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
