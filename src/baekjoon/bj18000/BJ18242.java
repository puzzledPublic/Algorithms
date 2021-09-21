package baekjoon.bj18000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//네모네모 시력검사
public class BJ18242 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] rect = new char[N][];
		for(int i = 0; i < N; i++) {
			rect[i] = br.readLine().toCharArray();
		}
		boolean topOrDown = false, leftOrRight = false;
		int gateX = -1, gateY = -1;
		tal: for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(rect[i][j] == '.') {
					if((j - 1 >= 0 && j + 1 < M && rect[i][j - 1] == '#' && rect[i][j + 1] == '#')) {
						topOrDown = true;
						gateX = i;
						gateY = j;
						break tal;
					}else if((i - 1 >= 0 && i + 1 < N && rect[i - 1][j] == '#' && rect[i + 1][j] == '#')) {
						leftOrRight = true;
						gateX = i;
						gateY = j;
						break tal;
					}
				}
			}
		}
		
		if(topOrDown) {
			boolean down = false;
			while(gateX >= 0) {
				if(rect[gateX][gateY] == '#') {
					down = true;
					break;
				}
				gateX--;
			}
			if(down) {
				bw.write("DOWN\n");
			}else {
				bw.write("UP\n");
			}
		}else if(leftOrRight) {
			boolean right = false;
			while(gateY >= 0) {
				if(rect[gateX][gateY] == '#') {
					right = true;
					break;
				}
				gateY--;
			}
			if(right) {
				bw.write("RIGHT\n");
			}else {
				bw.write("LEFT\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
