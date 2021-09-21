package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//패턴
public class BJ17300 {
	static int[][] pos = {{0, 0}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};	//3x3행렬에서 i의 좌표
	static int[][] screen = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};	//3x3행렬
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[10];
		boolean[] chk = new boolean[11];	//이미 수열에 들었는지 표시하는 배열
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean can = true;
		chk[arr[0]] = true;	//첫번째 숫자 표시
		for(int i = 1; i < N; i++) {
			if(chk[arr[i]]) {	//이미 나온 숫자라면 패턴 불가
				can = false;
				break;
			}
			int len1 = Math.abs(pos[arr[i - 1]][0] - pos[arr[i]][0]);	//이전 숫자와 현재 숫자 좌표 차이의 절대값.
			int len2 = Math.abs(pos[arr[i - 1]][1] - pos[arr[i]][1]);
			//좌표 절대값이 (2, 0), (0, 2), (2, 2)가 아니라면 바로 갈 수 있는 곳이므로 체크
			if(!((len1 == 2 && len2 == 0) || (len1 == 0 && len2 == 2) || (len1 == 2 && len2 == 2))) {
				chk[arr[i]] = true;
			}else {
				//좌표 절대값이 (2, 0), (0, 2), (2, 2)라면 중간에 숫자 하나를 건너 뛴 셈이고 ex)1 -> 9 or 1 -> 3 or 1 -> 7...
				//중간 숫자 좌표를 계산하여 해당 좌표의 숫자가 체크 되어있다면 현재 숫자로 갈 수 있다.
				int x = (pos[arr[i - 1]][0] + pos[arr[i]][0]) / 2;
				int y = (pos[arr[i - 1]][1] + pos[arr[i]][1]) / 2;
				if(chk[screen[x][y]]) {
					chk[arr[i]] = true;
				}else {
					can = false;
					break;
				}
			}
		}
		
		bw.write(can ? "YES" : "NO");
		bw.flush();
		bw.close();
		br.close();
	}
}