package demos.week6.collectionsbasicdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main
{
	public static void main(String[] args)
	{
		List<String> listOfNames = new ArrayList<String>();
		listOfNames.add("John");
		listOfNames.add("Jane");
		listOfNames.add("Bob");
		
		listOfNames.add(1, "Mary");
		
		System.out.println(listOfNames.getFirst());
		System.out.println(listOfNames);
		System.out.println(listOfNames.size());
		
		String input = "Tauhid";
		System.out.println("The array list contains Tauhid?: " + listOfNames.contains(input));
		input = "Mary";
		System.out.println("The array list contains Mary?: " + listOfNames.contains(input));
		
		Collections.sort(listOfNames.reversed());
		System.out.println(listOfNames);
	}
}
