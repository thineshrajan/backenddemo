package com.ecomm.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoTest 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.ecomm");
		context.refresh();
		
		
	}
}
