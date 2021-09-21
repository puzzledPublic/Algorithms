package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//아이 러브 크로아티아
public class BJ9517 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int K = Integer.parseInt(br.readLine()) - 1;	//시작번호, 8명이지만 번호를 0~7사이로 만든다.
		int N = Integer.parseInt(br.readLine());	//질문 수
		int bombTime = 210;	//터지는 시간(초)
		int time = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int answerTime = Integer.parseInt(st.nextToken());	//대답에 걸리는 시간
			char answer = st.nextToken().charAt(0);	//대답
			if(time + answerTime >= bombTime) {	//현재시간 + 대답에 걸리는 시간 >= 터지는시간이면 현재 번호에서 터진다.
				bw.write((K + 1) + "\n");	//0~7번이므로 1을 더해줘서 출력.
				break;
			}
			time += answerTime;	//대답에 걸리는 시간을 더해줌.
			if(answer == 'T') {	//정답을 맞췄다면 다음 번호로 넘어간다.
				K = (K + 1) % 8;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
