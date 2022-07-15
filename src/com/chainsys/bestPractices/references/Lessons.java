package com.chainsys.bestPractices.references;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Lessons {
	public static void testA() {
		List<Phone> phonelist = new ArrayList<Phone>(); // once the object is created the toString() method is called
		// Phone ::print;//direct call of method reference will not work here
		phonelist.add(new Phone());
		phonelist.add(new Phone());
		phonelist.add(new Phone());
		phonelist.add(new Phone());
		phonelist.add(new Phone());
		phonelist.forEach(System.out::println);
	}

	public static void testB() {
		List<Long> phoneNumber = new ArrayList<Long>();
		phoneNumber.add(9879001234l);
		phoneNumber.add(9879001452l);
		phoneNumber.add(9879111234l);
		phoneNumber.add(9979001234l);
		phoneNumber.add(9679001234l);
		phoneNumber.forEach(Phone::print);
		// static method call -> using class to call static method
		Phone iPhone = new Phone();
		phoneNumber.forEach(iPhone::makeACall);
		// non static method -> using object reference to call instance method
	}

// constructor reference
	public static void testC() {
		PhoneEmpty pmobile = Phone::new; // constructor reference
		Phone p1 = pmobile.get(); // object will be created
		p1.makeACall(9876543211l);
		PhoneWithNumberandModel mobileA = Phone::new;
		Phone p2 = mobileA.get(9876543211l, "5G nokia");
		p2.makeACall(9900012345l);
		System.out.println(p2.toString());

	}

	// Using constructor reference inside stream
	public static void testD() {
		Map<Long, String> phoneMap = new HashMap<Long, String>();
		phoneMap.put(16563421121l, "nokia");
		phoneMap.put(26533421121l, "samsung");
		phoneMap.put(3656342221l, "vivo");
		phoneMap.put(46563421121l, "redmi");
		phoneMap.put(56563421111l, "realme");
		// map does not have stream because it is not a collection
		// phoneMap.stream()
		Set<Long> longSet = phoneMap.keySet();
		Stream<Long> numberStream = longSet.stream();
		// Map has to be converted to set and stream method should be called on a set
		Phone[] phonearray = numberStream.map(Phone::new) // constructor reference of Phone
				.toArray(Phone[]::new);// Constructor reference of Array
//		 int count = phonearray.length;
//		 for(int i=0;i<count;i++) {
//			 System.out.println(phonearray[i]);
//		 }
//		Stream<Phone> phoneA =phonearray.stream(); //stream method cannot used directly in  an array
//      Creating a stream from array
		Stream<Phone> phoneStream = Arrays.stream(phonearray);
		phoneStream.forEach(System.out::println);
	}
}

// 		functional Interface for non parameterized constructor
interface PhoneEmpty {
	Phone get();
}

// functional Interface for  parameterized constructor
interface PhoneWithNumberandModel {
	Phone get(long number, String model);
}

class Phone {
	private long number;
	private String model;

	public Phone() {
		System.out.println("Default constructor");
	}

	// also create this constructor
	public Phone(long number) {
		System.out.println("Single Parameter constructor");
		this.number = number;
		this.model = "not assigned";

	}

	public Phone(long number, String model) {
		System.out.println("Parameterized constructor");
		this.number = number;
		this.model = model;

	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void makeACall(long number) {
		System.out.println("call made : " + number);
	}

	public static void print(long number) {
		System.out.println("print document : " + number);
	}

	public String toString() { // method overridden here
		// return this.hashCode() + " ";
		return this.number + " " + this.model;

	}
}