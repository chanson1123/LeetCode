package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Compare {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,3,5,7);
		Optional<Integer> result = list.stream().max(Comparator.reverseOrder());
		System.out.println(result);
		
		List<Person> personList = Arrays.asList(new Person(17, "cc"), new Person(18, "dd"), new Person(16, "ee"));
		Optional<Integer> p = personList.stream().filter(s -> s.getAge() < 18).map(s -> s.getAge()).max((o1, o2) -> o1 - o2);
		System.out.println(p);
		
		List<Person> pList = Arrays.asList(new Person(16, "cc"), new Person(17, "bb"), new Person(18, "dd"));
		pList.stream().sorted((p1, p2) -> p1.getAge() - p2.getAge()).forEach(s -> System.out.println(s.getName()));
		
	}
	
}
