package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//Crazy_aRcade_Good
public class BJ17290 {
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken()) - 1;
		int y = Integer.parseInt(st.nextToken()) - 1;
		
		char[][] map = new char[10][];
		for(int i = 0; i < 10; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(map[i][j] == 'o') {
					for(int k = 0; k < d.length; k++) {
						int nx = i + d[k][0], ny = j + d[k][1];
						while((0 <= nx && nx < 10) && (0 <= ny && ny < 10)) {
							if(map[nx][ny] != 'o') {
								map[nx][ny] = '-';
							}
							nx += d[k][0];
							ny += d[k][1];
						}
					}
				}
			}
		}
		int min = 987654321;
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(map[i][j] == 'x') {
					int dist = Math.abs(i - x) + Math.abs(j - y);
					if(min > dist) {
						min = dist;
					}
				}
			}
		}
		
		bw.write(min + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
