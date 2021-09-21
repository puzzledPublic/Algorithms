package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//숫자고르기
public class BJ2668 {
	static int N;	//배열 크기
	static int[] chart;	//해당 인덱스에 대한 숫자를 담을 배열
	static boolean[] chk;	//DFS 중복 방문 방지 위한 배열
	static boolean back;	//해당 숫자를 list에 넣을지 chk배열을 원상복구 할지 결정할 flag
	static List<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		chart = new int[N + 1];
		list = new ArrayList<>();
		chk = new boolean[N + 1];
		for(int i = 1; i <= N; i++) {
			chart[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 1; i <= N; i++) {
			if(!chk[i]) {	//방문안한 숫자들에 대해 i로 시작해 i로 끝나는 사이클을 이루는지 검사
				back = false;
				solve(i, i);
			}
		}
		
		Collections.sort(list);
		bw.write(list.size() + "\n");
		for(int i : list) {
			bw.write(i + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(int start, int next) {	//DFS 시작, start에서 시작해 start로 끝나면(사이클) 그 사이의 숫자들은 쌍이 존재한다.
		if(chk[next]) {	//이미 방문했고
			if(start == next) {	//시작점(start)라면 백트래킹시 list에 숫자를 넣기위해 flag 설정
				back = true;
			}
			return;
		}
		chk[next] = true;	//방문체크
		
		solve(start, chart[next]);	//다음 숫자 방문
		
		if(back) {	//백트래킹하며 list에 숫자를 넣는다.
			list.add(next);
		}else {		//사이클이 존재안하므로 방문표시를 다시 지운다.
			chk[next] = false;
		}
	}
}
