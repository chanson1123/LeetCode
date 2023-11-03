package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Map {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(18,16);
		List<Person> personList = list.stream().map(num -> new Person(num)).collect(Collectors.toList());
		personList.stream().forEach(p -> System.out.println(p.getAge()));
		int ages = personList.stream().mapToInt(Person::getAge).sum();
		
		List<Person> pList = Arrays.asList(new Person(17, "xiao"), new Person(19, "da"));
		List<Integer> resultList = pList.stream().map(p -> p.getAge()).collect(Collectors.toList());
		
		//map()把一个类型的 stream 转化成另一种
		List<Integer> l1 = Arrays.asList(1,2,3);
		List<Integer> l2 = Arrays.asList(4,5,6);
		List<List<Integer>> l = Arrays.asList(l1,l2);
		List<Integer> result = l.stream().flatMap(s -> s.stream()).collect(Collectors.toList());
		result.stream().forEach(System.out::println);
		
		//flatMap()中每一个元素都是一串元素
		List<Person> nameList = Arrays.asList(new Person(18, "Chang,Che"), new Person(19, "Fatty,Panda"));
		List<String> results = nameList.stream().map(p -> p.getName())
				.flatMap(str -> Arrays.stream(str.split(","))).collect(Collectors.toList());
		results.forEach(System.out::println);
	}

}
