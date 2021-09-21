package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//기상캐스터
public class BJ10709 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < H; i++) {
			int f = -1;	//시작 숫자
			String line = br.readLine();
			for(int j = 0; j < W; j++) {
				char at = line.charAt(j);
				if(at == 'c') {	//구름이라면 0
					f = 0;
				}else if(f != -1){	//-1이 아니라면 숫자 증가
					f++;
				}
				bw.write(f + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
