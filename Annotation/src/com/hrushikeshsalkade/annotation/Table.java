package com.hrushikeshsalkade.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.TYPE)
public @interface Table {

	public String tableName();
	
	public String databaseName();
	
	public String databaseUri();
	
}
