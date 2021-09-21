package programmers;

import java.util.HashSet;
import java.util.Set;


//N으로 표현
public class MonodigitalRepresentations {
	public static void main(String[] args) {
		int[] N = {5, 2, 9};
		int[] number = {56, 11, 100};
		for(int i = 0; i < N.length; i++) {
			System.out.println(solution(N[i], number[i]));
		}
	}
	static int solution(int N, int number) {
        int answer = -1;
        Set<Integer>[] setArr = new Set[9];	//setArr[i] = 숫자 N을 i번 사용해서 만들 수 있는 숫자들을 담는 Set
        int t = N;
        for(int i = 1; i < 9; i++) {
        	setArr[i] = new HashSet<>();
        	setArr[i].add(t);
        	t = t * 10 + N;		//숫자 N, NN, NNN ... NNNNNNNN으로 Set을 초기화
        }
        for(int i = 1; i < 9; i++) {
        	for(int j = 1; j < i; j++) {
        		for(Integer a : setArr[j]) {
        			for(Integer b : setArr[i - j]) {
        				setArr[i].add(a + b);
        				setArr[i].add(a - b);
        				setArr[i].add(b - a);
        				setArr[i].add(a * b);
        				if(b != 0) {
        					setArr[i].add(a / b);
        				}
        				if(a != 0) {
        					setArr[i].add(b / a);
        				}
        			}
        		}
        	}
        }
        for(int i = 1; i < 9; i++) {
        	if(setArr[i].contains(number)) {
        		answer = i;
        		break;
        	}
        }
        return answer;
    }
}
