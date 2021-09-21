package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

//AC
public class BJ5430 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			solve(br.readLine(), Integer.parseInt(br.readLine()), br.readLine(), bw);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(String op, int n, String arr, Writer w) throws IOException {
		int s, e, opLen = op.length();	//s는 배열의 첫째 인덱스, e는 배열의 마지막 인덱스
		s = (n == 0) ? 0 : 1;	//배열이 비었다면 s는 0, 아니라면 1부터 시작
		e = n;	//e는 n
		for(int i = 0; i < opLen; i++) {	//명령어 따라서
			if(op.charAt(i) == 'R') {	//R인 경우 s와 e를 서로 교환
				int temp = s;
				s = e;
				e = temp;
			}else {	//D인 경우
				if(s == e) {	//s == e인경우는 두가지 중 하나인데 s = e = 0이면 배열이 비었다는것이고 s = e = 그외 는 배열에 요소 하나만 있다는것
					if(s == 0) {
						w.write("error\n");
						return;
					}else {	//하나의 요소만 존재하고 D인 경우 이므로 요소 하나를 빼서 배열이 비게 된다.
						s = e = 0;
					}
				}else if(s > e) {	//s > e이면 s는 감소하고
					s--;
				}else{	//s < e이면 s가 증가한다.
					s++;
				}
			}
		}
		String[] nums = arr.substring(1, arr.length() - 1).split(",");	//문자열로 된 배열을 파싱
		w.write("[");
		if(s > e) {	//각각의 경우에 따라 파싱된 배열에서 골라 출력 (처음에 s가 1부터 시작한다고 했고 배열은 0 부터 시작하므로 s - 1 부터 시작, e도 마찬가지)
			for(int i = s - 1; i >= e - 1; i--) {
				w.write(nums[i]);
				if(i != e - 1) {
					w.write(",");
				}
			}
		}else if(s < e){
			for(int i = s - 1; i <= e - 1; i++) {
				w.write(nums[i]);
				if(i != e - 1) {
					w.write(",");
				}
			}
		}else {
			if(s != 0) {	//0인 경우는 배열이 빈 경우, 그 외는 하나의 요소가 존재
				w.write(nums[s - 1]);
			}
		}
		w.write("]\n");
	}
}
