package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//빗물
public class BJ14719 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		boolean[][] world = new boolean[H][W];	//2차원 세상
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < W; i++) {
			int h = Integer.parseInt(st.nextToken());
			for(int j = 0; j < h; j++) {	//기둥을 그려준다.
				world[j][i] = true;
			}
		}
		
		//기둥은 수직으로만 있으므로 뚜껑이 존재하지 않는다. 그래서 왼쪽->오른쪽으로 훑으면서 계산하면 된다.
		int count = 0;
		for(int i = 0; i < H; i++) {
			boolean left = false;	//왼쪽 기둥
			int tmp = 0;			//왼쪽 기둥 위치 인덱스
			for(int j = 0; j < W; j++) {
				if(world[i][j] && !left) {	//현재 위치에 기둥이 있고 왼쪽 기둥이 없다면 현재 기둥을 왼쪽 기둥으로 정한다.
					left = true;
					tmp = j;
				}else if(world[i][j] && left) {	//현재 위치에 기둥이 있고 왼쪽 기둥이 있다면 현재 기둥은 오른쪽 기둥이고 둘 사이의 거리만큼 빗물이 찬다.
					count += (j - tmp - 1);
					tmp = j;
				}
			}
		}
		
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
