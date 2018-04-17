package com.sort;

import java.util.Arrays;

public class TestSort {
	public static void main(String[] args) {
		Person[] persons = new Person[5];
		persons[0] = new Person(1, "yzk", 18, 180);
		persons[1] = new Person(8, "秦岚", 25, 130);
		persons[2] = new Person(6, "贾玲", 22, 160);
		persons[3] = new Person(7, "冯提莫", 21, 150);
		persons[4] = new Person(3, "金莲", 38, 155);

		Arrays.sort(persons, new ImplementPersonCompartor());
		System.out.println("************************************By Id*****************************");
		for (Person p : persons) {
			System.out.println(p);
		}

		System.out.println("************************************By Age*****************************");
		Arrays.sort(persons, new ImplementPersonComparatorAge());
		for (Person p : persons) {
			System.out.println(p);
		}

	}

}
