package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//기타줄	(그리디)
public class BJ1049 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int sixPack = Integer.MAX_VALUE, onePack = Integer.MAX_VALUE;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sixTmp = Integer.parseInt(st.nextToken()), oneTmp = Integer.parseInt(st.nextToken());
			if(sixPack > sixTmp) {	//6묶음 가격중 가작 낮은것을 고른다.
				sixPack = sixTmp;
			}
			if(onePack > oneTmp) {	//낱개 가격중 가장 낮은것을 고른다.
				onePack = oneTmp;
			}
		}
		int total = 0;
		if(sixPack >= 6 * onePack) {	//6묶음 가격이 낱개 6개 가격보다 크다면 모두 낱개로 사는게 가격이 제일 낮다.
			total = N * onePack;
		}else {	//6묶음 가격이 더 낮다면
			total = (N / 6) * sixPack;	//N개 이하에서 최대한 6묶음씩 사놓는다.
			int left = N % 6;	//그리고 남은 left개의 기타줄은
			if(sixPack > onePack * left) {	//6개 묶음 가격이 낱개 left개 가격보다 크다면 left개를 낱개로 산다.
				total += onePack * left;
			}else {							//아니라면 6개 묶음으로 산다.
				total += sixPack;
			}
		}
		
		bw.write(total + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
