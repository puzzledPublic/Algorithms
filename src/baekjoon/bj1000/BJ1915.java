package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//가장 큰 정사각형
public class BJ1915 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[][] rectangle = new int[N][M];	//rectangle[i][j] = (i,j)가 정사각형을 이루는 우하단 마지막 칸일때 정사각형 변의 길이
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				rectangle[i][j] = line.charAt(j) - '0';
			}
		}
		
		//N = 1인 경우를 위해 첫번째 행을 돌며 result를 갱신
		int result = 0;
		for(int i = 0; i < N; i++) {
			if(rectangle[i][0] == 1) {
				result = 1;
				break;
			}
		}
		
		//M = 1인 경우를 위해 첫번째 열을 돌며 result를 갱신
		if(result == 0) {
			for(int i = 0; i < M; i++) {
				if(rectangle[0][i] == 1) {
					result = 1;
					break;
				}
			}
		}
		
		//그 외의 경우
		for(int i = 1; i < N; i++) {
			for(int j = 1; j < M; j++) {
				//현재 칸이 1이고 현재 칸 기준 좌단, 좌상단, 상단이 1이상이면 그 3칸 중 가장 작은 수 + 1이 현재 칸으로 정사각형을 만들 수 있는 변의 길이가 된다.
				if(rectangle[i][j] == 1 && rectangle[i - 1][j] > 0 && rectangle[i][j] > 0 && rectangle[i - 1][j - 1] > 0) {
					rectangle[i][j] = Math.min(rectangle[i - 1][j], Math.min(rectangle[i][j - 1], rectangle[i - 1][j - 1])) + 1;
					if(result < rectangle[i][j]) {	//가장 큰 정사각형 변의 길이 갱신
						result = rectangle[i][j];
					}
				}
			}
		}
		
		//정사각형의 넓이 출력
		bw.write((result * result) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
