package java8;

import java.util.Arrays;
import java.util.Scanner;

//단어 맞추기
public class Jungol1034 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String word = input.next();
		
		char[] divided = word.toCharArray();	//문자배열로 변환
		char[] characters;	//문자들을 저장할 배열
		int index = 0;
		boolean flag = false; //마지막 글자순서인지 확인하는 플래그
		for(int i = divided.length - 1; i > 0 ; i--){	//배열의 뒤부터 조사
			if(divided[i-1] < divided[i]){	//앞의 문자순서가 더 작으면
				index = i-1;	//앞의 문자를 index로 설정
				characters = new char[divided.length - index -1];	//index이후 문자들의 배열을 생성
				for(int j = i ; j < divided.length; j++){	//배열에 저장
					characters[j - i] = divided[j];
				}	
				Arrays.sort(characters);	//배열 정렬
				for(int j = 0; j < characters.length; j++){ //배열 탐색
					if(divided[index] < characters[j]){	//현재 인덱스의 문자보다 바로 윗 순서인 문자찾기
						char temp;		//문자 교환
						temp = divided[index];
						divided[index] = characters[j];
						characters[j] = temp;
						//출력
						for(int k = 0 ; k < index + 1; k++){
							System.out.print(divided[k]);
						}
						for(int k = 0 ; k < characters.length; k++){
							System.out.print(characters[k]);
						}
						break;
					}
				}
				flag = true;
				break;
			}
		}
		//문자열이 마지막 순서인 경우 출력
		if(!flag){
			System.out.println(word);
		}
		
	}
}
