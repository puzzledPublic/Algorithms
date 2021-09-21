package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//색종이 - 2
public class BJ2567 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[][] paper = new char[102][102];
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			for(int j = x; j < x + 10; j++) {	//해당 사각형을 검은색으로 바꾼다.
				for(int k = y; k < y + 10; k++) {
					paper[j][k] = 'B';
				}
			}
		}
		int result = 0;
		for(int i = 1; i < 101; i++) {
			for(int j = 1; j < 101; j++) {
				if(paper[i][j] == 'B') {	//검은색구역이고 상하좌우에 흰색이 있는 갯수에따라 변의길이 증가.
					if(paper[i - 1][j] == '\0') result++;
					if(paper[i][j - 1] == '\0') result++;
					if(paper[i + 1][j] == '\0') result++;
					if(paper[i][j + 1] == '\0') result++;
				}
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
