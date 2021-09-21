package swExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//달팽이 숫자
public class SWEA1954 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] d = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			bw.write("#" + i + "\n");
			int direct = 0, x = 0, y = 0, val = 1, count = 0;
			while(count < 4) {	//상하좌우 모든 방향으로 쓸 수 없다면 종료
				if(!((0 <= x && x < N) && (0 <= y && y < N) && arr[x][y] == 0)) {	//현재 좌표가 쓰기 불능이면
					x -= d[direct][0];	//한번 되돌린다.
					y -= d[direct][1];
					direct = (direct + 1) % 4;	//방향을 바꾼다
					count++;
				}else {		//현재 좌표가 쓸 수 있으면
					arr[x][y] = val++;	//숫자를 쓴다.
					count = 0;
				}
				x += d[direct][0];	//다음 좌표로 이동
				y += d[direct][1];
			}
			
			for(int j = 0; j < N; j++) {	//출력
				for(int k = 0; k < N; k++) {
					bw.write(arr[j][k] + " ");
				}
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
