package programmers;

import java.util.HashSet;
import java.util.Set;

//전화번호 목록
public class PhoneBook {
	public static void main(String[] args) {
		String[][] phone_book = {
				{"119", "97674223", "1195524421"},
				{"123", "456", "789"},
				{"12", "123", "1235", "567", "88"}
		};
		
		for(int i = 0; i < phone_book.length; i++) {
			System.out.println(solution(phone_book[i]));
		}
	}
	
	static boolean solution(String[] phone_book) {
		boolean answer = true;
		Set<String> set = new HashSet<>();
		for(int i = 1; i < 21; i++) {
			for(int j = 0; j < phone_book.length; j++) {
				if(phone_book[j].length() > i) {
					set.add(phone_book[j].substring(0, i));
				}
			}
		}
		for(int i = 0; i < phone_book.length; i++) {
			if(set.contains(phone_book[i])) {
				answer = false;
				break;
			}
		}
		return answer;
	}
}
