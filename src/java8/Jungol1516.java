package java8;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//단어 세기
//문자열을 입력 받아 공백으로 구분되는 단어들을 세서 단어들의 개수를 출력하라
public class Jungol1516 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text;
		while(true){
			text = scanner.nextLine();
			if(text.equals("END")){
				break;
			}
			countWord(text);
		}
	}

	static void countWord(String text) {
		String[] words = text.split(" ");
		Map<String, Integer> wordMap = new TreeMap<String, Integer>();

		for (int i = 0; i < words.length; i++) {
			if (wordMap.containsKey(words[i])) {
				wordMap.put(words[i], wordMap.get(words[i]) + 1);
			} else {
				wordMap.put(words[i], 1);
			}
		}

		for (String str : wordMap.keySet()) {
			System.out.println(str + " : " + wordMap.get(str));
		}
	}
}
