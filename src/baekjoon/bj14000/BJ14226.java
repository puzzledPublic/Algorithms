package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

//이모티콘
public class BJ14226 {
	static class Emoticon {
		int screen, clipBoard, time;
		public Emoticon(int screen, int clipBoard, int time) {
			this.screen = screen;
			this.clipBoard = clipBoard;
			this.time = time;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int S = Integer.parseInt(br.readLine());
		
		bw.write(solve2(S) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int S) {
		Queue<Emoticon> queue = new LinkedList<>();
		boolean[][] visited = new boolean[1001][1001];	//방문 확인 배열(visited[화면이모티콘 수][클립보드 이모티콘 수])
		queue.add(new Emoticon(1, 0, 0));
		
		int result = 0;
		while(!queue.isEmpty()) {
			Emoticon emo = queue.poll();
			if(emo.screen + emo.clipBoard == S) {
				result = emo.time + 1;
				break;
			}
			if(emo.screen > 0) {	//화면에 이모티콘 있음
				if(emo.clipBoard > 0) {	//클립보드에 이모티콘 있음
					if(emo.screen + emo.clipBoard < 1001 && !visited[emo.screen + emo.clipBoard][emo.clipBoard]) {	//클립보드에 있는 이모티콘을 화면에 붙여넣기 (화면 이모티콘에 더해짐)
						visited[emo.screen + emo.clipBoard][emo.clipBoard] = true;
						queue.add(new Emoticon(emo.screen + emo.clipBoard, emo.clipBoard, emo.time + 1));
					}
				}
				if(!visited[emo.screen][emo.screen]) {	//화면의 이모티콘을 클립보드에 저장. (클립보드를 덮어 씀)
					visited[emo.screen][emo.screen] = true;
					queue.add(new Emoticon(emo.screen, emo.screen, emo.time + 1));
				}
				if(!visited[emo.screen - 1][emo.clipBoard]) {	//화면에 이모티콘 중 하나를 삭제
					visited[emo.screen - 1][emo.clipBoard] = true;
					queue.add(new Emoticon(emo.screen - 1, emo.clipBoard, emo.time + 1));
				}
			}else {		//화면에 이모티콘 없음.
				if(emo.clipBoard > 0) {	//클립보드에 있는 이모티콘을 화면에 붙여넣기
					if(!visited[emo.clipBoard][0]) {
						visited[emo.clipBoard][0] = true;
						queue.add(new Emoticon(emo.clipBoard, 0, emo.time + 1));
					}
				}
			}
		}
		return result;
	}
	//간단버전
	static int solve2(int S) {
		int result = 0;
		boolean[][] visited = new boolean[1001][1001];
		Queue<Emoticon> queue = new LinkedList<>();
		queue.add(new Emoticon(1, 0, 0));
		while(!queue.isEmpty()) {
			Emoticon emo = queue.poll();
			if(visited[emo.screen][emo.clipBoard]) {	//방문한적 있으면 무시
				continue;
			}
			if(emo.screen == S) {
				result = emo.time;
				break;
			}
			visited[emo.screen][emo.clipBoard] = true;	//방문 표시
			
			queue.add(new Emoticon(emo.screen, emo.screen, emo.time + 1));	//화면 이모티콘을 클립보드에 저장
			
			if(emo.screen + emo.clipBoard < 1001) {		//클립보드 이모티콘을 화면에 복사
				queue.add(new Emoticon(emo.screen + emo.clipBoard, emo.clipBoard , emo.time + 1));
			}
			
			if(emo.screen - 1 >= 0) {	//화면 이모티콘 중 하나 삭제
				queue.add(new Emoticon(emo.screen - 1, emo.clipBoard, emo.time + 1));
			}
		}
		return result;
	}
}
