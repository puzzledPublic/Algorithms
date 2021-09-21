package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//나는 학급회장이다
public class BJ2456 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		//prefer[i][0] = i의 총 점수, [i][1~3] = i의 각 점수 개수, [i][4] = 정렬 후 인식하기 위한 i번호
		int[][] prefer = new int[3][5];
		prefer[0][4] = 1;
		prefer[1][4] = 2;
		prefer[2][4] = 3;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 3; j++) {
				int p = Integer.parseInt(st.nextToken());
				prefer[j][0] += p;
				prefer[j][p]++;
			}
		}
		
		//총 점수, 3점 개수, 2점 개수 순으로 내림차순 정렬
		Arrays.sort(prefer, (a, b) -> {
			if(b[0] == a[0]) {
				if(b[3] == a[3]) {
					return b[2] - a[2];
				}
				return b[3] - a[3];
			}
			return b[0] - a[0];
		});
		
		//첫번째 두번째 학생이 점수가 모두 같으면 결정 안남.
		if(prefer[0][0] == prefer[1][0] && prefer[0][3] == prefer[1][3] && prefer[0][2] == prefer[1][2]) {
			bw.write("0 " + prefer[0][0]);
		}else {	//그 외의 경우 첫번째 학생이 회장.
			bw.write(prefer[0][4] + " " + prefer[0][0]);
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
