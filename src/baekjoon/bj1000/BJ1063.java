package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//킹
public class BJ1063 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String king = st.nextToken();
		String rock = st.nextToken();
		int N = Integer.parseInt(st.nextToken());
		
		int kingX = king.charAt(1) - '1', kingY = king.charAt(0) - 'A';
		int rockX = rock.charAt(1) - '1', rockY = rock.charAt(0) - 'A';
		
		for(int i = 0; i < N; i++) {
			String operation = br.readLine();
			int kx = kingX, ky = kingY, rx = rockX, ry = rockY;
			switch(operation) {
			case "R":	//오른쪽
				ky++;
				ry++;
				break;
			case "L":	//왼쪽
				ky--;
				ry--;
				break;
			case "B":	//아래
				kx--;
				rx--;
				break;
			case "T":	//위
				kx++;
				rx++;
				break;
			case "RT":	//오른쪽 위
				kx++;
				ky++;
				rx++;
				ry++;
				break;
			case "LT":	//왼쪽 위
				kx++;
				ky--;
				rx++;
				ry--;
				break;
			case "RB":	//오른쪽 아래
				kx--;
				ky++;
				rx--;
				ry++;
				break;
			case "LB":	//왼쪽 아래
				kx--;
				ky--;
				rx--;
				ry--;
				break;
			}
			if((0 <= kx && kx < 8) && (0 <= ky && ky < 8)) {	//킹 다음 위치가 범위내고
				if(kx == rockX && ky == rockY) {	//킹 다음 위치가 돌의 위치며
					if((0 <= rx && rx < 8) && (0 <= ry && ry < 8)) {	//돌의 다음 위치도 범위내라면 돌과 킹의 위치 갱신
						rockX = rx;
						rockY = ry;
						kingX = kx;
						kingY = ky;
					}
				}else {	//킹의 다음 위치가 돌의 위치가 아니면 킹의 위치만 갱신
					kingX = kx;
					kingY = ky;
				}
			}
		}
		bw.write((char)(kingY + 'A'));
		bw.write((char)((kingX + 1) + '0'));
		bw.write("\n");
		bw.write((char)(rockY + 'A'));
		bw.write((char)((rockX + 1) + '0'));
		bw.flush();
		bw.close();
		br.close();
	}
}
