package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//유턴 싫어
public class BJ2823 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][][] d = {	//각 길('.')에서 동서남북 중 한곳만 뚫려있다면 막다른길
				{{0, -1}, {-1, 0}, {0, 1}},	//남쪽만 뚫림
				{{-1, 0}, {0, 1}, {1, 0}},	//동쪽만 뚫림
				{{0, 1}, {1, 0}, {0, -1}},	//북쪽만 뚫림
				{{1, 0}, {0, -1}, {-1, 0}}	//서쪽만 뚫림
		};
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R + 2][C + 2];	//동서남북 검사시 배열 범위를 넘는걸 방지하기 위해 한겹 더 둘러싼다.
		for(int i = 0; i < R + 2; i++) {	//X로 초기화
			for(int j = 0; j < C + 2; j++) {
				map[i][j] = 'X';
			}
		}
		for(int i = 1; i < R + 1; i++) {
			String str = br.readLine();
			for(int j = 1; j < C + 1; j++) {
				map[i][j] = str.charAt(j - 1);
			}
		}
		boolean isBlocked = false;
		tal: for(int i = 1; i < R + 1; i++) {
			for(int j = 1; j < C + 1; j++) {
				if(map[i][j] == '.') {
					for(int k = 0; k < 4; k++) {
						int count = 0;
						for(int u = 0; u < 3; u++) {
							if(map[i + d[k][u][0]][j + d[k][u][1]] == 'X') {
								count++;
							}
						}
						if(count == 3) {	//3곳이 막혔다면 막다른길
							isBlocked = true;
							break tal;
						}
					}
				}
			}
		}
		if(isBlocked) {
			bw.write("1\n");
		}else {
			bw.write("0\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
