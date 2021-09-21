package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//문자메시지
public class BJ2037 {
	//' ' = 1, ABC = 2, DEF = 3, GHI = 4, JKL = 5, MNO = 6, PQRS = 7, TUV = 8, WXYZ = 9 
	static int[][] alpha = new int[26][2];	//alpha[i][0] = (char)(65 + i)의 버튼번호, alpha[i][1] = 누르는 횟수
	static {
		alpha[0][0] = alpha[1][0] = alpha[2][0] = 2;
		alpha[0][1] = 1;
		alpha[1][1] = 2;
		alpha[2][1] = 3;
		alpha[3][0] = alpha[4][0] = alpha[5][0] = 3;
		alpha[3][1] = 1;
		alpha[4][1] = 2;
		alpha[5][1] = 3;
		alpha[6][0] = alpha[7][0] = alpha[8][0] = 4;
		alpha[6][1] = 1;
		alpha[7][1] = 2;
		alpha[8][1] = 3;
		alpha[9][0] = alpha[10][0] = alpha[11][0] = 5;
		alpha[9][1] = 1;
		alpha[10][1] = 2;
		alpha[11][1] = 3;
		alpha[12][0] = alpha[13][0] = alpha[14][0] = 6;
		alpha[12][1] = 1;
		alpha[13][1] = 2;
		alpha[14][1] = 3;
		alpha[15][0] = alpha[16][0] = alpha[17][0] = alpha[18][0]= 7;
		alpha[15][1] = 1;
		alpha[16][1] = 2;
		alpha[17][1] = 3;
		alpha[18][1] = 4;
		alpha[19][0] = alpha[20][0] = alpha[21][0] = 8;
		alpha[19][1] = 1;
		alpha[20][1] = 2;
		alpha[21][1] = 3;
		alpha[22][0] = alpha[23][0] = alpha[24][0] = alpha[25][0] = 9;
		alpha[22][1] = 1;
		alpha[23][1] = 2;
		alpha[24][1] = 3;
		alpha[25][1] = 4;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int P = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		
		int time = 0;
		int prevNumber = -1;
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == ' ') {	//공백이면 버튼 누른 시간만 추가.
				time += P;
				prevNumber = -1;	//이전에 누른 번호 초기화
			}else {	//알파벳인 경우
				int number = alpha[ch - 65][0];	//현재 누른 번호
				if(number == prevNumber) {	//이전 누른 번호와 같다면 기다리는 시간 추가.
					time += W;
				}
				time += (alpha[ch - 65][1] * P);	//버튼 누른 횟수 * 버튼 누른 시간 추가.
				prevNumber = number;	//이전 번호 갱신
			}
		}
		
		bw.write(time + "\n");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
