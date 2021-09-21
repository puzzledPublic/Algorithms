package kakao.kakao2018;

import java.util.ArrayList;
import java.util.Scanner;
//다트 게임
public class DartGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(solution2("1S*2T*3S"));
	}
	
	static int solution2(String dartResult) {
		int answer = 0, prev = 0, tmp = 0, i = 0;
		while(i < dartResult.length()) {
			char current = dartResult.charAt(i);
			if('0' <= current && current <= '9') {
				tmp *= 10;
				tmp += current - '0';
			}else if(current == 'S' || current == 'D' || current == 'T') {
				if(current == 'D') {
					tmp *= tmp;
				}else if(current == 'T') {
					tmp *= (tmp * tmp);
				}
				answer += tmp;
				if(i + 1 < dartResult.length() &&(dartResult.charAt(i + 1) != '#' && dartResult.charAt(i + 1) != '*')) {
					prev = tmp;
					tmp = 0;
				}
			}else {
				if(current == '#') {
					prev = -tmp;
					answer += -2 * tmp;
				}else if(current == '*') {
					answer -= (prev + tmp);
					answer += ((prev + tmp) * 2);
					prev = 2 * tmp;
				}
				tmp = 0;
			}
			i++;
		}
		return answer;
	}
	
	static int solution(String dartResult){
		int answer = 0;
		int count = 0;
		char[] temp = dartResult.toCharArray();
		ArrayList<Integer> num = new ArrayList<>();
		int[] result = new int[3];
		for(int i = 0 ; i < temp.length; i++){
			
			if(temp[i] == '1' && temp[i+1] == '0'){
				i+=2;
				num.add(10);
			}
			else if(temp[i] >= '0' && temp[i] <= '9'){
				num.add(temp[i] - 48);
			}
			
			if(temp[i] == 'S'){
				result[count] = num.get(count);
				if(i+1 < temp.length){
					if(temp[i+1] == '*' && count != 0){
						result[count] =  result[count] * 2;
						result[count-1] = result[count-1] * 2;
					}
					else if(temp[i+1] == '*'){
						result[count] =  result[count] * 2;
					}
					else if(temp[i+1] == '#'){
						result[count] =  result[count] * -1;
					}}
				count++;
			}
			else if(temp[i] == 'D'){
				result[count] = (int)Math.pow(num.get(count), 2);
				if(i+1 < temp.length){
				if(temp[i+1] == '*' && count != 0){
					result[count] =  result[count] * 2;
					result[count-1] = result[count-1] * 2;
				}
				else if(temp[i+1] == '*'){
					result[count] =  result[count] * 2;
				}
				else if(temp[i+1] == '#'){
					result[count] =  result[count] * -1;
				}}
				count++;
			}
			else if(temp[i] == 'T'){
				result[count] = (int)Math.pow(num.get(count), 3);
				if(i+1 < temp.length){
				if(temp[i+1] == '*' && count != 0){
					result[count] =  result[count] * 2;
					result[count-1] = result[count-1] * 2;
				}
				else if(temp[i+1] == '*'){
					result[count] =  result[count] * 2;
				}
				else if(temp[i+1] == '#'){
					result[count] =  result[count] * -1;
				}}
				count++;
			}
		}
		for(int i = 0; i < 3; i++){
			answer += result[i];
		}
		return answer;
	}
}
