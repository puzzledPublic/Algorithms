package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//숫자 게임
public class BJ2303 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int max = 0, person = -1;	//max = 가장 높은 점수, person = 가장 높은 점수를 가진 사람의 번호
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][5];

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {	//각 사람들에서
			int pMax = -1;
			for(int j = 0; j < 3; j++) {	//3개의 번호를 뽑았을때 가장 높은 일의 자리 숫자 알아내기
				for(int k = j + 1; k < 4; k++) {
					for(int u = k + 1; u < 5; u++) {
						int grade = (arr[i][j] + arr[i][k] + arr[i][u]) % 10;
						if(pMax < grade) {
							pMax = grade;
						}
					}
				}
			}
			//가장 높은 점수라면 갱신.
			if(max <= pMax) {	//최고숫자가 같다면 사람중 가장 번호가 높은 사람이 되어야하므로 '<='로 처리
				max = pMax;
				person = i + 1;
			}
		}
		bw.write(person + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
