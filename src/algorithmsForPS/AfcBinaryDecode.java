package algorithmsForPS;

import java.util.LinkedList;
import java.util.Queue;

//이진 복원
public class AfcBinaryDecode {
	
	static Queue<Character> queue = new LinkedList<Character>();
	static char[] S = new char[1 << 10];
	
	public static void main(String[] args) {
		char[] encodedText = "--01-1-01".toCharArray();	//암호화된 문장
		int originTextLength = 8;	//원래 문장의 길이
		
		for(int i = 0 ; i < encodedText.length ; i++){	//암호화 문자들을 큐에 저장
			queue.add(encodedText[i]);
		}
		
		solve(0, originTextLength, queue.peek());
		
		for(int i = 0 ; i < S.length; i++){	//결과 추력
			System.out.print(S[i]);
		}
	}
	
	static void solve(int a, int n, char next){
		
		if(queue.isEmpty()){	//큐가 빌때까지 반복
			return;
		}
		if(next == '-'){	//'-'은 분리를 표시하므로 반으로 나눔
			queue.poll();
			solve(a, n / 2, queue.peek());	
			queue.poll();
			solve(a + n / 2, n / 2, queue.peek());
		}
		else{	//'-'가 아니라면 해당 구역을 0,1로 채움
			for(int i = a; i < a + n ; i++){
				S[i] = next;
			}
		}
	}
}
