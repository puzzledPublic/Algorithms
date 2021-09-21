package programmers;

import java.util.Arrays;

//종이접기 (2019 winter coding)
public class Origami {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(4)));
	}
	static int[] temp;
	public static  int[] solution(int n) {
		 int[] answer = {};
		 int len = (int)Math.pow(2, n);
	      temp = new int[len + 1];
	      answer = new int[len - 1];
	      divc(n, len / 2, 0, len / 4);
	      
	      for(int i = 1; i < len; i++) {
	    	  answer[i - 1] = temp[i];
	      }
	      return answer;
	}
	static void divc(int n, int index, int num, int sub) {
		temp[index] = num;
		if(n == 1) {
			return;
		}
		divc(n - 1, index - sub, 0, sub / 2);
		divc(n - 1, index + sub, 1, sub / 2);
	}
}
