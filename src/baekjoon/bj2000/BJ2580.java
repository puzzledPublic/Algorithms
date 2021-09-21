package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//스도쿠
public class BJ2580 {
	static class Pos {
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] sudoku= new int[9][9];
	static List<Pos> list = new ArrayList<>();
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
				if(sudoku[i][j] == 0) {	//0인 위치를 저장
					list.add(new Pos(i, j));
				}
			}
		}
		solve(0);
		br.close();
	}
	
	static void solve(int n) {
		if(flag == true) {	//이미 출력했으면 바로 리턴.
			return;
		}
		if(n == list.size()) {	//빈칸을 전부 채웠고
			if(!flag) {		//아직 출력을 안했다면 출력
				for(int i = 0; i < 9; i++) {
					for(int j = 0; j < 9; j++) {
						System.out.print(sudoku[i][j] + " ");
					}
					System.out.println();
				}
				flag = true;
			}
			return;
		}
		Pos p = list.get(n);	//채워야할 빈칸위치
		for(int j = 1; j <= 9; j++) {	//1 ~ 9까지 시도
			if(check(p.x, p.y, j)) {	//해당 숫자를 넣어도 되는가?
				sudoku[p.x][p.y] = j;	//숫자를 넣어본다.
				solve(n + 1);			//다음 빈칸으로
				sudoku[p.x][p.y]= 0; 	//백트래킹
			}
		}
	}
	static boolean check(int x, int y, int j) {
		for(int i = 0; i < 9; i++) {	//해당 빈칸을 포함하는 가로축과 세로축을 돌며 넣을 숫자가 중복되는지 검사
			if(sudoku[x][i] == j || sudoku[i][y] == j) {
				return false;
			}
		}
		for(int i = x / 3 * 3; i < x / 3 * 3 + 3; i++) {	//해당 빈칸을 포함하는 3x3 사각형에 넣을 숫자가 중복되는지 검사
			for(int k = y / 3 * 3; k < y / 3 * 3 + 3; k++) {
				if(sudoku[i][k] == j) {
					return false;
				}
			}
		}
		return true;
	}
}
// 좀더 최적화 버전. 입력시 배열에 행, 열, 박스에 따른 0이 아닌 숫자들을 표시해 전처리를 한다.
//class BJ2580AnotherSolve {
//	static class Pos {
//		int x, y;
//		public Pos(int x, int y) {
//			this.x = x;
//			this.y = y;
//		}
//	}
//	static int[][] sudoku= new int[9][9];
//	static boolean[][] row = new boolean[9][10]; //i행에 숫자 j가 있는가?
//	static boolean[][] col = new boolean[9][10]; //i열에 숫자 j가 있는가?
//	static boolean[][] box = new boolean[9][10]; //i번째 박스에 숫자 j가 있는가?
//	static List<Pos> list = new ArrayList<>();
//	static boolean flag;
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st;
//		for(int i = 0; i < 9; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			for(int j = 0; j < 9; j++) {
//				sudoku[i][j] = Integer.parseInt(st.nextToken());
//				if(sudoku[i][j] == 0) {	//0인 위치를 저장
//					list.add(new Pos(i, j));
//				}else {
//					row[i][sudoku[i][j]] = true;
//					col[j][sudoku[i][j]] = true;
//					box[(i / 3) * 3 + (j / 3)][sudoku[i][j]] = true;
//				}
//			}
//		}
//		solve(0, bw);
//		
//		bw.flush();
//		bw.close();
//		br.close();
//	}
//	static void solve(int n, Writer w) throws IOException {
//		if(flag) {
//			return;
//		}
//		if(n == list.size()) {
//			if(!flag) {
//				for(int i = 0; i < 9; i++) {
//					for(int j = 0; j < 9; j++) {
//						w.write(sudoku[i][j] + " ");
//					}
//					w.write("\n");
//				}
//				flag = true;
//			}
//			return;
//		}
//		Pos p = list.get(n);
//		for(int i = 1; i <= 9; i++) {
//			if(row[p.x][i]) {
//				continue;
//			}
//			if(col[p.y][i]) {
//				continue;
//			}
//			if(box[(p.x / 3) * 3 + (p.y / 3)][i]) {
//				continue;
//			}
//			row[p.x][i] = col[p.y][i] = box[(p.x / 3) * 3 + (p.y / 3)][i] = true;
//			sudoku[p.x][p.y] = i;
//			solve(n + 1, w);
//			sudoku[p.x][p.y] = 0;
//			row[p.x][i] = col[p.y][i] = box[(p.x / 3) * 3 + (p.y / 3)][i] = false;	
//		}
//	}
//}