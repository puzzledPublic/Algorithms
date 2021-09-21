package programmers;

//배열의 회전이란 모든 원소를 오른쪽으로 한 칸씩 이동시키고, 마지막 원소는 배열의 맨 앞에 넣는 것을 말합니다.
//두 배열 arrA와 arrB가 매개변수로 주어질 때, arrA를 회전해 arrB로 만들 수 있으면 true를, 그렇지 않으면 false를 return 하는 solution 함수를 작성해주세요.
//제한 조건
//arrA는 길이가 1 이상 1,500 이하인 배열입니다.
//arrA의 원소는 0 이상 1,500 이하인 정수입니다.
//arrB는 길이가 1 이상 1,500 이하인 배열입니다
//arrB의 원소는 0 이상 1,500 이하인 정수입니다.
public class MockTest_2nd_1 {
	public static void main(String[] args) {
		int[][] arrA = {
				{7, 8, 10},
				{4, 3, 2, 1}
		};
		int[][] arrB = {
				{10, 7, 8},
				{5, 4, 1, 2}
		};
		for(int i = 0; i < arrA.length; i++) {
			System.out.println(solution(arrA[i], arrB[i]));
		}
	}
	
	static boolean solution(int[] arrA, int[] arrB) {
        boolean answer = false;
        
        if(arrA.length != arrB.length) {
        	return false;
        }
        
        int[] temp = new int[arrA.length * 2];
        for(int i = 0; i < arrA.length; i++) {
        	temp[i] = arrA[i];
        	temp[i + arrA.length] = arrA[i];
        }
        
        for(int i = 0; i < temp.length - arrB.length; i++) {
        	int count = 0;
        	for(int j = 0; j < arrB.length; j++) {
        		if(temp[i + j] != arrB[j]) {
        			break;
        		}
        		count++;
        	}
        	if(count == arrB.length) {
        		answer = true;
        	}
        }
        
        return answer;
    }
}
