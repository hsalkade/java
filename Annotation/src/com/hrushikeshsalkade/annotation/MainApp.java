package com.hrushikeshsalkade.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/***
 * Java annotations. 
 * http://tutorials.jenkov.com/java/annotations.html
 * 
 * */

@SuppressWarnings({"unchecked"})
public class MainApp {

	public static void main(String[] args) {
		System.out.println("Annotations example...");
		System.out.println("---------------------------------------------");

		System.out.println("Class level annotations...");
		Country country = new Country("India", "Asia", 3, "Ruppes");
		Class<Country> countryClass = (Class<Country>)country.getClass();
		
		Annotation[] annotations = countryClass.getAnnotations();
		if(annotations != null && annotations.length > 0) {
			for(Annotation annotation : annotations) {
				System.out.println("Annotation " + annotation);
				if(annotation instanceof Table) {
					Table table = (Table) annotation;
					System.out.println(table.tableName() + ", " + table.databaseName() + ", " + table.databaseUri());
				}
			}
		}
		System.out.println("\n---------------------------------------------\n");
		System.out.println("Method annotations...");
		LoginRequest request = new LoginRequest();
		
		Class loginClass = request.getClass();
		Method[] methods = loginClass.getMethods();
		if(methods != null && methods.length > 0) {
			for(Method method : methods) {
				System.out.println("Method name : " + method.getName());
				annotations = method.getAnnotations();
				if(annotations != null && annotations.length > 0) {
					for(Annotation annotation : annotations) {
						System.out.println("Annotation " + annotation);
						if(annotation instanceof com.hrushikeshsalkade.annotation.Method) {
							com.hrushikeshsalkade.annotation.Method methodType = (com.hrushikeshsalkade.annotation.Method) annotation;
							System.out.println(methodType.value());
						}
					}
				}
			}
		}
	}
	
	
}
