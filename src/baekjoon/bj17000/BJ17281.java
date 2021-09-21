package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//야구
public class BJ17281 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] permut = new int[]{1, 2, 3, 4, 5, 6, 7, 8};	//8명의 순열배열 (1번은 4번째로 고정이므로 제외)
		int[] order = new int[9];	//1번 선수까지 넣은 순열 배열
		int N = Integer.parseInt(br.readLine());
		int[][] hitter = new int[N][9];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 9; j++) {
				hitter[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int maxScore = 0;
		while(permutation(permut)) {	//순열 배열(타자 순서) 생성
			
			for(int i = 0; i < 3; i++) {	//1번 선수를 포함하는 순열 배열 생성
				order[i] = permut[i];
			}
			for(int i = 4; i < 9; i++) {
				order[i] = permut[i - 1];
			}
			
			//이닝, 아웃, 1,2,3루, 다음 타자, 점수
			int inning = 0, out = 0, ru1 = 0, ru2 = 0, ru3 = 0, next = 0, score = 0;
			while(inning < N) {	//모든 이닝이 끝날때까지
				switch(hitter[inning][order[next]]) {
				case 1:	//안타인 경우
					score += ru3;
					ru3 = ru2;
					ru2 = ru1;
					ru1 = 1;
					break;
				case 2:	//2루타이 경우
					score += (ru3 + ru2);
					ru3 = ru1;
					ru1 = 0;
					ru2 = 1;
					break;
				case 3:	//3루타인 경우
					score += (ru3 + ru2 + ru1);
					ru2 = ru1 = 0;
					ru3 = 1;
					break;
				case 4:	//홈런인 경우
					score += (ru3 + ru2 + ru1 + 1);
					ru3 = ru2 = ru1 = 0;
					break;
				default:	//아웃인 경우
					out++;
					break;
				}
				
				if(out == 3) {	//3아웃인 경우 모든 루를 비우고 다음 이닝으로
					ru1 = ru2 = ru3 = out = 0;
					inning++;
				}
				next = (next + 1) % 9;	//다음 타자
			}
			
			if(maxScore < score) {	//최대 점수 갱신
				maxScore = score;
			}
		}
		
		bw.write(maxScore + "\n");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	static boolean permutation(int[] arr) {	//순열
		int i = arr.length - 1, j = arr.length - 1;
		
		while(i > 0 && arr[i] < arr[i - 1]) {
			i--;
		}
		
		if(i == 0) {
			return false;
		}
		
		while(arr[j] < arr[i - 1]) {
			j--;
		}
		
		int temp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = temp;
		
		j = arr.length - 1;
		
		while(i < j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		
		return true;
	}
}
