package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//마술사 남정훈
//S = 00, D = 11, H = 01, C = 10
//Epahs lasrever : S <-> C, D <-> H
//Roloc lasrever : S <-> H, C <-> D
//Gnitfihs(N) : 오른쪽으로 N번 쉬프트
//Tniop-taht-egnahc(N, P) : N번 카드를 P로 교체
//Aliov: 현재 문자열 출력
public class BJ17217 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		long xor = 0;
		for(int i = 0; i < 26; i++) {
			xor <<= 2;
			xor += 1;
		}
	
		long cards = 0;
		for(int i = 0; i < str.length(); i++) {
			switch(str.charAt(i)) {
			case 'S':
				cards <<= 2;
				break;
			case 'C':
				cards <<= 1;
				cards += 1;
				cards <<= 1;
				break;
			case 'D':
				cards <<= 1;
				cards += 1;
				cards <<= 1;
				cards += 1;
				break;
			case 'H':
				cards <<= 2;
				cards += 1;
				break;
			}
		}
		
		long tmp, n, zero, bit = 1L << 63;
		char p;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char ch = st.nextToken().charAt(0);
			switch(ch) {
			case 'E':
				cards = ~(cards ^ xor);
				break;
			case 'R':
				cards = (cards ^ xor);
				break;
			case 'G':
				tmp = 1;
				zero = 1;
				n = Integer.parseInt(st.nextToken());
				for(int j = 0; j < n * 2 - 1; j++) {
					tmp <<= 1;
					tmp += 1;
					zero <<= 1;
					zero += 1;
				}
				tmp = cards & tmp;
				cards >>= (n * 2);
				tmp <<= (26 - n) * 2;
				zero <<= (26 - n) * 2;
				cards &= ~zero;
				cards |= tmp;
				break;
			case 'T':
				n = Integer.parseInt(st.nextToken());
				p = st.nextToken().charAt(0);
				zero = 0;
				zero += 1;
				zero <<= 1;
				zero += 1;
				zero <<= (26 - n) * 2;
				zero = ~zero;
				cards &= zero;
				long set = 0;
				switch(p) {
				case 'S':
					set <<= 1;
					set += 1;
					break;
				case 'D':
					set += 1;
					set <<= 1;
					set += 1;
					break;
				case 'H':
					set <<= 1;
					set += 1;
					break;
				case 'C':
					set += 1;
					set <<= 1;
					break;
				}
				set <<= (26 - n) * 2;
				cards |= set;
				break;
			case 'A':
				tmp = cards;
				tmp <<= 12;
				boolean a, b;
				for(int j = 0; j < 26; j++) {
					a = (tmp & bit) == bit;
					tmp <<= 1;
					b = (tmp & bit) == bit;
					tmp <<= 1;
					if(a && b) {
						bw.write('D');
					}else if(a) {
						bw.write('C');
					}else if(b) {
						bw.write('H');
					}else {
						bw.write('S');
					}
				}
				bw.write("\n");
				break;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
