package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//에디터
public class BJ1406 {
	//문자열 이중 링크드 리스트
	static class StrList {
		char ch;
		StrList left, right;
		public StrList(char ch) {
			this.ch = ch;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StrList head, tail, cursor;
		head = tail = new StrList('H');	//헤드
		String line = br.readLine();
		for(int i = 0; i < line.length(); i++) {	//링크드 리스트 생성
			tail.right = new StrList(line.charAt(i));
			tail.right.left = tail;
			tail = tail.right;
		}
		
		tail.right = new StrList('T');	//테일
		tail.right.left = tail;
		cursor = tail = tail.right;
		
		int N = Integer.parseInt(br.readLine());
		
		//현재 위치의 문자에서 왼쪽에 커서가 있다고 가정한다.
		for(int i = 0; i < N; i++) {
			String operation = br.readLine();
			switch(operation.charAt(0)) {
			case 'L':	//왼쪽 이동
				if(cursor.left != head) {
					cursor = cursor.left;
				}
				break;
			case 'D':	//오른쪽 이동
				if(cursor != tail) {
					cursor = cursor.right;
				}
				break;
			case 'B':	//현재 위치의 왼쪽의 문자를 제거
				if(cursor.left != head) {
					cursor.left.left.right = cursor;
					cursor.left = cursor.left.left;
				}
				break;
			case 'P':	//현재 위치의 왼쪽에 문자를 추가
				StrList node = new StrList(operation.charAt(2));
				node.left = cursor.left;
				node.right = cursor;
				cursor.left.right = node;
				cursor.left = node;
				break;
			}
		}

		head = head.right;
		while(head != tail) {
			bw.write(head.ch);
			head = head.right;
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
