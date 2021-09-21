package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//확장 게임
//TODO:다시 풀기!
public class BJ16920 {
	static class Pos {
		int x, y, num;
		Pos(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static char[][] board;
	static int[] dist;
	static int[] territory;
	static int N, M, S;
	static Queue<Pos> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		dist = new int[S];
		territory = new int[S];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < S; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Pos> startPos = new ArrayList<>();
		int stageCount = 1;
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
				if('1' <= board[i][j] && board[i][j] <= '9') {
					startPos.add(new Pos(i, j, board[i][j] - '1'));
				}
			}
		}
		
		queue = new LinkedList<>();
		startPos.sort((a, b) -> a.num - b.num);
		for(Pos p : startPos) {
			territory[p.num]++;
			queue.add(p);
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
//public class Main {
//	static class Site{
//		int y,x;
//		public Site(int y, int x) {
//			super();
//			this.y = y;
//			this.x = x;
//		}
//		
//	}
//	static int sero, garo, playerN, playerMove[], count[];
//	static Queue<Site> q[];
//	static char[][] map;
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		String input;
//		
//		sero = Integer.parseInt(st.nextToken());
//		garo = Integer.parseInt(st.nextToken());
//		playerN = Integer.parseInt(st.nextToken());
//		
//		map = new char[sero][garo];
//		playerMove = new int[playerN];
//		count = new int[playerN];
//		q = new Queue[playerN];
//		
//		st = new StringTokenizer(br.readLine());
//		for(int i=0; i<playerN; i++) {
//			playerMove[i] = Integer.parseInt(st.nextToken());
//			q[i] = new LinkedList<>();
//		}
//		
//		
//		for(int i=0; i<sero; i++) {
//			input = br.readLine();
//			for(int j=0; j<garo; j++) {
//				map[i][j]=input.charAt(j);
//				if(map[i][j]!='.'&&map[i][j]!='#') {
//					q[map[i][j]-'1'].add(new Site(i, j));
//				}
//			}
//		}
//		//여기까지 입력
//		
//		bfs();
//		//for(char[] c: map)System.out.println(Arrays.toString(c));
//		for(int i : count) bw.write(i + " ");
//		bw.flush();
//		
//	}
//	static int[] dy= {1,-1, 0, 0}, dx= {0, 0, 1, -1};
//	private static void bfs() {
//		Site temp;
//		int qsize, ny, nx;
//		while(checkQs()) {
//			for(int i=0; i<playerN; i++) {
//				for(int j=0; j<playerMove[i]; j++) {
//					if(q[i].isEmpty()) break;
//					//각 플레이어의 이동거리만큼 반복된다
//					qsize = q[i].size();
//					count[i]+=qsize;
//					for(int k=0; k<qsize; k++) {
//						temp = q[i].poll();
//						for(int d=0; d<4; d++) {
//							ny = temp.y + dy[d];
//							nx = temp.x + dx[d];
//							if(ny<0||nx<0||ny>=sero||nx>=garo||map[ny][nx]!='.') continue;
//							q[i].offer(new Site(ny, nx));
//							map[ny][nx] = 'v';
//						}
//					}
//				}
//			}
//		}
//	}
//	private static boolean checkQs() {
//		boolean flag = false;
//		for(int i=0; i<playerN; i++)
//			if(!q[i].isEmpty())
//				flag = true;
//		return flag;
//	}
//}
