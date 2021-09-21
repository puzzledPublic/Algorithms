package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//색종이 붙이기
public class BJ17136 {
	static int minimum = Integer.MAX_VALUE;	//붙이는 색종이의 최소값
	static int[] rectangle = {0, 5, 5, 5, 5, 5};	//nxn크기의 색종이 갯수들
	static int[][] paper = new int[11][11];			//현재 판 상황
	static List<int[]> point = new ArrayList<>();	//1로 표시된 좌표들
	static boolean[][] check = new boolean[11][11];	//백트래킹을 위한 체크배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 1; i < 11; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j < 11; j++) {
				paper[i][j] = st.nextToken().charAt(0) - '0';
				if(paper[i][j] == 1) {	//1인 경우(색종이로 붙여야 하는곳)
					point.add(new int[]{i, j});	//좌표를 저장
					//DP를 사용하여 paper[i][j] = (i,j)가 1로 정사각형을 이루는 우하단 좌표일때 최대 정사각형 크기를 구한다.
					paper[i][j] = Math.min(Math.min(paper[i - 1][j], paper[i][j - 1]), paper[i - 1][j - 1]) + 1;
				}
			}
		}
		
		//좌표를 우하단에서 좌상단쪽으로 탐색하게끔 정렬.
		point.sort((a, b) -> {
			if(a[0] == b[0]) {
				return Integer.compare(b[1], a[1]);
			}
			return Integer.compare(b[0], a[0]);
		});
	
		solve(0, 0);	//solve(n, count) = n번째 좌표까지 살펴봤을때 붙인 색종이의 개수
		
		bw.write((minimum == Integer.MAX_VALUE ? "-1" : minimum) + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int n, int count) {
		if(n == point.size()) {	//좌표를 다 탐색했고
			boolean flag = false;
			for(int i = 0; i < point.size(); i++) {	//모든 좌표를 색종이로 붙였다면
				if(!check[point.get(i)[0]][point.get(i)[1]]) {
					flag = true;
					break;
				}
			}
			if(!flag && minimum > count) {	//minimum 갱신
				minimum = count;
			}
			return;
		}
		
		if(minimum <= count) {	//탐색 도중에 현재 minimum보다 크면 더 탐색할 필요없이 종료
			return;
		}
		
		int[] p = point.get(n);	//현재 탐색할 좌표
		if(check[p[0]][p[1]]) {	//현재 좌표가 이미 색종이로 붙여졌다면 다음 좌표로 넘어간다.
			solve(n + 1, count);
			return;
		}
		
		for(int i = paper[p[0]][p[1]]; i > 0; i--) {	//현재 좌표에서의 최대 정사각형 크기에서 1x1정사각형 크기까지 붙여본다.
			if(i > 5) continue;		//6x6 이상의 색종이는 없으므로 넘어간다.
			if(rectangle[i] == 0) continue;	//ixi크기의 색종이를 다 사용했다면 다른 색종이로 넘어간다.
			if(!checking(p[0], p[1], i)) continue;	//이미 붙여놓은 색종이와 겹칠 수 있으므로 현재 좌표서부터 ixi 색종이를 붙일 수 있는지 검사 후 못 붙인다면 넘어간다.
			
			//붙일 수 있으면
			fill(p[0], p[1], i, true);	//ixi크기 색종이만큼 방문 체크.
			rectangle[i]--;	//ixi크기의 색종이를 사용.
			solve(n + 1, count + 1);	//다음 좌표로 넘어간다. (색종이 사용 + 1)
			rectangle[i]++;	//백트래킹.
			fill(p[0], p[1], i, false);
		}
	}
	
	static boolean checking(int x, int y, int size) {
		for(int i = x; i > x - size; i--) {
			for(int j = y; j > y - size; j--) {
				if(check[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void fill(int x, int y, int size, boolean dummy) {
		for(int i = x; i > x - size; i--) {
			for(int j = y; j > y - size; j--) {
//				paper[i][j] = dummy ? 0 : 1;
				check[i][j] = dummy;
			}
		}
//		fillSize();
	}
//	static void fillSize() {	//checking 함수와 달리 paper 상태를 직접 갱신하는 함수였으나 10x10을 계속 갱신해야 해서 checking 보다 느리다.
//		for(int i = 1; i < 11; i++) {
//			for(int j = 1; j < 11; j++) {
//				if(paper[i][j] != 0) {
//					paper[i][j] = 1;
//					paper[i][j] = Math.min(Math.min(paper[i - 1][j], paper[i][j - 1]), paper[i - 1][j - 1]) + 1;
//				}
//			}
//		}
//	}
}

/*	
 * from BOJ.(비슷하면서 속도 더 빠른 풀이.)
 * SeoJeongWook2
 *  Kyungpook Nat'l University Mobile Engineering
 */

//public class BJTest {
//	static int input[][] = new int[15][15];
//	static int MAX_BLOCK[][] = new int[15][15];
//	static boolean visit[][] = new boolean[15][15];
//	static int UseCnt[] = new int[7]; 
//	
//	static int putX[] = new int[110]; static int putY[] = new int[110];
//	static int putCnt = 0, Answer = -1;
//	
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = null;
//		StringBuilder sb = new StringBuilder();
//		
//		for(int i = 0; i < 10; i++) {
//			st = new StringTokenizer(br.readLine());
//			for(int j = 0; j < 10; j++) {
//				input[i][j] = Integer.parseInt(st.nextToken());
//				if(input[i][j] == 1) { putX[putCnt] = j; putY[putCnt++] = i; }
//			}
//		}
//
//		Init();
//		solve(0, 0);
//		sb.append(Answer);
//		
//		System.out.println(sb);
//	}
//	
//	public static void Init() {
//		for(int k = 0; k < putCnt; k++) {
//			for(int size = 1; size <= 5; size++) {
//				boolean loopchk = false;
//				for(int y = putY[k]; y < putY[k] + size; y++) {
//					for(int x = putX[k]; x < putX[k] + size; x++) {
//						if(input[y][x]==0) { loopchk = true; break; }
//					}
//					if(loopchk) { break; }
//				}
//				
//				if(loopchk) { break; }
//				MAX_BLOCK[putY[k]][putX[k]] = size;
//			}
//		}
//	}
//	
//	public static void solve(int now, int cnt) {
//		if(Answer != -1 && Answer <= cnt) { return; }
//		if(now == putCnt) { 
//			if(Answer == -1) { Answer = cnt; return; }
//			if(Answer > cnt) { Answer = cnt; }
//			return;
//		}
//		
//		if(visit[putY[now]][putX[now]]) { solve(now + 1, cnt); }
//		
//		for(int size = MAX_BLOCK[putY[now]][putX[now]]; size >= 1; size--) {
//			if(UseCnt[size] + 1 > 5) { continue; }
//			if(!checking(now, size)) { continue; }
//			
//			UseCnt[size]++;
//			masking(now, size);
//			solve(now + 1, cnt + 1);
//			masking(now ,size);
//			UseCnt[size]--;
//		}
//	}
//	
//	public static boolean checking(int ind, int size) {
//		for(int i = putY[ind]; i < putY[ind] + size; i++) {
//			for(int j = putX[ind]; j < putX[ind] + size ; j++) {
//				if(visit[i][j]) { return false; }
//			}
//		}
//		return true;
//	}
//	
//	public static void masking(int ind, int size) {
//		for(int i = putY[ind]; i < putY[ind] + size; i++) {
//			for(int j = putX[ind]; j < putX[ind] + size ; j++) {
//				visit[i][j] = !visit[i][j];
//			}
//		}
//	}
//}
