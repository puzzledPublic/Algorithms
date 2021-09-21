package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//바둑이 포커
public class BJ17292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), ",");
		
		String[] cards = new String[6];
		for(int i = 0; i < cards.length; i++) {
			cards[i] = st.nextToken();
		}
		
		List<String> list = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			for(int j = i + 1; j < 6; j++) {
				list.add(cards[i] + cards[j]);
			}
		}
//		System.out.println(list.toString());
		list.sort((a, b) -> {
//			System.out.println(a + " " + b);
			int an1 = Integer.parseInt(a.charAt(0) + "", 16);
			int an2 = Integer.parseInt(a.charAt(2) + "", 16);
			int bn1 = Integer.parseInt(b.charAt(0) + "", 16);
			int bn2 = Integer.parseInt(b.charAt(2) + "", 16);
//			System.out.println(an1 + " " + an2 + " " + bn1 + " " + bn2);
			boolean consecutive1 = false, consecutive2 = false;
			if(Math.abs(an1 - an2) == 1 || (an1 == 1 && an2 == 15) || (an1 == 15 && an2 == 1)) {
				consecutive1 = true;
			}
			if(Math.abs(bn1 - bn2) == 1 || (bn1 == 1 && bn2 == 15) || (bn1 == 15 && bn2 == 1)) {
				consecutive2 = true;
			}
			
			if(consecutive1 && consecutive2) {
				return compare(an1, an2, bn1, bn2, a.charAt(1), a.charAt(3), b.charAt(1), b.charAt(3));
			}else if(consecutive1) {
				return -1;
			}else if(consecutive2){
				return 1;
			}else {
				if(an1 == an2 && bn1 == bn2) {
					return compare(an1, an2, bn1, bn2, a.charAt(1), a.charAt(3), b.charAt(1), b.charAt(3));
				}else if(an1 == an2) {
					return -1;
				}else if(bn1 == bn2){
					return 1;
				}else {
					return compare(an1, an2, bn1, bn2, a.charAt(1), a.charAt(3), b.charAt(1), b.charAt(3));
				}
			}
		});
		
		for(String s : list) {
			bw.write(s + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	static int compare(int an1, int an2, int bn1, int bn2, char ac1, char ac2, char bc1, char bc2) {
		if(ac1 == ac2 && bc1 != bc2) {
			return -1;
		}else if(bc1 == bc2 && ac1 != ac2) {
			return 1;
		}else {
			int aMax = Math.max(an1, an2);
			int bMax = Math.max(bn1, bn2);
			int aMin = Math.min(an1, an2);
			int bMin = Math.min(bn1, bn2);
			if(aMax == bMax) {
				if(aMin == bMin) {
					char acc, bcc;
					if(aMax == an1) {
						acc = ac1;
					}else {
						acc = ac2;
					}
					if(bMax == bn1) {
						bcc = bc1;
					}else {
						bcc = bc2;
					}
					if(acc == 'b' && bcc =='b') {
						return 0;
					}else if(acc == 'b') {
						return -1;
					}else if(bcc == 'b') {
						return 1;
					}else {
						return 0;
					}
				}else if(aMin > bMin) {
					return -1;
				}else {
					return 1;
				}
			}else if(aMax > bMax) {
				return -1;
			}else {
				return 1;
			}
		}
	}
}
