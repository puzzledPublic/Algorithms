package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//게임
public class BJ1072 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long X = Integer.parseInt(st.nextToken());
		long Y = Integer.parseInt(st.nextToken());
		
		long curr = (Y * 100) / X;	//현재 승률
		if(curr >= 99) {	//99%이상이면 변하지 않는다.
			bw.write("-1\n");
		}else {
			long start = 1, end = X * 2;	//최대 X의 2배면 알 수 있다.
			while(start < end) {	//이분탐색. mid번 더 이겼을때 승률이 올라가는가?
				long mid = (start + end) / 2;
				if((((Y + mid) * 100) / (X + mid)) <= curr) {	//승률이 올라가지 않으면 이긴 수를 높여본다.
					start = mid + 1;
				}else {	//승률이 높아지면 이긴 수를 줄여본다.
					end = mid;
				}
			}
			bw.write(start + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
