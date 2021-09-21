package java8_1;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogExample {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("com.company.LogExample");
		logger.setLevel(Level.FINE);
		logger.setUseParentHandlers(false);
		Handler handler = new ConsoleHandler();
		handler.setLevel(Level.FINE);
		logger.addHandler(handler);
		logger.fine("hello");
		
		Stream<String> stream = Stream.of("HELLO", "MY", "NAME", "IS", "BLAH", "BLAH");
		stream.map(str -> str.toLowerCase()).forEach(System.out::println);
		Stream<Double> infiniteStream = Stream.generate(Math::random);
		double d = infiniteStream.peek(System.out::println).limit(10).max(Double::compare).orElse(0.0);
		System.out.println("max -> " + d);
		
		Optional<Boolean> option = Optional.ofNullable(null);
		System.out.println(option.isPresent());
		
		//flatMap으로 옵션 값 함수 합성
		Optional<Double> result = Optional.of(4.0).flatMap(LogExample::inverse).flatMap(LogExample::squareRoot);
		System.out.println(result.orElseThrow(RuntimeException::new));
		
//		Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
//		Map<String, Set<String>> countryLanguageSets = locales.collect(
//				Collectors.toMap(
//						Locale::getDisplayCountry, 
//						l -> Collections.singleton(l.getDisplayLanguage()), 
//						(a, b) -> {
//							Set<String> union = new HashSet<>(a);
//							union.addAll(b);
//							return union;
//						}
//					)
//				);
//		countryLanguageSets.forEach((a, b) -> {
//			System.out.println(a);
//			b.forEach(c -> System.out.println(" " + a + " " + c));
//		});
		//위와 동일	같은 Locale::getDisplayCountry에 대해 Set에 Locale::getDisplayLanguage를 모은다.
		Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
		Map<String, Set<String>> countryLanguageSets = locales.collect(
				Collectors.groupingBy(
						Locale::getDisplayCountry, 
						Collectors.mapping(
								Locale::getDisplayLanguage, 
								Collectors.toSet())
						)
				);
		
		Stream<Locale> locales2 = Stream.of(Locale.getAvailableLocales());
		Map<String, List<Locale>> countryLocales = locales2.collect(Collectors.groupingBy(Locale::getCountry));
		System.out.println(countryLocales.get("CH"));
		
	}
	static Optional<Double> inverse(Double ind) {
		return ind == 0.0 ? Optional.empty() : Optional.of(1 / ind);
	}
	static Optional<Double> squareRoot(Double x) {
		return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
	}
}
