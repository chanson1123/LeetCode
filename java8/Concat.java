package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Concat {
	
	public static void main(String[] args) {
		Stream<Integer> s1 = Stream.of(1,2,3,4);
		Stream<Integer> s2 = Stream.of(4,5,6);
		Stream<Integer> result = Stream.concat(s1,  s2).distinct();
		result.forEach(System.out::print);
		System.out.println();
		
		Stream<Integer> s = Stream.of(1,2,3);
		long l = s.count();
		System.out.print(l);
	}

}
