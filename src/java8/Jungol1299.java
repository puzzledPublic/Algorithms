package java8;

import java.util.Arrays;
import java.util.Scanner;

//열암호
public class Jungol1299 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);	
		char keyword[], text[], sortedkeyword[];	//키워드, 암호문, 정렬된 키워드
		StringBuilder result = new StringBuilder();	//결과값 담을 스트링빌더
		int rowCount;
		
		keyword = input.nextLine().toCharArray();	//char 배열로
		text = input.nextLine().replaceAll(" ", "").toCharArray(); //' '를 제외하여 char 배열로
				
		rowCount = text.length / keyword.length;	//keyword 길이로 text를 나눴을때 나오는 행렬의 행 크기
		
		if(text.length % keyword.length != 0){	//나누어 떨어지지 않는 경우 => 행 크기++
			rowCount++;
		}
		
		sortedkeyword = Arrays.copyOf(keyword, keyword.length);	
		
		Arrays.sort(sortedkeyword);	//정렬된 키워드

		int order[] = new int[keyword.length];	//순서를 담을 배열
		
		for(int i = 0; i < keyword.length; i++){	//정렬된 키워드와 본래 키워드를 비교하며 순서를 저장
			for(int j = 0 ; j < keyword.length; j++){
				if(keyword[i] == sortedkeyword[j]){
					sortedkeyword[j] = ' ';
					order[i] = j;
					break;
				}
			}
		}
		
		//각 순서에 행 크기를 곱하고(기준 인덱스) 상대 인덱스를 더한다.
		int count = 0;
		for(int i = 0 ; i < rowCount; i++){
			for(int j = 0 ; j < order.length; j++){
				result.append(text[ order[j] * rowCount + i ]);
			}
		}
		
		System.out.println(result);
	}
}
