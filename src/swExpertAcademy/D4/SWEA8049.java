package swExpertAcademy.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//폭탄 감식반
public class SWEA8049 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			char[] bomb = br.readLine().trim().toCharArray();
			int type = 0;
			boolean detected = true;
			for(int i = 0; i < bomb.length; i++) {
				char curr = bomb[i];
				if(type == 0) {
					if(i + 1 < bomb.length && curr == 'F') {
						if(bomb[i + 1] == 'F') {
							type = 1;
						}else if(bomb[i + 1] == 'C') {
							type = 2;
						}else {
							detected = false;
							break;
						}
					}else {
						detected = false;
						break;
					}
				}else if(type == 1) {
					while(i < bomb.length && bomb[i] == 'F') {
						i++;
					}
					if((i < bomb.length && bomb[i] == 'M') && (i + 1 < bomb.length && bomb[i + 1] == 'C') && (i + 2 < bomb.length && bomb[i + 2] == 'M')) {
						i += 2;
						while(i < bomb.length && bomb[i] == 'M') {
							i++;
						}
						i--;
						type = 0;
					}else {
						detected = false;
						break;
					}
				}else if(type == 2) {
					while(i < bomb.length && bomb[i] == 'C') {
						i++;
					}
					if((i < bomb.length && bomb[i] == 'M') && (i + 1 < bomb.length && bomb[i + 1] == 'F')) {
						i++;
						type = 0;
					}else {
						detected = false;
						break;
					}
				}
			}
			bw.write("#" + t + " " + (detected ? "DETECTED!" : "NOTHING!") + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
