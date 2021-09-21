package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

//누울 자리를 찾아라
public class BJ1652 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][];
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		solve(N, map, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(int N, char[][] map, Writer w) throws IOException {
		int countRow = 0, countCol = 0;	//가로로 누울 자리 개수, 세로로 누울 자리 개수
		for(int i = 0; i < N; i++) {
			boolean flagRow = false, flagCol = false;	//자리가 있는지 flag
			for(int j = 1; j < N; j++) {
				if(!flagRow && map[i][j] == '.' && map[i][j - 1] == '.') {	//두개 연속으로 빈 자리면
					flagRow = true;	//자리있음 flag on
					countRow++;		//자리개수 ++
				}
				if(map[i][j] == 'X') {	//짐이 있는 경우 그 경계로 자리가 갱신
					flagRow = false;	//자리있음 flag off
				}
				
				if(!flagCol && map[j][i] == '.' && map[j - 1][i] == '.') {
					flagCol = true;
					countCol++;
				}
				if(map[j][i] == 'X') {
					flagCol = false;
				}
			}
		}
		w.write(countRow + " " + countCol + "\n");
	}
}
