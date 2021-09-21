package programmers;

import java.util.Arrays;

//스티커 모으기(2)
public class StickerCollecting {
	public static void main(String[] args) {
		int[][] sticker = {
				{14, 6, 5, 11, 3, 9, 2, 10},
				{1, 3, 2, 5, 4},
				{1}
		};
		
		for(int i = 0; i < sticker.length; i++) {
			System.out.println(solution(sticker[i]));
		}
		
	}
	static int solution(int sticker[]) {
        int answer = 0;

        if(sticker.length == 1) {	//1개면 바로 리턴.
        	return sticker[0];
        }
        
        int[] dp = new int[sticker.length];	//dp[i] = i번째 스티커를 뜯거나 뜯지 않았을때 얻는 최대 합.
        dp[0] = dp[1] = sticker[0];	//1. 첫번째 스티커를 뜯은 경우. 두번째와 마지막 스티커는 못뜯는게 정해진다.
        
        for(int i = 2; i < dp.length - 1; i++) {
        	dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);	//현재 스티커를 뜯는 경우와 현재 스티커를 뜯지 않는 경우 중 최대값.
        }
        answer = dp[dp.length - 2];
        
        dp[0] = 0;	//2. 첫번째 스티커를 뜯지 않는 경우.
        dp[1] = sticker[1];
        for(int i = 2; i < dp.length; i++) {
        	dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        }
        
        if(answer < dp[dp.length - 1]) {
        	answer = dp[dp.length - 1];
        }
        
        return answer;
    }
}
