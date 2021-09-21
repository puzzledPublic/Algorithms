package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

//벽 부수고 이동하기4
public class BJ16946 {
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static char[][] board;
	static int[][] group, result;
	static int N, M;
	static int mark = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][];
		group = new int[N][M];
		result = new int[N][M];
		for(int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j] == '0' && group[i][j] == 0) {	//이동할 수 있는 칸이고 그룹화가 아직 안된 경우 그룹화.
					int count = dfs(i, j);
					mark++;	//그룹 번호 증가
					list.add(count);	//그룹 내 이동 칸의 개수
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j] == '1') {	//벽인 경우, 벽을 제거했을때
					Set<Integer> set = new HashSet<>();
					for(int k = 0; k < d.length; k++) {	//벽 위치에서 상,하,좌,우를 살펴보며  '0'인 경우 해당 그룹을 확인하고 이동 칸의 개수 추가.
						int nx = i + d[k][0], ny = j + d[k][1];
						if((0 <= nx && nx < N) && (0 <= ny && ny < M) && board[nx][ny] == '0') {
							set.add(group[nx][ny]);	//그룹이 중복해 추가되는 것을 방지하기 위해 set에 그룹번호 저장.
						}
					}
					result[i][j]++;	//벽 칸 추가.
					for(int index : set) {
						result[i][j] += list.get(index - 1);	//그룹들의 이동 칸 개수 추가.
					}
				}
			}
		}
		//출력
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				bw.write((result[i][j] % 10) + "");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	static int dfs(int x, int y) {	//그룹화
		group[x][y] = mark;	//mark 번호로 체크.
		int result = 1;
		for(int i = 0; i < d.length; i++) {
			int nx = x + d[i][0], ny = y + d[i][1];
			if((0 <= nx && nx < N) && (0 <= ny && ny < M) && board[nx][ny] == '0' && group[nx][ny] == 0) {
				result += dfs(nx, ny);
			}
		}
		return result;
	}
}
