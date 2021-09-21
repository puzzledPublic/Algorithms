package java8;

public class ClockSync {

	//INF = 불가능할때 숫자, SWITCHES = 스위치 갯수, CLOCKS = 시계 갯수
	final static int INF = 9999, SWITCHES = 10, CLOCKS = 16;
	//linked[SWITCHES][CLOCKS] = SWITCHES번째 스위치에 연관된 시계는 'x'로 표시, 아니면 '.'
	final static char linked[][] = {"xxx.............".toCharArray(),
									"...x...x.x.x....".toCharArray(),
									"....x.....x...xx".toCharArray(),
									"x...xxxx........".toCharArray(),
									"......xxx.x.x...".toCharArray(),
									"x.x...........xx".toCharArray(),
									"...x..........xx".toCharArray(),
									"....xx.x......xx".toCharArray(),
									".xxxxx..........".toCharArray(),
									"...xxx...x...x..".toCharArray()};
	//메인 함수
	public static void main(String args[])
	{
		int clock[] = {6,6,6,12,12,12,12,12,12,12,12,12,12,12,12,12};//{12,6,6,6,6,6,12,12,12,12,12,12,12,12,12,12};
		System.out.println("result: "+solve(clock, 0));
		
	}
	//시계가 모두 12시를 가르키는지 확인하는 함수
	public static boolean areAligned(int[] clock)
	{
		for(int i = 0 ;i < clock.length ; i++)
		{
			if(clock[i]!= 12) 
			{
				return false;
			}
		}
		return true;
	}
	//스위치가 눌리면 연관된 시계가 +3시가 되도록 바꾸는 함수
	public static void push(int[] clock, int swtch)
	{
		//시계 갯수동안
		for(int i = 0 ; i < CLOCKS; i++)
		{
			//해당 스위치에 연관된 시계라면
			if(linked[swtch][i] =='x')
			{
				//+3시
				clock[i] +=3;
				//12시에 +3시가 된 경우
				if(clock[i] == 15)
				{
					clock[i]=3;
				}
			}
		}
	}
	//스위치를 누르는 재귀적 함수
	public static int solve(int[] clock, int swtch)
	{
		//스위치가 모두 
		if(swtch == SWITCHES) return areAligned(clock) ? 0:INF;
		int ret = INF;
		for(int cnt = 0; cnt <4; cnt++)
		{
			ret = Math.min(ret, cnt+solve(clock, swtch+1));
			push(clock, swtch);
		}
		return ret;
	}
}
