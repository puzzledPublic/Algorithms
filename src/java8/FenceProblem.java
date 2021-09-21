package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * 울타리에서 가장 큰 사각형의 넓이를 찾는 문제
 */
public class FenceProblem {

	public static void main(String args[])
	{
		//울타리 길이를 담을 리스트
		List<Integer> list = new ArrayList<>();
		//입력
		Scanner input = new Scanner(System.in);
		//울타리 갯수
		int n = input.nextInt();
		//울타리들의 길이 입력
		for(int i = 0 ; i < n ; i++)
		{
			list.add(input.nextInt());
		}
		//분할정복
		System.out.println(solve(list, 0, n-1));
		
	}
	public static int solve(List<Integer> list, int left, int right)
	{
		//울타리가 한 개인 경우 
		if(left == right)
		{
			return list.get(left);
		}
		//울타리의 중간 위치
		int mid = (left+right)/2;
		//왼쪽 오른쪽으로 나눠 분할정복
		int ret = Math.max(solve(list, left, mid), solve(list, mid+1, right));
		//왼쪽과 오른쪽구간에서 겹치는 울타리들을 계산하기 위해
		int lo = mid, hi = mid+1;
		//중간 위치의 울타리 길이와 오른쪽 울타리의 길이 중 짧은것을 선택
		int height = Math.min(list.get(lo), list.get(hi));
		//그 길이의 울타리의 넓이(오른쪽 울타리까지 포함)가 가장 넓은지 비교
		ret = Math.max(ret, height*2);
		//중간(lo)-> 왼쪽(left), 중간 옆(hi)->오른쪽(right)동안
		while(left < lo || hi < right)
		{
			//lo-1과 hi+1중 울타리 길이가 오른쪽이 더 길다면
			if(hi < right && (lo == left || list.get(lo-1) < list.get(hi+1)))
			{
				//오른쪽으로 이동(포인터처럼)
				hi++;
				//현재 길이와 hi위치의 길이 중 짧은 것 선택
				height = Math.min(height, list.get(hi));
			}
			//왼쪽이 더 길면
			else
			{
				//왼쪽으로 이동
				lo--;
				//현재 길이와 lo위치의 길이 중 짧은 것 선택
				height = Math.min(height, list.get(lo));
			}
			//현재 넓이(ret)와 방금 구한 넓이(높이(height)*밑변(hi-lo+1))중 큰 것 선택
			ret = Math.max(ret, height * (hi - lo + 1));
		}
		//결과 리턴
		return ret;
	}
}
