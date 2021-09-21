package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//주사위 쌓기
public class BJ2116 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] dice = new int[N][6];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		int[] pos = {5, 3, 4, 1, 2, 0};	//주사위에서 번호 i에 반대편인 번호들
		for(int i = 0; i < 6; i++) {	//시작번호가 정해지면 나머지 주사위 위치도 정해진다.
			int startPos = i, nextPos = pos[i], start, next, sum = 0;
			for(int j = 0; j < N; j++) {	//주사위들을 돌며
				start = dice[j][startPos];	//시작번호의 숫자와 반대번호의 숫자를 알아낸다.
				next = dice[j][nextPos];
				sum += getMaxNum(start, next);	//1~6까지 알아낸 숫자를 제외한 숫자들 중 최대값을 더한다. (생각해보면 한면의 최대값만 구하면 되므로 주사위들을 돌릴 필요없이 각 주사위에서 얻을 수 있는 최대값들을 더하면 된다.)
				
				if(j + 1 == N) break;	//마지막 주사위인 경우 아래에서 조사할 다음 주사위의 시작번호를 알아낼 필요가 없으므로 종료
				
				for(int k = 0; k < 6; k++) {	//1~6번까지
					if(dice[j + 1][k] == next) {	//다음 주사위의 시작번호를 알아낸다.
						startPos = k;	//시작번호
						nextPos = pos[k];	//반대편번호
						break;
					}
				}
			}
			
			if(result < sum) {	//최대값 갱신
				result = sum;
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	//1~6의 숫자에서 start, next를 제외한 숫자들 중 최대값을 리턴한다.
	static int getMaxNum(int start, int next) {
		if(start > next) {	//start < next가 되도록한다.
			int t = start;
			start = next;
			next = t;
		}
		if(next == 6 && start == 5) {	//next=6, start=5인경우 최대는 4
			return 4;
		}else if(next == 6) {	//next=6, start!=5인경우 최대는 5
			return 5;
		}
		return 6;	//그외 최대는 6
	}
}
