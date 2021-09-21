package java8;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//소수문자열
//문자열을 입력 받고, 그 문자열 중 어떤 한 문자라도 발생빈도가 소수를 만족하면 이는 소수문자열이라고 한다
//10,000 이하의 문자열이 입력된다. 문자열은 알파벳 대문자만 구성된다.
//입력에 대해서 해당 문자열이 소수문자열이 아닌 경우 "NONE"을 출력하며 소수문자열일 경우 소수문자열을 이루게 만들어주는 문자를 사전순으로 한 줄에 공백없이 출력한다.
public class Jungol1566 {
	static boolean eratostenes[] = new boolean[10005];
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String text;
		text = scanner.next();
		//에라토스테네스 체
		eratos(10000);
		primeText(text);
	}

	static void primeText(String text) {
		//트리 맵 생성
		Map<Character, Integer> wordCounter = new TreeMap<Character, Integer>();
		for (int i = 0; i < text.length(); i++) {
			char word = text.charAt(i);
			//문자가 트리에 이미 있다면
			if (wordCounter.containsKey(word)) {
				//개수 증가
				wordCounter.put(word, wordCounter.get(word) + 1);
			} else {
				//아니라면 1로 넣어준다
				wordCounter.put(word, 1);
			}
		}
		StringBuilder sb = new StringBuilder();
		//문자들의 개수들을 돌며
		for (char word : wordCounter.keySet()) {
			int c = wordCounter.get(word);
			//개수가 소수라면
			if(eratostenes[c] == false){//if (c != 1 && isPrime(c)) {
				//해당 문자들 저장
				sb.append(word);
			}
		}
		//저장된게 없으면 NONE
		if(sb.length()==0){
			System.out.println("NONE");
		}else{
			//있다면 소수문자열 출력
			System.out.println(sb);
		}
	}
	/*
	static boolean isPrime(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}*/
	static void eratos(int number){
		eratostenes[1] = true;
		for(int i = 2; i*i<=number;i++){
			if(eratostenes[i] == false){
				for(int j = i*i; j<=number;j+=i){
					eratostenes[j] = true;
				}
			}
		}
	}
}
