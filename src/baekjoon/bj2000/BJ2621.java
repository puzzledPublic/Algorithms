package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//카드게임
public class BJ2621 {
	static class Card {	//카드 클래스
		char color;
		int number;
		public Card(char color, int number) {
			this.color = color;
			this.number = number;
		}
	}
	static class SameNum {	//a, b = 몇개가 같은지 나타냄 a = 4, b = 0 || a = 3, b = 2 || a = 3, b = 0 || a = 2, b == 2 || a = 2, b = 0 || a == 0, b == 0
		int a, b, h, l;		//h, l = a, b에 대응하는 숫자 (h > l)
		public SameNum(int a, int b, int h, int l) {
			this.a = a;
			this.b = b;
			this.h = h;
			this.l = l;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Card> list = new ArrayList<>();
		StringTokenizer st;
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list.add(new Card(st.nextToken().charAt(0), Integer.parseInt(st.nextToken())));
		}
		list.sort((a, b) -> a.number - b.number);
		solve(list, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(List<Card> list, Writer w) throws IOException {
		if(isAllSameColor(list) && isElevate(list)) {
			w.write((900 + list.get(4).number) + "\n");
			return;
		}
		SameNum sn = sameNumber(list);
		if(sn.a == 4) {
			w.write((800 + sn.h) + "\n");
		}else if(sn.a == 3 && sn.b == 2) {
			w.write((700 + (sn.h * 10) + sn.l) + "\n");
		}else if(isAllSameColor(list)) {
			w.write((600 + list.get(4).number) + "\n");
		}else if(isElevate(list)) {
			w.write((500 + list.get(4).number) + "\n");
		}else if(sn.a == 3) {
			w.write((400 + sn.h) + "\n");
		}else if(sn.a == 2 && sn.b == 2) {
			w.write((300 + (sn.h * 10) + sn.l) + "\n");
		}else if(sn.a == 2) {
			w.write((200 + sn.h) + "\n");
		}else {
			w.write((100 + list.get(4).number) + "\n");
		}
	}
	static SameNum sameNumber(List<Card> list) {
		int[] chk = new int[10];
		for(int i = 0; i < 5; i++) {
			chk[list.get(i).number]++;
		}
		for(int i = 9; i >= 0; i--) {
			if(chk[i] == 4) {
				return new SameNum(4, 0, i, 0);
			}
			else if(chk[i] == 3) {
				SameNum sn = new SameNum(3, 0, i, 0);
				for(int k = 9; k >= 0; k--) {
					if(chk[k] == 2) {
						sn.b = 2;
						sn.l = k;
						return sn;
					}
				}
				return sn;
			}else if(chk[i] == 2) {
				SameNum sn = new SameNum(2, 0, i, 0);
				for(int k = 9; k >=0; k--) {
					if(chk[k] == 3) {
						sn.b = sn.a;
						sn.l = sn.h;
						sn.a = 3;
						sn.h = k;
						return sn;
					}
					else if(k != i && chk[k] == 2) {
						sn.b = 2;
						sn.l = k;
						return sn;
					}
				}
				return sn;
			}
		}
		return new SameNum(0, 0, 0, 0);
	}
	static boolean isElevate(List<Card> list) {
		for(int i = 1; i < 5; i++) {
			if(list.get(i).number - list.get(i - 1).number != 1) {
				return false;
			}
		}
		return true;
	}
	static boolean isAllSameColor(List<Card> list) {
		for(int i = 1; i < 5; i++) {
			if(list.get(i).color != list.get(i - 1).color) {
				return false;
			}
		}
		return true;
	}
}
