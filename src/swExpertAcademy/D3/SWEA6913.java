package swExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//동철이의 프로그래밍 대회
public class SWEA6913 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
			int max = 0, human = 0;		//최고 점수, 최고 점수를 받은 사람 수
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int score = 0;
				for(int k = 0; k < M; k++) {	//점수 계산
					score += Integer.parseInt(st.nextToken());
				}
				if(max < score) {	//최고 점수보다 높으면 갱신
					max = score;
					human = 1;
				}else if(max == score) {	//최고 점수와 같다면 사람 수 증가
					human++;
				}
			}
			bw.write("#" + i + " " + human + " " + max + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
