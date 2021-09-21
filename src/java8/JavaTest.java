package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

public class JavaTest {

	public static void main(String args[])
	{/*
		String arg[] ={"c", "d", "b","e", "a"};
		ArrayList<String> arr = new ArrayList<>();
		arr.add("hell");
		arr.add("bbb");
		arr.add("bibi");
		arr.add("tostring");
		arr.add("bstring");
		Arrays.sort(arg, String::compareToIgnoreCase);
		for(String a : arg)
		{
			System.out.print(a+" ");
		}
		arr.forEach((t)->{if(t.startsWith("b")) System.out.print(t+" ");});
		arr.forEach(System.out::println);*/
		//repeat(10, i->System.out.print(9-i+" "));
		String[] p = {"new","word","hello","my"};

		Arrays.sort(p,(x,y)->{return x.length()-y.length();});
		for(int i = 0; i <p.length;i++)
		{
			System.out.println(p[i]);
		}
	}
	public static void repeat(int n, IntConsumer action) 
	{
		System.out.println("CountDown:");
		for(int i = 0 ; i< n; i++)
		{
			action.accept(i);
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				System.exit(0);
			}
		}
	}
}
