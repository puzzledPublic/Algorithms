package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//원판돌리기
public class BJ17822 {
	static int N, M, T;	//N = 원판 개수, M = 원판 당 숫자 개수, T = 회전 명령 수 
	static int[][] circle;
	static boolean[][] chk;
	static int[] tmp;
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		circle = new int[N + 1][M];	//숫자x 배수들의 행을 회전해야해서 1부터 시작하도록 행을 하나 더 추가한다.
		tmp = new int[M];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				circle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());	//회전 시켜야할 행 (x의 배수)
			int d = Integer.parseInt(st.nextToken());	//회전 방향 (0 = 오른쪽, 1 = 왼쪽)
			int k = Integer.parseInt(st.nextToken());	//회전 수
			rowRotate(x, d, k);	//회전 시킨다.
//			System.out.println("rowRotated");
//			printState();
			if(!erase()) {	//인접한 수들을 삭제
				calculate();	//삭제한 수가 없으면 평균 계산 후 숫자 가감
//				System.out.println("calcualted");
//				printState();
			}else {
//				System.out.println("erased");
//				printState();
			}
		}
//		System.out.println("done");
//		printState();

		//남아있는 모든 숫자들의 합 계산
		int result = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				if(circle[i][j] != Integer.MIN_VALUE) {
					result += circle[i][j];
				}
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
//	static void printState() {
//		for(int i = 1; i <= N; i++) {
//			for(int j = 0; j < M; j++) {
//				System.out.print((circle[i][j] == Integer.MIN_VALUE ? "x" : circle[i][j]) + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
	
	static void calculate() {
		int sum = 0, count = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				if(circle[i][j] != Integer.MIN_VALUE) {
					sum += circle[i][j];
					count++;
				}
			}
		}
		double avg = (double)sum / count;
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				if(circle[i][j] != Integer.MIN_VALUE) {
					if((double)circle[i][j] < avg) {
						circle[i][j]++;
					}else if(circle[i][j] > avg){
						circle[i][j]--;
					}
				}
			}
		}
//		System.out.println("sum: " + sum + " count: " + count + " avg: " + avg);
	}
	
	static boolean erase() {
		chk = new boolean[N + 1][M];
		for(int i = 1; i <= N; i++) {	//인접한 같은 숫자들이 있는지 체크
			for(int j = 0; j < M; j++) {
				for(int k = 0; k < d.length; k++) {
					int nx = i + d[k][0], ny = j + d[k][1];
					if(ny == -1) ny = M - 1;	//원판이므로 양 옆으로도 이어지는것을 주의
					else if(ny == M) ny = 0;
					//지워진 숫자(Integer.MIN_VALUE)가 아니면서 인접한 같은 숫자면 체크
					if((1 <= nx && nx <= N) && circle[i][j] == circle[nx][ny] && circle[i][j] != Integer.MIN_VALUE) chk[i][j] = chk[nx][ny] = true;
				}
			}
		}
		
		boolean isErased = false;
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < M; j++) {
				if(chk[i][j]) {
					isErased = true;
					circle[i][j] = Integer.MIN_VALUE;	//삭제 체크.
				}
			}
		}
		return isErased;
	}
	
	static void rowRotate(int x, int d, int k) {
		k = k % M;	//k >= M인 경우 k % M번 회전 하는것과 같다.
		if(d != 0) {	//왼쪽으로 k번 회전하는 것은 오른쪽으로 M - k번 회전하는 것과 같다.
			k = M - k;
		}
		
		for(int i = x; i <= N; i += x) {
			for(int j = 0; j < M; j++) {
				tmp[(j + k) % M] = circle[i][j];
			}
			for(int j = 0; j < M; j++) {
				circle[i][j] = tmp[j];
			}
		}
	}
}
