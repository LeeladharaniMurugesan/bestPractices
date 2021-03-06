package com.chainsys.bestPractices.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.DoubleStream;
import java.util.stream.BaseStream;
import java.util.stream.Collector;
import java.util.stream.Stream;

// Stream is a sequence of elements computed on demand
// Stream supports sequential and parallel aggregation operations
// Stream is not a data structure
// Stream cannot be iterated directly
// Streams cannot be accessed using index number
//Stream represents single use sequence of data
// Stream should be operated on only once
public class StreamLessons {
	public static void demoA() {
		Stream s1 = Stream.empty(); // empty stream
		Stream<Integer> intStream = Stream.of(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);// creating stream from array
//		long count = intStream.count();
//		System.out.println("count : " + count);
//		long c1 = s1.count();
//		System.out.println("c1 : " + c1);
//		Stream has already been operated upon or closed
//		int value = intStream.findFirst().get();
//      find first returns the object of the type Optional
//      get() of Optional returns the first value
//		System.out.println(value);
//	    System.out.println(intStream.toList());
//		System.out.println(intStream[0]); // it will works in array and list in stream it will shows error.
	}

	public static void demoB() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			list.add(i);
		}
//		List<Integer> list2 = Arrays.asList(10,80,50,40,50);
		Stream<Integer> intStream = list.stream();
		List<Integer> evenNumbers = intStream.filter(i -> i % 2 == 0).collect(Collectors.toList()); // collect() returns
																									// a collection
		System.out.println("EvenNumbers are : " + evenNumbers);
	}

	public static void demoC() {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		Integer sum = integers.stream().reduce(0, (a, b) -> a + b); // reduce() returns one value
		System.out.println(sum);
//    Reduction of objects/elements - returning a single value
//    by forming an operation on elements of a collection.
	}

	public static void demoD() {
		IntStream intstream = IntStream.of(1, 2, 3, 4, 5);
//	    System.out.println(intstream.count());
		System.out.println(intstream.sum());
		LongStream longstream = LongStream.of(1, 2, 3, 4, 5);
		System.out.println(longstream.sum());
		DoubleStream doublestream = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0);
		System.out.println(doublestream.sum());
	}

	public static void demoE() {
		Supplier<Stream<Integer>> intstream = () -> Stream.of(10, 2, 3, 4, 5);
		System.out.println("Count: " + intstream.get().count());
		System.out.println("First: " + intstream.get().findFirst().get());
		System.out.println("List: " + intstream.get().toList());
		// get () on the supplier creates a new stream every time
	}

	public static void demoF() {
		Stream<Integer> intstream = IntStream.of(1, 2, 3, 4, 5).boxed();
		// converting primitive type to object
		System.out.println(intstream.findFirst().get());
	}

	public static void demoG() {
		Stream<Integer> streamOne = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		streamOne.forEach(p -> System.out.println(p));
		Stream<Integer> streamTwo = Stream.of(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		streamTwo.forEach(p -> System.out.println(p));
	}

	public static void demoH() {
		Stream<Integer> randomNumbers = Stream.generate(() -> (new Random()).nextInt(100));

		randomNumbers.limit(5).forEach(System.out::println);
	}

	public static void demoI() {
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Vijay");
		memberNames.add("VijaySethupathy");
		memberNames.add("Arjun");
		memberNames.add("Rajini");
		memberNames.add("Ajith");
		memberNames.add("Suriya");
		memberNames.add("Anjali");
		memberNames.add("Kamal");
		memberNames.stream().filter((s) -> s.startsWith("A")).forEach(System.out::println);
		// filter() returns a stream -Intermediate operations
		memberNames.stream().filter((s) -> s.startsWith("V")).map(String::toUpperCase).forEach(System.out::println);
		// The map() intermediate operation converts each element
		// in the stream into another object via the given function.
		memberNames.stream().sorted().map(String::toUpperCase).forEach(System.out::println);
	}

	public static void demoJ() {
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Vijay");
		memberNames.add("Arjun");
		memberNames.add("Rajini");
		memberNames.add("Ajith");
		memberNames.add("Suriya");
		memberNames.add("Anjali");
		memberNames.add("Kamal");
		memberNames.add("Vimal");
		memberNames.add("Vinay");
		memberNames.add("Vignesh");
		memberNames.add("Kamal");
		memberNames.add("Malar");
		memberNames.add("Sowmiya");
		// Terminal operations return a result of a certain type after processing all
		// the stream elements.
		List<String> memNamesInUppercase = memberNames.stream().sorted().map(String::toUpperCase)
				.collect(Collectors.toList());
		// System.out.print(memNamesInUppercase);
		boolean matchedResult = memberNames.stream().anyMatch((s) -> s.startsWith("A"));

		System.out.println(matchedResult); // true

		matchedResult = memberNames.stream().allMatch((s) -> s.startsWith("A"));

		System.out.println(matchedResult); // false

		matchedResult = memberNames.stream().noneMatch((s) -> s.startsWith("E"));

		System.out.println(matchedResult); // true
		long totalMatched = memberNames.stream().filter((s) -> s.startsWith("A")).count();

		System.out.println(totalMatched);
		Optional<String> reduced = memberNames.stream().reduce((s1, s2) -> s1 + "," + s2);

		reduced.ifPresent(System.out::println);
	}

	public static void demoK() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 100; i++) {
			list.add(i);
		}
		System.out.println(list.parallelStream().findFirst().get());
		System.out.println(list.parallelStream().findAny().get());
	}

	public static void demoL() { // skip()
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).skip(2).forEach(i -> System.out.print(i + " "));
	}

	public static void demoM() { // distinct()
		List<Integer> memberNames = new ArrayList<Integer>();
		memberNames.add(1);
		memberNames.add(1);
		memberNames.add(2);
		memberNames.add(3);
		memberNames.add(3);
		memberNames.add(4);
		memberNames.add(5);
		memberNames.add(8);
		memberNames.add(8);
		memberNames.stream().distinct().forEach(System.out::println);
	}

	public static void demoM1() { // distinct()
		List<Integer> list = Arrays.asList(2, 2, 4, 6, 8, 8, 10);
		list.stream().distinct().forEach(System.out::println);

	}

	public static void demoM2() { // distinct()
		List<Integer> list = Arrays.asList(2, 2, 4, 6, 8, 8, 10);
		List<Integer> l1 = list.stream().distinct().collect(Collectors.toList());
		System.out.println(l1);
	}

	public static void demoN() { // Peek()
		List<Integer> list = Arrays.asList(2, 4, 6, 8, 10);
		// list.stream().peek(System.out::println).collect(Collectors.toList());
		// peek() is an intermediate operation and we didn't apply a terminal operation
		// to the pipeline.
		list.stream().forEach(System.out::println);
	}

	public static void demoO() { // peek()
//		Stream.of("one", "two", "three", "four")
//		  .peek(e -> System.out.println("value: "+ e))
//		  .collect(Collectors.toList());
		Stream.of("one", "two", "three", "four").peek(System.out::println) // method reference
				.collect(Collectors.toList());

	}

	public static void demoO1() {
		// Stream.of("one", "two", "three", "four").peek (e -> e.toUpperCase()) //
		// peek() doesn't manipulate the element .forEach(System.out::println);
		Stream.of("one", "two", "three", "four").map(e -> e.toUpperCase()).forEach(System.out::println);// map() well
																										// manipulate
																										// the element
		// peek() can be useful in altering the inner state of an element
		// without replacing the element
	}

	public static void demoP() { // Peek()
		Stream.of("one", "two", "three", "four").peek(e -> e.toUpperCase()) // peek () does not manipulate the element
				.forEach(System.out::println);
	}

	public static void demoR() {
//		Stream<Emp> empStream = Stream.of(new Emp(100, "Alice"), new Emp(101, "Bob"), new Emp(102, "Chuck"));
//		empStream.peek(e -> e.setName(e.getId()+" "+e.getName().toUpperCase())).forEach(System.out::println);
		Stream<Emp> empStream = Stream.of(new Emp(100, "Alice"), new Emp(101, "Bob"), new Emp(102, "Chuck"));
		empStream.peek(e -> e.toString()).forEach(e -> System.out.println(e.getId()));
	}

}

class Emp {
	private int id;
	private String name;

	public Emp(int id, String name) {
		this.setId(id);
		this.setName(name);
	}

	public String toString() {
		return getName();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
