package com.chainsys.bestPractices.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.DoubleStream;
import java.util.stream.BaseStream;
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

}
