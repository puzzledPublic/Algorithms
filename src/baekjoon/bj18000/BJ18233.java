package baekjoon.bj18000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//러버덕을 사랑하는 모임
public class BJ18233 {
	static class Doll {
		int index, min, max;
		Doll(int index, int min, int max) {
			this.index = index;
			this.min = min;
			this.max = max;
		}
	}
	static Doll[] dolls;
	static Doll[] selectedDolls;
	static boolean[] selected;
	static int N, P, E;
	static boolean alreadyPrint;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		dolls = new Doll[N];
		selectedDolls = new Doll[P];
		selected = new boolean[N];
		result = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			dolls[i] = new Doll(i, min, max);
		}
		
		calc(0, 0);
		
		if(alreadyPrint) {
			for(int i = 0; i < N; i++) {
				bw.write(result[i] + " ");
			}
		}else {
			bw.write("-1\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void calc(int k, int p) {
		if(alreadyPrint) {	//이미 출력됐으면 바로 리턴
			return;
		}
		if(k == N && p != P) {	//P명을 고르지 않고 N명을 모두 탐색한 경우
			return;
		}
		if(p == P) {	//P명을 고른 경우
			int min = 0, max = 0;	//P명의 최소, 최대 요구 인형 수
			for(int i = 0; i < selectedDolls.length; i++) {
				min += selectedDolls[i].min;
				max += selectedDolls[i].max;
			}
			
			if(min <= E && E <= max) {	//범위 내에 E개가 포함되면 나눠줄 수 있다.
				int e = E;	//나눠 줄 인형 수
				for(int i = 0; i < selectedDolls.length; i++) {	//각 사람이 요구하는 최소 인형 수 만큼 나눠준다.
					e -= selectedDolls[i].min;
					result[selectedDolls[i].index] = selectedDolls[i].min;
				}
				for(int i = 0; i < selectedDolls.length; i++) {	//각 사람을 돌며 남은 인형들을 그리디하게 나눠 준다.
					if(selectedDolls[i].max - selectedDolls[i].min >= e) {
						result[selectedDolls[i].index] += e;
						break;
					}else {
						result[selectedDolls[i].index] += selectedDolls[i].max - selectedDolls[i].min;
						e -= selectedDolls[i].max - selectedDolls[i].min;
					}
				}
				alreadyPrint = true;	//답 구했으니 출력 표시.
			}
			return;
		}
		
		selectedDolls[p] = dolls[k];
		calc(k + 1, p + 1);	//선택 하거나
		
		calc(k + 1, p);	//선택 안하거나
	}
}
