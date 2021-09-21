package java8;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// 단어 집합
// 스트링을 입력 한 후, 스트링을 구성하는 단어들 중, 현재 단어목록에 포함이 되어있지 않은 단어를 단어목록의 가장 뒤에 추가하라
// 스트링의 길이 <= 50, 입력 스트링 개수 <= 10
// 처음에는 단어의 목록이 하나도 없다.
// 단어의 구분은 공백으로 한다.
// 스트링은 계속 입력받으며, 프로그램이 종료되지 않는 이상 기존의 단어들의 목록은 계속 유지된다. 
// 목록에 단어가 없을 경우 단어를 목록의 가장 뒤에 추가하고, 있을경우 추가하지 않는다.
// 단어목록에는 입력되는 순서대로 저장된다.
// 알파벳 대.소문자는 구분된다(다르다).
public class Jungol1535 {
	
	static StringBuilder sb = new StringBuilder();
	static Set<String> independentWord = new TreeSet<String>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text;
		while(true){
			text = scanner.nextLine();
			if(text.equals("END")){
				break;
			}
			insertWord(text);
		}
	}
	static void insertWord(String text){
		String[] words = text.split(" ");
		
		for(int i = 0 ; i < words.length; i++){
			if(!independentWord.contains(words[i])){
				independentWord.add(words[i]);
				sb.append(words[i]);
				sb.append(" ");
			}
		}
		System.out.println(sb);
	}
}
