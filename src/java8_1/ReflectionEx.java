package java8_1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Scanner;

//타입 계층도 출력
public class ReflectionEx {
	
	private static String[]
			basic = { "class", "interface", "enum", "annotation"},
			supercl = { "extends", "implements"},
			iFace = { null, "extends" };
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String className = input.next();
		
		ReflectionEx desc = new ReflectionEx();
		
		try{
			Class<?> startClass = Class.forName(className);
			desc.printType(startClass, 0, basic);
		}catch(ClassNotFoundException e) {
			System.err.println(e);
		}
	}
	
	private void printType(Type type, int depth, String[] labels) {
		if(type == null) {
			return;
		}
		
		Class<?> cls = null;
		if(type instanceof Class<?>) {
			cls = (Class<?>)type;
		}
		else {
			if(type instanceof ParameterizedType) {
				cls = (Class<?>)((ParameterizedType)type).getRawType();
			}
			else {
				throw new Error("Unexpected non-class type");
			}
		}
		/*if(cls == Object.class) {
			return;
		}
*/		
		for(int i = 0 ; i < depth; i++) {
			System.out.print(" ");
		}
		int kind = cls.isAnnotation() ? 3 : cls.isEnum() ? 2 : cls.isInterface() ? 1 : 0;
		System.out.print(labels[kind] + " ");
		System.out.print(cls.getCanonicalName());
		
		TypeVariable<?>[] params = cls.getTypeParameters();
		if(params.length > 0) {
			System.out.print('<');
			for(TypeVariable<?> param : params) {
				System.out.print(param.getName());
				System.out.print(", ");
			}
			System.out.println("\b\b>");
		}
		else {
			System.out.println();
		}
		
		Type[] interfaces = cls.getGenericInterfaces();
		for(Type iface : interfaces) {
			printType(iface, depth + 1, cls.isInterface() ? iFace : supercl);
		}
		
		printType(cls.getGenericSuperclass(), depth + 1, supercl);
	}
}
