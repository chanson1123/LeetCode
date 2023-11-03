package java8;

import java.util.stream.Stream;

public class Find {
	
	public static void main(String[] args) {
		Stream.of(1,2,3).parallel().findAny().ifPresent(System.out::print);
		Stream.of(11,22,33).findFirst().ifPresent(System.out::println);
	}

}
