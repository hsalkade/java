package com.hrushikeshsalkade.java.reflection;

public class Person {

	public String name;
	public String age;
	private String address;
	private int id;

	private static int category = 1;

	public Person() {
		this("", "", "", 0);
	}

	public Person(String name, String age, String address, int id) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.id = id;
	}

	public String getName() {
		System.out.println("getName ");
		return name;
	}

	public void setName(String name) {
		System.out.println("setName " + name);
		initPerson(name);
	}

	public String getAge() {
		System.out.println("getAge ");
		return age;
	}

	public void setAge(String age) {
		System.out.println("setAge " + age);
		this.age = age;
	}

	public String getAddress() {
		System.out.println("getAddress ");
		return address;
	}

	public void setAddress(String address) {
		System.out.println("setAddress " + address);
		this.address = address;
	}

	public int getId() {
		System.out.println("getId ");
		return id;
	}

	public void setId(int id) {
		System.out.println("setId " + id);
		this.id = id;
	}

	public static int getCategory() {
		System.out.println("getCategory ");
		return category;
	}

	public static void setCategory(int category) {
		System.out.println("setCategory " + category);
		Person.category = category;
	}

	private String initPerson(String name) {
		System.out.println("initPerson " + name + ", oldname " + this.name);
		String oldName = this.name;
		this.name = name;
		return oldName;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address
				+ ", id=" + id + "]";
	}

}
