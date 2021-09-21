package java8_1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

//어노테이션
public class ReflectionEx3 {
	public static void main(String[] args) {
		Class<Foo> cls = Foo.class;
		try {
			Foo foo = cls.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		RefAnnotation refA = (RefAnnotation) cls.getAnnotation(RefAnnotation.class);
		String[] s = refA.values();
		for(String id : s) {
			System.out.println(id);
		}
		
		//메소드 객체
		Method[] methods = cls.getDeclaredMethods();
		Method.setAccessible(methods, true);
		
		for(Method m : methods) {
			System.out.println(m.isAccessible());
			System.out.println(m);
		}
		//필드 객체
		Field[] fields = cls.getDeclaredFields();
		Field.setAccessible(fields, true);
		
		for(Field f : fields) {
			Type t = f.getGenericType();
			System.out.println(t.getTypeName());
			System.out.println();
			
			refA = f.getAnnotation(RefAnnotation.class);
			if(refA != null) {
				for(String str : refA.values()) {
					System.out.print(str + ", ");
				}
			}
			System.out.println();
		}
		
		//생성자 객체
		try {
			Constructor<?> constructor = cls.getDeclaredConstructor(int.class, String.class);	//생성자 객체

			Foo fooInstance = (Foo) constructor.newInstance(1, "hello");	//생성자 객체로 인스턴스 생성
			fooInstance.printFoo();
			/*Constructor<?>[] constructor = cls.getDeclaredConstructors();
			System.out.println(constructor.length);
			for(Constructor<?> co : constructor) {
				System.out.println(co);
			}*/
		} catch (SecurityException | IllegalArgumentException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}

@Retention(RetentionPolicy.RUNTIME)	//런타임 보유정책을 가져야 리플렉션 가능 (default = class)
@interface RefAnnotation {
	String[] values();
}

@RefAnnotation(values = { "457605", "532456" })
class Foo {
	Foo() {
		
	}
	Foo(int a, String b) {
		this.a = a;
		this.b = b;
		this.list = null;
	}
	
	@RefAnnotation(values = {"4", "2"})
	private int a;
	private String b;
	private List<String> list;
	
	//private는 일반 코드에서와 마찬가지로 리플렉션에 AccessibleObject 검사에 걸려 접근 불가.
	//하지만 객체에 setAccessible 설정을 true로 하면 가능
	private void privateFoo() {
		System.out.println("hello");
	}
	public void printFoo() {
		System.out.println("a: "+ a +", b: " + b);
	}
}