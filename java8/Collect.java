package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collect {

	public static void main(String[] args) {
		List<Person> list = Arrays.asList(new Person(18, "cc"), new Person(16, "mm"));
		Map<Integer, Person> map = list.stream().collect(HashMap::new, (m, p) -> m.put(p.getAge(), p), HashMap::putAll);
		map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey()));
		
		List<Person> list2 = Arrays.asList(new Person(17, "cc"), new Person(15, "mm"));
		Map<Integer, String> map2 = list2.stream().collect(Collectors.toMap(Person::getAge, Person::getName));
		map2.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

		List<String> result = Stream.of("aa", "cc")
		.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		result.stream().forEach(System.out::println);
		
		List<String> strInput = Arrays.asList("aaa", "bbb", "ccc");
		String strResult = strInput.stream()
				.collect(StringBuilder::new, (sb, s) -> sb.append(s), StringBuilder::append).toString();
		System.out.println(strResult);

	}
}
