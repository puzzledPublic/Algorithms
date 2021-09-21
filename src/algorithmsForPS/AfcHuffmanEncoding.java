package algorithmsForPS;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AfcHuffmanEncoding {
	static int K;
	static char str[];
	static String data;
	static String[] strValue;
	static char[] tree = new char[15000];
	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "\\src\\test\\AfcHuffmanEncoding";
		try(Scanner input = new Scanner(new File(path))) {
			
			//입력
			K = input.nextInt();
			str = new char[K];
			strValue = new String[K];
			for(int i = 0; i < K; i++) {
				str[i] = input.next().charAt(0);
				strValue[i] = input.next();
			}
			data = input.next();
			
			//처리
			//solve();
			solve2();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void solve() {
		for(int i = 0; i < K; i++) {
			int idx = 1;
			for(int j = 0; j < strValue[i].length(); j++) {	//각 문자에 대응하는 이진수를 완전이진트리에 삽입
				if(strValue[i].charAt(j) == '0') {	//0인경우 왼쪽 자식 인덱스로
					idx = idx * 2;
				} else {	//1인경우 오른쪽 자식 인덱스로
					idx = idx * 2 + 1;
				}
			}
			tree[idx] = str[i];	//최종 인덱스 위치에 문자삽입
		}
		int idx = 1;
		for(int i = 0; i < data.length(); i++) {	//이진 문자열 따라서 이동
			if(data.charAt(i) == '0') {	
				idx = idx * 2;
			} else {
				idx = idx * 2 + 1;
			}
			if(tree[idx] != '\0') {	//지나가던 중 해당 인덱스가 문자인 경우 출력 후 다시 인덱스를 처음으로
				System.out.print(tree[idx]);
				idx = 1;
			}
		}
	}
	
	static void solve2() {
		Map<String, Character> map = new HashMap<>();	//맵에 저장
		for(int i = 0; i < K; i++) {
			map.put(strValue[i], str[i]);
		}
		int index = 0;
		for(int i = 1; i < data.length() + 1; i++) {	//해독할 문자열을 처음부터 하나씩 늘려나가며 맵에 있는지 확인
			String temp = data.substring(index, i);
			if(map.containsKey(temp)) {	//있다면 인덱스를 다음 위치로
				index = i;
				System.out.print(map.get(temp));
			}
		}
	}
}
