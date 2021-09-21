package baekjoon.bj18000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//스티커 붙이기
public class BJ18808 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] board = new int[N][M];

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int[][] sticker = new int[R][C];
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < C; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			tal1: for (int r = 0; r < 4; r++) {	//4번 90도 회전하는 동안.
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						boolean isStick = true;
						//스티커를 붙일 자리가 있는지 검사.
						tal2: for (int i2 = 0; i2 < sticker.length; i2++) {
							for (int j2 = 0; j2 < sticker[0].length; j2++) {
								if ((i + i2 >= N) || (j + j2 >= M) || (board[i + i2][j + j2] + sticker[i2][j2] > 1)) { //붙일 자리가 없으면 바로 탐색 종료.
									isStick = false;
									break tal2;
								}
							}
						}
						if (isStick) {	//붙일 수 있다면 체크.
							for (int i2 = 0; i2 < sticker.length; i2++) {
								for (int j2 = 0; j2 < sticker[0].length; j2++) {
									board[i + i2][j + j2] += sticker[i2][j2];
								}
							}
							break tal1;
						}
					}
				}
				sticker = rotate(sticker);	//90도 회전시킨다.
			}
		}
		
		//스티커가 붙은 칸의 수를 센다.
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1) {
					count++;
				}
			}
		}

		bw.write(count + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	//90도 시계방향으로 회전
	static int[][] rotate(int[][] sticker) {
		int R = sticker.length;
		int C = sticker[0].length;
		int[][] result = new int[C][R];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				result[j][R - i - 1] = sticker[i][j];
			}
		}

		return result;
	}
}
