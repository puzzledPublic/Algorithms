package baekjoon.bj3000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//테트리스
public class BJ3019 {
	//각 블록 모양 하단의 상대값을 매김. 바닥에 맞닫는 면은 0 높아질수록 -1증가 (ex. '|' 모양의 바닥은 0, '----' 모양의 바닥은 0,0,0,0, 'ㅜ' 모양의 바닥은 -1,0,-1)
	static int[][][] tetris = { { { 0 }, { 0, 0, 0, 0 } }, { { 0, 0 } }, { { -1, 0 }, { 0, 0, -1 } },
			{ { 0, -1 }, { -1, 0, 0 } }, { { -1, 0 }, { 0, -1 }, { 0, 0, 0 }, { -1, 0, -1 } },
			{ { -2, 0 }, { 0, 0 }, { 0, 0, 0 }, { 0, -1, -1 } }, { { 0, -2 }, { 0, 0 }, { 0, 0, 0 }, { -1, -1, 0 } } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int C = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int[] heights = new int[C];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;

		for (int p = 0; p < tetris[P - 1].length; p++) { // P 블록 회전시 각각 다른 모양 수
			for (int i = 0; i < C - tetris[P - 1][p].length + 1; i++) { // (테트리스 판의 width - 각 블록 모양의 width)만큼 테트리스 판 조사.
				int[] arr = new int[tetris[P - 1][p].length];
				for (int j = 0; j < tetris[P - 1][p].length; j++) {
					arr[j] = heights[i + j] + tetris[P - 1][p][j];
				}
				
				boolean sameAll = true;
				for (int k = 1; k < arr.length; k++) {
					if (arr[k] != arr[k - 1]) {
						sameAll = false;
						break;
					}
				}
				if (sameAll) {
					count++;
				}
			}
		}

		bw.write(count + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
