package com.hrushikeshsalkade.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Java reflection tutorial.
 * 
 * @author hrushikesh
 */
public class MainApp {

	public static void main(String[] args) {
		System.out.println("Starting Main App...");
		// printStringClass(String.class;);
		printPersonClass();
	}

	@SuppressWarnings("unchecked")
	protected static void printPersonClass() {

		System.out.println("-------------------------------------");

		try {
			Class<Person> personClass = Person.class;
			printClass(personClass);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println("-------------------------------------");

		try {

			Class<Person> personClass = Person.class;
			System.out.println("x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x\n");

			System.out.println("Constructor reflection");
			System.out.println(
					"Create object and call parameterized constructor using reflection.");

			Constructor<?> constructor = personClass
					.getConstructor(new Class[]{});
			Person person = (Person) constructor.newInstance();
			System.out.println(person);

			Constructor<?> constructorParameterized = personClass
					.getConstructor(new Class[]{String.class, String.class,
							String.class, int.class});
			Person person1 = (Person) constructorParameterized
					.newInstance("Hrushikesh", "28", "Lonavala", 11);
			System.out.println(person1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\nx-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x\n");

		System.out.println("Field reflection.");
		System.out.println("Get field and set its value using reflection.");
		try {
			Person person = new Person();

			Class<Person> reflectPerson = (Class<Person>) person.getClass();
			Field[] fields = reflectPerson.getFields();
			if (fields != null && fields.length > 0) {
				for (Field field : fields) {
					System.out.println("Field name : " + field.getName());
					System.out.println("Field type : " + field.getType());
				}
			}
			System.out.println("Person class(before)" + person);
			System.out.println("Setting new name and age.");

			Field field = reflectPerson.getField("name");
			field.set(person, "Salkade");

			field = reflectPerson.getField("age");
			field.set(person, "24");

			/*
			 * field = reflectPerson.getField("address");
			 * field.set(person, "Lonavala");
			 */

			System.out.println("Person class(after)" + person);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\nx-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x\n");

		System.out.println("Method reflection");
		System.out.println("Call getter and setter methods using reflection.");
		try {
			Person person = new Person("Hrushikesh", "28", "Lonavala", 111);

			Class<Person> personClass = (Class<Person>) person.getClass();
			Method method = personClass.getMethod("getName", null);
			Class returnType = method.getReturnType();
			System.out.println("Return type : " + returnType);
			Object returnValue = method.invoke(person, null);
			System.out.println("Return value : " + returnValue);

			method = personClass.getMethod("setName", String.class);
			method.invoke(person, "Salkade");
			System.out.println("Person " + person);

			method = personClass.getMethod("setCategory", int.class);
			method.invoke(null, 123);

			method = personClass.getMethod("getCategory", null);
			returnValue = method.invoke(null, null);
			System.out.println("Category : " + returnValue);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("\nx-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x\n");

		try {

			System.out.println("Accessing private fields.");
			System.out.println("Access private field in class.");

			Person person = new Person("Hrushikesh", "29", "Lonavala", 1010);
			Class<Person> personClass = (Class<Person>) person.getClass();
			Field addressField = personClass.getDeclaredField("address");
			addressField.setAccessible(true);

			Object value = addressField.get(person);
			System.out.println("Address : " + value);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\nx-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x\n");

		try {
			System.out.println("Accessing Private Method.");
			Person person = new Person("Hrushikesh", "29", "Lonavala", 1010);
			Class<Person> personClass = (Class<Person>) person.getClass();
			Method initMethod = personClass.getDeclaredMethod("initPerson",
					String.class);
			initMethod.setAccessible(true);
			Object returnValue = initMethod.invoke(person, "Salkade");
			System.out.println("Old Name : " + returnValue);
			System.out.println("New name : " + person.getName());

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\nx-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x\n");
	}

	protected static void printClass(Class clazz) {

		System.out.println("Name : " + clazz.getName());
		System.out.println("Simple name : " + clazz.getSimpleName());
		System.out.println("Canonical name : " + clazz.getCanonicalName());
		System.out.println("Modifiers : " + clazz.getModifiers());
		System.out.println("Type name : " + clazz.getTypeName());

		System.out.println("Declared Methods : ");
		Method[] methods = clazz.getDeclaredMethods();
		if (methods != null && methods.length > 0) {
			for (Method method : methods) {
				System.out.println("\t" + method.getName());
			}

		}

		System.out.println("Constructors : ");
		Constructor[] constructors = clazz.getConstructors();
		if (constructors != null && constructors.length > 0) {
			for (Constructor constructor : constructors) {
				System.out.println("\t" + constructor.getName());
			}
		}
		System.out.println("Fields : ");
		Field[] fields = clazz.getFields();
		if (fields != null && fields.length > 0) {
			for (Field field : fields) {
				System.out.println("\t" + field.getName());
			}
		}
	}
}
