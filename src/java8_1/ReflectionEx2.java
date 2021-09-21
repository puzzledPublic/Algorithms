package java8_1;

import java.lang.reflect.Member;
import java.util.Scanner;


//클래스 내 필드, 생성자, 메소드 출력
public class ReflectionEx2 {
	static String classNameDetail;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String className = input.next();
		classNameDetail = className.substring(0, className.lastIndexOf(".") + 1);
		try{
			Class<?> cls = Class.forName(className);
			System.out.println(cls);
			System.out.println("/////////");
			printMembers(cls.getFields());
			System.out.println("/////////");
			printMembers(cls.getConstructors());
			System.out.println("/////////");
			printMembers(cls.getMethods());
			System.out.println("/////////");
		}
		catch(ClassNotFoundException e) {
			System.err.println("unkown class: " + className);
		}
	}
	public static void printMembers(Member[] members) {
		for(Member m : members) {
			if(m.getDeclaringClass() == Object.class) {
				continue;
			}
			String decl = m.toString();
			System.out.print("   ");
			System.out.println(decl.replaceAll(classNameDetail, ""));
		}
		
	}
	
}
