package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Filter {

	
	//lambda expression：函数作为参数，代码作为数据
	
	public static void main(String[] args) {
		Filter filter = new Filter();
		List<String> input = Arrays.asList("aa", "bb", "cc");
		List<String> exput = Arrays.asList("cc", "bb");
		List<String> result = filter.filter2(input, exput);
		result.stream().forEach(System.out :: println);
		
		List<Person> personInput = Arrays.asList(new Person(18, "cc"), new Person(16, "mm"));
		List<Person> personExput = Arrays.asList(new Person(18, "cc"));
		List<Person> result2 = filter.filter4(personInput, personExput);
		result2.stream().map(p -> p.getName()).forEach(System.out :: println);
	}
	
	private List<Person> filter4(List<Person> input, List<Person> output){
		return input.stream().filter(p -> output.stream().allMatch(q -> !q.getName().equals(p.getName()))).collect(Collectors.toList());
	}
	
	// exput 中所有元素都不 match input 中某个 str，filter 才能通过
	// exput 中任一元素不 match 某个 str filter 就能通过
	private List<String> filter2(List<String> input, List<String> exput){
		List<String> result = 
		input.stream().filter(str -> exput.stream().allMatch(name -> !name.equals(str))).collect(Collectors.toList());
		
		return result;
	}
	
	private List<String> filter3(List<String> input, List<String> exput){
		Set<String> set = exput.stream().collect(Collectors.toSet());
		return input.stream().filter(str -> !set.contains(str)).collect(Collectors.toList());
	}
	
	private List<String> filter1(List<String> input, List<String> exput){
		List<String> result = new ArrayList<>();
		for(String str : input) {
			for(String exStr : exput) {
				if(!str.equals(exStr)) {
					result.add(str);
				}
			}
		}
		return result;
	}
	
	
}
