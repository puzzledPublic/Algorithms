package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//두개의 손 (무조건 이기는 경우만 알면되므로 MS가 낸 두 모양을 TK와 대조하며 둘다 이기는 경우 무조건 MS, 그 반대로 TK->MS로도 조사한다. 그 외의 경우 결과는 알 수 없음)
public class BJ16675 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		String msL = st.nextToken();
		String msR = st.nextToken();
		String tkL = st.nextToken();
		String tkR = st.nextToken();
		
		if(win(msL, tkL) && win(msL, tkR)) {
			bw.write("MS\n");
		}else if(win(msR, tkL) && win(msR, tkR)) {
			bw.write("MS\n");
		}else if(win(tkL, msL) && win(tkL, msR)) {
			bw.write("TK\n");
		}else if(win(tkR, msL) && win(tkR, msR)) {
			bw.write("TK\n");
		}else {
			bw.write("?\n");
		}
		/*
		 * int[] state = new int[4]; for(int i = 0; i < 4; i++) { char input =
		 * st.nextToken().charAt(0); if(input == 'R') { state[i] = 0; }else if(input ==
		 * 'S') { state[i] = 1; }else { state[i] = 2; } } boolean printed = false;
		 * for(int i = 0; i < 2; i++) { int win = 0; for(int j = 2; j < 4; j++) {
		 * if((state[i] + 1) % 3 == state[j]) { win++; } } if(win == 2) {
		 * bw.write("MS\n"); printed = true; break; } } if(!printed) { for(int i = 2; i
		 * < 4; i++) { int win = 0; for(int j = 0; j < 2; j++) { if((state[i] + 1) % 3
		 * == state[j]) { win++; } } if(win == 2) { bw.write("TK\n"); printed = true;
		 * break; } } } if(!printed) { bw.write("?\n"); }
		 */
		bw.flush();
		bw.close();
		br.close();
	}
	static boolean win(String source, String dest) {
		if(source.equals("R") && dest.equals("S")) {
			return true;
		}else if(source.equals("S") && dest.equals("P")) {
			return true;
		}else if(source.equals("P") && dest.equals("R")) {
			return true;
		}
		return false;
	}
}
