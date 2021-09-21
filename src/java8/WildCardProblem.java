package java8;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class WildCardProblem {

	public static void main(String args[])
	{
		//Scanner input = new Scanner(System.in);
		//String pattern = input.next();
		//String word = input.next();
		//System.out.println(match(pattern, word));
		for(int i = 0 ; i< cache.length; i++)
		{
			Arrays.fill(cache[i], -1);
		}
		System.out.println(matchMemoized(0, 0));
	}
	public static boolean match(String pattern, String word)
	{
		int pos = 0;
		while(pos < pattern.length() && pos < word.length() && (pattern.charAt(pos)=='?' || pattern.charAt(pos) == word.charAt(pos)))
		{
			pos++;
		}
		
		if(pos == pattern.length())
		{
			return pos == word.length(); 
		}
		
		if(pattern.charAt(pos) == '*')
		{
			for(int skip = 0 ; pos+skip <= word.length(); skip++)
			{
				if(match(pattern.substring(pos+1), word.substring(pos+skip)))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	static int cache[][] = new int[101][101];
	static String W="*ac", S="babbbc";
	public static int matchMemoized(int w, int s)
	{
		int ret = cache[w][s];
		if(ret != -1)
		{
			return ret;
		}
		
		while(s < S.length() && w < W.length() && (W.charAt(w)=='?' || W.charAt(w) == S.charAt(s)))
		{
			w++;
			s++;
		}
		if(w == W.length())
		{
			return cache[w][s] = (s==S.length())?1:0;
		}
		if(W.charAt(w) == '*')
		{
			for(int skip = 0 ; skip+s <= S.length(); skip++)
			{
				if(matchMemoized(w+1, s+skip) == 1)
				{
					return cache[w][s] = 1;
				}
			}
		}
		return cache[w][s] = 0;
	}
}
