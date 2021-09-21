package kakao.kakao2020.intern;

//키패드 누르기
public class PushingKeypad {
	public static void main(String[] args) {
		int[][] numberss = {
				{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},	//"LRLLLRLLRRL"
				{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},	//"LRLLRRLLLRR"
				{1, 2, 3, 4, 5, 6, 7, 8, 9, 0},		//"LLRLLRLLRL"
		};
		
		String[] hands = {
				"right", "left", "right",
		};
		
		for(int i = 0; i < numberss.length; i++) {
			System.out.println(solution(numberss[i], hands[i]));
		}
	}
	
	static String solution(int[] numbers, String hand) {
        String answer = "";
        
        int[][] phone = new int[][] {
        	{-1, -1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {3, 0}, {3, 1}, {3, 2}
        };
        
        int leftNum = 10, rightNum = 12;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length; i++) {
        	if(isLeft(phone, leftNum, rightNum, numbers[i], hand)) {
        		leftNum = numbers[i];
        		sb.append("L");
        	}else {
        		rightNum = numbers[i];
        		sb.append("R");
        	}
        }
        
        return answer = sb.toString();
    }
	static boolean isLeft(int[][] phone, int leftNum, int rightNum, int nextNum, String hand) {
		if(nextNum == 1 || nextNum == 4 || nextNum == 7) {
			return true;
		}
		if(nextNum == 3 || nextNum == 6 || nextNum == 9) {
			return false;
		}
		leftNum = leftNum == 0 ? 11 : leftNum;
		rightNum = rightNum == 0 ? 11 : rightNum;
		nextNum = nextNum == 0 ? 11 : nextNum;
		int leftDist = Math.abs(phone[leftNum][0] - phone[nextNum][0]) + Math.abs(phone[leftNum][1] - phone[nextNum][1]);
		int rightDist = Math.abs(phone[rightNum][0] - phone[nextNum][0]) + Math.abs(phone[rightNum][1] - phone[nextNum][1]);
		return (leftDist < rightDist) || (leftDist == rightDist && hand.equals("left")) ? true : false;
	}
}
