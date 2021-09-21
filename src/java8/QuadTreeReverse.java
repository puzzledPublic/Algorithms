package java8;

import java.util.Iterator;



public class QuadTreeReverse {
	
	static String s = "xxwwwbxwxwbbbwwxxxwwbbbwwwwbb";
	static char[] c = s.toCharArray();
	static int i = -1;
	public static void main(String args[])
	{
		//System.out.println(reverse(s));
		
		System.out.println(reverse2());
		
		//System.out.println(reverse3(new StringIterator(s)));
	}
	
	public static String reverse(String s)
	{
		if(s.charAt(0) != 'x')
		{
			return s.charAt(0)+"";
		}
		
		String sqr[] = new String[4];
		int beginIndex = 1;
		sqr[0] = reverse(s.substring(beginIndex));
		beginIndex +=sqr[0].length();
		sqr[1] = reverse(s.substring(beginIndex));
		beginIndex +=sqr[1].length();
		sqr[2] = reverse(s.substring(beginIndex));
		beginIndex +=sqr[2].length();
		sqr[3] = reverse(s.substring(beginIndex));
		
		return 'x'+ sqr[2]+sqr[3]+sqr[0]+sqr[1];
	}
	
	public static String reverse2()
	{
		i++;
		System.out.print(i+" ");
		if(c[i] !='x')
		{
			return c[i]+"";
		}
		String sqr[] = new String[4];
		sqr[0] = reverse2();
		sqr[1] = reverse2();
		sqr[2] = reverse2();
		sqr[3] = reverse2();
		
		return "x"+sqr[2]+sqr[3]+sqr[0]+sqr[1];
	}
	
	public static class StringIterator implements Iterator<Character>
	{

		private  String str;
		private int cnt = 0;
		public StringIterator(String s)
		{
			this.str = s;
		}
		@Override
		public boolean hasNext() {
			if(cnt<str.length()) return true;
			return false;
		}

		@Override
		public Character next() {
			if(cnt ==str.length()) throw new RuntimeException();
			cnt++;
			return str.charAt(cnt-1);
		}
		
		public void remove()
		{
			throw new RuntimeException();
		}
		
	}
	public static String reverse3(StringIterator si)
	{
		char head = si.next();
		if(head != 'x')
		{
			return String.valueOf(head);
		}
		
		String sqr[] = new String[4];
		
		sqr[0] = reverse3(si);
		sqr[1] = reverse3(si);
		sqr[2] = reverse3(si);
		sqr[3] = reverse3(si);
	
		return "x"+sqr[2]+sqr[3]+sqr[0]+sqr[1];
	}

}
