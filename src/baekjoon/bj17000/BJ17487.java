package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//타자 연습
public class BJ17487 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//왼쪽 q w e r t y a s d f g z x c v b
		char[][] leftKey = {
				{'q', 'w', 'e', 'r', 't', 'y', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v', 'b'},
				{'Q', 'W', 'E', 'R', 'T', 'Y', 'A', 'S', 'D', 'F', 'G', 'Z', 'X', 'C', 'V' ,'B'}
		};
		//오른쪽 u i o p h j k l n m
		char[][] rightKey = {
				{'u', 'i', 'o', 'p', 'h', 'j', 'k', 'l', 'n', 'm'},
				{'U', 'I', 'O', 'P', 'H', 'J', 'K', 'L', 'N', 'M'},
		};
		String S = br.readLine();
		
		int left = 0;
		int right = 0;
		int remain = 0;
		
		for(int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			if(ch == ' ') {	//스페이스를 누른 경우
				remain++;
				continue;
			}
			for(int j = 0; j < 2; j++) {
				for(int k = 0; k < leftKey[0].length; k++) {	//왼쪽 키를 누른 경우
					if(leftKey[j][k] == ch) {
						remain += j;
						left++;
						break;
					}
				}
				for(int k = 0; k < rightKey[0].length; k++) {	//오른쪽 키를 누른 경우
					if(rightKey[j][k] == ch) {
						remain += j;
						right++;
						break;
					}
				}
			}
		}
		
		//왼쪽과 오른쪽 버튼을 누른 횟수 차이가 최소가 되도록 쉬프트, 스페이스 누른키 횟수를 분배
		while(remain > 0)  {
			if(left <= right) {
				left++;
			}else {
				right++;
			}
			remain--;
		}
		
		bw.write(left + " " + right + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
